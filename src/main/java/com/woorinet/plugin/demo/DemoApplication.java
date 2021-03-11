package com.woorinet.plugin.demo;

import com.google.gson.Gson;
import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.HOLA.HOLAManager;
import com.woorinet.plugin.demo.Manager.QNETManager;
import com.woorinet.plugin.demo.Mapper.QNETMapper;
import com.woorinet.plugin.demo.Repository.HOLA.*;
import com.woorinet.plugin.demo.Repository.SDN.*;
import com.woorinet.plugin.demo.UTIL.ThrowingConsumer;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private QNETMapper qnetMapper;

	@Autowired
	private SdnNodeRepository sdnNodeRepository;
	@Autowired
	private SdnConnectorRepository sdnConnectorRepository;
	@Autowired
	private SdnLinkRepository sdnLinkRepository;
	@Autowired
	private SdnServiceRepository sdnServiceRepository;
	@Autowired
	private SdnTunnelRepository sdnTunnelRepository;
	@Autowired
	private SdnAccessIfRepository sdnAccessIfRepository;
	@Autowired
	private SdnConstraintRepository sdnConstraintRepository;
	@Autowired
	private SdnPathRepository sdnPathRepository;
	@Autowired
	private SdnCryptoModuleRepository sdnCryptoModuleRepository;
	@Autowired
	private SdnCryptoSessionRepository sdnCryptoSessionRepository;
	@Autowired
	private SdnPmPortRepository sdnPmPortRepository;

	@Autowired
	private HolaSdnLineNumSheetRepository holaSdnLineNumSheetRepository;
	@Autowired
	private HolaSdnLinkMngRepository holaSdnLinkMngRepository;
	@Autowired
	private HolaSdnTrunkUsageRepository holaSdnTrunkUsageRepository;
	@Autowired
	private HolaSdnInventroyDetailRepository holaSdnInventroyDetailRepository;
	@Autowired
	private HolaSdnOtnNodeUsageRepository holaSdnOtnNodeUsageRepository;
	@Autowired
	private HolaSdnOtnMaterialRepository holaSdnOtnMaterialRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		try {
			String ip = "222.117.54.175";
			int port = 19012;
			SocketChannel socketChannel;
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(true);
			socketChannel.connect(new InetSocketAddress(ip, port));

			while(true) {
				ByteBuffer byteBuffer =  ByteBuffer.allocate(1024);
				Charset charset = Charset.forName("UTF-8");
				byteBuffer.flip();
				String bufferStr = "";
				String result = "";
				while (!bufferStr.contains(";")) {
					byteBuffer.clear();
					socketChannel.read(byteBuffer);
					byteBuffer.flip();
					bufferStr = charset.decode(byteBuffer).toString();
					result += bufferStr;
				}
				if(!result.equals("")) System.out.println(result);

			}
		} catch (Exception e) {

		}

	}


	@RequestMapping("/hola")
	String syncronizeHola() {
		try {
			//SdnNode 조회
			List<SdnNode> sdnNodeList = sdnNodeRepository.findAll();
			//SdnConnector 조회
			List<SdnConnector> sdnConnectorList = sdnConnectorRepository.findAll();
			//SdnLink 조회
			List<SdnLink> sdnLinkList = sdnLinkRepository.findAll();
			//SdnService 조회
			List<SdnService> sdnServiceList = sdnServiceRepository.findAll();
			//SdnPath 조회
			List<SdnPath> sdnPathList = sdnPathRepository.findAll();
			//SdnConstraint 조회
			List<SdnConstraint> sdnConstraintList = sdnConstraintRepository.findAll();
			//SdnAccessIf 조회
			List<SdnAccessIf> sdnAccessIfList = sdnAccessIfRepository.findAll();

			HOLAManager manager = new HOLAManager(holaSdnLineNumSheetRepository,
					holaSdnLinkMngRepository,
					holaSdnTrunkUsageRepository,
					holaSdnInventroyDetailRepository,
					holaSdnOtnNodeUsageRepository,
					holaSdnOtnMaterialRepository,
					sdnNodeList,
					sdnConnectorList,
					sdnLinkList,
					sdnServiceList,
					sdnPathList,
					sdnConstraintList,
					sdnAccessIfList

			);

			manager.HOLASyncStart();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "sync hola";
	}



	@RequestMapping("/synchronization_anapi")
	String synchronizationQNAPI() {

		try {
			qnetMapper.initDatabase();
			qnetMapper.initNodeTable();
			qnetMapper.initNodeLinkTable();
			qnetMapper.initConsumerLinkTable();
			qnetMapper.initProviderLinkTable();
			qnetMapper.initPathTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebClient client1 = WebClient
				.builder()
				.baseUrl("https://1.226.250.42/v1/admin")
				.defaultHeaders( httpHeaders -> {
					httpHeaders.add(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46QWRtaW4=");
					httpHeaders.add(HttpHeaders.ACCEPT, "text/plain");
				})
				.clientConnector(
						new ReactorClientHttpConnector(
								HttpClient.create()
									.secure(
											ThrowingConsumer.unchecked(
													sslContextSpec -> sslContextSpec.sslContext(
															SslContextBuilder.forClient()
															.trustManager(InsecureTrustManagerFactory.INSTANCE)
															.build()
													)
											)
									)
						)
				)
				.build();

		WebClient.RequestBodySpec uri1 = client1
				.method(HttpMethod.GET)
				.uri("/node?consumers=true&providers=true&links=true");

		QNETManager qnetManager = new QNETManager();
		String response = uri1.retrieve()
					.bodyToMono(Map.class)
					.map(map -> (Map) map.get("configuration"))
					.map(map -> {
						qnetManager.QNETSyncKMSGroups((List) map.get("groups"));
						try {
							qnetManager.QNETSyncKMSNodes((List) map.get("nodes"), qnetMapper);
							qnetManager.QNETSyncKMSNodeLinks((List) map.get("nodeLinks"),qnetMapper);
							qnetManager.QNETSyncKMSConsumerLinks((List) map.get("consumerLinks"),qnetMapper);
							qnetManager.QNETSyncKMSProviderLinks((List) map.get("providerLinks"), qnetMapper);
							qnetManager.QNETSyncKMSPaths((List) map.get("paths"),qnetMapper);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return "ok";
					})
					.block();

		System.out.println("response: " + response);

		return "ok";
	}



	@RequestMapping("/select_node")
	@ApiOperation(value="test", notes="test")
	@GetMapping(value="/save")
	@ResponseBody
	String selectNode() {
		List<Tl1Node> list = null;
		try {
			//list = tl1Mapper.selectNode();
			for (Tl1Node item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/system_info")
	String selectSystemInfo() {
		List<Tl1SystemInfo> list = null;
		try {
			//list = tl1Mapper.selectSystemInfo();
			for (Tl1SystemInfo item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/access_if")
	String selectAccessIf() {
		List<Tl1AccessIf> list = null;
		try {
			//list = tl1Mapper.selectAccessIf();
			for (Tl1AccessIf item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/ces_node_connector")
	String selectCesNodeConnector() {
		List<Tl1CesNodeConnector> list = null;
		try {
			//list = tl1Mapper.selectCesNodeConnector();
			for (Tl1CesNodeConnector item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/eth_port")
	String selectEthPort() {
		List<Tl1EthPort> list = null;
		try {
			//list = tl1Mapper.selectEthPort();
			for (Tl1EthPort item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/mpls_ac")
	String selectMplsAc() {
		List<Tl1MplsAc> list = null;
		try {
			//list = tl1Mapper.selectMplsAc();
			for (Tl1MplsAc item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/mpls_if")
	String selectMplsIf() {
		List<Tl1MplsIf> list = null;
		try {
			//list = tl1Mapper.selectMplsIf();
			for (Tl1MplsIf item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

}

