package com.woorinet.plugin.demo;

import com.woorinet.plugin.demo.DTO.TL1.EVENT.Tl1EventTca;
import com.woorinet.plugin.demo.Mapper.QNETMapper;
import com.woorinet.plugin.demo.Repository.TL1.EVENT.Tl1EventTcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

@RestController
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private QNETMapper qnetMapper;

	@Autowired
	private static Tl1EventTcaRepository tl1EventTcaRepository;

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
				if(!result.equals("")) {
					if(result.contains("TCA") && result.contains("EMS")) {
						String[] fields = ConvertResponseForTCA(result);
						Tl1EventTca tl1EventTca = new Tl1EventTca(fields);
						tl1EventTcaRepository.save(tl1EventTca);
					} else if (result.contains("REPT ALM")) {
						System.out.println("test2");
					}
					System.out.println(result);
				}

			}
		} catch (Exception e) {

		}

	}
	private static String[] ConvertResponseForTCA(String data) throws Exception {
		String[] convData = data.split("\n");

		String[] result;

		String TID = "";
		String AID = "";
		String UNIT = "";
		String SIGNAL = "";
		String TIME = "";
		String PM_ELEMENT = "";
		String DATETIME = "";
		String EVENT_DATETIME = "";
		for(String line: convData) {
			line = line.trim();
			if(line.startsWith("EMS")) {
				TID = line.split(" ")[0];
				EVENT_DATETIME = line.split(" ")[2];
			} else if (line.contains("/*") && line.contains("*/")) {
				line = line.replace("/*", "");
				line = line.replace("*/", "");

				String[] columns = line.split(",");
				AID = columns[0];
				UNIT = columns[1];
				SIGNAL = columns[2];
				TIME = columns[3];
				PM_ELEMENT = columns[4];
				DATETIME = columns[5];
			}
		}
		result = new String[]{TID, AID, UNIT, SIGNAL, TIME, PM_ELEMENT, DATETIME, EVENT_DATETIME};
		return result;
	}
	/*
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
	*/
}

