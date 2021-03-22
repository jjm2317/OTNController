package com.woorinet.plugin.demo.CONTROLLER;


import com.woorinet.plugin.demo.DTO.OTN.*;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Manager.OtnManager;
import com.woorinet.plugin.demo.Manager.PortalManager;
import com.woorinet.plugin.demo.Manager.QkdManager;
import com.woorinet.plugin.demo.Manager.Tl1Manager;
import com.woorinet.plugin.demo.Repository.OTN.*;
import com.woorinet.plugin.demo.Repository.TN2.*;
import com.woorinet.plugin.demo.Repository.QKD.*;
import com.woorinet.plugin.demo.Repository.TL1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/sync")
public class SyncController {
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
    private OtnNodeRepository otnNodeRepository;
    @Autowired
    private OtnConnectorRepository otnConnectorRepository;
    @Autowired
    private OtnLinkRepository otnLinkRepository;
    @Autowired
    private OtnServiceRepository otnServiceRepository;
    @Autowired
    private OtnTunnelRepository otnTunnelRepository;
    @Autowired
    private OtnAccessIfRepository otnAccessIfRepository;
    @Autowired
    private OtnConstraintRepository otnConstraintRepository;
    @Autowired
    private OtnPathRepository otnPathRepository;
    @Autowired
    private OtnCryptoModuleRepository otnCryptoModuleRepository;
    @Autowired
    private OtnCryptoSessionRepository otnCryptoSessionRepository;
    @Autowired
    private OtnPmPortRepository otnPmPortRepository;


    @GetMapping("/tl1")
    String synchronization() {
        int CTAG = 100;
        try {
            Tl1Manager manager = new Tl1Manager(
                    CTAG,
                    "222.117.54.175",
                    19011,
                    tl1NodeRepository,
                    tl1SystemInfoRepository,
                    tl1SlotRepository,
                    tl1EthPortRepository,
                    tl1NodeConnectorRepository,
                    tl1CesNodeConnectorRepository,
                    tl1OduNodeConnectorRepository,
                    tl1MplsIfRepository,
                    tl1OduMplsIfRepository,
                    tl1StunnelRepository,
                    tl1StunnelExtRepository,
                    tl1StunnelTransitRepository,
                    tl1TunnelPortRepository,
                    tl1SpwRepository,
                    tl1MspwRepository,
                    tl1MplsAcRepository,
                    tl1AccessIfRepository,
                    tl1ServiceRepository,
                    tl1ServiceExtRepository,
                    tl1ServiceTunnelRepository,
                    tl1ServiceMspwRepository,
                    tl1OduRepository,
                    tl1CesPortRepository,
                    tl1CesPwRepository,
                    tl1L2LacpRepository,
                    tl1OpticPowerRepository,
                    tl1PmRepository,
                    tl1PmPortRepository,
                    tl1PmAcRepository,
                    tl1PmPwRepository,
                    tl1PmTunnelRepository,
                    tl1InventoryRepository,
                    tl1SessStateRepository,
                    tl1KeyStateRepository,
                    tl1ModuleInfoRepository,
                    tl1CmPortRepository,
                    tl1BypassInfoRepository,
                    tl1CryptoModeRepository,
                    tl1CmProgramInfoRepository);
            manager.TL1SyncStart();
            manager.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "tl1 synchronization fail";
        }

        return "tl1 synchronization success";
    }

    @GetMapping("/otn")
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
            OtnManager manager = new OtnManager(
                    otnNodeRepository,
                    otnConnectorRepository,
                    otnLinkRepository,
                    otnServiceRepository,
                    otnTunnelRepository,
                    otnPathRepository,
                    otnConstraintRepository,
                    otnAccessIfRepository,
                    otnCryptoModuleRepository,
                    otnCryptoSessionRepository,
                    otnPmPortRepository,
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

    @Autowired
    private PortalLinkbookRepository portalLinkBookRepository;
    @Autowired
    private PortalLinkmngRepository portalLinkMngRepository;
    @Autowired
    private PortalTrunkUsageRepository portalTrunkUsageRepository;
    @Autowired
    private PortalStatsInventoryRepository portalStatsInventoryRepository;
    @Autowired
    private PortalStatsNodeRepository portalStatsNodeRepository;
    @Autowired
    private PortalStatsSuppliesRepository portalStatsSuppliesRepository;

    @GetMapping("/portal")
    String syncronizeHola() {
        try {
            //SdnNode 조회
            List<OtnNode> otnNodeList = otnNodeRepository.findAll();
            //SdnConnector 조회
            List<OtnConnector> otnConnectorList = otnConnectorRepository.findAll();
            //SdnLink 조회
            List<OtnLink> otnLinkList = otnLinkRepository.findAll();
            //SdnService 조회
            List<OtnService> otnServiceList = otnServiceRepository.findAll();
            //SdnPath 조회
            List<OtnPath> otnPathList = otnPathRepository.findAll();
            //SdnConstraint 조회
            List<OtnConstraint> otnConstraintList = otnConstraintRepository.findAll();
            //SdnAccessIf 조회
            List<OtnAccessIf> otnAccessIfList = otnAccessIfRepository.findAll();

            PortalManager manager = new PortalManager(portalLinkBookRepository,
                    portalLinkMngRepository,
                    portalTrunkUsageRepository,
                    portalStatsInventoryRepository,
                    portalStatsNodeRepository,
                    portalStatsSuppliesRepository,
                    otnConnectorRepository,
                    otnNodeList,
                    otnConnectorList,
                    otnLinkList,
                    otnServiceList,
                    otnPathList,
                    otnConstraintList,
                    otnAccessIfList

            );

            manager.PortalSyncStart();
        } catch (Exception e) {
            e.printStackTrace();
            return "hola synchronization fail";
        }

        return "hola synchronization success";
    }

    @Autowired
    private QkdNodeRepository qkdNodeRepository;
    @Autowired
    private QkdServiceRepository qkdServiceRepository;
    @Autowired
    private QkdLinkRepository qkdLinkRepository;
    @Autowired
    private QkdPathRepository qkdPathRepository;
    @Autowired
    private QkdProviderNodeRepository qkdProviderNodeRepository;
    @Autowired
    private QkdProviderLinkRepository qkdProviderLinkRepository;
    @Autowired
    private QkdAppNodeRepository qkdAppNodeRepository;
    @Autowired
    private QkdAppLinkRepositroy qkdAppLinkRepositroy;
    @GetMapping("/qkd")
    String syncronizeQKD() {
        try {
            QkdManager manager = new QkdManager(
                    qkdNodeRepository,
                    qkdServiceRepository,
                    qkdLinkRepository,
                    qkdPathRepository,
                    qkdProviderNodeRepository,
                    qkdProviderLinkRepository,
                    qkdAppNodeRepository,
                    qkdAppLinkRepositroy
            );
            manager.QkdSyncStart();
        } catch (Exception e) {
            e.printStackTrace();
            return "qkd synchronization fail";
        }

        return "qkd synchronization success";
    }
}
