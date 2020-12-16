package com.woorinet.plugin.demo;

import com.woorinet.plugin.demo.DTO.NODE;
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

//			//Node DB연동
//			manager.Tl1SyncNodeList(CTAG, tl1Mapper);
//
			//Node 조회
			List<NODE> nodes = tl1Mapper.selectNode();
//
//			//SystemInfo DB연동
//			for (Node node: nodes) {
//				manager.Tl1SyncSystemInfo(CTAG, node.getTID(), tl1Mapper);
//			}
//
//			//Slot DB연동
//			for (Node node: nodes) {
//				manager.Tl1SyncSlot(CTAG, node.getTID(), tl1Mapper);
//			}

//			//EthPort DB연동
//			for (Node node: nodes) {
//				manager.Tl1SyncEthPort(CTAG, node.getTID(), tl1Mapper);
//			}

//			//NodeConnector DB연동
//			for (Node node: nodes) {
//				manager.Tl1SyncNodeConnector(CTAG, node.getTID(), tl1Mapper);
//			}
//
//			//CesNodeConnector DB연동
//			for (Node node: nodes) {
//				manager.Tl1SyncCesNodeConnector(CTAG, node.getTID(), tl1Mapper);
//			}

//			//OduNodeConnector DB연동
//			for (NODE node: nodes) {
//				manager.Tl1SyncOduNodeConnector(CTAG, node.getTID(), tl1Mapper);
//			}

//			//MPLS_IF DB연동
//			for (NODE node: nodes) {
//				manager.Tl1SyncMplsIf(CTAG, node.getTID(), tl1Mapper);
//			}

			//MPLS_IF DB연동
			for (NODE node: nodes) {
				manager.Tl1SyncOduMplsIf(CTAG, node.getTID(), tl1Mapper);
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
		try {
			List<NODE> list = tl1Mapper.selectNode();
			for (NODE node: list) {
				System.out.println(node.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test success";
	}

}
