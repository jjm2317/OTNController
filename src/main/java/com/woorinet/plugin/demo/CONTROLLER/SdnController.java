package com.woorinet.plugin.demo.CONTROLLER;


import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Manager.SDNManager;
import com.woorinet.plugin.demo.Repository.SDN.*;
import com.woorinet.plugin.demo.Repository.TL1.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sdn")
public class SdnController {
    @Autowired
    private Tl1NodeRepository tl1NodeRepository;
    @Autowired
    private Tl1SystemInfoRepository tl1SystemInfoRepository;
    @Autowired
    private Tl1SlotRepository tl1SlotRepository;
    @Autowired
    private Tl1EthPortRepository tl1EthPortRepository;
    @Autowired
    private Tl1NodeConnectorRepository tl1NodeConnectorRepository;
    @Autowired
    private Tl1CesNodeConnectorRepository tl1CesNodeConnectorRepository;
    @Autowired
    private Tl1OduNodeConnectorRepository tl1OduNodeConnectorRepository;
    @Autowired
    private Tl1MplsIfRepository tl1MplsIfRepository;
    @Autowired
    private Tl1OduMplsIfRepository tl1OduMplsIfRepository;
    @Autowired
    private Tl1StunnelRepository tl1StunnelRepository;
    @Autowired
    private Tl1StunnelExtRepository tl1StunnelExtRepository;
    @Autowired
    private Tl1StunnelTransitRepository tl1StunnelTransitRepository;
    @Autowired
    private Tl1TunnelPortRepository tl1TunnelPortRepository;
    @Autowired
    private Tl1SpwRepository tl1SpwRepository;
    @Autowired
    private Tl1MspwRepository tl1MspwRepository;
    @Autowired
    private Tl1MplsAcRepository tl1MplsAcRepository;
    @Autowired
    private Tl1AccessIfRepository tl1AccessIfRepository;
    @Autowired
    private Tl1ServiceRepository tl1ServiceRepository;
    @Autowired
    private Tl1ServiceExtRepository tl1ServiceExtRepository;
    @Autowired
    private Tl1ServiceTunnelRepository tl1ServiceTunnelRepository;
    @Autowired
    private Tl1ServiceMspwRepository tl1ServiceMspwRepository;
    @Autowired
    private Tl1OduRepository tl1OduRepository;
    @Autowired
    private Tl1CesPortRepository tl1CesPortRepository;
    @Autowired
    private Tl1CesPwRepository tl1CesPwRepository;
    @Autowired
    private Tl1L2LacpRepository tl1L2LacpRepository;
    @Autowired
    private Tl1OpticPowerRepository tl1OpticPowerRepository;
    @Autowired
    private Tl1PmRepository tl1PmRepository;
    @Autowired
    private Tl1PmPortRepository tl1PmPortRepository;
    @Autowired
    private Tl1PmAcRepository tl1PmAcRepository;
    @Autowired
    private Tl1PmPwRepository tl1PmPwRepository;
    @Autowired
    private Tl1PmTunnelRepository tl1PmTunnelRepository;
    @Autowired
    private Tl1InventoryRepository tl1InventoryRepository;
    @Autowired
    private Tl1SessStateRepository tl1SessStateRepository;
    @Autowired
    private Tl1KeyStateRepository tl1KeyStateRepository;
    @Autowired
    private Tl1ModuleInfoRepository tl1ModuleInfoRepository;
    @Autowired
    private Tl1CmPortRepository tl1CmPortRepository;
    @Autowired
    private Tl1BypassInfoRepository tl1BypassInfoRepository;
    @Autowired
    private Tl1CryptoModeRepository tl1CryptoModeRepository;
    @Autowired
    private Tl1CmProgramInfoRepository tl1CmProgramInfoRepository;

    @Autowired
    private SdnNodeRepository sdnNodeRepository;
    @Autowired
    private SdnConnectorRepository sdnConnectorRepository;
    @Autowired
    private SdnLinkRepository sdnLinkRepository;
    @Autowired
    private SdnServiceRepository sdnServiceRepository;
    @Autowired
    private SdnTunnelRepository sdnTunnelRepository;
    @Autowired
    private SdnAccessIfRepository sdnAccessIfRepository;
    @Autowired
    private SdnConstraintRepository sdnConstraintRepository;
    @Autowired
    private SdnPathRepository sdnPathRepository;
    @Autowired
    private SdnCryptoModuleRepository sdnCryptoModuleRepository;
    @Autowired
    private SdnCryptoSessionRepository sdnCryptoSessionRepository;
    @Autowired
    private SdnPmPortRepository sdnPmPortRepository;

    @GetMapping("/")
    String convertTL1() {
        try {
            // Node 조회
            List<Tl1Node> tl1NodeList = tl1NodeRepository.findAll();
            // SYSTEM_INFO 조회
            List<Tl1SystemInfo> tl1SystemInfoList = tl1SystemInfoRepository.findAll();
            // ODU_NODE_CONNECTOR 조회
            List<Tl1OduNodeConnector> tl1OduNodeConnectorList = tl1OduNodeConnectorRepository.findAll();
            // ODU 조회
            List<Tl1Odu> tl1OduList = tl1OduRepository.findAll();
            // ODU_MPLS_IF 조회
            List<Tl1OduMplsIf> tl1OduMplsIfList = tl1OduMplsIfRepository.findAll();
            // OPTIC_POWER 조회
            List<Tl1OpticPower> tl1OpticPowerList = tl1OpticPowerRepository.findAll();
            // SERVICE 조회
            List<Tl1Service> tl1ServiceList = tl1ServiceRepository.findAll();
            // ACCESS_IF 조회
            List<Tl1AccessIf> tl1AccessIfList = tl1AccessIfRepository.findAll();
            // SERVICE_EXT 조회
            List<Tl1ServiceExt> tl1ServiceExtList = tl1ServiceExtRepository.findAll();
            // MPLS_IF 조회
            List<Tl1MplsIf> tl1MplsIfList = tl1MplsIfRepository.findAll();
            // INVENTORY 조회
            List<Tl1Inventory> tl1InventorieList = tl1InventoryRepository.findAll();
            // CM_PORT 조회
            List<Tl1CmPort> tl1CmPortList = tl1CmPortRepository.findAll();
            // MODULE_INFO 조회
            List<Tl1ModuleInfo> tl1ModuleInfoList = tl1ModuleInfoRepository.findAll();
            // BYPASS_INFO 조회
            List<Tl1BypassInfo> tl1BypassInfoList = tl1BypassInfoRepository.findAll();
            // CM_PROGRAM_INFO 조회
            List<Tl1CmProgramInfo> tl1CmProgramInfoList = tl1CmProgramInfoRepository.findAll();
            // SESS_STATE 조회
            List<Tl1SessState> tl1SessStateList = tl1SessStateRepository.findAll();
            // KEY_STATE 조회
            List<Tl1KeyState> tl1KeyStateList = tl1KeyStateRepository.findAll();
            // PM_PORT 조회
            List<Tl1PmPort> tl1PmPortList = tl1PmPortRepository.findAll();
            SDNManager manager = new SDNManager(
                    sdnNodeRepository,
                    sdnConnectorRepository,
                    sdnLinkRepository,
                    sdnServiceRepository,
                    sdnTunnelRepository,
                    sdnPathRepository,
                    sdnConstraintRepository,
                    sdnAccessIfRepository,
                    sdnCryptoModuleRepository,
                    sdnCryptoSessionRepository,
                    sdnPmPortRepository,
                    tl1NodeList,
                    tl1SystemInfoList,
                    tl1OduNodeConnectorList,
                    tl1OpticPowerList,
                    tl1OduList,
                    tl1OduMplsIfList,
                    tl1ServiceList,
                    tl1AccessIfList,
                    tl1ServiceExtList,
                    tl1MplsIfList,
                    tl1InventorieList,
                    tl1CmPortList,
                    tl1ModuleInfoList,
                    tl1BypassInfoList,
                    tl1CmProgramInfoList,
                    tl1SessStateList,
                    tl1KeyStateList,
                    tl1PmPortList);
            // Sync 시작
            manager.SDNSyncStart();
        } catch (Exception e) {
            e.printStackTrace();
            return "sdn synchronization fail";
        }

        return "sdn synchronization success";
    }


    @ApiOperation(value = "get node list", notes = "전체 노드 조회")
    @GetMapping(value = "/node/list")
    @ResponseBody
    public ResponseEntity selectNodeList() {
        return ResponseEntity.ok(sdnNodeRepository.findAll());
    }

    @ApiOperation(value = "get node", notes = "노드 조회")
    @GetMapping(value = "/node")
    @ResponseBody
    public ResponseEntity selectNode(@RequestParam String ne_id) {
        return ResponseEntity.ok(sdnNodeRepository.findSdnNodeByNeId(ne_id));
    }

    @ApiOperation(value = "get connector list", notes = "전체 커넥터 조회")
    @GetMapping(value = "/connector/list")
    @ResponseBody
    public ResponseEntity selectConnectorList() {
        return ResponseEntity.ok(sdnConnectorRepository.findAll());
    }

    @ApiOperation(value = "get connector", notes = "커넥터 조회")
    @GetMapping(value = "/connector")
    @ResponseBody
    public ResponseEntity selectConnector(@RequestParam String connect_id) {
        return ResponseEntity.ok(sdnConnectorRepository.findSdnConnectorByConnectId(connect_id));
    }

    @ApiOperation(value = "get link list", notes = "전체 링크 조회")
    @GetMapping(value = "/link/list")
    @ResponseBody
    public ResponseEntity selectLinkList() {
        return ResponseEntity.ok(sdnLinkRepository.findAll());
    }

    @ApiOperation(value = "get link", notes = "링크 조회")
    @GetMapping(value = "/link")
    @ResponseBody
    public ResponseEntity selectLink(@RequestParam String link_id) {
        return ResponseEntity.ok(sdnLinkRepository.findSdnLinkByLinkId(link_id));
    }

    @ApiOperation(value = "get tunnel list", notes = "전체 터널 조회")
    @GetMapping(value = "/tunnel/list")
    @ResponseBody
    public ResponseEntity selectTunnelList() {return ResponseEntity.ok(sdnTunnelRepository.findAll());}

    @ApiOperation(value = "get tunnel", notes = "터널 조회")
    @GetMapping(value = "/tunnel")
    @ResponseBody
    public ResponseEntity selectTunnel(@RequestParam String tunnel_id) {
        return ResponseEntity.ok(sdnTunnelRepository.findSdnTunnelByTunnelId(tunnel_id));
    }

    @ApiOperation(value = "get service list", notes = "전체 서비스 조회")
    @GetMapping(value = "/service/list")
    @ResponseBody
    public ResponseEntity selectServiceList() {return ResponseEntity.ok(sdnServiceRepository.findAll());}

    @ApiOperation(value = "get service", notes = "서비스 조회")
    @GetMapping(value = "/service")
    @ResponseBody
    public ResponseEntity selectService(@RequestParam String service_id) {
        return ResponseEntity.ok(sdnServiceRepository.findSdnServiceByServiceId(service_id));
    }

    @ApiOperation(value = "get path list", notes = "전체 경로 조회")
    @GetMapping(value = "/path/list")
    @ResponseBody
    public ResponseEntity selectPathList() {return ResponseEntity.ok(sdnPathRepository.findAll());}

    @ApiOperation(value = "get path", notes = "경로 조회")
    @GetMapping(value = "/path")
    @ResponseBody
    public ResponseEntity selectPath(@RequestParam(required = false, defaultValue = "0") int id , @RequestParam(required = false) String service_id) {
        if (id != 0) return ResponseEntity.ok(sdnPathRepository.findSdnPathById(id));
        return ResponseEntity.ok(sdnPathRepository.findSdnPathByServiceId(service_id));
    }

    @ApiOperation(value = "get constraint list", notes = "전체 속성 조회")
    @GetMapping(value = "/constraint/list")
    @ResponseBody
    public ResponseEntity selectConstraintList() {return ResponseEntity.ok(sdnConstraintRepository.findAll());}

    @ApiOperation(value = "get constraint", notes = "속성 조회")
    @GetMapping(value = "/constraint")
    @ResponseBody
    public ResponseEntity selectConstraint(@RequestParam(required = false, defaultValue = "0") int id, @RequestParam(required = false) String service_id) {
        if(id != 0) return ResponseEntity.ok(sdnConstraintRepository.findSdnConstraintById(id));
        return ResponseEntity.ok(sdnConstraintRepository.findSdnConstraintByServiceId(service_id));
    }

    @ApiOperation(value = "get accessif list", notes = "전체 access interface 조회")
    @GetMapping(value = "/accessif/list")
    @ResponseBody
    public ResponseEntity selectAccessIfList() {return ResponseEntity.ok(sdnAccessIfRepository.findAll());}

    @ApiOperation(value = "get accessif", notes = "access interface 조회")
    @GetMapping(value = "/accessif")
    @ResponseBody
    public ResponseEntity selectAccessIf(@RequestParam String accessif_id) {
        return ResponseEntity.ok(sdnAccessIfRepository.findSdnAccessIfByAccessifId(accessif_id));
    }
}

