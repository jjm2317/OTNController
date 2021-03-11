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

    @ApiOperation(value = "get node list", notes = "전체 노드 조회")
    @GetMapping(value = "/node/list")
    @ResponseBody
    public ResponseEntity selectNodeList() {
        if(sdnNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnNodeRepository.findAll());
    }

    @ApiOperation(value = "get node", notes = "노드 조회")
    @GetMapping(value = "/node")
    @ResponseBody
    public ResponseEntity selectNode(@RequestParam String ne_id) {
        if(sdnNodeRepository.findSdnNodeByNeId(ne_id) == null)  return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnNodeRepository.findSdnNodeByNeId(ne_id));
    }

    @ApiOperation(value = "get connector list", notes = "전체 커넥터 조회")
    @GetMapping(value = "/connector/list")
    @ResponseBody
    public ResponseEntity selectConnectorList() {
        if(sdnConnectorRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnConnectorRepository.findAll());
    }

    @ApiOperation(value = "get connector", notes = "커넥터 조회")
    @GetMapping(value = "/connector")
    @ResponseBody
    public ResponseEntity selectConnector(@RequestParam String connect_id) {
        if(sdnConnectorRepository.findSdnConnectorByConnectId(connect_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnConnectorRepository.findSdnConnectorByConnectId(connect_id));
    }

    @ApiOperation(value = "get link list", notes = "전체 링크 조회")
    @GetMapping(value = "/link/list")
    @ResponseBody
    public ResponseEntity selectLinkList() {
        if(sdnLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnLinkRepository.findAll());
    }

    @ApiOperation(value = "get link", notes = "링크 조회")
    @GetMapping(value = "/link")
    @ResponseBody
    public ResponseEntity selectLink(@RequestParam String link_id) {
        if(sdnLinkRepository.findSdnLinkByLinkId(link_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnLinkRepository.findSdnLinkByLinkId(link_id));
    }

    @ApiOperation(value = "get tunnel list", notes = "전체 터널 조회")
    @GetMapping(value = "/tunnel/list")
    @ResponseBody
    public ResponseEntity selectTunnelList() {
        if(sdnTunnelRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnTunnelRepository.findAll());
    }

    @ApiOperation(value = "get tunnel", notes = "터널 조회")
    @GetMapping(value = "/tunnel")
    @ResponseBody
    public ResponseEntity selectTunnel(@RequestParam String tunnel_id) {
        if(sdnTunnelRepository.findSdnTunnelByTunnelId(tunnel_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnTunnelRepository.findSdnTunnelByTunnelId(tunnel_id));
    }

    @ApiOperation(value = "get service list", notes = "전체 서비스 조회")
    @GetMapping(value = "/service/list")
    @ResponseBody
    public ResponseEntity selectServiceList() {
        if(sdnServiceRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnServiceRepository.findAll());
    }

    @ApiOperation(value = "get service", notes = "서비스 조회")
    @GetMapping(value = "/service")
    @ResponseBody
    public ResponseEntity selectService(@RequestParam String service_id) {
        if(sdnServiceRepository.findSdnServiceByServiceId(service_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnServiceRepository.findSdnServiceByServiceId(service_id));
    }

    @ApiOperation(value = "get path list", notes = "전체 경로 조회")
    @GetMapping(value = "/path/list")
    @ResponseBody
    public ResponseEntity selectPathList() {
        if(sdnPathRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnPathRepository.findAll());
    }

    @ApiOperation(value = "get path", notes = "경로 조회")
    @GetMapping(value = "/path")
    @ResponseBody
    public ResponseEntity selectPath(@RequestParam(required = false, defaultValue = "0") int id , @RequestParam(required = false) String service_id) {
        if (id != 0) {
            if (sdnPathRepository.findSdnPathById(id) == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(sdnPathRepository.findSdnPathById(id));
        }
        if (sdnPathRepository.findSdnPathByServiceId(service_id) == null)  return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnPathRepository.findSdnPathByServiceId(service_id));
    }

    @ApiOperation(value = "get constraint list", notes = "전체 속성 조회")
    @GetMapping(value = "/constraint/list")
    @ResponseBody
    public ResponseEntity selectConstraintList() {
        if(sdnConstraintRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnConstraintRepository.findAll());
    }

    @ApiOperation(value = "get constraint", notes = "속성 조회")
    @GetMapping(value = "/constraint")
    @ResponseBody
    public ResponseEntity selectConstraint(@RequestParam(required = false, defaultValue = "0") int id, @RequestParam(required = false) String service_id) {
        if(id != 0) {
            if (sdnConstraintRepository.findSdnConstraintById(id) == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(sdnConstraintRepository.findSdnConstraintById(id));
        }
        if(sdnConstraintRepository.findSdnConstraintByServiceId(service_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnConstraintRepository.findSdnConstraintByServiceId(service_id));
    }

    @ApiOperation(value = "get accessif list", notes = "전체 access interface 조회")
    @GetMapping(value = "/accessif/list")
    @ResponseBody
    public ResponseEntity selectAccessIfList() {
        if(sdnAccessIfRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnAccessIfRepository.findAll());
    }

    @ApiOperation(value = "get accessif", notes = "access interface 조회")
    @GetMapping(value = "/accessif")
    @ResponseBody
    public ResponseEntity selectAccessIf(@RequestParam String accessif_id) {
        if(sdnAccessIfRepository.findSdnAccessIfByAccessifId(accessif_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sdnAccessIfRepository.findSdnAccessIfByAccessifId(accessif_id));
    }
}

