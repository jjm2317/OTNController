package com.woorinet.plugin.demo.Tl1;

import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Mapper.TL1Mapper;
import com.woorinet.plugin.demo.Repository.TL1.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TL1Manager {
    int CTAG;

    List<NODE> nodeList;
//    ODU_MPLS_IFRepository odu_mpls_ifRepository;
    Tl1SystemInfoRepository tl1SystemInfoRepository;
    Tl1SlotRepository tl1SlotRepository;
    Tl1EthPortRepository tl1EthPortRepository;
    Tl1NodeConnectorRepository tl1NodeConnectorRepository;
    Tl1CesNodeConnectorRepository tl1CesNodeConnectorRepository;
    Tl1OduNodeConnectorRepository tl1OduNodeConnectorRepository;
    Tl1MplsIfRepository tl1MplsIfRepository;
    Tl1OduMplsIfRepository tl1OduMplsIfRepository;
    Tl1StunnelRepository tl1StunnelRepository;
    Tl1StunnelExtRepository tl1StunnelExtRepository;
    Tl1StunnelTransitRepository tl1StunnelTransitRepository;
    Tl1TunnelPortRepository tl1TunnelPortRepository;
    Tl1AccessIfRepository tl1AccessIfRepository;
    PMRepository pmRepository;
    PM_PORTRepository pm_portRepository;
    PM_ACRepositiory pm_acRepositiory;
    PM_PWRepository pmPwRepository;
    PM_TUNNELRepository pm_tunnelRepository;
    INVENTORYRepository inventoryRepository;
    SESS_STATERepository sess_stateRepository;
    KEY_STATERepository key_stateRepository;
    MODULE_INFORepository module_infoRepository;
    CM_PORTRepository cm_portRepository;
    BYPASS_INFORepository bypass_infoRepository;
    CRYPTO_MODERepository crypto_modeRepository;
    CM_PROGRAM_INFORepository cm_program_infoRepository;

    SocketChannel socketChannel;
    List<Tl1AccessIf> Tl1AccessIfs;
    List<Tl1OduMplsIf> tl1OduMplsIfs;

    HashMap<String, Tl1AccessIf> accessIfHashMap = new HashMap<>();
    HashMap<String, Tl1OduMplsIf> odu_mpls_ifHashMap = new HashMap<>();

    public TL1Manager(int CTAG,
                      String ip,
                      int port,
                      Tl1SystemInfoRepository tl1SystemInfoRepository,
                      Tl1SlotRepository tl1SlotRepository,
                      Tl1EthPortRepository tl1EthPortRepository,
                      Tl1NodeConnectorRepository tl1NodeConnectorRepository,
                      Tl1CesNodeConnectorRepository tl1CesNodeConnectorRepository,
                      Tl1OduNodeConnectorRepository tl1OduNodeConnectorRepository,
                      Tl1MplsIfRepository tl1MplsIfRepository,
                      Tl1OduMplsIfRepository tl1OduMplsIfRepository,
                      Tl1StunnelRepository tl1StunnelRepository,
                      Tl1StunnelExtRepository tl1StunnelExtRepository,
                      Tl1StunnelTransitRepository tl1StunnelTransitRepository,
                      Tl1TunnelPortRepository tl1TunnelPortRepository,
                      Tl1AccessIfRepository tl1AccessIfRepository,
                      PMRepository pmRepository,
                      PM_PORTRepository pm_portRepository,
                      PM_ACRepositiory pm_acRepositiory,
                      PM_PWRepository pmPwRepository,
                      PM_TUNNELRepository pm_tunnelRepository,
                      INVENTORYRepository inventoryRepository,
                      SESS_STATERepository sess_stateRepository,
                      KEY_STATERepository key_stateRepository,
                      MODULE_INFORepository module_infoRepository,
                      CM_PORTRepository cm_portRepository,
                      BYPASS_INFORepository bypass_infoRepository,
                      CRYPTO_MODERepository crypto_modeRepository,
                      CM_PROGRAM_INFORepository cm_program_infoRepository ) throws IOException {
        this.CTAG = CTAG;
        this.nodeList = new ArrayList<>();
//        this.odu_mpls_ifRepository = odu_mpls_ifRepository;
        this.tl1SystemInfoRepository = tl1SystemInfoRepository;
        this.tl1SlotRepository = tl1SlotRepository;
        this.tl1EthPortRepository = tl1EthPortRepository;
        this.tl1NodeConnectorRepository = tl1NodeConnectorRepository;
        this.tl1CesNodeConnectorRepository = tl1CesNodeConnectorRepository;
        this.tl1OduNodeConnectorRepository = tl1OduNodeConnectorRepository;
        this.tl1MplsIfRepository = tl1MplsIfRepository;
        this.tl1OduMplsIfRepository = tl1OduMplsIfRepository;
        this.tl1StunnelRepository = tl1StunnelRepository;
        this.tl1StunnelExtRepository = tl1StunnelExtRepository;
        this.tl1StunnelTransitRepository = tl1StunnelTransitRepository;
        this.tl1TunnelPortRepository = tl1TunnelPortRepository;
        this.tl1AccessIfRepository = tl1AccessIfRepository;
        this.pmRepository = pmRepository;
        this.pm_portRepository = pm_portRepository;
        this.pm_acRepositiory = pm_acRepositiory;
        this.pmPwRepository = pmPwRepository;
        this.pm_tunnelRepository = pm_tunnelRepository;
        this.inventoryRepository = inventoryRepository;
        this.sess_stateRepository = sess_stateRepository;
        this.key_stateRepository = key_stateRepository;
        this.module_infoRepository = module_infoRepository;
        this.cm_portRepository = cm_portRepository;
        this.bypass_infoRepository = bypass_infoRepository;
        this.crypto_modeRepository = crypto_modeRepository;
        this.cm_program_infoRepository = cm_program_infoRepository;

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
            nodeList.add(new NODE(fields));
        }
    }

    public void Tl1SyncSystemInfo() throws Exception {
        for(NODE node : nodeList) {
            String cmd = "RTRV-SYS:" + node.getTID() + ":::[" + CTAG + "];";
            Map<String, String> fields = ConvertResponse2(ExecuteCmd(cmd));
            Tl1SystemInfo info = new Tl1SystemInfo(
                    fields.get("TID") == null ? "" : fields.get("TID"),
                    fields.get("UID") == null ? "" : fields.get("UID"),
                    fields.get("LOCATION") == null ? "" : fields.get("LOCATION"),
                    fields.get("VENDOR") == null ? "" : fields.get("VENDOR"),
                    fields.get("PWOAM") == null ? "" : fields.get("PWOAM"),
                    fields.get("BOOT-TIME") == null ? "" : fields.get("BOOT-TIME"),
                    fields.get("RESET-REASON") == null ? "" : fields.get("RESET-REASON"));
            tl1SystemInfoRepository.save(info);
        }
    }

    public void Tl1SyncSlot() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-SLOT:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1SlotRepository.save(new Tl1Slot(fields));
            }
        }
    }

    public void Tl1SyncEthPort() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-ETH-PORT:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1EthPortRepository.save(new Tl1EthPort(fields));
            }
        }
    }

    public void Tl1SyncNodeConnector() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-NODE-CONNECTOR:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1NodeConnectorRepository.save(new Tl1NodeConnector(fields));
            }
        }
    }

    public void Tl1SyncCesNodeConnector() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-CES-NODE-CONNECTOR:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1CesNodeConnectorRepository.save(new Tl1CesNodeConnector(fields));
            }
        }
    }

    public void Tl1SyncOduNodeConnector() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-ODU-NODE-CONNECTOR:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1OduNodeConnectorRepository.save(new Tl1OduNodeConnector(fields));
            }
        }
    }

    public void Tl1SyncMplsIf() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-MPLS-IF:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1MplsIfRepository.save(new Tl1MplsIf(fields));
            }
        }
    }

    public void Tl1SyncOduMplsIf() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-ODU-MPLS-IF:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1OduMplsIfRepository.save(new Tl1OduMplsIf(fields));
            }
        }
    }

    public void Tl1SyncSTunnel() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-STUNNEL:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelRepository.save(new Tl1Stunnel(fields));
            }
        }
    }

    public void Tl1SyncSTunnelExt() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-STUNNEL-EXT:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelExtRepository.save(new Tl1StunnelExt(fields));
            }
        }
    }

    public void Tl1SyncSTunnelTransit() throws Exception {
        for(NODE node: nodeList) {
            String cmd = "RTRV-STUNNEL-TRANSIT:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelTransitRepository.save(new Tl1StunnelTransit(fields));
            }
        }
    }

    public void Tl1SyncTunnelProt() throws Exception {
        for(NODE node : nodeList) {
            String cmd = "RTRV-TUNNEL-PROT:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1TunnelPortRepository.save(new Tl1TunnelPort(fields));
            }
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

    public void Tl1SyncAccessIf() throws Exception {
        for(NODE node:nodeList) {
            String cmd = "RTRV-ACCESS-IF:" + node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1AccessIfRepository.save(new Tl1AccessIf(fields));
            }
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

    public void Tl1SyncOPTICPOWER(String TID, TL1Mapper tl1Mapper) throws Exception {
        String cmd = "RTRV-OPTIC-POWER:" + TID + ";";
        tl1Mapper.initDatabase();
        tl1Mapper.initOpticPowerTable();
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            System.out.println(fields);
            tl1Mapper.insertOpticPower(new OPTIC_POWER(fields));
        }
    }

    public void TL1SyncPM(int CTAG, List<Tl1OduNodeConnector> tl1OduNodeConnectors, List<Tl1OduMplsIf> tl1OduMplsIfs) throws Exception {
        for (Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectors) {
            String TID = tl1OduNodeConnector.getTID();
            String AID = tl1OduNodeConnector.getAID();
            String SIGNAL = getMITypeByTID(tl1OduMplsIfs, TID);
            String cmd = "RTRV-PM:" + TID +":" + AID + ":" + CTAG + ":SIGNAL=" + SIGNAL + ",INTERVAL=15MIN,TYPE=CURR;";

            ArrayList<String[]> fieldsList = ConvertResponse((ExecuteCmd(cmd)));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                pmRepository.save(new PM(fields));
            }
        }
    }

    public void Tl1SyncPmPort(int CTAG, List<Tl1OduNodeConnector> tl1OduNodeConnectors) throws Exception {

        for (Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectors) {
            String cmd = "RTRV-PM-PORT:" + tl1OduNodeConnector.getTID() +":" + tl1OduNodeConnector.getAID() +":"+ CTAG +":pm-time=15MIN;";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                pm_portRepository.save(new PM_PORT(fields));

            }
        }
    }

    public void TL1SyncPmAc(int CTAG, List<MPLS_AC> mplsAcs) throws Exception {
        for (MPLS_AC mplsAc : mplsAcs) {
            String cmd = "RTRV-PM-AC:" + mplsAc.getTID() + "::"+ CTAG +":ac-id="+ mplsAc.getAC_ID() +",pm-time=15MIN;";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                System.out.println(fields);
                pm_acRepositiory.save(new PM_AC(fields));
            }
        }

    }

    public void TL1SyncPmPw(int CTAG, List<NODE> nodes) throws Exception {
        for (NODE node : nodes) {
            String cmd = "RTRV-PM-PW:" + node.getTID() + "::" + CTAG + ":pm-time=15MIN;";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                System.out.println(fields);
                pmPwRepository.save(new PM_PW(fields));
            }
        }

    }

    public void TL1SyncPmTunnel(int CTAG, List<NODE> nodes) throws Exception {
        for (NODE node : nodes) {
            String cmd = "RTRV-PM-TUNNEL:" + node.getTID() + "::" + CTAG + ":pm-time=15MIN;";
            ArrayList<String[]> fieldList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldList) {
                System.out.println(fields);
                pm_tunnelRepository.save(new PM_TUNNEL(fields));
            }
        }

    }

    public void TL1SyncInventory(List<NODE> nodes) throws  Exception {
        for (NODE node : nodes) {
            String cmd = "RTRV-INVENTORY:" + node.getTID() +";";
            System.out.println(cmd);
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                inventoryRepository.save(new INVENTORY(fields));
            }
        }
    }

    public void TL1SyncSessState(List<NODE> nodes, List<Tl1NodeConnector> node_connectors) throws Exception {
        for (NODE node : nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue;
            String TID = node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(node_connectors, TID);
            String cmd = "RTRV-SESS-STATE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                sess_stateRepository.save(new SESS_STATE(fields));
            }
        }
    }

    public void TL1SyncKeyState(List<NODE> nodes, List<Tl1NodeConnector> node_connectors) throws Exception {
        for (NODE node : nodes) {
            if(!node.getNODE_TYPE().equals( "otn")) continue;
            String TID = node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(node_connectors, TID);
            String cmd = "RTRV-KEY-STATE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                key_stateRepository.save(new KEY_STATE(fields));
            }
        }
    }

    public void TL1SyncModuleInfo(List<NODE> nodes, List<Tl1NodeConnector> node_connectors) throws Exception {
        for (NODE node : nodes) {
            if(!node.getNODE_TYPE().equals( "otn")) continue;
            String TID = node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(node_connectors, TID);
            String cmd = "RTRV-MODULE-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                module_infoRepository.save(new MODULE_INFO(fields));
            }
        }
    }

    public void TL1SyncCmPort(List<NODE> nodes, List<Tl1NodeConnector> node_connectors) throws Exception {
        for (NODE node : nodes) {
            if(!node.getNODE_TYPE().equals( "otn")) continue;
            String TID = node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(node_connectors, TID);
            String cmd = "RTRV-CM-PORT:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                cm_portRepository.save(new CM_PORT(fields));
            }
        }
    }

    public void TL1SyncBypassInfo(List<NODE> nodes, List<Tl1NodeConnector> node_connectors) throws Exception {
        for (NODE node : nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue;
            String TID = node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(node_connectors, TID);
            String cmd = "RTRV-BYPASS-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                bypass_infoRepository.save(new BYPASS_INFO(fields));
            }
        }
    }

    public void TL1SyncCryptoMode(List<NODE> nodes, List<Tl1NodeConnector> node_connectors) throws Exception {
        for (NODE node : nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue;
            String TID = node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(node_connectors, TID);
            String cmd = "RTRV-CRYPTO-MODE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                crypto_modeRepository.save(new CRYPTO_MODE(fields));
            }
        }
    }

    public void TL1SyncCmProgramInfo(List<NODE> nodes, List<Tl1NodeConnector> node_connectors) throws Exception {
        for (NODE node : nodes) {
            if(!node.getNODE_TYPE().equals("otn")) continue;
            String TID = node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(node_connectors, TID);
            String cmd = "RTRV-CM-PROGRAM-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                cm_program_infoRepository.save(new CM_PROGRAM_INFO(fields));
            }
        }
    }

    public String getSlotIndexByTID(List<Tl1NodeConnector> node_connectors, String TID) {
        String result = "";
        for(Tl1NodeConnector node_connector : node_connectors) {
            if(!node_connector.getTID().equals(TID)) continue;
            if(!node_connector.getSLOT_TYPE().equals("O208CLU") && !node_connector.getSLOT_TYPE().equals("O401CLU")) continue;
            result = node_connector.getSLOT_INDEX();
            return result;
        }
        return result;
    }

    public String getMITypeByTID(List<Tl1OduMplsIf> tl1OduMplsIfs, String TID) {
        String result = "";
        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfs) {
            if (!tl1OduMplsIf.getTID().equals(TID)) continue;
            result = tl1OduMplsIf.getMPLSIF_TYPE();
            return result;
        }
        return result;
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
