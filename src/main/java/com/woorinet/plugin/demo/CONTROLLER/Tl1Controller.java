package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.Manager.TL1Manager;
import com.woorinet.plugin.demo.Repository.TL1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tl1")
public class Tl1Controller {
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

    @RequestMapping("/")
    String synchronization() {
        int CTAG = 100;
        try {
            TL1Manager manager = new TL1Manager(
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
}
