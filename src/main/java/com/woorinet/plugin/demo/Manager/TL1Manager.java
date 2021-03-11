package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.TL1.*;
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

    List<Tl1Node> tl1NodeList;
    List<Tl1Service> serviceList;
    List<Tl1NodeConnector> tl1NodeConnectorList;
    List<Tl1OduMplsIf> tl1OduMplsIfList;
    List<Tl1OduNodeConnector> tl1OduNodeConnectorList;
    List<Tl1MplsAc> tl1MplsAcList;

    Tl1NodeRepository tl1NodeRepository;
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
    Tl1SpwRepository tl1SpwRepository;
    Tl1MspwRepository tl1MspwRepository;
    Tl1MplsAcRepository tl1MplsAcRepository;
    Tl1AccessIfRepository tl1AccessIfRepository;
    Tl1ServiceRepository tl1ServiceRepository;
    Tl1ServiceExtRepository tl1ServiceExtRepository;
    Tl1ServiceTunnelRepository tl1ServiceTunnelRepository;
    Tl1ServiceMspwRepository tl1ServiceMspwRepository;
    Tl1OduRepository tl1OduRepository;
    Tl1CesPortRepository tl1CesPortRepository;
    Tl1CesPwRepository tl1CesPwRepository;
    Tl1L2LacpRepository tl1L2LacpRepository;
    Tl1OpticPowerRepository tl1OpticPowerRepository;
    Tl1PmRepository tl1PmRepository;
    Tl1PmPortRepository tl1PmPortRepository;
    Tl1PmAcRepository tl1PmAcRepository;
    Tl1PmPwRepository pmPwRepository;
    Tl1PmTunnelRepository tl1PmTunnelRepository;
    Tl1InventoryRepository tl1InventoryRepository;
    Tl1SessStateRepository tl1SessStateRepository;
    Tl1KeyStateRepository tl1KeyStateRepository;
    Tl1ModuleInfoRepository tl1ModuleInfoRepository;
    Tl1CmPortRepository tl1CmPortRepository;
    Tl1BypassInfoRepository tl1BypassInfoRepository;
    Tl1CryptoModeRepository tl1CryptoModeRepository;
    Tl1CmProgramInfoRepository tl1CmProgramInfoRepository;

    SocketChannel socketChannel;
    List<Tl1AccessIf> Tl1AccessIfs;
    List<Tl1OduMplsIf> tl1OduMplsIfs;

    HashMap<String, Tl1AccessIf> accessIfHashMap = new HashMap<>();
    HashMap<String, Tl1OduMplsIf> odu_mpls_ifHashMap = new HashMap<>();

    public TL1Manager(int CTAG,
                      String ip,
                      int port,
                      Tl1NodeRepository tl1NodeRepository,
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
                      Tl1SpwRepository tl1SpwRepository,
                      Tl1MspwRepository tl1MspwRepository,
                      Tl1MplsAcRepository tl1MplsAcRepository,
                      Tl1AccessIfRepository tl1AccessIfRepository,
                      Tl1ServiceRepository tl1ServiceRepository,
                      Tl1ServiceExtRepository tl1ServiceExtRepository,
                      Tl1ServiceTunnelRepository tl1ServiceTunnelRepository,
                      Tl1ServiceMspwRepository tl1ServiceMspwRepository,
                      Tl1OduRepository tl1OduRepository,
                      Tl1CesPortRepository tl1CesPortRepository,
                      Tl1CesPwRepository tl1CesPwRepository,
                      Tl1L2LacpRepository tl1L2LacpRepository,
                      Tl1OpticPowerRepository tl1OpticPowerRepository,
                      Tl1PmRepository tl1PmRepository,
                      Tl1PmPortRepository tl1PmPortRepository,
                      Tl1PmAcRepository tl1PmAcRepository,
                      Tl1PmPwRepository pmPwRepository,
                      Tl1PmTunnelRepository tl1PmTunnelRepository,
                      Tl1InventoryRepository tl1InventoryRepository,
                      Tl1SessStateRepository tl1SessStateRepository,
                      Tl1KeyStateRepository tl1KeyStateRepository,
                      Tl1ModuleInfoRepository tl1ModuleInfoRepository,
                      Tl1CmPortRepository tl1CmPortRepository,
                      Tl1BypassInfoRepository tl1BypassInfoRepository,
                      Tl1CryptoModeRepository tl1CryptoModeRepository,
                      Tl1CmProgramInfoRepository tl1CmProgramInfoRepository) throws IOException {
        this.CTAG = CTAG;
        this.tl1NodeList = new ArrayList<>();
        this.serviceList = new ArrayList<>();
        this.tl1NodeConnectorList = new ArrayList<>();
        this.tl1OduMplsIfList = new ArrayList<>();
        this.tl1OduNodeConnectorList = new ArrayList<>();
        this.tl1MplsAcList = new ArrayList<>();

        this.tl1NodeRepository = tl1NodeRepository;
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
        this.tl1SpwRepository = tl1SpwRepository;
        this.tl1MspwRepository = tl1MspwRepository;
        this.tl1MplsAcRepository = tl1MplsAcRepository;
        this.tl1AccessIfRepository = tl1AccessIfRepository;
        this.tl1ServiceRepository = tl1ServiceRepository;
        this.tl1ServiceExtRepository = tl1ServiceExtRepository;
        this.tl1ServiceTunnelRepository = tl1ServiceTunnelRepository;
        this.tl1ServiceMspwRepository = tl1ServiceMspwRepository;
        this.tl1OduRepository = tl1OduRepository;
        this.tl1CesPortRepository = tl1CesPortRepository;
        this.tl1CesPwRepository = tl1CesPwRepository;
        this.tl1L2LacpRepository = tl1L2LacpRepository;
        this.tl1OpticPowerRepository = tl1OpticPowerRepository;

        this.tl1PmRepository = tl1PmRepository;
        this.tl1PmPortRepository = tl1PmPortRepository;
        this.tl1PmAcRepository = tl1PmAcRepository;
        this.pmPwRepository = pmPwRepository;
        this.tl1PmTunnelRepository = tl1PmTunnelRepository;
        this.tl1InventoryRepository = tl1InventoryRepository;
        this.tl1SessStateRepository = tl1SessStateRepository;
        this.tl1KeyStateRepository = tl1KeyStateRepository;
        this.tl1ModuleInfoRepository = tl1ModuleInfoRepository;
        this.tl1CmPortRepository = tl1CmPortRepository;
        this.tl1BypassInfoRepository = tl1BypassInfoRepository;
        this.tl1CryptoModeRepository = tl1CryptoModeRepository;
        this.tl1CmProgramInfoRepository = tl1CmProgramInfoRepository;

        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        socketChannel.connect(new InetSocketAddress(ip, port));
    }
    public void TL1SyncStart() throws IOException {
        try {
            //TL1 로그인
            Tl1Login("admin", "admin");
            //Node DB연동
            Tl1SyncNodeList();
            Tl1SyncOduNodeConnector();
            TL1SyncCmProgramInfo();
            //SystemInfo DB연동
            Tl1SyncSystemInfo();
            //Slot DB연동
            Tl1SyncSlot();
            //EthPort DB연동
            Tl1SyncEthPort();
            //NodeConnector DB연동
            Tl1SyncNodeConnector();
            //CesNodeConnector DB연동
            Tl1SyncCesNodeConnector();
            //OduNodeConnector DB연동
            Tl1SyncOduNodeConnector();
            //MPLS_IF DB연동
            Tl1SyncMplsIf();
            //ODU_MPLS_IF DB연동
            Tl1SyncOduMplsIf();
            //STUNNEL DB연동
            Tl1SyncSTunnel();
            //STUNNEL_EXT DB연동
            Tl1SyncSTunnelExt();
            //STUNNEL_TRANSIT DB연동
            Tl1SyncSTunnelTransit();
            //TUNNEL_PROT DB연동
            Tl1SyncTunnelProt();
            //SPW DB연동
            Tl1SyncSpw();
            //MSPW DB연동
            Tl1SyncMSpw();
            //MPLS_AC DB연동
            Tl1SyncMplsAc();
            //ACCESS_IF DB연동
            Tl1SyncAccessIf();
            //SERVICE DB연동
            Tl1SyncService();
            //SERVICE_EXT DB연동
            Tl1SyncServiceExt();
            //SERVICE_TUNNEL DB연동
            Tl1SyncServiceTunnel();
            //SERVICE_MSPW DB연동
            Tl1SyncServiceMspw();
            //ODU DB연동
            Tl1SyncOdu();
            //CES_PORT DB연동
            Tl1SyncCesPort();
            //CES_PW DB연동
            Tl1SyncCesPw();
            //L2Lacp DB연동
            Tl1SyncL2Lacp();
            //OPTIC-POWER DB연동
            Tl1SyncOPTICPOWER();
            //PM DB연동
            TL1SyncPM();
            //PM-PORT DB연동
            Tl1SyncPmPort();
            //PM-AC DB연동
            TL1SyncPmAc();
            //PM-PW DB연동
            TL1SyncPmPw();
            //PM-TUNNEL DB연동
            TL1SyncPmTunnel();
            //INVENTORY DB연동
            TL1SyncInventory();
            //SESS_STATE DB연동
            TL1SyncSessState();
            //KEY_STATE DB연동
            TL1SyncKeyState();
            //MODULE_INFO DB연동
            TL1SyncModuleInfo();
            //CM_PORT DB연동
            TL1SyncCmPort();
            //BYPASS_INFO DB연동
            TL1SyncBypassInfo();
            //CRYPTO_MODE DB연동
            TL1SyncCryptoMode();
            //CM_PROGRAM_INFO DB연동
            TL1SyncCmProgramInfo();
            //TL1 로그아웃
            Tl1Logout("admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Tl1Login(String id, String password) throws IOException {
        String cmd = "ACT-USER:::100:" + id + "," + password + ";";
        System.out.println("Receive Data: " + ExecuteCmd(cmd));
    }

    public void Tl1Logout(String id) throws IOException {
        String cmd = "CANC-USER:::100:" + id + ";";
        System.out.println("Receive Data: " + ExecuteCmd(cmd));
    }

    public void Tl1SyncNodeList() throws Exception {
        String cmd = "RTRV-NET:::[" + CTAG + "];";
        ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
        for (String[] fields: fieldsList) {
            Tl1Node tl1Node = new Tl1Node(fields);
            tl1NodeRepository.save(tl1Node);
            tl1NodeList.add(tl1Node);
        }
    }

    public void Tl1SyncSystemInfo() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SYS:" + tl1Node.getTID() + ":::[" + CTAG + "];";
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
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SLOT:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1SlotRepository.save(new Tl1Slot(fields));
            }
        }
    }

    public void Tl1SyncEthPort() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ETH-PORT:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1EthPortRepository.save(new Tl1EthPort(fields));
            }
        }
    }

    public void Tl1SyncNodeConnector() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-NODE-CONNECTOR:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1NodeConnector tl1NodeConnector = new Tl1NodeConnector(fields);
                tl1NodeConnectorRepository.save(tl1NodeConnector);
                tl1NodeConnectorList.add(tl1NodeConnector);
            }
        }
    }

    public void Tl1SyncCesNodeConnector() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-CES-NODE-CONNECTOR:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1CesNodeConnectorRepository.save(new Tl1CesNodeConnector(fields));
            }
        }
    }

    public void Tl1SyncOduNodeConnector() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ODU-NODE-CONNECTOR:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1OduNodeConnector tl1OduNodeConnector = new Tl1OduNodeConnector(fields);
                tl1OduNodeConnectorRepository.save(tl1OduNodeConnector);
                tl1OduNodeConnectorList.add(tl1OduNodeConnector);
            }
        }
    }

    public void Tl1SyncMplsIf() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-MPLS-IF:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1MplsIfRepository.save(new Tl1MplsIf(fields));
            }
        }
    }

    public void Tl1SyncOduMplsIf() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ODU-MPLS-IF:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1OduMplsIf tl1OduMplsIf = new Tl1OduMplsIf(fields);
                tl1OduMplsIfRepository.save(tl1OduMplsIf);
                tl1OduMplsIfList.add(tl1OduMplsIf);
            }
        }
    }

    public void Tl1SyncSTunnel() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-STUNNEL:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelRepository.save(new Tl1Stunnel(fields));
            }
        }
    }

    public void Tl1SyncSTunnelExt() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-STUNNEL-EXT:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelExtRepository.save(new Tl1StunnelExt(fields));
            }
        }
    }

    public void Tl1SyncSTunnelTransit() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-STUNNEL-TRANSIT:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelTransitRepository.save(new Tl1StunnelTransit(fields));
            }
        }
    }

    public void Tl1SyncTunnelProt() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-TUNNEL-PROT:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1TunnelPortRepository.save(new Tl1TunnelPort(fields));
            }
        }
    }

    public void Tl1SyncSpw() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SPW:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1SpwRepository.save(new Tl1Spw(fields));
            }
        }
    }

    public void Tl1SyncMSpw() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-MSPW:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1MspwRepository.save(new Tl1Mspw(fields));
            }
        }
    }

    public void Tl1SyncMplsAc() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-MPLS-AC:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1MplsAc tl1MplsAc = new Tl1MplsAc(fields);
                tl1MplsAcRepository.save(tl1MplsAc);
                tl1MplsAcList.add(tl1MplsAc);
            }
        }
    }

    public void Tl1SyncAccessIf() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ACCESS-IF:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1AccessIfRepository.save(new Tl1AccessIf(fields));
            }
        }
    }

    public void Tl1SyncService() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SERVICE:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1Service tl1Service = new Tl1Service(fields);
                tl1ServiceRepository.save(tl1Service);
                serviceList.add(tl1Service);
            }
        }
    }

    public void Tl1SyncServiceExt() throws Exception {
        for(Tl1Service tl1Service : serviceList) {
            String cmd = "RTRV-SERVICE-EXT:" + tl1Service.getTID() + "::" + CTAG + ":serv-name=" + tl1Service.getNAME() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1ServiceExtRepository.save(new Tl1ServiceExt(fields));
            }
        }
    }

    public void Tl1SyncServiceTunnel() throws Exception {
        for(Tl1Service tl1Service : serviceList) {
            String cmd = "RTRV-SERVICE-TUNNEL:" + tl1Service.getTID() + "::" + CTAG + ":serv-name=" + tl1Service.getNAME() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1ServiceTunnelRepository.save(new Tl1ServiceTunnel(fields));
            }
        }
    }

    public void Tl1SyncServiceMspw() throws Exception {
        for(Tl1Service tl1Service : serviceList) {
            String cmd = "RTRV-SERVICE-MSPW:" + tl1Service.getTID() + "::" + CTAG + ":serv-name=" + tl1Service.getNAME() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1ServiceMspwRepository.save(new Tl1ServiceMspw(fields));
            }
        }
    }

    public void Tl1SyncOdu() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ODU:" + tl1Node.getTID() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1OduRepository.save(new Tl1Odu(fields));
            }
        }
    }

    public void Tl1SyncCesPort() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-CES-PORT:" + tl1Node.getTID() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1CesPortRepository.save(new Tl1CesPort(fields));
            }
        }
    }

    public void Tl1SyncCesPw() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-CES-PW:" + tl1Node.getTID() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1CesPwRepository.save(new Tl1CesPw(fields));
            }
        }
    }

    public void Tl1SyncL2Lacp() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-L2-LACP:" + tl1Node.getTID() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1L2LacpRepository.save(new Tl1L2Lacp(fields));
            }
        }
    }

    public void Tl1SyncOPTICPOWER() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-OPTIC-POWER:" + tl1Node.getTID() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                System.out.println(fields);
                tl1OpticPowerRepository.save(new Tl1OpticPower(fields));
            }
        }
    }

    public void TL1SyncPM() throws Exception {
        for (Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectorList) {
            String TID = tl1OduNodeConnector.getTID();
            String AID = tl1OduNodeConnector.getAID();
            String SIGNAL = getMITypeByTID(tl1OduMplsIfList, TID);
            String cmd = "RTRV-PM:" + TID +":" + AID + ":" + CTAG + ":SIGNAL=" + SIGNAL + ",INTERVAL=15MIN,TYPE=CURR;";

            ArrayList<String[]> fieldsList = ConvertResponse((ExecuteCmd(cmd)));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1PmRepository.save(new Tl1Pm(fields));
            }
        }
    }

    public void Tl1SyncPmPort() throws Exception {

        for (Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectorList) {
            String cmd = "RTRV-PM-PORT:" + tl1OduNodeConnector.getTID() +":" + tl1OduNodeConnector.getAID() +":"+ CTAG +":pm-time=15MIN;";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1PmPortRepository.save(new Tl1PmPort(fields));
            }
        }
    }

    public void TL1SyncPmAc() throws Exception {
        for (Tl1MplsAc mplsAc : tl1MplsAcList) {
            String cmd = "RTRV-PM-AC:" + mplsAc.getTID() + "::"+ CTAG +":ac-id="+ mplsAc.getAC_ID() +",pm-time=15MIN;";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                System.out.println(fields);
                tl1PmAcRepository.save(new Tl1PmAc(fields));
            }
        }

    }

    public void TL1SyncPmPw() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-PM-PW:" + tl1Node.getTID() + "::" + CTAG + ":pm-time=15MIN;";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                System.out.println(fields);
                pmPwRepository.save(new Tl1PmPw(fields));
            }
        }

    }

    public void TL1SyncPmTunnel() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-PM-TUNNEL:" + tl1Node.getTID() + "::" + CTAG + ":pm-time=15MIN;";
            ArrayList<String[]> fieldList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldList) {
                System.out.println(fields);
                tl1PmTunnelRepository.save(new Tl1PmTunnel(fields));
            }
        }

    }

    public void TL1SyncInventory() throws  Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-INVENTORY:" + tl1Node.getTID() +";";
            System.out.println(cmd);
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1InventoryRepository.save(new Tl1Inventory(fields));
            }
        }
    }

    public void TL1SyncSessState() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNODE_TYPE().equals("otn")) continue;
            String TID = tl1Node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-SESS-STATE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1SessStateRepository.save(new Tl1SessState(fields));
            }
        }
    }

    public void TL1SyncKeyState() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNODE_TYPE().equals( "otn")) continue;
            String TID = tl1Node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-KEY-STATE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1KeyStateRepository.save(new Tl1KeyState(fields));
            }
        }
    }

    public void TL1SyncModuleInfo() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNODE_TYPE().equals( "otn")) continue;
            String TID = tl1Node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-MODULE-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1ModuleInfoRepository.save(new Tl1ModuleInfo(fields));
            }
        }
    }

    public void TL1SyncCmPort() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNODE_TYPE().equals( "otn")) continue;
            String TID = tl1Node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-CM-PORT:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1CmPortRepository.save(new Tl1CmPort(fields));
            }
        }
    }

    public void TL1SyncBypassInfo() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNODE_TYPE().equals("otn")) continue;
            String TID = tl1Node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-BYPASS-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1BypassInfoRepository.save(new Tl1BypassInfo(fields));
            }
        }
    }

    public void TL1SyncCryptoMode() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNODE_TYPE().equals("otn")) continue;
            String TID = tl1Node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-CRYPTO-MODE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1CryptoModeRepository.save(new Tl1CryptoMode(fields));
            }
        }
    }

    public void TL1SyncCmProgramInfo() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNODE_TYPE().equals("otn")) continue;
            String TID = tl1Node.getTID();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-CM-PROGRAM-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                System.out.println(fields);
                tl1CmProgramInfoRepository.save(new Tl1CmProgramInfo(fields));
            }
        }
    }

    public String getSlotIndexByTID(List<Tl1OduNodeConnector> tl1OduNodeConnectorList, String TID) {
        String result = "";
        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectorList) {
            if(!tl1OduNodeConnector.getTID().equals(TID)) continue;
            if(!tl1OduNodeConnector.getSLOT_TYPE().equals("O208CLU") && !tl1OduNodeConnector.getSLOT_TYPE().equals("O401CLU")) continue;
            result = tl1OduNodeConnector.getSLOT_INDEX();
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

        ArrayList<String> keyList = new ArrayList<>();
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
                    keyList.add(column.trim());
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

        //Filter result not containing DATE value
        boolean hasDate = false;
        for(String key : keyList) {
            if(key.contains("DATE")) hasDate = true;
        }
        if(!hasDate) return result;

        //Fix result : num of key list  != num of value list (caused by DATE value)
        System.out.println("datevalue start");
        for( int r=0 ;r< result.size(); r++ ) {
            String []rowValue = result.get(r);

            //Filter exact value
            if( rowValue.length == keyList.size()) continue;

            String[] newValue = new String[keyList.size()];

            for( int i = 0, k = 0 ; i < newValue.length; i ++, k ++) {
                if(!keyList.get(i).contains("DATE")) {
                    newValue[i] = rowValue[k];
                    continue;
                }
                newValue[i] = rowValue[k] + "_" +  rowValue[k + 1];
                k ++;
            }

            result.set(r,newValue);
        }
        return result;
    }

//    private void checkResult(ArrayList result) {
//
//    }

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