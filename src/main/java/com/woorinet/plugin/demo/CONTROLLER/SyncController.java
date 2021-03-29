package com.woorinet.plugin.demo.CONTROLLER;


import com.woorinet.plugin.demo.DTO.OTN.*;
import com.woorinet.plugin.demo.DTO.TL1.CM.*;
import com.woorinet.plugin.demo.DTO.TL1.PM.*;
import com.woorinet.plugin.demo.DTO.TL1.*;
import com.woorinet.plugin.demo.Manager.OtnManager;
import com.woorinet.plugin.demo.Manager.PortalManager;
import com.woorinet.plugin.demo.Manager.QkdManager;
import com.woorinet.plugin.demo.Manager.Tl1Manager;
import com.woorinet.plugin.demo.Repository.OTN.*;
import com.woorinet.plugin.demo.Repository.OTN.PM.*;
import com.woorinet.plugin.demo.Repository.QKD.*;
import com.woorinet.plugin.demo.Repository.TL1.*;
import com.woorinet.plugin.demo.Repository.TL1.CM.*;
import com.woorinet.plugin.demo.Repository.TL1.PM.*;
import com.woorinet.plugin.demo.Repository.TN2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private Tl1PmPwRepository tl1PmPwRepository;
    @Autowired
    private Tl1PmTunnelRepository tl1PmTunnelRepository;
    @Autowired
    private Tl1PmTemperatureRepository tl1PmTemperatureRepository;
    @Autowired
    private Tl1PmAcRepository tl1PmAcRepository;
    @Autowired
    private Tl1PmOpticRepository tl1PmOpticRepository;
    @Autowired
    private Tl1PmRepository tl1PmRepository;
    @Autowired
    private Tl1PmPortRepository tl1PmPortRepository;
    @Autowired
    private Tl1PmOpticTemperatureRepository tl1PmOpticTemperatureRepository;
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
    private Tl1QkdInfoRepository tl1QkdInfoRepository;



    @GetMapping("/tl1")
    String synchronization(@RequestParam String syncDate) {
        int CTAG = 100;
        try {
            Tl1Manager manager = new Tl1Manager(
                    syncDate,
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
                    tl1PmPwRepository,
                    tl1PmTunnelRepository,
                    tl1PmTemperatureRepository,
                    tl1PmAcRepository,
                    tl1PmOpticRepository,
                    tl1PmRepository,
                    tl1PmPortRepository,
                    tl1PmOpticTemperatureRepository,
                    tl1InventoryRepository,
                    tl1SessStateRepository,
                    tl1KeyStateRepository,
                    tl1ModuleInfoRepository,
                    tl1CmPortRepository,
                    tl1BypassInfoRepository,
                    tl1CryptoModeRepository,
                    tl1CmProgramInfoRepository,
                    tl1QkdInfoRepository);
            manager.Tl1PmWithFtpSyncStart();
            manager.TL1SyncStart();
            manager.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "tl1 synchronization fail";
        }

        return "tl1 synchronization success";
    }

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
    private OtnPmPwRepository otnPmPwRepository;
    @Autowired
    private OtnPmTunnelRepository otnPmTunnelRepository;
    @Autowired
    private OtnPmTemperatureRepository otnPmTemperatureRepository;
    @Autowired
    private OtnPmAcRepository otnPmAcRepository;
    @Autowired
    private OtnPmOpticRepository otnPmOpticRepository;
    @Autowired
    private OtnPmRepository otnPmRepository;
    @Autowired
    private OtnPmPortRepository otnPmPortRepository;
    @Autowired
    private OtnPmOpticTemperatureRepository otnPmOpticTemperatureRepository;
    @Autowired
    private OtnCmInventoryRepository otnCmInventoryRepository;
    @Autowired
    private OtnCmLinkRepository otnCmLinkRepository;
    @Autowired
    private OtnCmSessionRepository otnCmSessionRepository;
    @Autowired
    private OtnCmQkdLinkRepository otnCmQkdLinkRepository;

    @GetMapping("/otn")
    String convertTL1(@RequestParam String syncDate) {
        try {
            List<Tl1Node> tl1NodeList = tl1NodeRepository.findTl1NodeBySyncDate(syncDate);
            List<Tl1SystemInfo> tl1SystemInfoList = tl1SystemInfoRepository.findAll();
            List<Tl1OduNodeConnector> tl1OduNodeConnectorList = tl1OduNodeConnectorRepository.findAll();
            List<Tl1Odu> tl1OduList = tl1OduRepository.findAll();
            List<Tl1OduMplsIf> tl1OduMplsIfList = tl1OduMplsIfRepository.findAll();
            List<Tl1OpticPower> tl1OpticPowerList = tl1OpticPowerRepository.findAll();
            List<Tl1Service> tl1ServiceList = tl1ServiceRepository.findAll();
            List<Tl1AccessIf> tl1AccessIfList = tl1AccessIfRepository.findAll();
            List<Tl1ServiceExt> tl1ServiceExtList = tl1ServiceExtRepository.findAll();
            List<Tl1MplsIf> tl1MplsIfList = tl1MplsIfRepository.findAll();
            List<Tl1Inventory> tl1InventorieList = tl1InventoryRepository.findAll();
            List<Tl1CmPort> tl1CmPortList = tl1CmPortRepository.findAll();
            List<Tl1ModuleInfo> tl1ModuleInfoList = tl1ModuleInfoRepository.findAll();
            List<Tl1BypassInfo> tl1BypassInfoList = tl1BypassInfoRepository.findAll();
            List<Tl1CmProgramInfo> tl1CmProgramInfoList = tl1CmProgramInfoRepository.findAll();
            List<Tl1SessState> tl1SessStateList = tl1SessStateRepository.findAll();
            List<Tl1KeyState> tl1KeyStateList = tl1KeyStateRepository.findAll();
            List<Tl1QkdInfo> tl1QkdInfoList = tl1QkdInfoRepository.findAll();

            List<Tl1PmPw> tl1PmPwList = tl1PmPwRepository.findAll();
            List<Tl1PmTunnel> tl1PmTunnelList = tl1PmTunnelRepository.findAll();
            List<Tl1PmTemperature> tl1PmTemperatureList = tl1PmTemperatureRepository.findAll();
            List<Tl1PmAc> tl1PmAcList = tl1PmAcRepository.findAll();
            List<Tl1PmOptic> tl1PmOpticList = tl1PmOpticRepository.findAll();
            List<Tl1Pm> tl1PmList = tl1PmRepository.findAll();
            List<Tl1PmPort> tl1PmPortList = tl1PmPortRepository.findAll();
            List<Tl1PmOpticTemperature> tl1PmOpticTemperatureList = tl1PmOpticTemperatureRepository.findAll();
            OtnManager manager = new OtnManager(
                    otnNodeRepository,
                    otnConnectorRepository,
                    otnLinkRepository,
                    otnServiceRepository,
                    otnTunnelRepository,
                    otnPathRepository,
                    otnConstraintRepository,
                    otnAccessIfRepository,

                    otnPmPwRepository,
                    otnPmTunnelRepository,
                    otnPmTemperatureRepository,
                    otnPmAcRepository,
                    otnPmOpticRepository,
                    otnPmRepository,
                    otnPmPortRepository,
                    otnPmOpticTemperatureRepository,
                    otnCmInventoryRepository,
                    otnCmLinkRepository,
                    otnCmSessionRepository,
                    otnCmQkdLinkRepository,
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
                    tl1QkdInfoList,
                    tl1PmPwList,
                    tl1PmTunnelList,
                    tl1PmTemperatureList,
                    tl1PmAcList,
                    tl1PmOpticList,
                    tl1PmList,
                    tl1PmPortList,
                    tl1PmOpticTemperatureList
            );
            // Sync 시작
            manager.OtnSyncStart();
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
