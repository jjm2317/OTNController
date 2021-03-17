package com.woorinet.plugin.demo.CONTROLLER;


import com.woorinet.plugin.demo.Repository.OTN.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/tn")
public class OtnController {
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

    @ApiOperation(value = "get node list", notes = "전체 노드 조회")
    @GetMapping(value = "/node/list")
    @ResponseBody
    public ResponseEntity selectNodeList() {
        if(otnNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnNodeRepository.findAll());
    }

    @ApiOperation(value = "get node", notes = "노드 조회")
    @GetMapping(value = "/node")
    @ResponseBody
    public ResponseEntity selectNode(@RequestParam String ne_id) {
        if(otnNodeRepository.findSdnNodeByNeId(ne_id) == null)  return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnNodeRepository.findSdnNodeByNeId(ne_id));
    }

    @ApiOperation(value = "get connector list", notes = "전체 커넥터 조회")
    @GetMapping(value = "/connector/list")
    @ResponseBody
    public ResponseEntity selectConnectorList() {
        if(otnConnectorRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnConnectorRepository.findAll());
    }

    @ApiOperation(value = "get connector", notes = "커넥터 조회")
    @GetMapping(value = "/connector")
    @ResponseBody
    public ResponseEntity selectConnector(@RequestParam String connect_id) {
        if(otnConnectorRepository.findSdnConnectorByConnectId(connect_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnConnectorRepository.findSdnConnectorByConnectId(connect_id));
    }

    @ApiOperation(value = "get link list", notes = "전체 링크 조회")
    @GetMapping(value = "/link/list")
    @ResponseBody
    public ResponseEntity selectLinkList() {
        if(otnLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnLinkRepository.findAll());
    }

    @ApiOperation(value = "get link", notes = "링크 조회")
    @GetMapping(value = "/link")
    @ResponseBody
    public ResponseEntity selectLink(@RequestParam String link_id) {
        if(otnLinkRepository.findSdnLinkByLinkId(link_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnLinkRepository.findSdnLinkByLinkId(link_id));
    }

    @ApiOperation(value = "get tunnel list", notes = "전체 터널 조회")
    @GetMapping(value = "/tunnel/list")
    @ResponseBody
    public ResponseEntity selectTunnelList() {
        if(otnTunnelRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnTunnelRepository.findAll());
    }

    @ApiOperation(value = "get tunnel", notes = "터널 조회")
    @GetMapping(value = "/tunnel")
    @ResponseBody
    public ResponseEntity selectTunnel(@RequestParam String tunnelId) {
        if(otnTunnelRepository.findOtnTunnelByTunnelId(tunnelId) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnTunnelRepository.findOtnTunnelByTunnelId(tunnelId));
    }

    @ApiOperation(value = "get service list", notes = "전체 서비스 조회")
    @GetMapping(value = "/service/list")
    @ResponseBody
    public ResponseEntity selectServiceList() {
        if(otnServiceRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnServiceRepository.findAll());
    }

    @ApiOperation(value = "get service", notes = "서비스 조회")
    @GetMapping(value = "/service")
    @ResponseBody
    public ResponseEntity selectService(@RequestParam String service_id) {
        if(otnServiceRepository.findSdnServiceByServiceId(service_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnServiceRepository.findSdnServiceByServiceId(service_id));
    }

    @ApiOperation(value = "get path list", notes = "전체 경로 조회")
    @GetMapping(value = "/path/list")
    @ResponseBody
    public ResponseEntity selectPathList() {
        if(otnPathRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnPathRepository.findAll());
    }

    @ApiOperation(value = "get path", notes = "경로 조회")
    @GetMapping(value = "/path")
    @ResponseBody
    public ResponseEntity selectPath(@RequestParam(required = false, defaultValue = "0") int id , @RequestParam(required = false) String service_id) {
        if (id != 0) {
            if (otnPathRepository.findSdnPathById(id) == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(otnPathRepository.findSdnPathById(id));
        }
        if (otnPathRepository.findSdnPathByServiceId(service_id) == null)  return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnPathRepository.findSdnPathByServiceId(service_id));
    }

    @ApiOperation(value = "get constraint list", notes = "전체 속성 조회")
    @GetMapping(value = "/constraint/list")
    @ResponseBody
    public ResponseEntity selectConstraintList() {
        if(otnConstraintRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnConstraintRepository.findAll());
    }

    @ApiOperation(value = "get constraint", notes = "속성 조회")
    @GetMapping(value = "/constraint")
    @ResponseBody
    public ResponseEntity selectConstraint(@RequestParam(required = false, defaultValue = "0") int id, @RequestParam(required = false) String service_id) {
        if(id != 0) {
            if (otnConstraintRepository.findSdnConstraintById(id) == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(otnConstraintRepository.findSdnConstraintById(id));
        }
        if(otnConstraintRepository.findSdnConstraintByServiceId(service_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnConstraintRepository.findSdnConstraintByServiceId(service_id));
    }

    @ApiOperation(value = "get accessif list", notes = "전체 access interface 조회")
    @GetMapping(value = "/accessif/list")
    @ResponseBody
    public ResponseEntity selectAccessIfList() {
        if(otnAccessIfRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnAccessIfRepository.findAll());
    }

    @ApiOperation(value = "get accessif", notes = "access interface 조회")
    @GetMapping(value = "/accessif")
    @ResponseBody
    public ResponseEntity selectAccessIf(@RequestParam String accessif_id) {
        if(otnAccessIfRepository.findSdnAccessIfByAccessifId(accessif_id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(otnAccessIfRepository.findSdnAccessIfByAccessifId(accessif_id));
    }
}

