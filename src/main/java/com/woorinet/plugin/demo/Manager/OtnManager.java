package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.OTN.*;
import com.woorinet.plugin.demo.DTO.OTN.CM.OtnCmInventory;
import com.woorinet.plugin.demo.DTO.OTN.CM.OtnCmLink;
import com.woorinet.plugin.demo.DTO.OTN.CM.OtnCmQkdLink;
import com.woorinet.plugin.demo.DTO.OTN.CM.OtnCmSession;
import com.woorinet.plugin.demo.DTO.OTN.PM.*;
import com.woorinet.plugin.demo.DTO.TL1.CM.*;
import com.woorinet.plugin.demo.DTO.TL1.PM.*;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Repository.OTN.*;
import com.woorinet.plugin.demo.Repository.OTN.PM.*;

import java.util.*;
import java.util.stream.Stream;

public class OtnManager {
    OtnNodeRepository otnNodeRepository;
    OtnConnectorRepository otnConnectorRepository;
    OtnLinkRepository otnLinkRepository;
    OtnServiceRepository otnServiceRepository;
    OtnTunnelRepository otnTunnelRepository;
    OtnPathRepository otnPathRepository;
    OtnConstraintRepository otnConstraintRepository;
    OtnAccessIfRepository otnAccessIfRepository;
    OtnPmPwRepository otnPmPwRepository;
    OtnPmTunnelRepository otnPmTunnelRepository;
    OtnPmTemperatureRepository otnPmTemperatureRepository;
    OtnPmAcRepository otnPmAcRepository;
    OtnPmOpticRepository otnPmOpticRepository;
    OtnPmRepository otnPmRepository;
    OtnPmPortRepository otnPmPortRepository;
    OtnPmOpticTemperatureRepository otnPmOpticTemperatureRepository;
    OtnCmInventoryRepository otnCmInventoryRepository;
    OtnCmLinkRepository otnCmLinkRepository;
    OtnCmSessionRepository otnCmSessionRepository;
    OtnCmQkdLinkRepository otnCmQkdLinkRepository;

    String separator;

    List<Tl1Node> tl1NodeList;
    List<Tl1SystemInfo> tl1SystemInfoList;
    List<Tl1OduNodeConnector> tl1OduNodeConnectorList;
    List<Tl1OpticPower> tl1OpticPowerList;
    List<Tl1Odu> tl1OduList;
    List<Tl1OduMplsIf> tl1OduMplsIfList;
    List<Tl1Service> tl1ServiceList;
    List<Tl1AccessIf> tl1AccessIfList;
    List<Tl1ServiceExt> tl1ServiceExtList;
    List<Tl1MplsIf> tl1MplsIfList;
    List<List<Tl1Odu>> tl1OduListForService = new ArrayList<>();
    List<Tl1Inventory> tl1InventoryList;
    List<Tl1CmPort> tl1CmPortList;
    List<Tl1ModuleInfo> tl1ModuleInfoList;
    List<Tl1BypassInfo> tl1BypassInfoList;
    List<Tl1CmProgramInfo> tl1CmProgramInfoList;
    List<Tl1SessState> tl1SessStateList;
    List<Tl1KeyState> tl1KeyStateList;
    List<Tl1QkdInfo> tl1QkdInfoList;
    List<Tl1PmPw> tl1PmPwList;
    List<Tl1PmTunnel> tl1PmTunnelList;
    List<Tl1PmTemperature> tl1PmTemperatureList;
    List<Tl1PmAc> tl1PmAcList;
    List<Tl1PmOptic> tl1PmOpticList;
    List<Tl1Pm> tl1PmList;
    List<Tl1PmPort> tl1PmPortList;
    List<Tl1PmOpticTemperature> tl1PmOpticTemperatureList;

    HashMap<String, Tl1Node> tl1NodeHashMap = new HashMap<>();
    HashMap<String, Tl1SystemInfo> tl1SystemInfoHashMap = new HashMap<>();
    HashMap<String, Tl1Inventory> tl1InventoryHashMap = new HashMap<>();
    HashMap<String, Tl1OpticPower> tl1OpticPowerHashMap = new HashMap<>();
    HashMap<String, Tl1OduNodeConnector> tl1OduNodeConnectorHashMap = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduHashMapForOduTunnel = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduHashMapForMplsTp = new HashMap<>();
    HashMap<String, Tl1AccessIf> tl1AccessIfHashMap = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduNameTailHashMapForOduTunnel = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduNameHeadHashMapForOduTunnel = new HashMap<>();
    HashMap<String, Tl1Odu> tl1OduMapInMplsTpByLocalId = new HashMap<>();
    HashMap<String, Tl1OduMplsIf> tl1OduMplsIfHashMap = new HashMap<>();
    HashMap<String, List<Tl1Odu>> tl1OduHashMapForPath = new HashMap<>();
    HashMap<String, Tl1CmPort> tl1CmPortHashMap = new HashMap<>();
    HashMap<String, Tl1BypassInfo> tl1BypassInfoHashMap = new HashMap<>();
    HashMap<String, Tl1CmProgramInfo> tl1CmProgramInfoHashMap = new HashMap<>();
    HashMap<String, Tl1KeyState> tl1KeyStateHashMap = new HashMap<>();

    HashMap<String, OtnNode> sdnNodeHashMap = new HashMap<>();
    HashMap<String, OtnConnector> sdnConnectorHashMap = new HashMap<>();
    HashMap<String, OtnLink> sdnLinkHashMap = new HashMap<>();
    HashMap<String, OtnService> sdnServiceHashMapForPath = new HashMap<>();

    String syncDate;

    public OtnManager(
            String syncDate,
            OtnNodeRepository otnNodeRepository,
                      OtnConnectorRepository otnConnectorRepository,
                      OtnLinkRepository otnLinkRepository,
                      OtnServiceRepository otnServiceRepository,
                      OtnTunnelRepository otnTunnelRepository,
                      OtnPathRepository otnPathRepository,
                      OtnConstraintRepository otnConstraintRepository,
                      OtnAccessIfRepository otnAccessIfRepository,

                      OtnPmPwRepository otnPmPwRepository,
                      OtnPmTunnelRepository otnPmTunnelRepository,
                      OtnPmTemperatureRepository otnPmTemperatureRepository,
                      OtnPmAcRepository otnPmAcRepository,
                      OtnPmOpticRepository otnPmOpticRepository,
                      OtnPmRepository otnPmRepository,
                      OtnPmPortRepository otnPmPortRepository,
                      OtnPmOpticTemperatureRepository otnPmOpticTemperatureRepository,
                      OtnCmInventoryRepository otnCmInventoryRepository,
                      OtnCmLinkRepository otnCmLinkRepository,
                      OtnCmSessionRepository otnCmSessionRepository,
                      OtnCmQkdLinkRepository otnCmQkdLinkRepository,

                      List<Tl1Node> tl1NodeList,
                      List<Tl1SystemInfo> tl1SystemInfoList,
                      List<Tl1OduNodeConnector> tl1OduNodeConnectorList,
                      List<Tl1OpticPower> tl1OpticPowerList,
                      List<Tl1Odu> tl1OduList,
                      List<Tl1OduMplsIf> tl1OduMplsIfList,
                      List<Tl1Service> tl1ServiceList,
                      List<Tl1AccessIf> tl1AccessIfList,
                      List<Tl1ServiceExt> tl1ServiceExtList,
                      List<Tl1MplsIf> tl1MplsIfList,
                      List<Tl1Inventory> tl1InventoryList,
                      List<Tl1CmPort> tl1CmPortList,
                      List<Tl1ModuleInfo> tl1ModuleInfoList,
                      List<Tl1BypassInfo> tl1BypassInfoList,
                      List<Tl1CmProgramInfo> tl1CmProgramInfoList,
                      List<Tl1SessState> tl1SessStateList,
                      List<Tl1KeyState> tl1KeyStateList,
                      List<Tl1QkdInfo> tl1QkdInfoList,
                      List<Tl1PmPw> tl1PmPwList,
                      List<Tl1PmTunnel> tl1PmTunnelList,
                      List<Tl1PmTemperature> tl1PmTemperatureList,
                      List<Tl1PmAc> tl1PmAcList,
                      List<Tl1PmOptic> tl1PmOpticList,
                      List<Tl1Pm> tl1PmList,
                      List<Tl1PmPort> tl1PmPortList,
                      List<Tl1PmOpticTemperature> tl1PmOpticTemperatureList
    ) throws Exception{
        this.syncDate = syncDate;
        this.otnNodeRepository = otnNodeRepository;
        this.otnConnectorRepository = otnConnectorRepository;
        this.otnLinkRepository = otnLinkRepository;
        this.otnServiceRepository = otnServiceRepository;
        this.otnTunnelRepository = otnTunnelRepository;
        this.otnPathRepository = otnPathRepository;
        this.otnConstraintRepository = otnConstraintRepository;
        this.otnAccessIfRepository = otnAccessIfRepository;
        this.otnPmPwRepository = otnPmPwRepository;
        this.otnPmTunnelRepository = otnPmTunnelRepository;
        this.otnPmTemperatureRepository = otnPmTemperatureRepository;
        this.otnPmAcRepository = otnPmAcRepository;
        this.otnPmOpticRepository = otnPmOpticRepository;
        this.otnPmRepository = otnPmRepository;
        this.otnPmPortRepository = otnPmPortRepository;
        this.otnPmOpticTemperatureRepository = otnPmOpticTemperatureRepository;
        this.otnCmInventoryRepository = otnCmInventoryRepository;
        this.otnCmLinkRepository = otnCmLinkRepository;
        this.otnCmSessionRepository = otnCmSessionRepository;
        this.otnCmQkdLinkRepository = otnCmQkdLinkRepository;


        this.separator = ".";
        this.tl1NodeList = tl1NodeList;
        this.tl1SystemInfoList = tl1SystemInfoList;
        this.tl1OduNodeConnectorList = tl1OduNodeConnectorList;
        this.tl1OpticPowerList = tl1OpticPowerList;
        this.tl1OduList = tl1OduList;
        this.tl1OduMplsIfList = tl1OduMplsIfList;
        this.tl1ServiceList = tl1ServiceList;
        this.tl1AccessIfList = tl1AccessIfList;
        this.tl1ServiceExtList = tl1ServiceExtList;
        this.tl1MplsIfList = tl1MplsIfList;
        this.tl1InventoryList = tl1InventoryList;
        this.tl1CmPortList = tl1CmPortList;
        this.tl1ModuleInfoList = tl1ModuleInfoList;
        this.tl1BypassInfoList = tl1BypassInfoList;
        this.tl1CmProgramInfoList = tl1CmProgramInfoList;
        this.tl1SessStateList = tl1SessStateList;
        this.tl1KeyStateList = tl1KeyStateList;
        this.tl1QkdInfoList = tl1QkdInfoList;
        this.tl1PmPwList = tl1PmPwList;
        this.tl1PmTunnelList = tl1PmTunnelList;
        this.tl1PmTemperatureList = tl1PmTemperatureList;
        this.tl1PmAcList = tl1PmAcList;
        this.tl1PmOpticList = tl1PmOpticList;
        this.tl1PmList = tl1PmList;
        this.tl1PmPortList = tl1PmPortList;
        this.tl1PmOpticTemperatureList = tl1PmOpticTemperatureList;

        makeHashMap();
    }

    private void makeHashMap() {
        for(Tl1Node tl1Node : tl1NodeList) {
            tl1NodeHashMap.put(tl1Node.getTid(), tl1Node);
        }
        for(Tl1SystemInfo tl1SystemInfo : tl1SystemInfoList) {
            tl1SystemInfoHashMap.put(tl1SystemInfo.getTid(), tl1SystemInfo);
        }
        for(Tl1Inventory tl1Inventory : tl1InventoryList) {
            tl1InventoryHashMap.put(tl1Inventory.getTid(), tl1Inventory);
        }
        for(Tl1OpticPower tl1OpticPower : tl1OpticPowerList) {
            tl1OpticPowerHashMap.put(tl1OpticPower.getTid()+"/"+ tl1OpticPower.getAid(), tl1OpticPower);
        }
        for(Tl1Odu tl1Odu : tl1OduList) {
            if(tl1OduHashMapForPath.get(tl1Odu.getName()) == null ) {
                List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                tl1Odu_list.add(tl1Odu);
                tl1OduHashMapForPath.put(tl1Odu.getName(), tl1Odu_list);
            } else {
                List<Tl1Odu> tl1Odu_list = tl1OduHashMapForPath.get(tl1Odu.getName());
                tl1Odu_list.add(tl1Odu);
                tl1OduHashMapForPath.put(tl1Odu.getName(), tl1Odu_list);
            }

            if(tl1Odu.getEmsService().equals("ODU_TUNNEL")) {
                tl1OduHashMapForOduTunnel.put(tl1Odu.getTid() + '/' + tl1Odu.getLocalId().split("-")[0] +'-'+ tl1Odu.getLocalId().split("-")[1], tl1Odu);
                if (tl1Odu.getRole().equals("TAIL")) {
                    tl1OduNameTailHashMapForOduTunnel.put(tl1Odu.getName(), tl1Odu);

                    if (tl1OduNameHeadHashMapForOduTunnel.get(tl1Odu.getName()) != null) {
                        List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                        tl1Odu_list.add(tl1OduNameHeadHashMapForOduTunnel.get(tl1Odu.getName()));
                        tl1Odu_list.add(tl1Odu);
                        tl1OduListForService.add(tl1Odu_list);
                    }
                } else {
                    tl1OduNameHeadHashMapForOduTunnel.put(tl1Odu.getName(), tl1Odu);

                    if (tl1OduNameTailHashMapForOduTunnel.get(tl1Odu.getName()) != null) {
                        List<Tl1Odu> tl1Odu_list = new ArrayList<>();
                        tl1Odu_list.add(tl1Odu);
                        tl1Odu_list.add(tl1OduNameTailHashMapForOduTunnel.get(tl1Odu.getName()));
                        tl1OduListForService.add(tl1Odu_list);
                    }
                }
            } else if (tl1Odu.getEmsService().equals("MPLS_TP")) {
                tl1OduMapInMplsTpByLocalId.put(tl1Odu.getTid()+'/'+ tl1Odu.getLocalId(), tl1Odu);
                tl1OduHashMapForMplsTp.put(tl1Odu.getTid()+ '/' + tl1Odu.getLocalId().split("-")[0] +'-'+ tl1Odu.getLocalId().split("-")[1], tl1Odu);
            }



        }
        for(Tl1OduNodeConnector tl1OduNodeConnector : tl1OduNodeConnectorList) {
            tl1OduNodeConnectorHashMap.put(tl1OduNodeConnector.getTid() + '/' + tl1OduNodeConnector.getAid(), tl1OduNodeConnector);
        }
        for(Tl1AccessIf Tl1AccessIf : tl1AccessIfList) {
            tl1AccessIfHashMap.put(Tl1AccessIf.getTid(), Tl1AccessIf);
        }
        for(Tl1OduMplsIf tl1OduMplsIf : tl1OduMplsIfList) {
            tl1OduMplsIfHashMap.put(tl1OduMplsIf.getTid()+'/'+ tl1OduMplsIf.getMplsTpId(), tl1OduMplsIf);
        }
        for(Tl1CmPort tl1CmPort : tl1CmPortList) {
            tl1CmPortHashMap.put(tl1CmPort.getAid(), tl1CmPort);
        }
        for(Tl1BypassInfo tl1BypassInfo :tl1BypassInfoList) {
            tl1BypassInfoHashMap.put(tl1BypassInfo.getAid(), tl1BypassInfo);
        }
        for(Tl1CmProgramInfo tl1CmProgramInfo : tl1CmProgramInfoList) {
            tl1CmProgramInfoHashMap.put(tl1CmProgramInfo.getAid(), tl1CmProgramInfo);
        }

        Stream<Tl1KeyState> tl1KeyStateStream = tl1KeyStateList.stream();
        tl1KeyStateStream.forEach(keystate -> tl1KeyStateHashMap.put(keystate.getAid(), keystate));
        for (Map.Entry<String, Tl1KeyState> entry : tl1KeyStateHashMap.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public void OtnSyncStart() throws Exception {
        OTNSyncPmPw();
        OTNSyncPmTunnel();
        OTNSyncPmTemperature();
        OTNSyncPmAc();
        OTNSyncPmOptic();
        OTNSyncPm();
        OTNSyncPmPort();
        OTNSyncPmOpticTemperature();
        // Node 데이터 업데이트
        OtnSyncNodeList();
        // Connector 데이터 업데이트
        OtnSyncConnectorList();
        // Link 데이터 업데이트
        OtnSyncLinkList();
        // Tunnel 데이터 업데이트
        OtnSyncTunnelList();
        // Service 데이터 업데이트
        OtnSyncServiceList();
        // Path 데이터 업데이트
        OtnSyncPathList();
        // Constraint 데이터 업데이트
        OtnSyncConstraint();
        // AccessIf 데이터 업데이트
        OtnSyncAccess_if();
        // cmInventory 데이터 업데이트
        OtnSyncCmInventory();
        // cmLink 데이터 업데이트
        OtnSyncCmLink();
        // cmSession 데이터 업데이트
        OtnSyncCmSession();
        // cmQkdLink 데이터 업데이트
        OtnSyncCmQkdLink();
    }

    private void OtnSyncNodeList() throws Exception {
        Stream<OtnNode> sdnNodeStream = tl1NodeList
            .stream()
            .filter(tl1NodeState -> tl1NodeState.getNodeType().equals("otn"))
            .map(tl1NodeState -> {
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1NodeState.getTid());
                Tl1Inventory tl1Inventory = tl1InventoryHashMap.get(tl1NodeState.getTid());

                OtnNode otnNode = new OtnNode(
                        200009, // ems_id
                        tl1SystemInfo==null? separator + tl1NodeState.getNodeType() + separator + tl1NodeState.getTid() : tl1SystemInfo.getVendor() + separator + tl1NodeState.getNodeType() + separator + tl1NodeState.getTid(), // ne_id
                        tl1NodeState.getTid(), // ne_name
                        "", //ne_type
                        tl1NodeState.getSystemType(), // ne_model
                        tl1NodeState.getNodeStatus().equals("normal") ? tl1NodeState.getNodeStatus() : "broken", // ne_status
                        tl1NodeState.getSoftware(), // sw_ver
                        tl1NodeState.getIpAddr(), // ip_addr
                        tl1SystemInfo==null? "":tl1SystemInfo.getVendor(), // vendor
                        tl1Inventory==null ? "" : tl1Inventory.getSerialNum(), // serial_num
                        tl1NodeState.getNodeType(), // sys_type
                        syncDate
                );

                sdnNodeHashMap.put(tl1NodeState.getTid(), otnNode);
                return otnNode;
            });
        sdnNodeStream.forEach(otnNodeRepository::save);
    }

    public void OtnSyncConnectorList( ) throws Exception {
        Stream<OtnConnector> sdnConnectorStream = tl1OduNodeConnectorList
            .stream()
            .map(tl1OduNodeConnector -> {
                Tl1Node tl1Node = tl1NodeHashMap.get(tl1OduNodeConnector.getTid());
                OtnNode otnNode = sdnNodeHashMap.get(tl1OduNodeConnector.getTid());
                Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduNodeConnector.getTid()+"/"+ tl1OduNodeConnector.getAid());
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1Node.getTid());

                String connectId = tl1SystemInfo.getVendor() +
                        separator +
                        otnNode.getSysType() +
                        separator +
                        otnNode.getNeName() +
                        separator +
                        tl1OduNodeConnector.getShelfIndex() +
                        separator +
                        tl1OduNodeConnector.getSlotIndex() +
                        separator +
                        tl1OduNodeConnector.getPortIndex();
                String connectType = "";
                if (tl1OpticPower != null) {
                    if (tl1OpticPower.getPartNumber().equals("TR-PX13L-NG2")) connectType = "sfp+";
                    else if (tl1OpticPower.getPartNumber().equals("TR-PX13L-NG2") || tl1OpticPower.getPartNumber().equals("EOLP-1396-10") || tl1OpticPower.getPartNumber().equals("FTLX1471D3BNL"))
                        connectType = "sfp";
                    else connectType = tl1OpticPower.getPartNumber(); // 구글링 해야됨
                }

                OtnConnector otnConnector = new OtnConnector(
                        200009, // ems_id
                        connectId, // connect_id
                        "", // connect_name
                        tl1OpticPower == null ? "" : connectType, // connect_type
                        otnNode.getNeId(), // ne_id
                        otnNode.getNeName(), // ne_name
                        "", // rack_id
                        tl1OduNodeConnector.getShelfIndex(), // shelf_id
                        tl1OduNodeConnector.getSlotIndex(), // slot_id
                        "", // subslot_id
                        tl1OduNodeConnector.getPortIndex(), // port_id
                        tl1OduNodeConnector.getPortStatus().equals("ACT") ? "up" : "down", // connect_status
                        tl1OduNodeConnector.getPortRole(), // connect_role
                        tl1OpticPower == null ? "idle" : "occupied", // connect_idle
                        tl1OpticPower == null ? "" : "", // connect_llcf
                        tl1OpticPower == null ? "" : tl1OpticPower.getTxWavelength(), // connect_lambda
                        tl1OpticPower == null ? "" : tl1OpticPower.getPartNumber(), // module_name
                        tl1OpticPower == null ? "" : "", // connect_pec
                        tl1OpticPower == null ? "" : tl1OpticPower.getSerial(), // connect_serial
                        tl1OpticPower == null ? "" : tl1OpticPower.getUnitType(), // unit_type
                        syncDate
                );
                sdnConnectorHashMap.put(tl1OduNodeConnector.getTid() + '/' + tl1OduNodeConnector.getAid(), otnConnector);
                return otnConnector;
            });
        sdnConnectorStream.forEach(otnConnectorRepository::save);
    }

    public void OtnSyncLinkList ( ) throws Exception {
        Stream<OtnLink> sdnLinkStream = tl1OduMplsIfList
            .stream()
            .map(tl1OduMplsIf -> {
                Tl1SystemInfo srcTl1SystemInfo = tl1SystemInfoHashMap.get(tl1OduMplsIf.getSrcTid());
                Tl1SystemInfo dstTl1SystemInfo = tl1SystemInfoHashMap.get(tl1OduMplsIf.getDstTid());
                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1OduMplsIf.getSrcTid());
                OtnNode dstOtnNode = sdnNodeHashMap.get(tl1OduMplsIf.getDstTid());
                OtnConnector srcOtnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getSrcTid()+ '/' + tl1OduMplsIf.getSrcPort());
                OtnConnector dstOtnConnector = sdnConnectorHashMap.get(tl1OduMplsIf.getDstTid()+ '/' + tl1OduMplsIf.getDstPort());
                Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduMplsIf.getTid() + '/' + tl1OduMplsIf.getMplsTpId());
                Tl1Odu tl1Odu = tl1OduHashMapForOduTunnel.get(tl1OduMplsIf.getTid()+ '/' + tl1OduMplsIf.getMplsTpId());
                Tl1OduNodeConnector tl1OduNodeConnector = tl1OduNodeConnectorHashMap.get(tl1OduMplsIf.getSrcTid()+ '/' + tl1OduMplsIf.getSrcPort());

                int maximumBandwidth = Integer.parseInt(tl1OduMplsIf.getMaximumBandwidth());
                int availableBandwidth = Integer.parseInt(tl1OduMplsIf.getAvailableBandwidth());

                String srcVendor = "";
                String dstVendor = "";
                String srcShelfSlotPort = "";
                String dstShelfSlotPort = "";
                if (srcTl1SystemInfo != null)  srcVendor = srcTl1SystemInfo.getVendor();
                if (dstTl1SystemInfo != null )  dstVendor = dstTl1SystemInfo.getVendor();
                if (srcOtnConnector != null) srcShelfSlotPort = srcOtnConnector.getShelfId() + separator + srcOtnConnector.getSlotId() + separator + srcOtnConnector.getPortId();
                if (dstOtnConnector != null) dstShelfSlotPort = dstOtnConnector.getShelfId() + separator + dstOtnConnector.getSlotId() + separator + dstOtnConnector.getPortId();
                String linkId = srcVendor + separator + srcOtnNode.getSysType() + separator + srcOtnNode.getNeName() + separator +
                        srcShelfSlotPort
                        + ":" + dstVendor + separator + dstOtnNode.getSysType() + separator + dstOtnNode.getNeName() + separator +
                        dstShelfSlotPort;

                OtnLink otnLink = new OtnLink(
                        200009, // ems_id
                        200009, // dst_ems_id
                        linkId, // link_id
                        tl1OduMplsIf.getName(), // link_nm
                        srcOtnNode.getNeId(), // src_ne_id
                        srcOtnNode.getNeName(), // src_ne_name
                        srcOtnConnector == null ? "":srcOtnConnector.getConnectId(), // src_node_connector_id
                        dstOtnNode.getNeId(), // dst_ne_id
                        dstOtnNode.getNeName(), // dst_ne_name
                        dstOtnConnector == null ? "":dstOtnConnector.getConnectId(), // dst_node_connector_id
                        tl1OduMplsIf.getLinkType(), // link_type
                        tl1OduNodeConnector.getPortStatus(), // link_status
                        "", // link_category
                        "", // high_order_tunnel
                        "", // latency
                        tl1OpticPower == null ? "":tl1OpticPower.getDistance(), // distance
                        "", // srlg
                        "", // ovpn
                        tl1Odu==null? "": tl1Odu.getTsmap(), // timeslot
                        tl1OpticPower == null ? "":tl1OpticPower.getTxWavelength(), // lambda
                        maximumBandwidth, // maximum_odu0s
                        maximumBandwidth/2, // maximum_odu1s
                        maximumBandwidth/8, // maximum_odu2s
                        maximumBandwidth/8, // maximum_odu2es
                        maximumBandwidth/32, // maximum_odu3s
                        maximumBandwidth/80, // maximum_odu4s
                        maximumBandwidth/160, // maximum_odu4cns
                        -1, // maximum_oduflexs
                        availableBandwidth, // available_odu0s
                        availableBandwidth/2, // available_odu1s
                        availableBandwidth/8, // available_odu2s
                        availableBandwidth/8, // available_odu2es
                        availableBandwidth/32, // available_odu3s
                        availableBandwidth/80, // available_odu4s
                        availableBandwidth/160, // available_odu4cns
                        -1, // available_oduflexs
                        syncDate
                );

                sdnLinkHashMap.put(tl1OduMplsIf.getSrcTid() + '/' + tl1OduMplsIf.getSrcPort() + '-' + tl1OduMplsIf.getDstTid() + '/' + tl1OduMplsIf.getDstPort(), otnLink);

                return otnLink;
            });
        sdnLinkStream.forEach(otnLinkRepository::save);
    }

    public void OtnSyncServiceList( ) throws Exception {

        Stream<OtnService> sdnServiceStream = tl1OduListForService
            .stream()
            .map(tl1OduList -> {
                Tl1Odu tl1OduHead = tl1OduList.get(0);
                Tl1Odu tl1OduTail = tl1OduList.get(1);

                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1OduHead.getTid());
                OtnNode dstOtnNode = sdnNodeHashMap.get(tl1OduTail.getTid());
                OtnConnector srcOtnConnector = sdnConnectorHashMap.get(tl1OduHead.getTid()+ '/' + tl1OduHead.getLocalId().split("-")[0] + "-" + tl1OduHead.getLocalId().split("-")[1]);
                OtnConnector dstOtnConnector = sdnConnectorHashMap.get(tl1OduTail.getTid()+ '/' + tl1OduTail.getLocalId().split("-")[0] + "-" + tl1OduTail.getLocalId().split("-")[1]);
                Tl1OduMplsIf tl1OduMplsIf = tl1OduMplsIfHashMap.get(tl1OduHead.getTid() + '/' + tl1OduHead.getLocalId().split("-")[0] + "-" + tl1OduHead.getLocalId().split("-")[1]);
                Tl1OpticPower tl1OpticPower = tl1OpticPowerHashMap.get(tl1OduHead.getTid() + '/' + tl1OduHead.getLocalId().split("-")[0] + "-" + tl1OduHead.getLocalId().split("-")[1]);

                OtnService otnService = new OtnService(
                        200009, // ems_id
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSysType() + separator + tl1OduHead.getName(), // service_id
                        srcOtnNode.getNeId(), // src_ne_id
                        srcOtnNode.getNeName(), // src_ne_name
                        srcOtnConnector.getConnectId(), // src_connect_id
                        tl1OduHead.getEmsService() + "," + tl1OduHead.getEmsServiceSig(), // src_accessif_type
                        dstOtnNode.getNeId(), // dst_ne_id
                        dstOtnNode.getNeName(), // dst_ne_name
                        dstOtnConnector.getConnectId(), // dst_connect_id
                        tl1OduTail.getEmsService() + "," + tl1OduTail.getEmsServiceSig(), // dst_accessif_type
                        tl1OduHead.getType(), // service_type
                        tl1OduHead.getName(), // service_name
                        "", // network_type
                        "", // service_status
                        tl1OduHead.getType(), // rate_type
                        tl1OduMplsIf.getLinkType(), // service_rate
                        "", // latency
                        tl1OpticPower == null ? "" : tl1OpticPower.getTxWavelength(), // wavelength
                        tl1OduHead.getActivePathStatus(), // active_path
                        tl1OduHead.getCreationDate(), // creation_date
                        syncDate
                );
                sdnServiceHashMapForPath.put(otnService.getServiceName(), otnService);
                return otnService;
            });
        sdnServiceStream.forEach(otnServiceRepository::save);
    }

    public void OtnSyncTunnelList( ) throws  Exception {
        Stream<OtnTunnel> sdnTunnelStream = tl1OduList
            .stream()
            .map(tl1Odu -> {
                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1Odu.getEmsSrcLsr());
                OtnNode dstOtnNode = sdnNodeHashMap.get(tl1Odu.getEmsDstLsr());

                OtnTunnel otnTunnel = new OtnTunnel(
                        200009, // ems_id
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSysType() + separator + tl1Odu.getName(), // tunnel_id
                        srcOtnNode.getNeId(), // src_ne_id
                        srcOtnNode.getNeName(), // src_ne_name
                        dstOtnNode.getNeId(), // dst_ne_id
                        dstOtnNode.getNeName(), // dst_ne_name
                        tl1Odu.getType(), // rate_type
                        "1", // multiple_rate
                        "", // local_id
                        "", // request_id
                        tl1Odu.getName(), // tunnel_name
                        tl1Odu.getEmsService().equals("ODU_TUNNEL")?"otn":tl1Odu.getEmsService(), // tunnel_type
                        "", // tunnel_status
                        "", // configuration_action
                        "", // configuration_result_type
                        "", // tunnel_oam_enabler
                        "", // deployment_enabler
                        "", // deployment_status
                        tl1Odu.getActivePathStatus(), // active_path
                        "", // src_node_ref
                        "", // dst_node_ref
                        "", // service_ref
                        "", // accessif_ref
                        tl1Odu.getProtType(), // protection_type
                        "", // working_path
                        "", // protection_path
                        "", // service_mapping
                        tl1Odu.getCreationDate(), // creation_date
                        syncDate
                );

                return otnTunnel;
            });
        sdnTunnelStream.forEach(otnTunnelRepository::save);
    }

    public void OtnSyncPathList() throws  Exception {
        for (Map.Entry<String, List<Tl1Odu>> entry : tl1OduHashMapForPath.entrySet() ) {
            List<Tl1Odu> tl1Odu_list = entry.getValue();
            if(tl1Odu_list.size() != 4) continue;

            Tl1Odu tl1Odu_head = null;
            Tl1Odu tl1Odu_tail = null;
            Tl1Odu tl1Odu_transit_from = null;
            Tl1Odu tl1Odu_transit_to = null;
            for(Tl1Odu tl1Odu : tl1Odu_list) {
                if (tl1Odu.getRole().equals("TRANSIT_FROM")) tl1Odu_transit_from = tl1Odu;
                else if(tl1Odu.getRole().equals("TRANSIT_TO")) tl1Odu_transit_to = tl1Odu;
                else if(tl1Odu.getRole().equals("HEAD")) tl1Odu_head = tl1Odu;
                else tl1Odu_tail = tl1Odu;
            }

            tl1Odu_list.set(0, tl1Odu_head);
            tl1Odu_list.set(1, tl1Odu_transit_from);
            tl1Odu_list.set(2, tl1Odu_transit_to);
            tl1Odu_list.set(3, tl1Odu_tail);


            { // HEAD <--> TRANSIT_FROM
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_head.getTid() +'/'+ tl1Odu_head.getLocalId().split("-")[0]+'-' + tl1Odu_head.getLocalId().split("-")[1] + '-' + tl1Odu_transit_from.getTid() +'/'+ tl1Odu_transit_from.getLocalId().split("-")[0]+'-'+ tl1Odu_transit_from.getLocalId().split("-")[1] );
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getName());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_head.getActivePathStatus());
                otnPath.setConnectionIdx("1");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("ingress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPath.setSyncDate(syncDate);
                otnPathRepository.save(otnPath);
            }
            { // TRANSIT_TO <--> TAIL
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_transit_to.getTid() +'/'+ tl1Odu_transit_to.getLocalId().split("-")[0]+'-' + tl1Odu_transit_to.getLocalId().split("-")[1] + '-' + tl1Odu_tail.getTid() +'/'+ tl1Odu_tail.getLocalId().split("-")[0]+'-'+ tl1Odu_tail.getLocalId().split("-")[1] );
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getName());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_transit_to.getActivePathStatus());
                otnPath.setConnectionIdx("2");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("ingress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPath.setSyncDate(syncDate);
                otnPathRepository.save(otnPath);
            }
        }

        for (Map.Entry<String, List<Tl1Odu>> entry : tl1OduHashMapForPath.entrySet() ) {
            List<Tl1Odu> tl1Odu_list = entry.getValue();
            if(tl1Odu_list.size() != 4) continue;

            Tl1Odu tl1Odu_head = null;
            Tl1Odu tl1Odu_tail = null;
            Tl1Odu tl1Odu_transit_from = null;
            Tl1Odu tl1Odu_transit_to = null;
            for(Tl1Odu tl1Odu : tl1Odu_list) {
                if (tl1Odu.getRole().equals("TRANSIT_FROM")) tl1Odu_transit_from = tl1Odu;
                else if(tl1Odu.getRole().equals("TRANSIT_TO")) tl1Odu_transit_to = tl1Odu;
                else if(tl1Odu.getRole().equals("HEAD")) tl1Odu_head = tl1Odu;
                else tl1Odu_tail = tl1Odu;
            }

            tl1Odu_list.set(0, tl1Odu_head);
            tl1Odu_list.set(1, tl1Odu_transit_from);
            tl1Odu_list.set(2, tl1Odu_transit_to);
            tl1Odu_list.set(3, tl1Odu_tail);


            { // HEAD <--> TRANSIT_FROM
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_transit_from.getTid() +'/'+ tl1Odu_transit_from.getLocalId().split("-")[0]+'-'+ tl1Odu_transit_from.getLocalId().split("-")[1] + '-' + tl1Odu_head.getTid() +'/'+ tl1Odu_head.getLocalId().split("-")[0]+'-' + tl1Odu_head.getLocalId().split("-")[1]);
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getName());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_head.getActivePathStatus());
                otnPath.setConnectionIdx("3");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("egress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPath.setSyncDate(syncDate);
                otnPathRepository.save(otnPath);
            }
            { // TRANSIT_TO <--> TAIL
                OtnLink otnLink = sdnLinkHashMap.get(tl1Odu_tail.getTid() +'/'+ tl1Odu_tail.getLocalId().split("-")[0]+'-'+ tl1Odu_tail.getLocalId().split("-")[1] +'-'+ tl1Odu_transit_to.getTid() +'/'+ tl1Odu_transit_to.getLocalId().split("-")[0]+'-' + tl1Odu_transit_to.getLocalId().split("-")[1]);
                OtnService otnService = sdnServiceHashMapForPath.get(tl1Odu_head.getName());
                OtnPath otnPath = new OtnPath();
                otnPath.setEmsId(200009);
                otnPath.setServiceId(otnService.getServiceId());
                otnPath.setPathType(tl1Odu_transit_to.getActivePathStatus());
                otnPath.setConnectionIdx("4");
                otnPath.setConnectionType("Forward");
                otnPath.setDirectionType("egress");
                otnPath.setTpType("");
                otnPath.setInstanceType("link");
                otnPath.setInstanceRef(otnLink.getLinkId());
                otnPath.setRefType("");
                otnPath.setSyncDate(syncDate);
                otnPathRepository.save(otnPath);
            }
        }

    }

    public void OtnSyncConstraint() throws Exception {
        Stream<OtnConstraint> sdnConstraintStream = tl1OduListForService
            .stream()
            .map(tl1OduList -> {
                Tl1Odu tl1Odu_head = tl1OduList.get(0);
                Tl1Odu tl1Odu_tail = tl1OduList.get(1);

                OtnNode srcOtnNode = sdnNodeHashMap.get(tl1Odu_head.getTid());

                OtnConstraint otnConstraint = new OtnConstraint(
                        200009, // ems_id
                        srcOtnNode.getVendor() + separator + srcOtnNode.getSysType() + separator + tl1Odu_head.getName(), // service_id
                        "protection type", // const_id
                        "", // const_type
                        "PROTECTION TYPE", // const_name
                        tl1Odu_head.getProtType(), // const_value
                        "", // const_operator
                        syncDate
                );

                return otnConstraint;
            });
        sdnConstraintStream.forEach(otnConstraintRepository::save);
    }

    public void OtnSyncAccess_if() throws Exception {
        Stream<OtnAccessIf> sdnAccessIfStream = tl1MplsIfList
            .stream()
            .filter(tl1MplsIf -> tl1OduHashMapForMplsTp.get(tl1MplsIf.getTid()+ '/' + tl1MplsIf.getMplsTpId().split("-")[0] + "-" + tl1MplsIf.getMplsTpId().split("-")[1]) != null)
            .map(tl1MplsIf -> {
                Tl1SystemInfo tl1SystemInfo = tl1SystemInfoHashMap.get(tl1MplsIf.getTid());
                OtnNode otnNode = sdnNodeHashMap.get(tl1MplsIf.getTid());
                OtnConnector otnConnector = sdnConnectorHashMap.get(tl1MplsIf.getTid()+ '/' + tl1MplsIf.getMplsTpId().split("-")[0] + "-" + tl1MplsIf.getMplsTpId().split("-")[1]);
                Tl1Odu tl1Odu = tl1OduHashMapForMplsTp.get(tl1MplsIf.getTid()+ '/' + tl1MplsIf.getMplsTpId().split("-")[0] + "-" + tl1MplsIf.getMplsTpId().split("-")[1]);

                OtnAccessIf otnAccessIf = new OtnAccessIf(
                        200009, // ems_id
                        tl1SystemInfo.getVendor() + separator + otnNode.getSysType() + separator + otnNode.getNeId() + separator + otnConnector.getConnectId(), // access_if_id
                        "", // accessif_name
                        otnNode.getNeId(), // ne_id
                        otnConnector.getConnectId(), // connector_id
                        tl1Odu.getService(), // accessif_type
                        tl1MplsIf.getOperationStatus(), // accessif_status
                        "", // service_ref
                        "", // node_connector_ref
                        syncDate
                );

                return otnAccessIf;
            });
        sdnAccessIfStream.forEach(otnAccessIfRepository::save);
    }


    public void OTNSyncPmPw() throws Exception {
        Stream<OtnPmPw> otnPmPwStream = tl1PmPwList.stream()
            .map(tl1PmPw -> {
               OtnPmPw otnPmPw = new OtnPmPw(
                       tl1PmPw.getTid(),
                       tl1PmPw.getSystemType(),
                       tl1PmPw.getSlot(),
                       tl1PmPw.getPort(),
                       tl1PmPw.getTime(),
                       tl1PmPw.getName(),
                       tl1PmPw.getIngPackets(),
                       tl1PmPw.getIngBytes(),
                       tl1PmPw.getIngRate(),
                       tl1PmPw.getEgrPackets(),
                       tl1PmPw.getEgrBytes(),
                       tl1PmPw.getEgrRate(),
                       tl1PmPw.getDate(),
                       syncDate
               );
               return otnPmPw;
            });
        otnPmPwStream.forEach(otnPmPwRepository::save);
    }

    public void OTNSyncPmTunnel() throws Exception {
        Stream<OtnPmTunnel> otnPmTunnelStream = tl1PmTunnelList.stream()
            .map(tl1PmTunnel -> {
               OtnPmTunnel otnPmTunnel = new OtnPmTunnel(
                       tl1PmTunnel.getTid(),
                       tl1PmTunnel.getSystemType(),
                       tl1PmTunnel.getSlot(),
                       tl1PmTunnel.getPort(),
                       tl1PmTunnel.getTime(),
                       tl1PmTunnel.getName(),
                       tl1PmTunnel.getIngPackets(),
                       tl1PmTunnel.getIngBytes(),
                       tl1PmTunnel.getIngRate(),
                       tl1PmTunnel.getEgrPackets(),
                       tl1PmTunnel.getEgrBytes(),
                       tl1PmTunnel.getEgrRate(),
                       tl1PmTunnel.getDate(),
                       syncDate
               );
               return otnPmTunnel;
            });
        otnPmTunnelStream.forEach(otnPmTunnelRepository::save);
    }

    public void OTNSyncPmTemperature() throws Exception {
        Stream<OtnPmTemperature> otnPmTemperatureStream = tl1PmTemperatureList.stream()
            .map(tl1PmTemperature -> {
               OtnPmTemperature otnPmTemperature = new OtnPmTemperature(
                       tl1PmTemperature.getTid(),
                       tl1PmTemperature.getSystemType(),
                       tl1PmTemperature.getSlot(),
                       tl1PmTemperature.getTime(),
                       tl1PmTemperature.getMax(),
                       tl1PmTemperature.getMin(),
                       tl1PmTemperature.getAverage(),
                       tl1PmTemperature.getDate(),
                       syncDate
                       );
               return otnPmTemperature;
            });
        otnPmTemperatureStream.forEach(otnPmTemperatureRepository::save);
    }

    public void OTNSyncPmAc() throws Exception {
        Stream<OtnPmAc> otnPmAcStream = tl1PmAcList.stream()
            .map(tl1PmAc -> {
               OtnPmAc otnPmAc = new OtnPmAc(
                       tl1PmAc.getTid(),
                       tl1PmAc.getSystemType(),
                       tl1PmAc.getSlot(),
                       tl1PmAc.getPort(),
                       tl1PmAc.getTime(),
                       tl1PmAc.getName(),
                       tl1PmAc.getIngPackets(),
                       tl1PmAc.getIngBytes(),
                       tl1PmAc.getIngRate(),
                       tl1PmAc.getEgrPackets(),
                       tl1PmAc.getEgrBytes(),
                       tl1PmAc.getEgrRate(),
                       tl1PmAc.getDate(),
                       syncDate
               );
               return otnPmAc;
            });
        otnPmAcStream.forEach(otnPmAcRepository::save);
    }

    public void OTNSyncPmOptic() throws Exception {
        Stream<OtnPmOptic> otnPmOpticStream = tl1PmOpticList.stream()
            .map(tl1PmOptic -> {
               OtnPmOptic otnPmOptic = new OtnPmOptic(
                       tl1PmOptic.getTid(),
                       tl1PmOptic.getSystemType(),
                       tl1PmOptic.getSlot(),
                       tl1PmOptic.getPort(),
                       tl1PmOptic.getPmType(),
                       tl1PmOptic.getRxMinPower(),
                       tl1PmOptic.getRxMaxPower(),
                       tl1PmOptic.getRxAvgPower(),
                       tl1PmOptic.getTxMinPower(),
                       tl1PmOptic.getTxMaxPower(),
                       tl1PmOptic.getTxAvgPower(),
                       tl1PmOptic.getDate(),
                       syncDate
               );
               return otnPmOptic;
            });
        otnPmOpticStream.forEach(otnPmOpticRepository::save);
    }

    public void OTNSyncPm() throws Exception {
        Stream<OtnPm> otnPmStream = tl1PmList.stream()
            .map(tl1Pm -> {
               OtnPm otnPm = new OtnPm(
                   tl1Pm.getTid(),
                   tl1Pm.getSystemType(),
                   tl1Pm.getSlot(),
                   tl1Pm.getPort(),
                   tl1Pm.getSignal(),
                   tl1Pm.getTime(),
                   tl1Pm.getInErrorPackets(),
                   tl1Pm.getEs(),
                   tl1Pm.getSes(),
                   tl1Pm.getUas(),
                   tl1Pm.getInDiscardPackets(),
                   tl1Pm.getOutErrorPackets(),
                   tl1Pm.getOutDiscardPackets(),
                   tl1Pm.getDate(),
                       syncDate
               );
               return otnPm;
            });
        otnPmStream.forEach(otnPmRepository::save);
    }

    public void OTNSyncPmPort() throws Exception {
        Stream<OtnPmPort> sdnPmPortStream = tl1PmPortList.stream()
        .map(tl1PmPort -> {
            OtnPmPort otnPmPort = new OtnPmPort(
                    tl1PmPort.getTid(),
                    tl1PmPort.getSystemType(),
                    tl1PmPort.getSlot(),
                    tl1PmPort.getPort(),
                    tl1PmPort.getTime(),
                    tl1PmPort.getInOctets(),
                    tl1PmPort.getInOkPackets(),
                    tl1PmPort.getInDiscardPackets(),
                    tl1PmPort.getInErrorPackets(),
                    tl1PmPort.getInPausePackets(),
                    tl1PmPort.getInAlignmentErrors(),
                    tl1PmPort.getInFcsErrors(),
                    tl1PmPort.getInSymbolErrors(),
                    tl1PmPort.getOutOctets(),
                    tl1PmPort.getOutOkPackets(),
                    tl1PmPort.getOutUnicastPackets(),
                    tl1PmPort.getOutNonUnicastPackets(),
                    tl1PmPort.getOutDiscardPackets(),
                    tl1PmPort.getOutErrorPackets(),
                    tl1PmPort.getOutBroadcastPackets(),
                    tl1PmPort.getOutMulticastPackets(),
                    tl1PmPort.getOutPausePackets(),
                    tl1PmPort.getInRate(),
                    tl1PmPort.getOutRate(),
                    tl1PmPort.getInLossRatio(),
                    tl1PmPort.getOutLossRatio(),
                    tl1PmPort.getDate(),
                    syncDate
            );

            return otnPmPort;
        });
        sdnPmPortStream.forEach(otnPmPortRepository::save);
    }
    public void OTNSyncPmOpticTemperature() throws Exception {
        Stream<OtnPmOpticTemperature> otnPmOpticTemperatureStream = tl1PmOpticTemperatureList.stream()
            .map(tl1PmOpticTemperature -> {
               OtnPmOpticTemperature otnPmOpticTemperature = new OtnPmOpticTemperature(
                       tl1PmOpticTemperature.getTid(),
                       tl1PmOpticTemperature.getSystemType(),
                       tl1PmOpticTemperature.getSlot(),
                       tl1PmOpticTemperature.getTime(),
                       tl1PmOpticTemperature.getMax(),
                       tl1PmOpticTemperature.getMin(),
                       tl1PmOpticTemperature.getAverage(),
                       tl1PmOpticTemperature.getDate(),
                       syncDate
               );
               return otnPmOpticTemperature;
            });
        otnPmOpticTemperatureStream.forEach(otnPmOpticTemperatureRepository::save);
    }

    //cm module
    public void OtnSyncCmInventory() throws Exception {
        Stream<OtnCmInventory> otnCmInventoryStream = tl1CmProgramInfoList.stream()
            .map(tl1CmProgramInfo -> {
                OtnCmInventory otnCmInventory = new OtnCmInventory(
                    tl1CmProgramInfo.getTid(),//tid
                    tl1CmProgramInfo.getAid(),//slot
                    tl1CmProgramInfo.getUnitType(),//unit_type
                    tl1CmProgramInfo.getPkgVersion(),//pkg_version
                    tl1CmProgramInfo.getPkgFilename(),//pkg_filename
                    tl1CmProgramInfo.getPkgVersionDate(),//pkg_version_date,
                    tl1CmProgramInfo.getPkgSize(),//pkg_size
                    tl1CmProgramInfo.getFpgaVersion(),//fpga_version
                    tl1CmProgramInfo.getFpgaVersionDate(),//fpga_version_date
                    tl1CmProgramInfo.getFpgaSize(),//fpga_size
                    tl1CmProgramInfo.getCpldVersion(),//cpld_version
                    tl1CmProgramInfo.getCpldVersionDate(),//cpld_version_date,
                    tl1CmProgramInfo.getCpldSize(),//cpld_size
                    tl1CmProgramInfo.getHwVersion(),//hw_version
                        syncDate
                );

                return otnCmInventory;
            });
        otnCmInventoryStream.forEach(otnCmInventoryRepository::save);
    }

    public void OtnSyncCmLink() throws Exception {
        Stream<OtnCmLink> otnCmLinkStream = tl1CmPortList.stream()
            .map(tl1CmPort -> {
                Optional<Tl1ModuleInfo> tl1ModuleInfo = tl1ModuleInfoList.stream()
                    .filter(moduleInfo -> moduleInfo.getAid().equals(tl1CmPort.getAid())).findAny();

                //예> AID(EMS_1000_B-OPN1000-S03-P1)에서 3, 4번째 값만 추출, 구분자는 '-'
                String slot = tl1CmPort.getAid().split("-")[2];
                String port = tl1CmPort.getAid().split("-")[3];

                OtnCmLink otnCmLink = new OtnCmLink(
                        tl1CmPort.getTid(),//tid
                        slot,//slot
                        port,//port
                        tl1CmPort.getUnitType(),//unitType
                        tl1CmPort.getSignal(),//signal
                        tl1ModuleInfo.map(moduleInfo -> moduleInfo.getMid()).orElse(""),//mid
                        tl1ModuleInfo.map(moduleInfo -> moduleInfo.getMidContext()).orElse(""),//midContext
                        tl1ModuleInfo.map(moduleInfo -> moduleInfo.getPmid()).orElse(""),//pmid
                        tl1ModuleInfo.map(moduleInfo -> moduleInfo.getPmidContext()).orElse(""),//pmidContext
                        tl1ModuleInfo.map(moduleInfo -> moduleInfo.getOperationState()).orElse(""),//operationState
                        tl1ModuleInfo.map(moduleInfo -> moduleInfo.getOperationStateReason()).orElse(""),//operationStateReason
                        tl1ModuleInfo.map(moduleInfo -> moduleInfo.getCryptoMode()).orElse(""),//cryptoMode
                        syncDate
                );

                return otnCmLink;
            });

        otnCmLinkStream.forEach(otnCmLinkRepository::save);
    }

    public void OtnSyncCmSession() throws Exception {
        Stream<OtnCmSession> otnCmSessionStream = tl1SessStateList.stream()
            .map(tl1SessState -> {
                Optional<Tl1KeyState> tl1KeyState= tl1KeyStateList.stream()
                    .filter(keyState -> keyState.getAid().equals(tl1SessState.getAid())).findAny();

                //AID(EMS_1000_B-OPN1000-S03-P1)에서 3번째 값만 추출, 구분자는 '-'
                String slot = tl1SessState.getAid().split("-")[2];
                String port = tl1SessState.getAid().split("-")[3];

                Optional<Tl1BypassInfo> tl1BypassInfo = tl1BypassInfoList.stream()
                    .filter(bypassInfo -> bypassInfo.getTid().equals(tl1SessState.getTid())
                            && bypassInfo.getAid().equals(slot + "-" + port)).findAny();
                System.out.println(tl1KeyState + slot + port + tl1BypassInfo + ",....test");
                OtnCmSession otnCmSession = new OtnCmSession(
                        tl1SessState.getTid(),//tid
                        slot,//slot
                        port,//port
                        tl1SessState.getLocalIp(),//local_ip
                        tl1SessState.getRemoteIp(),//remote_ip
                        tl1SessState.getKspMode(),//ksp_mode
                        tl1SessState.getDeadTime(),//dead_time
                        tl1SessState.getKeyLifeTime(),//key_life_time
                        tl1SessState.getKeySrcMode(),//key_src_mode
                        tl1SessState.getKeyFailover(),//key_failover
                        tl1SessState.getRetryReqInterval(),//retry_req_interval
                        tl1SessState.getSessionState(),//session_state
                        tl1SessState.getDstLid(),//dst_lid
                        tl1SessState.getCurrentTxKeySrcMode(),//current_tx_key_src_mode
                        tl1SessState.getCurrentRxKeySrcMode(),//current_rx_key_src_mode
                        tl1KeyState.map(keyState -> keyState.getTxKeyState()).orElse(""),//tx_key_state
                        tl1KeyState.map(keyState -> keyState.getTxKeyBankState()).orElse(""),//tx_key_bank_state
                        tl1KeyState.map(keyState -> keyState.getRxKeyState()).orElse(""),//rx_key_state
                        tl1KeyState.map(keyState -> keyState.getRxKeyBankState()).orElse(""),//rx_key_bank_state
                        tl1BypassInfo.map(bypassInfo -> bypassInfo.getMode()).orElse(""),//bypass_mode
                        tl1BypassInfo.map(bypassInfo -> bypassInfo.getAction()).orElse(""),//bypass_action
                        tl1BypassInfo.map(bypassInfo -> bypassInfo.getCurrentAction()).orElse(""),//bypass_current_action
                        tl1BypassInfo.map(bypassInfo -> bypassInfo.getPeerMode()).orElse(""),//bypass_peer_mode
                        tl1BypassInfo.map(bypassInfo -> bypassInfo.getPeerAction()).orElse(""),//bypass_peer_action
                        tl1BypassInfo.map(bypassInfo -> bypassInfo.getPeerCurrentAction()).orElse(""),//bypass_peer_current_action
                        syncDate
                );

                return otnCmSession;
            });

        otnCmSessionStream.forEach(otnCmSessionRepository::save);
    }

    public void OtnSyncCmQkdLink() throws Exception {
        Stream<OtnCmQkdLink> otnCmQkdLinkStream = tl1QkdInfoList.stream()
            .map(tl1QkdInfo -> {
                OtnCmQkdLink otnCmQkdLink = new OtnCmQkdLink(
                        tl1QkdInfo.getTid(),//tid
                        tl1QkdInfo.getAid().split("-")[0],//slot  AID(S03-P1)에서 1번째 값만 추출, 구분자는 '-'
                        tl1QkdInfo.getAid().split("-")[1],//port  AID(S03-P1)에서 2번째 값만 추출, 구분자는 '-'
                        tl1QkdInfo.getServer(),//server
                        tl1QkdInfo.getServerPort(),//server_port
                        tl1QkdInfo.getMasterSaeId(),//master_sae_id
                        tl1QkdInfo.getSlaveSaeId(),//slave_sae_id
                        tl1QkdInfo.getKeyIntfIp(),//key_intf_ip
                        tl1QkdInfo.getKeyIntfNetmask(),//key_intf_netmask
                        tl1QkdInfo.getKeyIntfGateway(),//key_intf_gateway
                        tl1QkdInfo.getKeySize(),//key_key_size(byte)
                        tl1QkdInfo.getKmsStatus(),//kms_status
                        tl1QkdInfo.getVendor(),//vendor
                        syncDate
                );

                return otnCmQkdLink;
            });

        otnCmQkdLinkStream.forEach(otnCmQkdLinkRepository::save);
    }
}
