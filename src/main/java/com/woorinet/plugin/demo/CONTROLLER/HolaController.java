package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.Manager.HOLAManager;
import com.woorinet.plugin.demo.Repository.HOLA.*;
import com.woorinet.plugin.demo.Repository.SDN.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hola")
public class HolaController {
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

    @Autowired
    private HolaSdnLineNumSheetRepository holaSdnLineNumSheetRepository;
    @Autowired
    private HolaSdnLinkMngRepository holaSdnLinkMngRepository;
    @Autowired
    private HolaSdnTrunkUsageRepository holaSdnTrunkUsageRepository;
    @Autowired
    private HolaSdnInventroyDetailRepository holaSdnInventroyDetailRepository;
    @Autowired
    private HolaSdnOtnNodeUsageRepository holaSdnOtnNodeUsageRepository;
    @Autowired
    private HolaSdnOtnMaterialRepository holaSdnOtnMaterialRepository;

    @GetMapping("/hola")
    String syncronizeHola() {
        try {
            //SdnNode 조회
            List<SdnNode> sdnNodeList = sdnNodeRepository.findAll();
            //SdnConnector 조회
            List<SdnConnector> sdnConnectorList = sdnConnectorRepository.findAll();
            //SdnLink 조회
            List<SdnLink> sdnLinkList = sdnLinkRepository.findAll();
            //SdnService 조회
            List<SdnService> sdnServiceList = sdnServiceRepository.findAll();
            //SdnPath 조회
            List<SdnPath> sdnPathList = sdnPathRepository.findAll();
            //SdnConstraint 조회
            List<SdnConstraint> sdnConstraintList = sdnConstraintRepository.findAll();
            //SdnAccessIf 조회
            List<SdnAccessIf> sdnAccessIfList = sdnAccessIfRepository.findAll();

            HOLAManager manager = new HOLAManager(holaSdnLineNumSheetRepository,
                    holaSdnLinkMngRepository,
                    holaSdnTrunkUsageRepository,
                    holaSdnInventroyDetailRepository,
                    holaSdnOtnNodeUsageRepository,
                    holaSdnOtnMaterialRepository,
                    sdnNodeList,
                    sdnConnectorList,
                    sdnLinkList,
                    sdnServiceList,
                    sdnPathList,
                    sdnConstraintList,
                    sdnAccessIfList

            );

            manager.HOLASyncStart();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sync hola";
    }
}
