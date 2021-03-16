package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.Repository.QKD.QkdNodeRepository;
import com.woorinet.plugin.demo.Repository.QKD.QkdProviderNodeRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/qkd")
public class QkdController {
    @Autowired
    private QkdProviderNodeRepository qkdProviderNodeRepository;

    @Autowired
    private QkdNodeRepository qkdNodeRepository;

    @ApiOperation(value = "get kms node list", notes = "전체 KMS 노드 조회")
    @GetMapping(value = "/node/list")
    @ResponseBody
    public ResponseEntity selectNodeList() {
        if(qkdNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(qkdNodeRepository.findAll());
    }
    @ApiOperation(value = "get qkd node list", notes = "전체 qkd 노드 조회")
    @GetMapping(value = "/provider_node/list")
    @ResponseBody
    public ResponseEntity selectProviderNodeList() {
        if(qkdProviderNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(qkdProviderNodeRepository.findAll());
    }
}
