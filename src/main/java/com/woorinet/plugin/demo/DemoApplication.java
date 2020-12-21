package com.woorinet.plugin.demo;

import com.google.gson.Gson;
import com.woorinet.plugin.demo.DTO.*;
import com.woorinet.plugin.demo.Mapper.TL1Mapper;
import com.woorinet.plugin.demo.Tl1.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private TL1Mapper tl1Mapper;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/synchronization")
	String synchronization() {
		int CTAG = 100;
		try {
			Manager manager = new Manager("222.117.54.175", 19011);
			//TL1 로그인
			manager.Tl1Login("admin", "admin");

			//Node DB연동
			manager.Tl1SyncNodeList(CTAG, tl1Mapper);

			//Node 조회
			List<NODE> nodes = tl1Mapper.selectNode();

			//SystemInfo DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncSystemInfo(CTAG, node.getTID(), tl1Mapper);
			}

			//Slot DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncSlot(CTAG, node.getTID(), tl1Mapper);
			}

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
			for (NODE node: nodes) {
				manager.Tl1SyncAccessIf(CTAG, node.getTID(), tl1Mapper);
			}

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


			//TL1 로그아웃
			manager.Tl1Logout("admin");
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "synchronization";
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
		List<SYSTEM_INFO> list = null;
		try {
			list = tl1Mapper.selectSystemInfo();
			for (SYSTEM_INFO item: list) {
				System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (new Gson()).toJson(list);
	}

	@RequestMapping("/access_if")
	String selectAccessIf() {
		List<ACCESS_IF> list = null;
		try {
			list = tl1Mapper.selectAccessIf();
			for (ACCESS_IF item: list) {
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
