package com.woorinet.plugin.demo.Tl1;

import com.woorinet.plugin.demo.DTO.Node;
import com.woorinet.plugin.demo.Mapper.NodeMapper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

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

    public void Tl1GetNodeList(int CTAG, NodeMapper nodeMapper) throws Exception {
        String cmd = "RTRV-NET:::[" + CTAG + "];";
        nodeMapper.initDatabase();
        nodeMapper.initTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            nodeMapper.insertNode(new Node(fields));
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
        socketChannel.read(byteBuffer);
        byteBuffer.flip();
        return charset.decode(byteBuffer).toString();
    }

    public ArrayList<String[]> ConvertResponse(String data) throws Exception {
        String[] convData1 = data.split("\n");

        ArrayList<String[]> result = new ArrayList<>();

        int i = 0;
        for (String line: convData1) {
            System.out.println("line["+ (i++) + "]:" + line);
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
                    System.out.println(fields[j]);
                    fields[j] = fields[j].trim();
                }
                System.out.println("len: " + fields.length);

//                Node node = new Node(fields);
//                System.out.println(node.toString());
//
//                nodeMapper.insertNode(node);

                result.add(fields);
            }
        }
        return result;
    }

    public void close() throws IOException {
        socketChannel.close();
    }
}
