package com.woorinet.plugin.demo;

import com.woorinet.plugin.demo.DTO.Node;
import com.woorinet.plugin.demo.Mapper.NodeMapper;
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
	private NodeMapper nodeMapper;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/synchronization")
	String synchronization() {

		try {
			Manager manager = new Manager("222.117.54.175", 19011);
			manager.Tl1Login("admin", "admin");

			manager.Tl1GetNodeList(100, nodeMapper);

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
			List<Node> list = nodeMapper.selectNode();
			for (Node node: list) {
				System.out.println(node.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test success";
	}

}
