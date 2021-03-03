package com.woorinet.plugin.demo;

import com.google.gson.Gson;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Mapper.QNETMapper;
import com.woorinet.plugin.demo.QNET.QNETManager;
import com.woorinet.plugin.demo.Repository.SDN.*;
import com.woorinet.plugin.demo.Repository.TL1.*;
import com.woorinet.plugin.demo.SDN.SDNManager;
import com.woorinet.plugin.demo.Tl1.TL1Manager;
import com.woorinet.plugin.demo.UTIL.ThrowingConsumer;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private QNETMapper qnetMapper;

	@Autowired
	private Tl1NodeRepository tl1NodeRepository;
	@Autowired
	private Tl1SystemInfoRepository tl1SystemInfoRepository;
	@Autowired
	private Tl1SlotRepository tl1SlotRepository;
	@Autowired
	private Tl1EthPortRepository tl1EthPortRepository;
	@Autowired
	private Tl1NodeConnectorRepository tl1NodeConnectorRepository;
	@Autowired
	private Tl1CesNodeConnectorRepository tl1CesNodeConnectorRepository;
	@Autowired
	private Tl1OduNodeConnectorRepository tl1OduNodeConnectorRepository;
	@Autowired
	private Tl1MplsIfRepository tl1MplsIfRepository;
	@Autowired
	private Tl1OduMplsIfRepository tl1OduMplsIfRepository;
	@Autowired
	private Tl1StunnelRepository tl1StunnelRepository;
	@Autowired
	private Tl1StunnelExtRepository tl1StunnelExtRepository;
	@Autowired
	private Tl1StunnelTransitRepository tl1StunnelTransitRepository;
	@Autowired
	private Tl1TunnelPortRepository tl1TunnelPortRepository;
	@Autowired
	private Tl1SpwRepository tl1SpwRepository;
	@Autowired
	private Tl1MspwRepository tl1MspwRepository;
	@Autowired
	private Tl1MplsAcRepository tl1MplsAcRepository;
	@Autowired
	private Tl1AccessIfRepository tl1AccessIfRepository;
	@Autowired
	private Tl1ServiceRepository tl1ServiceRepository;
	@Autowired
	private Tl1ServiceExtRepository tl1ServiceExtRepository;
	@Autowired
	private Tl1ServiceTunnelRepository tl1ServiceTunnelRepository;
	@Autowired
	private Tl1ServiceMspwRepository tl1ServiceMspwRepository;
	@Autowired
	private Tl1OduRepository tl1OduRepository;
	@Autowired
	private Tl1CesPortRepository tl1CesPortRepository;
	@Autowired
	private Tl1CesPwRepository tl1CesPwRepository;
	@Autowired
	private Tl1L2LacpRepository tl1L2LacpRepository;
	@Autowired
	private Tl1OpticPowerRepository tl1OpticPowerRepository;
	@Autowired
	private Tl1PmRepository tl1PmRepository;
	@Autowired
	private Tl1PmPortRepository tl1PmPortRepository;
	@Autowired
	private Tl1PmAcRepository tl1PmAcRepository;
	@Autowired
	private Tl1PmPwRepository pmPwRepository;
	@Autowired
	private Tl1PmTunnelRepository tl1PmTunnelRepository;
	@Autowired
	private Tl1InventoryRepository tl1InventoryRepository;
	@Autowired
	private Tl1SessStateRepository tl1SessStateRepository;
	@Autowired
	private Tl1KeyStateRepository tl1KeyStateRepository;
	@Autowired
	private Tl1ModuleInfoRepository tl1ModuleInfoRepository;
	@Autowired
	private Tl1CmPortRepository tl1CmPortRepository;
	@Autowired
	private Tl1BypassInfoRepository tl1BypassInfoRepository;
	@Autowired
	private Tl1CryptoModeRepository tl1CryptoModeRepository;
	@Autowired
	private Tl1CmProgramInfoRepository tl1CmProgramInfoRepository;

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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
//		System.out.println(odu_mpls_ifRepository.findByTid("EMS_1000_C"));
		return "Hello World!";
	}

	@RequestMapping("/convertTL1")
	String convertTL1() {
		try {
			// Node 조회
			List<Tl1Node> tl1Nodes = tl1NodeRepository.findAll();
			// SYSTEM_INFO 조회
			List<Tl1SystemInfo> tl1SystemInfos = tl1SystemInfoRepository.findAll();
			// ODU_NODE_CONNECTOR 조회
			List<Tl1OduNodeConnector> tl1OduNodeConnectors = tl1OduNodeConnectorRepository.findAll();
			// ODU 조회
			List<Tl1Odu> oduses = tl1OduRepository.findAll();
			// ODU_MPLS_IF 조회
			List<Tl1OduMplsIf> tl1OduMplsIfs = tl1OduMplsIfRepository.findAll();
			// OPTIC_POWER 조회
			List<Tl1OpticPower> tl1OpticPowers = tl1OpticPowerRepository.findAll();
			// SERVICE 조회
			List<Tl1Service> tl1Services = tl1ServiceRepository.findAll();
			// ACCESS_IF 조회
			List<Tl1AccessIf> Tl1AccessIfs = tl1AccessIfRepository.findAll();
			// SERVICE_EXT 조회
			List<Tl1ServiceExt> tl1ServiceExts = tl1ServiceExtRepository.findAll();
			// MPLS_IF 조회
			List<Tl1MplsIf> tl1MplsIfs = tl1MplsIfRepository.findAll();
			// INVENTORY 조회
			List<Tl1Inventory> inventories = tl1InventoryRepository.findAll();
			// CM_PORT 조회
			List<Tl1CmPort> tl1CmPorts = tl1CmPortRepository.findAll();
			// MODULE_INFO 조회
			List<Tl1ModuleInfo> tl1ModuleInfos = tl1ModuleInfoRepository.findAll();
			// BYPASS_INFO 조회
			List<Tl1BypassInfo> tl1BypassInfos = tl1BypassInfoRepository.findAll();
			// CM_PROGRAM_INFO 조회
			List<Tl1CmProgramInfo> tl1CmProgramInfos = tl1CmProgramInfoRepository.findAll();
			// SESS_STATE 조회
			List<Tl1SessState> tl1SessStates = tl1SessStateRepository.findAll();
			// KEY_STATE 조회
			List<Tl1KeyState> tl1KeyStates = tl1KeyStateRepository.findAll();
			SDNManager manager = new SDNManager(sdnNodeRepository,
					sdnConnectorRepository,
					sdnLinkRepository,
					sdnServiceRepository,
					sdnTunnelRepository,
					sdnPathRepository,
					sdnConstraintRepository,
					sdnAccessIfRepository,
					sdnCryptoModuleRepository,
					tl1Nodes,
					tl1SystemInfos,
					tl1OduNodeConnectors,
					tl1OpticPowers,
					oduses,
					tl1OduMplsIfs,
					tl1Services,
					Tl1AccessIfs,
					tl1ServiceExts,
					tl1MplsIfs,
					inventories,
					tl1CmPorts,
					tl1ModuleInfos,
					tl1BypassInfos,
					tl1CmProgramInfos,
					tl1SessStates,
					tl1KeyStates);

			// Node 테이블 생성
			manager.SDNSyncNodeList();
			// Connector 테이블 생성
			manager.SDNSyncConnectorList();
			// Link 테이블 생성
			manager.SDNSyncLinkList();
			// Tunnel 테이블 생성
			manager.SDNSyncTunnelList();
			// Service 테이블 생성
			manager.SDNSyncServiceList();
			// Path 테이블 생성
			manager.SDNSyncPathList();
			// Constraint 테이블 생성
			manager.SDNSyncConstraint();
			// AccessIf 테이블 생성
			manager.SDNSyncAccess_if();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "convert complete";
	}

	@RequestMapping("/synchronization")
	String synchronization() {
		int CTAG = 100;
		try {
			TL1Manager manager = new TL1Manager(
					CTAG,
					"222.117.54.175",
					19011,
					tl1NodeRepository,
					tl1SystemInfoRepository,
					tl1SlotRepository,
					tl1EthPortRepository,
					tl1NodeConnectorRepository,
					tl1CesNodeConnectorRepository,
					tl1OduNodeConnectorRepository,
					tl1MplsIfRepository,
					tl1OduMplsIfRepository,
					tl1StunnelRepository,
					tl1StunnelExtRepository,
					tl1StunnelTransitRepository,
					tl1TunnelPortRepository,
					tl1SpwRepository,
					tl1MspwRepository,
					tl1MplsAcRepository,
					tl1AccessIfRepository,
					tl1ServiceRepository,
					tl1ServiceExtRepository,
					tl1ServiceTunnelRepository,
					tl1ServiceMspwRepository,
					tl1OduRepository,
					tl1CesPortRepository,
					tl1CesPwRepository,
					tl1L2LacpRepository,
					tl1OpticPowerRepository,
					tl1PmRepository,
					tl1PmPortRepository,
					tl1PmAcRepository,
					pmPwRepository,
					tl1PmTunnelRepository,
					tl1InventoryRepository,
					tl1SessStateRepository,
					tl1KeyStateRepository,
					tl1ModuleInfoRepository,
					tl1CmPortRepository,
					tl1BypassInfoRepository,
					tl1CryptoModeRepository,
					tl1CmProgramInfoRepository);
			//TL1 로그인
			manager.Tl1Login("admin", "admin");
			//Node DB연동
			manager.Tl1SyncNodeList();
			//SystemInfo DB연동
			manager.Tl1SyncSystemInfo();
			//Slot DB연동
			manager.Tl1SyncSlot();
			//EthPort DB연동
			manager.Tl1SyncEthPort();
			//NodeConnector DB연동
			manager.Tl1SyncNodeConnector();
			//CesNodeConnector DB연동
			manager.Tl1SyncCesNodeConnector();
			//OduNodeConnector DB연동
			manager.Tl1SyncOduNodeConnector();
			//MPLS_IF DB연동
			manager.Tl1SyncMplsIf();
			//ODU_MPLS_IF DB연동
			manager.Tl1SyncOduMplsIf();
			//STUNNEL DB연동
			manager.Tl1SyncSTunnel();
			//STUNNEL_EXT DB연동
			manager.Tl1SyncSTunnelExt();
			//STUNNEL_TRANSIT DB연동
			manager.Tl1SyncSTunnelTransit();
			//TUNNEL_PROT DB연동
			manager.Tl1SyncTunnelProt();
			//SPW DB연동
			manager.Tl1SyncSpw();
			//MSPW DB연동
			manager.Tl1SyncMSpw();
			//MPLS_AC DB연동
			manager.Tl1SyncMplsAc();
			//ACCESS_IF DB연동
			manager.Tl1SyncAccessIf();
			//SERVICE DB연동
			manager.Tl1SyncService();
			//SERVICE_EXT DB연동
			manager.Tl1SyncServiceExt();
			//SERVICE_TUNNEL DB연동
			manager.Tl1SyncServiceTunnel();
			//SERVICE_MSPW DB연동
			manager.Tl1SyncServiceMspw();
			//ODU DB연동
			manager.Tl1SyncOdu();
			//CES_PORT DB연동
			manager.Tl1SyncCesPort();
			//CES_PW DB연동
			manager.Tl1SyncCesPw();
			//L2Lacp DB연동
			manager.Tl1SyncL2Lacp();
			//OPTIC-POWER DB연동
			manager.Tl1SyncOPTICPOWER();
			//PM DB연동
			manager.TL1SyncPM();
			//PM-PORT DB연동
			manager.Tl1SyncPmPort();
			//PM-AC DB연동
			manager.TL1SyncPmAc();
			//PM-PW DB연동
			manager.TL1SyncPmPw();
			//PM-TUNNEL DB연동
			manager.TL1SyncPmTunnel();
			//INVENTORY DB연동
			manager.TL1SyncInventory();
			//SESS_STATE DB연동
			manager.TL1SyncSessState();
			//KEY_STATE DB연동
			manager.TL1SyncKeyState();
			//MODULE_INFO DB연동
			manager.TL1SyncModuleInfo();
			//CM_PORT DB연동
			manager.TL1SyncCmPort();
			//BYPASS_INFO DB연동
			manager.TL1SyncBypassInfo();
			//CRYPTO_MODE DB연동
			manager.TL1SyncCryptoMode();
			//CM_PROGRAM_INFO DB연동
			manager.TL1SyncCmProgramInfo();
			//TL1 로그아웃
			manager.Tl1Logout("admin");
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "TL1 접속 실패";
		}

		return "synchronization";
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
