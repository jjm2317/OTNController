package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.PORTAL.PortalLinkbook;
import com.woorinet.plugin.demo.DTO.PORTAL.PortalLinkmng;
import com.woorinet.plugin.demo.Repository.PORTAL.*;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/tn2")
public class Tn2Controller {
    @Autowired
    private PortalLinkbookRepository portalLinkBookRepository;
    @Autowired
    private PortalLinkmngRepository portalLinkMngRepository;
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
        if(portalLinkBookRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {

            for(PortalLinkbook portalLinkBook : portalLinkBookRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject EPStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getEndpointClientStart());
                JSONObject TCStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getTransmitClientStart());
                JSONObject LStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getLinkStart());
                JSONObject RMStartJsonObj = (JSONObject) parser.parse(portalLinkBook.getRoadmMuxStart());
                JSONObject RMEndJsonObj = (JSONObject) parser.parse(portalLinkBook.getRoadmMuxEnd());
                JSONObject LEndJsonObj = (JSONObject) parser.parse(portalLinkBook.getLinkEnd());
                JSONObject TCEndJsonObj = (JSONObject) parser.parse(portalLinkBook.getTransmitClientEnd());
                JSONObject EPENDJsonObj = (JSONObject) parser.parse(portalLinkBook.getEndpointClientEnd());


                jsonObject.put("linkbook_id", portalLinkBook.getPortalLinkBookId());
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

    @ApiOperation(value = "get linkmng", notes = "전체 링크관리 조회")
    @GetMapping(value = "/linkmng/list")
    @ResponseBody
    public ResponseEntity selectLinkmngList() {
        if(portalLinkMngRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for (PortalLinkmng portalLinkMng : portalLinkMngRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONArray linkJsonArray = (JSONArray) parser.parse(portalLinkMng.getLink());

                jsonObject.put("linkmng_id", portalLinkMng.getPortalLinkMngId());
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
        return ResponseEntity.ok(portalStatsInventoryRepository.findAll());
    }

    @ApiOperation(value = "get stats node", notes = "전체 otn node 사용현황 조회")
    @GetMapping(value = "/stats/node/list")
    @ResponseBody
    public ResponseEntity selectStatsNode() {
        if(portalStatsNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalStatsNodeRepository.findAll());
    }

    @ApiOperation(value = "get stats supplies", notes = "전체 otn 물자현황 조회")
    @GetMapping(value = "/stats/supplies/list")
    @ResponseBody
    public ResponseEntity selectStatsSupplies() {
        if(portalStatsSuppliesRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalStatsSuppliesRepository.findAll());
    }
}
