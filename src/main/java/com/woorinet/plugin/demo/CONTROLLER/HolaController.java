package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.Manager.HOLAManager;
import com.woorinet.plugin.demo.Repository.HOLA.*;
import com.woorinet.plugin.demo.Repository.SDN.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hola")
public class HolaController {
    @Autowired
    private HolaLineNumSheetRepository holaLineNumSheetRepository;
    @Autowired
    private HolaLinkMngRepository holaLinkMngRepository;
    @Autowired
    private HolaTrunkUsageRepository holaTrunkUsageRepository;
    @Autowired
    private HolaInventroyDetailRepository holaInventroyDetailRepository;
    @Autowired
    private HolaOtnNodeUsageRepository holaOtnNodeUsageRepository;
    @Autowired
    private HolaOtnMaterialRepository holaOtnMaterialRepository;

    @ApiOperation(value = "get Line Number Sheet", notes = "전체 선번장 조회")
    @GetMapping(value = "/lineNumSheet")
    @ResponseBody
    public ResponseEntity selectLineNumSheetList() {
        if(holaLineNumSheetRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaLineNumSheetRepository.findAll());
    }

    @ApiOperation(value = "get link mng", notes = "전체 링크관리 조회")
    @GetMapping(value = "/linkMng")
    @ResponseBody
    public ResponseEntity selectLinkMngList() {
        if(holaLinkMngRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaLinkMngRepository.findAll());
    }

    @ApiOperation(value = "get trunk usage", notes = "전체 trunk 사용률 조회")
    @GetMapping(value = "/trunkUsage")
    @ResponseBody
    public ResponseEntity selectTrunkUsageList() {
        if(holaTrunkUsageRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaTrunkUsageRepository.findAll());
    }

    @ApiOperation(value = "get inventory detail", notes = "전체 상새 inventory 현황 조회")
    @GetMapping(value = "/inventoryDetail")
    @ResponseBody
    public ResponseEntity selectInventoryDetail() {
        if(holaInventroyDetailRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaInventroyDetailRepository.findAll());
    }

    @ApiOperation(value = "get otn node usage", notes = "전체 otn node 사용현황 조회")
    @GetMapping(value = "/otnNodeUsage")
    @ResponseBody
    public ResponseEntity selectOtnNodeUsage() {
        if(holaOtnNodeUsageRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaOtnNodeUsageRepository.findAll());
    }

    @ApiOperation(value = "get otn material", notes = "전체 otn 물자현황 조회")
    @GetMapping(value = "/otnMaterial")
    @ResponseBody
    public ResponseEntity selectOtnMaterial() {
        if(holaOtnMaterialRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaOtnMaterialRepository.findAll());
    }
}
