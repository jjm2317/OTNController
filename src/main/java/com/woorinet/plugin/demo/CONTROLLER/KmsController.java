package com.woorinet.plugin.demo.CONTROLLER;


import com.woorinet.plugin.demo.Repository.KMS.KmsNodeRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kms")
public class KmsController {
    @Autowired
    private KmsNodeRepository kmsNodeRepository;

    @ApiOperation(value = "get kms node list", notes = "전체 KMS 노드 조회")
    @GetMapping(value = "/node/list")
    @ResponseBody
    public ResponseEntity selectNodeList() {
        if(kmsNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(kmsNodeRepository.findAll());
    }

}
