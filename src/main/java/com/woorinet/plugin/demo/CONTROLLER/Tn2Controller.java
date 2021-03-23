package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.TN2.PortalLinkbook;
import com.woorinet.plugin.demo.DTO.TN2.PortalLinkmng;
import com.woorinet.plugin.demo.DTO.TN2.PortalStatsInventory;
import com.woorinet.plugin.demo.DTO.TN2.PortalStatsNode;
import com.woorinet.plugin.demo.Repository.TN2.*;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/tn2")
public class Tn2Controller {
    @Autowired
    private PortalLinkbookRepository portalLinkbookRepository;
    @Autowired
    private PortalLinkmngRepository portalLinkmngRepository;
    @Autowired
    private PortalTrunkUsageRepository portalTrunkUsageRepository;
    @Autowired
    private PortalStatsInventoryRepository portalStatsInventoryRepository;
    @Autowired
    private PortalStatsNodeRepository portalStatsNodeRepository;
    @Autowired
    private PortalStatsSuppliesRepository portalStatsSuppliesRepository;

    @ApiOperation(value = "get linkbook", notes = "전체 선번장 조회")
    @GetMapping(value = "/linkbook/list")
    @ResponseBody
    public ResponseEntity selectLinkbookList() {
        if(portalLinkbookRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {

            for(PortalLinkbook portalLinkBook : portalLinkbookRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject EPStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getEndpointClientStart());
                JSONObject TCStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getTransmitClientStart());
                JSONObject LStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getLinkStart());
                JSONObject RMStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getRoadmMuxStart());
                JSONObject RMEndJsonObj = (JSONObject) parser.parse(portalLinkBook.getRoadmMuxEnd());
                JSONObject LEndJsonObj = (JSONObject) parser.parse(portalLinkBook.getLinkEnd());
                JSONObject TCEndJsonObj = (JSONObject) parser.parse(portalLinkBook.getTransmitClientEnd());
                JSONObject EPENDJsonObj = (JSONObject) parser.parse(portalLinkBook.getEndpointClientEnd());


                jsonObject.put("tn2_linkbook_id", portalLinkBook.getPortalLinkbookId());
                jsonObject.put("group", portalLinkBook.getGroup());
                jsonObject.put("domain_type", portalLinkBook.getDomainType());
                jsonObject.put("area_start", portalLinkBook.getAreaStart());
                jsonObject.put("area_end", portalLinkBook.getAreaEnd());
                jsonObject.put("node_start", portalLinkBook.getNodeStart());
                jsonObject.put("node_end", portalLinkBook.getNodeEnd());
                jsonObject.put("circuit_id", portalLinkBook.getCircuitId());
                jsonObject.put("auto_service_name", portalLinkBook.getAutoServiceName());
                jsonObject.put("input_service_name", portalLinkBook.getInputServiceName());
                jsonObject.put("service_type", portalLinkBook.getServiceType());
                jsonObject.put("vendor", portalLinkBook.getVendor());
                jsonObject.put("constraint_id", portalLinkBook.getConstraintId());
                jsonObject.put("protection_type", portalLinkBook.getProtectionType());
                jsonObject.put("service_rate", portalLinkBook.getServiceRate());
                jsonObject.put("service_status", portalLinkBook.getServiceStatus());
                jsonObject.put("active_path", portalLinkBook.getActivePath());
                jsonObject.put("traffic_status", portalLinkBook.getTrafficStatus());
                jsonObject.put("home_path", portalLinkBook.getHomePath());
                jsonObject.put("latency", portalLinkBook.getLatency());
                jsonObject.put("cable_creation_date", portalLinkBook.getCableCreationDate());
                jsonObject.put("network_cable_number", portalLinkBook.getNetworkCableNumber());
                jsonObject.put("writer", portalLinkBook.getWriter());
                jsonObject.put("remarks", portalLinkBook.getRemarks());
                jsonObject.put("endpoint_client_start",EPStartJsonObj);
                jsonObject.put("transmit_client_start",TCStartJsonObj);
                jsonObject.put("link_start", LStartJsonObj);
                jsonObject.put("roadm_mux_start", RMStartJsonObj);
                jsonObject.put("roadm_mux_end", RMEndJsonObj);
                jsonObject.put("link_end", LEndJsonObj);
                jsonObject.put("transmit_client_end",TCEndJsonObj);
                jsonObject.put("endpoint_client_end",EPENDJsonObj);

                jsonArray.add(jsonObject);
            }

        } catch (Exception exception){
            exception.printStackTrace();
        }


        return ResponseEntity.ok(jsonArray.toString());
    }

//    @ApiOperation(value = "create linkbook", notes = "선번장 생성")
//    @PostMapping(value = "/linkbook")
//    @ResponseBody
//    public ResponseEntity createLinkbook(@RequestBody PortalLinkbook linkbook) {
//        portalLinkbookRepository.save(linkbook);
//        return ResponseEntity.ok("create");
//    }
//
//    @ApiOperation(value = "update linkbook", notes = "선번장 수정")
//    @PatchMapping(value = "/linkbook")
//    @ResponseBody
//    public ResponseEntity updateLinkbook(@RequestBody PortalLinkbook newLinkbook) {
//        System.out.println(newLinkbook+",...test");
//        Optional<PortalLinkbook> linkbookOptional = portalLinkbookRepository.findById(newLinkbook.getPortalLinkbookId());
//        linkbookOptional.ifPresent(selectedLinkbook -> {
//            portalLinkbookRepository.delete(selectedLinkbook);
//            portalLinkbookRepository.save(newLinkbook);
//        });
//        return ResponseEntity.ok("update");
//    }

    @ApiOperation(value = "delete linkbook", notes = "선번장 삭제")
    @DeleteMapping(value = "/linkbook")
    @ResponseBody
    public ResponseEntity deleteLinkbook(@RequestParam int id) {
        Optional<PortalLinkbook> linkbookOptional = portalLinkbookRepository.findById(id);
        linkbookOptional.ifPresent(linkbook -> {
            portalLinkbookRepository.delete(linkbook);
        });
        return ResponseEntity.ok("delete");
    }

    @ApiOperation(value = "get linkmng", notes = "전체 링크관리 조회")
    @GetMapping(value = "/linkmng/list")
    @ResponseBody
    public ResponseEntity selectLinkmngList() {
        if(portalLinkmngRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for (PortalLinkmng portalLinkMng : portalLinkmngRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONArray linkJsonArray = (JSONArray) parser.parse(portalLinkMng.getLink());

                jsonObject.put("tn2_linkmng_id", portalLinkMng.getPortalLinkmngId());
                jsonObject.put("vendor", portalLinkMng.getVendor());
                jsonObject.put("link", linkJsonArray);
                jsonObject.put("admin_weight", portalLinkMng.getAdminWeight());
                jsonObject.put("maximum_usage_ratio", portalLinkMng.getMaximumUsageRatio());
                jsonObject.put("memory", portalLinkMng.getMemory());
                jsonObject.put("usage_ratio", portalLinkMng.getUsageRatio());
                jsonObject.put("all_memory", portalLinkMng.getAllMemory());
                jsonObject.put("all_usage_ratio", portalLinkMng.getAllUsageRatio());
                jsonObject.put("distance", portalLinkMng.getDistance());
                jsonObject.put("srlg", portalLinkMng.getSrlg());
                jsonObject.put("roadm_path", portalLinkMng.getRoadmPath());
                jsonObject.put("remarks", portalLinkMng.getRemarks());

                jsonArray.add(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(jsonArray.toString());
    }

//    @ApiOperation(value = "create linkmng", notes = "링크관리 생성")
//    @PostMapping(value = "/linkmng")
//    @ResponseBody
//    public void createLinkmng() {
//
//    }
//
//    @ApiOperation(value = "update linkmng", notes = "링크관리 수정")
//    @PatchMapping(value = "/linkmng")
//    @ResponseBody
//    public void updateLinkmng() {
//
//    }
//
//    @ApiOperation(value = "delete linkmng", notes = "링크관리 삭제")
//    @DeleteMapping(value = "/linkmng")
//    @ResponseBody
//    public void deleteLinkmng() {
//
//    }

    @ApiOperation(value = "get trunk usage", notes = "전체 trunk 사용률 조회")
    @GetMapping(value = "/trunkusage/list")
    @ResponseBody
    public ResponseEntity selectTrunkUsageList() {
        if(portalTrunkUsageRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalTrunkUsageRepository.findAll());
    }

    @ApiOperation(value = "get stats inventory", notes = "전체 상세 inventory 현황 조회")
    @GetMapping(value = "/inventory/list")
    @ResponseBody
    public ResponseEntity selectStatsInventory() {
        if(portalStatsInventoryRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for (PortalStatsInventory portalStatsInventory : portalStatsInventoryRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONArray remarksListArray = (JSONArray) parser.parse(portalStatsInventory.getRemarksList());

                jsonObject.put("tn2_stats_inventory_id", portalStatsInventory.getPortalStatsInventoryId());
                jsonObject.put("vendor", portalStatsInventory.getVendor());
                jsonObject.put("cell", portalStatsInventory.getCell());
                jsonObject.put("tid", portalStatsInventory.getTid());
                jsonObject.put("shelf_id", portalStatsInventory.getShelfId());
                jsonObject.put("ip", portalStatsInventory.getIp());
                jsonObject.put("ne_type", portalStatsInventory.getNeType());
                jsonObject.put("unit_type", portalStatsInventory.getUnitType());
                jsonObject.put("unit_pec", portalStatsInventory.getUnitPec());
                jsonObject.put("serial_number", portalStatsInventory.getSerialNumber());
                jsonObject.put("slot_id", portalStatsInventory.getSlotId());
                jsonObject.put("port_id", portalStatsInventory.getPortId());
                jsonObject.put("connect_status", portalStatsInventory.getConnectStatus());
                jsonObject.put("llcf", portalStatsInventory.getLlcf());
                jsonObject.put("module_name", portalStatsInventory.getModuleName());
                jsonObject.put("module_pec", portalStatsInventory.getModulePec());
                jsonObject.put("distance", portalStatsInventory.getDistance());
                jsonObject.put("module_description", portalStatsInventory.getModuleDescription());
                jsonObject.put("cable_name", portalStatsInventory.getCableName());
                jsonObject.put("remarks_list", remarksListArray);

                jsonArray.add(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(jsonArray.toString());
    }

//    @ApiOperation(value = "create stats inventory", notes = "Inventory 정보 생성")
//    @PostMapping(value = "/stats/inventory")
//    @ResponseBody
//    public void createStatsInventory() {
//
//    }
//
//    @ApiOperation(value = "update stats inventory", notes = "Inventory 정보 수정")
//    @PatchMapping(value = "/stats/inventory")
//    @ResponseBody
//    public void updateStatsInventory() {
//
//    }
//
//    @ApiOperation(value = "delete stats inventory", notes = "Inventory 정보 삭제")
//    @DeleteMapping(value = "/stats/inventory")
//    @ResponseBody
//    public void deleteStatsInventory() {
//
//    }



    @ApiOperation(value = "get stats node", notes = "전체 otn node 사용현황 조회")
    @GetMapping(value = "/stats/node/list")
    @ResponseBody
    public ResponseEntity selectStatsNode() {
        if(portalStatsNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        PortalStatsNode portalStatsNode = portalStatsNodeRepository.findAll().get(0);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            JSONObject mountingStatusJson = (JSONObject) parser.parse(portalStatsNode.getMountingStatus());

            jsonObject.put("tn2_stats_node_id", portalStatsNode.getPortalStatsNodeId());
            jsonObject.put("area", portalStatsNode.getArea());
            jsonObject.put("city", portalStatsNode.getCity());
            jsonObject.put("mounting_status", mountingStatusJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(jsonObject.toString());
    }

    @ApiOperation(value = "get stats supplies", notes = "전체 otn 물자현황 조회")
    @GetMapping(value = "/stats/supplies/list")
    @ResponseBody
    public ResponseEntity selectStatsSupplies() {
        if(portalStatsSuppliesRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalStatsSuppliesRepository.findAll());
    }
}
