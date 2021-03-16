package com.woorinet.plugin.demo;

import com.woorinet.plugin.demo.DTO.TL1.EVENT.Tl1EventAlm;
import com.woorinet.plugin.demo.DTO.TL1.EVENT.Tl1EventTca;
import com.woorinet.plugin.demo.Mapper.QNETMapper;
import com.woorinet.plugin.demo.Repository.TL1.EVENT.Tl1EventAlmRepository;
import com.woorinet.plugin.demo.Repository.TL1.EVENT.Tl1EventTcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/*
전체 프로그램 설계에 대한 설명

View Controller: view(웹페이지)를 담당하는 controller
Tl1 Controller: woorinet(우리넷)의 TL1 api를 통해 받은 데이터 값을 관리하는 controller
Sdn Controller: TL1데이터를 모비젠 DB 스키마에 맞춘 데이터를 관리하는 controller
Hola Controller: Sdn(모비젠 DB 스키마)를 Hola 라는 SKT 사이트의 형태로 맞춘 데이터를 관리하는 controller

Tl1 -> Sdn -> Hola 순으로 되어 있다.( TL1 데이터를 Sdn데이터로 변환, Sdn 데이터를 Hola데이터로 가공 해서 사용 하고 있다.)

 */

@SpringBootApplication
public class DemoApplication {
	@Autowired
	private QNETMapper qnetMapper;

	@Autowired
	private static Tl1EventTcaRepository tl1EventTcaRepository;

	@Autowired
	private static Tl1EventAlmRepository tl1EventAlmRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		/*
		스프링 부트가 실행되고 있는 동안에는 계속해서 Event 데이터를 받아서 DB에 저장 하고 있다.
		*/
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
						String[] fields = ConvertResponseForAlm(result);
						Tl1EventAlm tl1EventAlm = new Tl1EventAlm(fields);
						tl1EventAlmRepository.save(tl1EventAlm);
					}
					System.out.println(result);
				}

			}
		} catch (Exception e) {

		}

	}
	private static String[] ConvertResponseForAlm(String data) throws Exception {
		String[] convData = data.split("\n");
		String[] result;

		String TID = "";
		String AID = "";
		String NAME = "";
		String UNIT = "";
		String REASON = "";
		String SEV = "";
		String SA = "";
		String DATETIME = "";
		String EVENT_DATETIME = "";

		for(String line: convData) {
			line = line.trim();

			if (line.startsWith("EMS")) {
				TID = line.split(" ")[0];
				EVENT_DATETIME = line.split(" ")[2];
			} else if (line.contains("/*") && line.contains("*/")) {
				line = line.replace("/*", "");
				line = line.replace("*/", "");

				String[] columns = line.split(",");
				AID = columns[0];
				NAME = columns[1];
				UNIT = columns[2];
				REASON = columns[3];
				SEV = columns[4];
				SA = columns[5];
				DATETIME = columns[6];
			}

		}


		result = new String[]{TID,AID,NAME,UNIT,REASON,SEV,SA,DATETIME,EVENT_DATETIME};

		return result;
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

