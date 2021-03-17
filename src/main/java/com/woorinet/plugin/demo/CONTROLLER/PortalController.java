package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.PORTAL.PortalLineNumSheet;
import com.woorinet.plugin.demo.DTO.PORTAL.PortalLinkMng;
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
@RequestMapping(value = "/v1/portal")
public class PortalController {
    @Autowired
    private PortalLineNumSheetRepository portalLineNumSheetRepository;
    @Autowired
    private PortalLinkMngRepository portalLinkMngRepository;
    @Autowired
    private PortalTrunkUsageRepository portalTrunkUsageRepository;
    @Autowired
    private PortalInventroyDetailRepository portalInventroyDetailRepository;
    @Autowired
    private PortalOtnNodeUsageRepository portalOtnNodeUsageRepository;
    @Autowired
    private PortalOtnMaterialRepository portalOtnMaterialRepository;

    @ApiOperation(value = "get Line Number Sheet", notes = "전체 선번장 조회")
    @GetMapping(value = "/lineNumSheet/list")
    @ResponseBody
    public ResponseEntity selectLineNumSheetList() {
        if(portalLineNumSheetRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {

            for(PortalLineNumSheet portalLineNumSheet : portalLineNumSheetRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject EPStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getEndpointClientStart());
                JSONObject TCStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getTransmitClientStart());
                JSONObject LStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getLinkStart());
                JSONObject RMStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getRoadmMuxStart());
                JSONObject RMEndJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getRoadmMuxEnd());
                JSONObject LEndJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getLinkEnd());
                JSONObject TCEndJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getTransmitClientEnd());
                JSONObject EPENDJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getEndpointClientEnd());


                jsonObject.put("line_num_sheet_id", portalLineNumSheet.getLineNumSheetId());
                jsonObject.put("group", portalLineNumSheet.getGroup());
                jsonObject.put("domain_type", portalLineNumSheet.getDomainType());
                jsonObject.put("area_start", portalLineNumSheet.getAreaStart());
                jsonObject.put("area_end", portalLineNumSheet.getAreaEnd());
                jsonObject.put("node_start", portalLineNumSheet.getNodeStart());
                jsonObject.put("node_end", portalLineNumSheet.getNodeEnd());
                jsonObject.put("circuit_id", portalLineNumSheet.getCircuitId());
                jsonObject.put("auto_service_name", portalLineNumSheet.getAutoServiceName());
                jsonObject.put("input_service_name", portalLineNumSheet.getInputServiceName());
                jsonObject.put("service_type", portalLineNumSheet.getServiceType());
                jsonObject.put("vendor", portalLineNumSheet.getVendor());
                jsonObject.put("constraint_id", portalLineNumSheet.getConstraintId());
                jsonObject.put("protection_type", portalLineNumSheet.getProtectionType());
                jsonObject.put("service_rate", portalLineNumSheet.getServiceRate());
                jsonObject.put("service_status", portalLineNumSheet.getServiceStatus());
                jsonObject.put("active_path", portalLineNumSheet.getActivePath());
                jsonObject.put("traffic_status", portalLineNumSheet.getTrafficStatus());
                jsonObject.put("home_path", portalLineNumSheet.getHomePath());
                jsonObject.put("latency", portalLineNumSheet.getLatency());
                jsonObject.put("cable_creation_date", portalLineNumSheet.getCableCreationDate());
                jsonObject.put("network_cable_number", portalLineNumSheet.getNetworkCableNumber());
                jsonObject.put("writer", portalLineNumSheet.getWriter());
                jsonObject.put("remarks", portalLineNumSheet.getRemarks());
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

    @ApiOperation(value = "get link mng", notes = "전체 링크관리 조회")
    @GetMapping(value = "/linkMng/list")
    @ResponseBody
    public ResponseEntity selectLinkMngList() {
        if(portalLinkMngRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for (PortalLinkMng portalLinkMng : portalLinkMngRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONArray linkJsonArray = (JSONArray) parser.parse(portalLinkMng.getLink());

                jsonObject.put("hola_link_mng_id", portalLinkMng.getHolaSdnLinkMngId());
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
    @GetMapping(value = "/trunkUsage/list")
    @ResponseBody
    public ResponseEntity selectTrunkUsageList() {
        if(portalTrunkUsageRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalTrunkUsageRepository.findAll());
    }

    @ApiOperation(value = "get inventory detail", notes = "전체 상새 inventory 현황 조회")
    @GetMapping(value = "/inventoryDetail/list")
    @ResponseBody
    public ResponseEntity selectInventoryDetail() {
        if(portalInventroyDetailRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalInventroyDetailRepository.findAll());
    }

    @ApiOperation(value = "get otn node usage", notes = "전체 otn node 사용현황 조회")
    @GetMapping(value = "/otnNodeUsage/list")
    @ResponseBody
    public ResponseEntity selectOtnNodeUsage() {
        if(portalOtnNodeUsageRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalOtnNodeUsageRepository.findAll());
    }

    @ApiOperation(value = "get otn material", notes = "전체 otn 물자현황 조회")
    @GetMapping(value = "/otnMaterial/list")
    @ResponseBody
    public ResponseEntity selectOtnMaterial() {
        if(portalOtnMaterialRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(portalOtnMaterialRepository.findAll());
    }
}
