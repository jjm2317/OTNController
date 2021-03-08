package com.woorinet.plugin.demo.CONTROLLER.SDN;


import com.woorinet.plugin.demo.Repository.SDN.SdnNodeRepository;
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
public class SdnNodeController {

    @Autowired
    private SdnNodeRepository sdnNodeRepository;

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

}
