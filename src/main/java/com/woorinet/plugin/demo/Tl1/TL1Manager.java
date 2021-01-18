package com.woorinet.plugin.demo.Tl1;

import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Mapper.TL1Mapper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TL1Manager {
    SocketChannel socketChannel;

    public TL1Manager(String ip, int port) throws IOException {
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
                fields.get("TID") == null ? "" : fields.get("TID"),
                fields.get("UID") == null ? "" : fields.get("UID"),
                fields.get("LOCATION") == null ? "" : fields.get("LOCATION"),
                fields.get("VENDOR") == null ? "" : fields.get("VENDOR"),
                fields.get("PWOAM") == null ? "" : fields.get("PWOAM"),
                fields.get("BOOT-TIME") == null ? "" : fields.get("BOOT-TIME"),
                fields.get("RESET-REASON") == null ? "" : fields.get("RESET-REASON"));
        tl1Mapper.insertSystemInfo(info);
    }

    public void Tl1SyncSlot(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SLOT:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initSlotTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertSlot(new SLOT(fields));
        }
    }

    public void Tl1SyncEthPort(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ETH-PORT:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initEthPortTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertEthPort(new ETH_PORT(fields));
        }
    }

    public void Tl1SyncNodeConnector(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-NODE-CONNECTOR:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initNodeConnectorTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertNodeConnector(new NODECONNECTOR(fields));
        }
    }

    public void Tl1SyncCesNodeConnector(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-CES-NODE-CONNECTOR:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initCesNodeConnectorTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertCesNodeConnector(new CES_NODE_CONNECTOR(fields));
        }
    }

    public void Tl1SyncOduNodeConnector(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ODU-NODE-CONNECTOR:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initOduNodeConnectorTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertOduNodeConnector(new ODU_NODE_CONNECTOR(fields));
        }
    }

    public void Tl1SyncMplsIf(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-MPLS-IF:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initMplsIfTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertMplsIf(new MPLS_IF(fields));
        }
    }

    public void Tl1SyncOduMplsIf(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ODU-MPLS-IF:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initOduMplsIfTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertOduMplsIf(new ODU_MPLS_IF(fields));
        }
    }

    public void Tl1SyncSTunnel(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-STUNNEL:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initSTunnelTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertSTunnel(new STUNNEL(fields));
        }
    }

    public void Tl1SyncSTunnelExt(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-STUNNEL-EXT:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initSTunnelExtTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertSTunnelExt(new STUNNEL_EXT(fields));
        }
    }

    public void Tl1SyncSTunnelTransit(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-STUNNEL-TRANSIT:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initSTunnelTransitTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertSTunnelTransit(new STUNNEL_TRANSIT(fields));
        }
    }

    public void Tl1SyncTunnelProt(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-TUNNEL-PROT:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initTunnelProtTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertTunnelProt(new TUNNEL_PROT(fields));
        }
    }

    public void Tl1SyncSpw(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SPW:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initSpwTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertSpw(new SPW(fields));
        }
    }

    public void Tl1SyncMSpw(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-MSPW:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initMSpwTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertMSpw(new MSPW(fields));
        }
    }

    public void Tl1SyncMplsAc(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-MPLS-AC:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initMplsAcTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertMplsAc(new MPLS_AC(fields));
        }
    }

    public void Tl1SyncAccessIf(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ACCESS-IF:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initAccessIfTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertAccessIf(new ACCESS_IF(fields));
        }
    }

    public void Tl1SyncService(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SERVICE:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initServiceTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertService(new SERVICE(fields));
        }
    }

    public void Tl1SyncServiceExt(int CTAG, String TID, String serviceName, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SERVICE-EXT:" + TID + "::" + CTAG + ":serv-name=" + serviceName + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initServiceExtTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertServiceExt(new SERVICE_EXT(fields));
        }
    }

    public void Tl1SyncServiceTunnel(int CTAG, String TID, String serviceName, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SERVICE-TUNNEL:" + TID + "::" + CTAG + ":serv-name=" + serviceName + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initServiceTunnelTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertServiceTunnel(new SERVICE_TUNNEL(fields));
        }
    }

    public void Tl1SyncServiceMspw(int CTAG, String TID, String serviceName, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-SERVICE-MSPW:" + TID + "::" + CTAG + ":serv-name=" + serviceName + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initServiceMspwTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertServiceMspw(new SERVICE_MSPW(fields));
        }
    }

    public void Tl1SyncOdu(int CTAG, String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-ODU:" + TID + "::" + CTAG + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initOduTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertOdu(new ODU(fields));
        }
    }

    public void Tl1SyncCesPort(String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-CES-PORT:" + TID + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initCesPortTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertCesPort(new CES_PORT(fields));
        }
    }

    public void Tl1SyncCesPw(String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-CES-PW:" + TID + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initCesPwTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertCesPw(new CES_PW(fields));
        }
    }

    public void Tl1SyncL2Lacp(String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-L2-LACP:" + TID + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initL2LacpTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            tl1Mapper.insertL2Lacp(new L2_LACP(fields));
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