package com.woorinet.plugin.demo.CONTROLLER.SDN;


import com.woorinet.plugin.demo.Repository.SDN.SdnConnectorRepository;

import com.woorinet.plugin.demo.Repository.SDN.SdnLinkRepository;
import com.woorinet.plugin.demo.Repository.SDN.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sdn")
public class SdnController {

    @Autowired
    private SdnNodeRepository sdnNodeRepository;
    @Autowired
    private SdnConnectorRepository sdnConnectorRepository;
    @Autowired
    private SdnLinkRepository sdnLinkRepository;
    @Autowired
    private SdnTunnelRepository sdnTunnelRepository;
    @Autowired
    private SdnServiceRepository sdnServiceRepository;

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

}

