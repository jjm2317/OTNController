package com.woorinet.plugin.demo.Tl1;

import com.woorinet.plugin.demo.DTO.*;
import com.woorinet.plugin.demo.Mapper.TL1Mapper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manager {
    SocketChannel socketChannel;

    public Manager(String ip, int port) throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        socketChannel.connect(new InetSocketAddress(ip, port));
    }

    public void Tl1Login(String id, String password) throws IOException {
        String cmd = "ACT-USER:::100:" + id + "," + password + ";";
        System.out.println("Receive Data: " + ExecuteCmd(cmd));
    }

    public void Tl1Logout(String id) throws IOException {
        String cmd = "CANC-USER:::100:" + id + ";";
        System.out.println("Receive Data: " + ExecuteCmd(cmd));
    }

    public void Tl1SyncNodeList(int CTAG, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-NET:::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initNodeTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertNode(new NODE(fields));
        }
    }

    public void Tl1SyncSystemInfo(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SYS:" + TID + ":::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initSystemInfoTable();
        Map<String, String> fields = ConvertResponse2(ExecuteCmd(cmd));
        SYSTEM_INFO info = new SYSTEM_INFO(
                fields.get("TID"),
                fields.get("UID"),
                fields.get("LOCATION"),
                fields.get("VENDOR"),
                fields.get("PWOAM"),
                fields.get("BOOT-TIME"),
                fields.get("RESET-REASON")
        );
        tl1Mapper.insertSystemInfo(info);
    }

    public void Tl1SyncSlot(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SLOT:" + TID + "::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initSlotTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertSlot(new SLOT(fields));
        }
    }

    public void Tl1SyncEthPort(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ETH-PORT:" + TID + "::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initEthPortTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertEthPort(new ETH_PORT(fields));
        }
    }

    public void Tl1SyncNodeConnector(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-NODE-CONNECTOR:" + TID + "::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initNodeConnectorTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertNodeConnector(new NODECONNECTOR(fields));
        }
    }

    public void Tl1SyncCesNodeConnector(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-CES-NODE-CONNECTOR:" + TID + "::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initCesNodeConnectorTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertCesNodeConnector(new CES_NODE_CONNECTOR(fields));
        }
    }

    public void Tl1SyncOduNodeConnector(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ODU-NODE-CONNECTOR:" + TID + "::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initOduNodeConnectorTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertOduNodeConnector(new ODU_NODE_CONNECTOR(fields));
        }
    }

    public void Tl1SyncMplsIf(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-MPLS-IF:" + TID + "::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initMplsIfTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertMplsIf(new MPLS_IF(fields));
        }
    }

    public void Tl1SyncOduMplsIf(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ODU-MPLS-IF:" + TID + "::[" + CTAG + "];";
        tl1Mapper.initDatabase();
        tl1Mapper.initOduMplsIfTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertOduMplsIf(new ODU_MPLS_IF(fields));
        }
    }

    public String ExecuteCmd(String cmd) throws IOException {
        ByteBuffer byteBuffer;
        Charset charset = Charset.forName("UTF-8");

        byteBuffer = charset.encode(cmd);
        socketChannel.write(byteBuffer);
        System.out.println("Send Data: " + cmd);
        byteBuffer.flip();

        byteBuffer = ByteBuffer.allocate(1024);

        String bufferStr = "";
        String result = "";

        while (!bufferStr.contains(";")) {
            byteBuffer.clear();
            socketChannel.read(byteBuffer);
            byteBuffer.flip();
            bufferStr = charset.decode(byteBuffer).toString();
            result += bufferStr;
        }

        return result;
    }

    public ArrayList<String[]> ConvertResponse(String data) throws Exception {
        String[] convData1 = data.split("\n");

        ArrayList<String[]> result = new ArrayList<>();

        for (String line: convData1) {
            if (line.startsWith("   TL1ADAPTER")) {
                // Filter TL1ADAPTER
                System.out.println("TL1ADAPTER");
            } else if (line.startsWith("M")) {
                // Filter Response info
                System.out.println("INFO: " + line);
            } else if (line.contains("/*") && line.contains("*/")) {
                // Filter comment
                line = line.replace("/*", "");
                line = line.replace("*/", "");

                String[] columns = line.split(",");
                for (String column: columns ) {
                    System.out.println("column: " + column.trim());
                }
            }else if (line.contains("\"")) {
                //Filter Data
                line = line.replace("\"", "");
                System.out.println(line);

                String[] fields = line.split(",");
                for (int j=0; j<fields.length; j++) {
                    fields[j] = fields[j].trim();
                }
                System.out.println("line: " + fields.length);
                result.add(fields);
            }
        }
        return result;
    }

    public Map<String,String> ConvertResponse2(String data) {
        String[] convData1 = data.split("\n");

        Map<String,String> result = new HashMap<>();

        for (String line: convData1) {
            if (line.startsWith("   TL1ADAPTER")) {
                // Filter TL1ADAPTER
                System.out.println("TL1ADAPTER");
            } else if (line.startsWith("M")) {
                // Filter Response info
                System.out.println("INFO: " + line);
            } else if (line.contains("/*") && line.contains("*/")) {
                // Filter comment
                line = line.replace("/*", "");
                line = line.replace("*/", "");

                String[] columns = line.split(",");
                for (String column : columns) {
                    System.out.println("column: " + column.trim());
                }
            } else if (line.contains("\"")) {
                //Filter Data
                line = line.replace("\"", "");
                System.out.println(line);

                String[] values = line.split("=");
                result.put(values[0].trim(), values[1].trim());
            }
        }

        return result;
    }

    public void close() throws IOException {
        socketChannel.close();
    }
}
