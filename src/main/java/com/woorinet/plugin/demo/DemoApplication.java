package com.woorinet.plugin.demo;

import com.google.gson.Gson;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Mapper.QNETMapper;
import com.woorinet.plugin.demo.Mapper.TL1Mapper;
import com.woorinet.plugin.demo.QNET.QNETManager;
import com.woorinet.plugin.demo.Repository.SDN.*;
import com.woorinet.plugin.demo.Repository.TL1.*;
import com.woorinet.plugin.demo.Repository.TL1.Tl1AccessIfRepository;
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
	private TL1Mapper tl1Mapper;

	@Autowired
	private QNETMapper qnetMapper;

	@Autowired
	private Tl1AccessIfRepository tl1AccessIfRepository;
	@Autowired
	private Tl1SystemInfoRepository tl1SystemInfoRepository;
	@Autowired
	private Tl1SlotRepository tl1SlotRepository;
//	@Autowired
//	private ODU_MPLS_IFRepository odu_mpls_ifRepository;
	@Autowired
	private PMRepository pmRepository;
	@Autowired
	private PM_PORTRepository pm_portRepository;
	@Autowired
	private PM_ACRepositiory pm_acRepositiory;
	@Autowired
	private PM_PWRepository pmPwRepository;
	@Autowired
	private PM_TUNNELRepository pm_tunnelRepository;
	@Autowired
	private INVENTORYRepository inventoryRepository;
	@Autowired
	private SESS_STATERepository sess_stateRepository;
	@Autowired
	private KEY_STATERepository key_stateRepository;
	@Autowired
	private MODULE_INFORepository module_infoRepository;
	@Autowired
	private CM_PORTRepository cm_portRepository;
	@Autowired
	private BYPASS_INFORepository bypass_infoRepository;
	@Autowired
	private CRYPTO_MODERepository crypto_modeRepository;
	@Autowired
	private CM_PROGRAM_INFORepository cm_program_infoRepository;

	@Autowired
	private NODERepository nodeRepository;
	@Autowired
	private CONNECTORRepository connectorRepository;
	@Autowired
	private LINKRepository linkRepository;
	@Autowired
	private SERVICERepository serviceRepository;
	@Autowired
	private TUNNELRepository tunnelRepository;
	@Autowired
	private com.woorinet.plugin.demo.Repository.SDN.ACCESS_IFRepository access_ifRepository;
	@Autowired
	private CONSTRAINTRepository constraintRepository;
	@Autowired
	private PATHRepository pathRepository;

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
			List<NODE> nodes = tl1Mapper.selectNode();
			// SYSTEM_INFO 조회
			List<Tl1SystemInfo> tl1SystemInfos = tl1Mapper.selectSystemInfo();
			// ODU_NODE_CONNECTOR 조회
			List<ODU_NODE_CONNECTOR> odu_node_connectors = tl1Mapper.selectOduNodeConnector();
			// ODU 조회
			List<ODU> odus = tl1Mapper.selectOdu();
			// ODU_MPLS_IF 조회
			List<ODU_MPLS_IF> odu_mpls_ifs= tl1Mapper.selectOduMplsIf();
			// OPTIC_POWER 조회
			List<OPTIC_POWER> optic_powers = tl1Mapper.selectOpticPower();
			// SERVICE 조회
			List<SERVICE> services = tl1Mapper.selectService();
			// ACCESS_IF 조회
			List<Tl1AccessIf> Tl1AccessIfs = tl1Mapper.selectAccessIf();
			// SERVICE_EXT 조회
			List<SERVICE_EXT> service_exts = tl1Mapper.selectServiceExt();
			// MPLS_IF 조회
			List<MPLS_IF> mpls_ifs = tl1Mapper.selectMplsIf();
			// INVENTORY 조회
			List<INVENTORY> inventories = inventoryRepository.findAll();
			SDNManager manager = new SDNManager(nodeRepository,connectorRepository,linkRepository,serviceRepository, tunnelRepository, pathRepository, constraintRepository, access_ifRepository, nodes, tl1SystemInfos,odu_node_connectors,optic_powers, odus, odu_mpls_ifs,services, Tl1AccessIfs, service_exts,mpls_ifs, inventories);

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
			TL1Manager manager = new TL1Manager(CTAG,"222.117.54.175", 19011,tl1SystemInfoRepository,tl1SlotRepository, tl1AccessIfRepository,pmRepository,  pm_portRepository,pm_acRepositiory, pmPwRepository, pm_tunnelRepository,inventoryRepository,sess_stateRepository,key_stateRepository, module_infoRepository, cm_portRepository, bypass_infoRepository, crypto_modeRepository, cm_program_infoRepository);
			//TL1 로그인
			manager.Tl1Login("admin", "admin");

			//Node DB연동
			manager.Tl1SyncNodeList(CTAG, tl1Mapper);

			//Node 조회
			List<NODE> nodes = tl1Mapper.selectNode();

			//SystemInfo DB연동
			manager.Tl1SyncSystemInfo();

			//Slot DB연동
			manager.Tl1SyncSlot();

			//EthPort DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncEthPort(CTAG, node.getTID(), tl1Mapper);
			}

			//NodeConnector DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncNodeConnector(CTAG, node.getTID(), tl1Mapper);
			}

			//CesNodeConnector DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncCesNodeConnector(CTAG, node.getTID(), tl1Mapper);
			}

			//OduNodeConnector DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncOduNodeConnector(CTAG, node.getTID(), tl1Mapper);
			}

			//MPLS_IF DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncMplsIf(CTAG, node.getTID(), tl1Mapper);
			}

			//MPLS_IF DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncOduMplsIf(CTAG, node.getTID(), tl1Mapper);
			}

			//MPLS_IF DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncOduMplsIf(CTAG, node.getTID(), tl1Mapper);
			}

			//STUNNEL DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncSTunnel(CTAG, node.getTID(), tl1Mapper);
			}

			//STUNNEL_EXT DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncSTunnelExt(CTAG, node.getTID(), tl1Mapper);
			}

			//STUNNEL_TRANSIT DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncSTunnelTransit(CTAG, node.getTID(), tl1Mapper);
			}

			//TUNNEL_PROT DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncTunnelProt(CTAG, node.getTID(), tl1Mapper);
			}


			//SPW DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncSpw(CTAG, node.getTID(), tl1Mapper);
			}

			//MSPW DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncMSpw(CTAG, node.getTID(), tl1Mapper);
			}

			//MPLS_AC DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncMplsAc(CTAG, node.getTID(), tl1Mapper);
			}

			//ACCESS_IF DB연동
			manager.Tl1SyncAccessIf();

			//SERVICE DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncService(CTAG, node.getTID(), tl1Mapper);
			}

			List<SERVICE> services = tl1Mapper.selectService();

			//SERVICE_EXT DB연동
			for (SERVICE service: services) {
				manager.Tl1SyncServiceExt(CTAG, service.getTID(), service.getNAME(), tl1Mapper);
			}

			//SERVICE_TUNNEL DB연동
			for (SERVICE service: services) {
				manager.Tl1SyncServiceTunnel(CTAG, service.getTID(), service.getNAME(), tl1Mapper);
			}

			//SERVICE_MSPW DB연동
			for (SERVICE service: services) {
				manager.Tl1SyncServiceMspw(CTAG, service.getTID(), service.getNAME(), tl1Mapper);
			}

			//ODU DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncOdu(CTAG, node.getTID(), tl1Mapper);
			}

			//CES_PORT DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncCesPort(node.getTID(), tl1Mapper);
			}

			//CES_PW DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncCesPw(node.getTID(), tl1Mapper);
			}

			//CES_PW DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncL2Lacp(node.getTID(), tl1Mapper);
			}

			//OPTIC-POWER DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncOPTICPOWER(node.getTID(), tl1Mapper);
			}

			List<NODECONNECTOR> node_connectors = tl1Mapper.selectNodeConnector();
			List<ODU_MPLS_IF> odu_mpls_ifs = tl1Mapper.selectOduMplsIf();
			List<ODU_NODE_CONNECTOR> odu_node_connectors = tl1Mapper.selectOduNodeConnector();
			List<MPLS_AC> mplsAcs = tl1Mapper.selectMplsAc();

			//PM DB연동
			manager.TL1SyncPM(CTAG, odu_node_connectors, odu_mpls_ifs);

			//PM-PORT DB연동
			manager.Tl1SyncPmPort(CTAG, odu_node_connectors);

			//PM-AC DB연동
			manager.TL1SyncPmAc(CTAG, mplsAcs);

			//PM-PW DB연동
			manager.TL1SyncPmPw(CTAG, nodes);

			//PM-TUNNEL DB연동
			manager.TL1SyncPmTunnel(CTAG, nodes);

			//INVENTORY DB연동
			manager.TL1SyncInventory(nodes);

			//SESS_STATE DB연동
			manager.TL1SyncSessState(nodes, node_connectors);

			//KEY_STATE DB연동
			manager.TL1SyncKeyState(nodes, node_connectors);

			//MODULE_INFO DB연동
			manager.TL1SyncModuleInfo(nodes, node_connectors);

			//CM_PORT DB연동
			manager.TL1SyncCmPort(nodes, node_connectors);

			//BYPASS_INFO DB연동
			manager.TL1SyncBypassInfo(nodes, node_connectors);

			//CRYPTO_MODE DB연동
			manager.TL1SyncCryptoMode(nodes, node_connectors);

			//CM_PROGRAM_INFO DB연동
			manager.TL1SyncCmProgramInfo(nodes, node_connectors);

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
		List<NODE> list = null;
		try {
			list = tl1Mapper.selectNode();
			for (NODE item: list) {
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
			list = tl1Mapper.selectSystemInfo();
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
			list = tl1Mapper.selectAccessIf();
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
		List<CES_NODE_CONNECTOR> list = null;
		try {
			list = tl1Mapper.selectCesNodeConnector();
			for (CES_NODE_CONNECTOR item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/eth_port")
	String selectEthPort() {
		List<ETH_PORT> list = null;
		try {
			list = tl1Mapper.selectEthPort();
			for (ETH_PORT item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/mpls_ac")
	String selectMplsAc() {
		List<MPLS_AC> list = null;
		try {
			list = tl1Mapper.selectMplsAc();
			for (MPLS_AC item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/mpls_if")
	String selectMplsIf() {
		List<MPLS_IF> list = null;
		try {
			list = tl1Mapper.selectMplsIf();
			for (MPLS_IF item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

}
