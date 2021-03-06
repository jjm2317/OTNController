package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.DTO.TL1.CM.*;
import com.woorinet.plugin.demo.DTO.TL1.PM.*;
import com.woorinet.plugin.demo.Repository.TL1.*;
import com.woorinet.plugin.demo.Repository.TL1.CM.*;
import com.woorinet.plugin.demo.Repository.TL1.PM.*;
import me.saro.commons.ftp.FTP;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tl1Manager {
    String syncDate;
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
    Tl1PmPwRepository tl1PmPwRepository;
    Tl1PmTunnelRepository tl1PmTunnelRepository;
    Tl1PmTemperatureRepository tl1PmTemperatureRepository;
    Tl1PmAcRepository tl1PmAcRepository;
    Tl1PmOpticRepository tl1PmOpticRepository;
    Tl1PmRepository tl1PmRepository;
    Tl1PmPortRepository tl1PmPortRepository;
    Tl1PmOpticTemperatureRepository tl1PmOpticTemperatureRepository;
    Tl1InventoryRepository tl1InventoryRepository;
    Tl1SessStateRepository tl1SessStateRepository;
    Tl1KeyStateRepository tl1KeyStateRepository;
    Tl1ModuleInfoRepository tl1ModuleInfoRepository;
    Tl1CmPortRepository tl1CmPortRepository;
    Tl1BypassInfoRepository tl1BypassInfoRepository;
    Tl1CryptoModeRepository tl1CryptoModeRepository;
    Tl1CmProgramInfoRepository tl1CmProgramInfoRepository;
    Tl1QkdInfoRepository tl1QkdInfoRepository;

    SocketChannel socketChannel;

    List<String> pmPwFilepathList;
    List<String> pmTunnelFilepathList;
    List<String> pmTemperatureFilepathList;
    List<String> pmAcFilepathList;
    List<String> pmOpticFilepathList;
    List<String> pmFilepathList;
    List<String> pmPortFilepathList;
    List<String> pmOpticTemperatureFilepathList;

    public Tl1Manager(
                      String syncDate,
                      int CTAG,
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
                      Tl1PmPwRepository tl1PmPwRepository,
                      Tl1PmTunnelRepository tl1PmTunnelRepository,
                      Tl1PmTemperatureRepository tl1PmTemperatureRepository,
                      Tl1PmAcRepository tl1PmAcRepository,
                      Tl1PmOpticRepository tl1PmOpticRepository,
                      Tl1PmRepository tl1PmRepository,
                      Tl1PmPortRepository tl1PmPortRepository,
                      Tl1PmOpticTemperatureRepository tl1PmOpticTemperatureRepository,
                      Tl1InventoryRepository tl1InventoryRepository,
                      Tl1SessStateRepository tl1SessStateRepository,
                      Tl1KeyStateRepository tl1KeyStateRepository,
                      Tl1ModuleInfoRepository tl1ModuleInfoRepository,
                      Tl1CmPortRepository tl1CmPortRepository,
                      Tl1BypassInfoRepository tl1BypassInfoRepository,
                      Tl1CryptoModeRepository tl1CryptoModeRepository,
                      Tl1CmProgramInfoRepository tl1CmProgramInfoRepository,
                      Tl1QkdInfoRepository tl1QkdInfoRepository
                      ) throws IOException {
        this.syncDate = syncDate;
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

        this.tl1PmPwRepository = tl1PmPwRepository;
        this.tl1PmTunnelRepository = tl1PmTunnelRepository;
        this.tl1PmTemperatureRepository = tl1PmTemperatureRepository;
        this.tl1PmAcRepository = tl1PmAcRepository;
        this.tl1PmOpticRepository = tl1PmOpticRepository;
        this.tl1PmRepository =tl1PmRepository;
        this.tl1PmPortRepository = tl1PmPortRepository;
        this.tl1PmOpticTemperatureRepository = tl1PmOpticTemperatureRepository;
        this.tl1InventoryRepository = tl1InventoryRepository;
        this.tl1SessStateRepository = tl1SessStateRepository;
        this.tl1KeyStateRepository = tl1KeyStateRepository;
        this.tl1ModuleInfoRepository = tl1ModuleInfoRepository;
        this.tl1CmPortRepository = tl1CmPortRepository;
        this.tl1BypassInfoRepository = tl1BypassInfoRepository;
        this.tl1CryptoModeRepository = tl1CryptoModeRepository;
        this.tl1CmProgramInfoRepository = tl1CmProgramInfoRepository;
        this.tl1QkdInfoRepository = tl1QkdInfoRepository;

        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        socketChannel.connect(new InetSocketAddress(ip, port));

        this.pmPwFilepathList = new ArrayList<>();
        this.pmTunnelFilepathList  = new ArrayList<>();
        this.pmTemperatureFilepathList  = new ArrayList<>();
        this.pmAcFilepathList  = new ArrayList<>();
        this.pmOpticFilepathList  = new ArrayList<>();
        this.pmFilepathList  = new ArrayList<>();
        this.pmPortFilepathList  = new ArrayList<>();
        this.pmOpticTemperatureFilepathList  = new ArrayList<>();
    }
    public void Tl1PmWithFtpSyncStart() throws Exception {
        try {
            String host = "woorinet.speedvpn.net";
            int port = 621;
            String user = "ftpuser";
            String pass = "ftp-123456";
            FTP ftp = FTP.openFTP(host, port, user, pass);
            String tl1 = "TL1";

            String localPath = "./ftp";
            File localPathFile = new File(localPath);


            localPathFile.mkdirs();
            System.out.println(tl1+" Ftp down start");
            ftpDownAllFiles(ftp, localPath);
            System.out.println(tl1+" Ftp down end");

            System.out.println(tl1+" PmPw sync start");
            Tl1SyncPmPw();
            System.out.println(tl1+" PmPw sync end");
            System.out.println(tl1+" PmTunnel sync start");
            Tl1SyncPmTunnel();
            System.out.println(tl1+" PmTunnel sync end");
            System.out.println(tl1+" PmTemperature sync start");
            Tl1SyncPmTemperature();
            System.out.println(tl1+" PmTemperature sync end");
            System.out.println(tl1+" PmAc sync start");
            Tl1SyncPmAc();
            System.out.println(tl1+" PmAc sync end");
            System.out.println(tl1+" PmOptic sync start");
            Tl1SyncPmOptic();
            System.out.println(tl1+" PmOptic sync end");
            System.out.println(tl1+" Pm sync start");
            Tl1SyncPm();
            System.out.println(tl1+" Pm sync end");
            System.out.println(tl1+" PmPort sync start");
            Tl1SyncPmPort();
            System.out.println(tl1+" PmPort sync end");
            System.out.println(tl1+" PmOpticTemperature sync start");
            Tl1SyncPmOpticTemperature();
            System.out.println(tl1+" PmOpticTemperature sync end");

            rmLocalFtpFolder(localPathFile);
            ftp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void Tl1SyncPmPw() throws Exception {
        tl1PmPwRepository.deleteAll();
        pmPwFilepathList.forEach(e->{
            try {
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmPwRepository.save(new Tl1PmPw(fields, syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void Tl1SyncPmTunnel() throws Exception {
        tl1PmTunnelRepository.deleteAll();
        pmTunnelFilepathList.forEach(e-> {
            try {
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmTunnelRepository.save(new Tl1PmTunnel(fields, syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void Tl1SyncPmTemperature() throws Exception {
        tl1PmTemperatureRepository.deleteAll();
        pmTemperatureFilepathList.forEach(e-> {
            try{
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmTemperatureRepository.save(new Tl1PmTemperature(fields, syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void Tl1SyncPmAc() throws Exception {
        tl1PmAcRepository.deleteAll();
        pmAcFilepathList.forEach(e->{
            try{
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmAcRepository.save(new Tl1PmAc(fields,syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void Tl1SyncPmOptic() throws Exception {
        tl1PmOpticRepository.deleteAll();
        pmOpticFilepathList.forEach(e-> {
            try{
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmOpticRepository.save(new Tl1PmOptic(fields,syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void Tl1SyncPm() throws Exception {
        tl1PmRepository.deleteAll();
        pmFilepathList.forEach(e-> {
            try{
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmRepository.save(new Tl1Pm(fields,syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void Tl1SyncPmPort() throws Exception {
        tl1PmPortRepository.deleteAll();
        pmPortFilepathList.forEach(e-> {
            try{
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmPortRepository.save(new Tl1PmPort(fields, syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void Tl1SyncPmOpticTemperature() throws Exception {
        tl1PmOpticTemperatureRepository.deleteAll();
        pmOpticTemperatureFilepathList.forEach(e-> {
            try{
                ArrayList<String[]> fieldsList = convertTxtFileResponse(e);
                for(String[] fields : fieldsList) {
                    tl1PmOpticTemperatureRepository.save(new Tl1PmOpticTemperature(fields, syncDate));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private void ftpDownAllFiles(FTP ftp, String localPath) throws Exception {
        ftp.listFiles().forEach(e -> {
            try {
                String pathName = localPath + "/" + e;
                ftp.recv(e, new File(pathName));
                String []splitDataList = e.split("_");
                String tableName = "";
                for(String splitData : splitDataList) {
                    if( '0' <=splitData.charAt(0) &&splitData.charAt(0) <='9') break;
                    else tableName += splitData + "_";
                }
                tableName = tableName.replaceFirst(".$",""); // 마지막 문자 '_' 제거

                if(tableName.equals("PM_PW")) pmPwFilepathList.add(pathName);
                else if(tableName.equals("PM_TUNNEL")) pmTunnelFilepathList.add(pathName);
                else if(tableName.equals("PM_TEMPERATURE")) pmTemperatureFilepathList.add(pathName);
                else if(tableName.equals("PM_AC")) pmAcFilepathList.add(pathName);
                else if(tableName.equals("PM_OPTIC")) pmOpticFilepathList.add(pathName);
                else if(tableName.equals("PM")) pmFilepathList.add(pathName);
                else if(tableName.equals("PM_PORT")) pmPortFilepathList.add(pathName);
                else if(tableName.equals("PM_OPTIC_TEMPERATURE")) pmOpticTemperatureFilepathList.add(pathName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
    private void rmLocalFtpFolder(File localPathFile) {
        File[] deleteFolderList = localPathFile.listFiles();
        for (int j = 0; deleteFolderList != null &&j < deleteFolderList.length; j++  ) {
            deleteFolderList[j].delete();
        }
        localPathFile.delete();
    }
    public void TL1SyncStart() throws IOException {
        try {
            String tl1 = "TL1";
            Tl1Login("admin", "admin");
            System.out.println(tl1+" Node sync start");
            Tl1SyncNodeList();
            System.out.println(tl1+" Node sync end");
            System.out.println(tl1+" OduNodeConnector sync start");
            Tl1SyncOduNodeConnector();
            System.out.println(tl1+" OduNodeConnector sync end");
            System.out.println(tl1+" CmProgramInfo sync start");
            TL1SyncCmProgramInfo();
            System.out.println(tl1+" CmProgramInfo sync end");
            System.out.println(tl1+" SystemInfo sync start");
            Tl1SyncSystemInfo();
            System.out.println(tl1+" SystemInfo sync end");
            System.out.println(tl1+" Slot sync start");
            Tl1SyncSlot();
            System.out.println(tl1+" Slot sync end");
            System.out.println(tl1+" EthPort sync start");
            Tl1SyncEthPort();
            System.out.println(tl1+" EthPort sync end");
            System.out.println(tl1+" NodeConnector sync start");
            Tl1SyncNodeConnector();
            System.out.println(tl1+" NodeConnector sync end");
            System.out.println(tl1+" CesNodeConnector sync start");
            Tl1SyncCesNodeConnector();
            System.out.println(tl1+" CesNodeConnector sync end");
            System.out.println(tl1+" OduNodeConnector sync start");
            Tl1SyncOduNodeConnector();
            System.out.println(tl1+" OduNodeConnector sync end");
            System.out.println(tl1+" MplsIf sync start");
            Tl1SyncMplsIf();
            System.out.println(tl1+" MplsIf sync end");
            System.out.println(tl1+" OduMplsIf sync start");
            Tl1SyncOduMplsIf();
            System.out.println(tl1+" OduMplsIf sync end");
            System.out.println(tl1+" STunnel sync start");
            Tl1SyncSTunnel();
            System.out.println(tl1+" STunnel sync end");
            System.out.println(tl1+" STunnelExt sync start");
            Tl1SyncSTunnelExt();
            System.out.println(tl1+" STunnelExt sync end");
            System.out.println(tl1+" Spw sync start");
            Tl1SyncSpw();
            System.out.println(tl1+" Spw sync end");
            System.out.println(tl1+" MSpw sync start");
            Tl1SyncMSpw();
            System.out.println(tl1+" MSpw sync end");
            System.out.println(tl1+" MplsAc sync start");
            Tl1SyncMplsAc();
            System.out.println(tl1+" MplsAc sync end");
            System.out.println(tl1+" AccessIf sync start");
            Tl1SyncAccessIf();
            System.out.println(tl1+" AccessIf sync end");
            System.out.println(tl1+" Service sync start");
            Tl1SyncService();
            System.out.println(tl1+" Service sync end");
            System.out.println(tl1+" ServiceExt sync start");
            Tl1SyncServiceExt();
            System.out.println(tl1+" ServiceExt sync end");
            System.out.println(tl1+" ServiceTunnel sync start");
            Tl1SyncServiceTunnel();
            System.out.println(tl1+" ServiceTunnel sync end");
            System.out.println(tl1+" ServiceMspw sync start");
            Tl1SyncServiceMspw();
            System.out.println(tl1+" ServiceMspw sync end");
            System.out.println(tl1+" Odu sync start");
            Tl1SyncOdu();
            System.out.println(tl1+" Odu sync end");
            System.out.println(tl1+" CesPort sync start");
            Tl1SyncCesPort();
            System.out.println(tl1+" CesPort sync end");
            System.out.println(tl1+" CesPw sync start");
            Tl1SyncCesPw();
            System.out.println(tl1+" CesPw sync end");
            System.out.println(tl1+" L2Lacp sync start");
            Tl1SyncL2Lacp();
            System.out.println(tl1+" L2Lacp sync end");
            System.out.println(tl1+" OpticPower sync start");
            Tl1SyncOPTICPOWER();
            System.out.println(tl1+" OpticPower sync end");
            System.out.println(tl1+" Inventory sync start");
            TL1SyncInventory();
            System.out.println(tl1+" Inventory sync end");
            System.out.println(tl1+" SessState sync start");
            TL1SyncSessState();
            System.out.println(tl1+" SessState sync end");
            System.out.println(tl1+" KeyState sync start");
            TL1SyncKeyState();
            System.out.println(tl1+" KeyState sync end");
            System.out.println(tl1+" ModuleInfo sync start");
            TL1SyncModuleInfo();
            System.out.println(tl1+" ModuleInfo sync end");
            System.out.println(tl1+" CmPort sync start");
            TL1SyncCmPort();
            System.out.println(tl1+" CmPort sync end");
            System.out.println(tl1+" BypassInfo sync start");
            TL1SyncBypassInfo();
            System.out.println(tl1+" BypassInfo sync end");
            System.out.println(tl1+" CryptoMode sync start");
            TL1SyncCryptoMode();
            System.out.println(tl1+" CryptoMode sync end");
            System.out.println(tl1+" CmProgramInfo sync start");
            TL1SyncCmProgramInfo();
            System.out.println(tl1+" CmProgramInfo sync end");
            System.out.println(tl1+" QkdInfo sync start");
            TL1SyncQkdInfo();
            System.out.println(tl1+" QkdInfo sync end");
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
            Tl1Node tl1Node = new Tl1Node(fields, syncDate);
            tl1NodeRepository.save(tl1Node);
            tl1NodeList.add(tl1Node);
        }
    }

    public void Tl1SyncSystemInfo() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SYS:" + tl1Node.getTid() + ":::[" + CTAG + "];";
            Map<String, String> fields = ConvertResponse2(ExecuteCmd(cmd));
            Tl1SystemInfo info = new Tl1SystemInfo(
                    fields.get("TID") == null ? "" : fields.get("TID"),
                    fields.get("UID") == null ? "" : fields.get("UID"),
                    fields.get("LOCATION") == null ? "" : fields.get("LOCATION"),
                    fields.get("VENDOR") == null ? "" : fields.get("VENDOR"),
                    fields.get("PWOAM") == null ? "" : fields.get("PWOAM"),
                    fields.get("BOOT-TIME") == null ? "" : fields.get("BOOT-TIME"),
                    fields.get("RESET-REASON") == null ? "" : fields.get("RESET-REASON"),
                    syncDate);
            tl1SystemInfoRepository.save(info);
        }
    }

    public void Tl1SyncSlot() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SLOT:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1SlotRepository.save(new Tl1Slot(fields, syncDate));
            }
        }
    }

    public void Tl1SyncEthPort() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ETH-PORT:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1EthPortRepository.save(new Tl1EthPort(fields, syncDate));
            }
        }
    }

    public void Tl1SyncNodeConnector() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-NODE-CONNECTOR:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1NodeConnector tl1NodeConnector = new Tl1NodeConnector(fields, syncDate);
                tl1NodeConnectorRepository.save(tl1NodeConnector);
                tl1NodeConnectorList.add(tl1NodeConnector);
            }
        }
    }

    public void Tl1SyncCesNodeConnector() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-CES-NODE-CONNECTOR:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1CesNodeConnectorRepository.save(new Tl1CesNodeConnector(fields, syncDate));
            }
        }
    }

    public void Tl1SyncOduNodeConnector() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            if (!tl1Node.getNodeType().equals("otn")) continue;
            String cmd = "RTRV-ODU-NODE-CONNECTOR:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1OduNodeConnector tl1OduNodeConnector = new Tl1OduNodeConnector(fields,syncDate);
                tl1OduNodeConnectorRepository.save(tl1OduNodeConnector);
                tl1OduNodeConnectorList.add(tl1OduNodeConnector);
            }
        }
    }

    public void Tl1SyncMplsIf() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-MPLS-IF:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1MplsIfRepository.save(new Tl1MplsIf(fields,syncDate));
            }
        }
    }

    public void Tl1SyncOduMplsIf() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ODU-MPLS-IF:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1OduMplsIf tl1OduMplsIf = new Tl1OduMplsIf(fields, syncDate);
                tl1OduMplsIfRepository.save(tl1OduMplsIf);
                tl1OduMplsIfList.add(tl1OduMplsIf);
            }
        }
    }

    public void Tl1SyncSTunnel() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-STUNNEL:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelRepository.save(new Tl1Stunnel(fields,syncDate));
            }
        }
    }

    public void Tl1SyncSTunnelExt() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-STUNNEL-EXT:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelExtRepository.save(new Tl1StunnelExt(fields, syncDate));
            }
        }
    }

    public void Tl1SyncSTunnelTransit() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-STUNNEL-TRANSIT:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1StunnelTransitRepository.save(new Tl1StunnelTransit(fields,syncDate));
            }
        }
    }

    public void Tl1SyncTunnelProt() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-TUNNEL-PROT:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1TunnelPortRepository.save(new Tl1TunnelPort(fields, syncDate));
            }
        }
    }

    public void Tl1SyncSpw() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SPW:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1SpwRepository.save(new Tl1Spw(fields, syncDate));
            }
        }
    }

    public void Tl1SyncMSpw() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-MSPW:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1MspwRepository.save(new Tl1Mspw(fields, syncDate));
            }
        }
    }

    public void Tl1SyncMplsAc() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-MPLS-AC:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1MplsAc tl1MplsAc = new Tl1MplsAc(fields,syncDate);
                tl1MplsAcRepository.save(tl1MplsAc);
                tl1MplsAcList.add(tl1MplsAc);
            }
        }
    }

    public void Tl1SyncAccessIf() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ACCESS-IF:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1AccessIfRepository.save(new Tl1AccessIf(fields, syncDate));
            }
        }
    }

    public void Tl1SyncService() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-SERVICE:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                Tl1Service tl1Service = new Tl1Service(fields,syncDate);
                tl1ServiceRepository.save(tl1Service);
                serviceList.add(tl1Service);
            }
        }
    }

    public void Tl1SyncServiceExt() throws Exception {
        for(Tl1Service tl1Service : serviceList) {
            String cmd = "RTRV-SERVICE-EXT:" + tl1Service.getTid() + "::" + CTAG + ":serv-name=" + tl1Service.getName() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1ServiceExtRepository.save(new Tl1ServiceExt(fields, syncDate));
            }
        }
    }

    public void Tl1SyncServiceTunnel() throws Exception {
        for(Tl1Service tl1Service : serviceList) {
            String cmd = "RTRV-SERVICE-TUNNEL:" + tl1Service.getTid() + "::" + CTAG + ":serv-name=" + tl1Service.getName() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1ServiceTunnelRepository.save(new Tl1ServiceTunnel(fields, syncDate));
            }
        }
    }

    public void Tl1SyncServiceMspw() throws Exception {
        for(Tl1Service tl1Service : serviceList) {
            String cmd = "RTRV-SERVICE-MSPW:" + tl1Service.getTid() + "::" + CTAG + ":serv-name=" + tl1Service.getName() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1ServiceMspwRepository.save(new Tl1ServiceMspw(fields, syncDate));
            }
        }
    }

    public void Tl1SyncOdu() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-ODU:" + tl1Node.getTid() + "::" + CTAG + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1OduRepository.save(new Tl1Odu(fields, syncDate));
            }
        }
    }

    public void Tl1SyncCesPort() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-CES-PORT:" + tl1Node.getTid() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1CesPortRepository.save(new Tl1CesPort(fields, syncDate));
            }
        }
    }

    public void Tl1SyncCesPw() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-CES-PW:" + tl1Node.getTid() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1CesPwRepository.save(new Tl1CesPw(fields, syncDate));
            }
        }
    }

    public void Tl1SyncL2Lacp() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-L2-LACP:" + tl1Node.getTid() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1L2LacpRepository.save(new Tl1L2Lacp(fields,syncDate));
            }
        }
    }

    public void Tl1SyncOPTICPOWER() throws Exception {
        for(Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-OPTIC-POWER:" + tl1Node.getTid() + ";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields : fieldsList) {
                tl1OpticPowerRepository.save(new Tl1OpticPower(fields, syncDate));
            }
        }
    }
    public void TL1SyncInventory() throws  Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            String cmd = "RTRV-INVENTORY:" + tl1Node.getTid() +";";
            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {
                tl1InventoryRepository.save(new Tl1Inventory(fields,syncDate));
            }
        }
    }

    public void TL1SyncSessState() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals("otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-SESS-STATE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1SessStateRepository.save(new Tl1SessState(fields, syncDate));
            }
        }
    }

    public void TL1SyncKeyState() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals( "otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-KEY-STATE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1KeyStateRepository.save(new Tl1KeyState(fields,syncDate));
            }
        }
    }

    public void TL1SyncModuleInfo() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals( "otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-MODULE-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1ModuleInfoRepository.save(new Tl1ModuleInfo(fields,syncDate));
            }
        }
    }

    public void TL1SyncCmPort() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals( "otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-CM-PORT:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1CmPortRepository.save(new Tl1CmPort(fields,syncDate));
            }
        }
    }

    public void TL1SyncBypassInfo() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals("otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-BYPASS-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1BypassInfoRepository.save(new Tl1BypassInfo(fields, syncDate));
            }
        }
    }

    public void TL1SyncCryptoMode() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals("otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-CRYPTO-MODE:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1CryptoModeRepository.save(new Tl1CryptoMode(fields,syncDate));
            }
        }
    }

    public void TL1SyncCmProgramInfo() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals("otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-CM-PROGRAM-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1CmProgramInfoRepository.save(new Tl1CmProgramInfo(fields,syncDate));
            }
        }
    }

    public void TL1SyncQkdInfo() throws Exception {
        for (Tl1Node tl1Node : tl1NodeList) {
            if(!tl1Node.getNodeType().equals("otn")) continue;
            String TID = tl1Node.getTid();
            String SLOT_INDEX = getSlotIndexByTID(tl1OduNodeConnectorList, TID);
            String cmd = "RTRV-QKD-INFO:" + TID + ":" + SLOT_INDEX + ";";

            ArrayList<String[]> fieldsList = ConvertResponse(ExecuteCmd(cmd));
            for (String[] fields: fieldsList) {

                tl1QkdInfoRepository.save(new Tl1QkdInfo(fields, syncDate));
            }
        }
    }

    public String getSlotIndexByTID(List<Tl1OduNodeConnector> tl1OduNodeConnectorList, String TID) {
        String result = "";
        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectorList) {
            if(!tl1OduNodeConnector.getTid().equals(TID)) continue;
            if(!tl1OduNodeConnector.getSlotType().equals("O208CLU") && !tl1OduNodeConnector.getSlotType().equals("O401CLU")) continue;
            result = tl1OduNodeConnector.getSlotIndex();
            return result;
        }
        return result;
    }

    public String getMITypeByTID(List<Tl1OduMplsIf> tl1OduMplsIfs, String TID) {
        String result = "";
        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfs) {
            if (!tl1OduMplsIf.getTid().equals(TID)) continue;
            result = tl1OduMplsIf.getMplsifType();
            return result;
        }
        return result;
    }


    public String ExecuteCmd(String cmd) throws IOException {
        ByteBuffer byteBuffer;
        Charset charset = Charset.forName("UTF-8");

        byteBuffer = charset.encode(cmd);
        socketChannel.write(byteBuffer);
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
            } else if (line.startsWith("M")) {
                // Filter Response info
            } else if (line.contains("/*") && line.contains("*/")) {
                // Filter comment
                line = line.replace("/*", "");
                line = line.replace("*/", "");

                String[] columns = line.split(",");
                for (String column: columns ) {
                    keyList.add(column.trim());
                }
            }else if (line.contains("\"")) {
                //Filter Data
                line = line.replace("\"", "");

                String[] fields = line.split(",");
                for (int j=0; j<fields.length; j++) {
                    fields[j] = fields[j].trim();
                }
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
            } else if (line.startsWith("M")) {
                // Filter Response info
            } else if (line.contains("/*") && line.contains("*/")) {
                // Filter comment
                line = line.replace("/*", "");
                line = line.replace("*/", "");

                String[] columns = line.split(",");
                for (String column : columns) {
                }
            } else if (line.contains("\"")) {
                //Filter Data
                line = line.replace("\"", "");

                String[] values = line.split("=");
                result.put(values[0].trim(), values[1].trim());
            }
        }

        return result;
    }

    private ArrayList<String[]> convertTxtFileResponse(String filePathName) throws Exception {
        File file = new File(filePathName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(fileReader);
        ArrayList<String[]> fieldsList = new ArrayList<>();

        String line = "";
        while((line = bufReader.readLine()) != null){
            if(line.contains("/*") || line.contains("*/") || line.equals("")) continue;
            String []fields = line.split("\\|");

            for(int i=0; i< fields.length ;i++) fields[i] = fields[i].trim();

            fieldsList.add(fields);
        }
        bufReader.close();

        return fieldsList;
    }

    public void close() throws IOException {
        socketChannel.close();
    }
}
