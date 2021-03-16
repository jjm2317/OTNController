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

                JSONObject EPStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getENDPOINT_CLIENT_START());
                JSONObject TCStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getTRANSMIT_CLIENT_START());
                JSONObject LStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getLINK_START());
                JSONObject RMStartJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getROADM_MUX_START());
                JSONObject RMEndJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getROADM_MUX_END());
                JSONObject LEndJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getLINK_END());
                JSONObject TCEndJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getTRANSMIT_CLIENT_END());
                JSONObject EPENDJsonObj = (JSONObject) parser.parse(portalLineNumSheet.getENDPOINT_CLIENT_END());


                jsonObject.put("line_num_sheet_id", portalLineNumSheet.getLINE_NUM_SHEET_ID());
                jsonObject.put("group", portalLineNumSheet.getGROUP());
                jsonObject.put("domain_type", portalLineNumSheet.getDOMAIN_TYPE());
                jsonObject.put("area_start", portalLineNumSheet.getAREA_START());
                jsonObject.put("area_end", portalLineNumSheet.getAREA_END());
                jsonObject.put("node_start", portalLineNumSheet.getNODE_START());
                jsonObject.put("node_end", portalLineNumSheet.getNODE_END());
                jsonObject.put("circuit_id", portalLineNumSheet.getCIRCUIT_ID());
                jsonObject.put("auto_service_name", portalLineNumSheet.getAUTO_SERVICE_NAME());
                jsonObject.put("input_service_name", portalLineNumSheet.getINPUT_SERVICE_NAME());
                jsonObject.put("service_type", portalLineNumSheet.getSERVICE_TYPE());
                jsonObject.put("vendor", portalLineNumSheet.getVENDOR());
                jsonObject.put("constraint_id", portalLineNumSheet.getCONSTRAINT_ID());
                jsonObject.put("protection_type", portalLineNumSheet.getPROTECTIOM_TYPE());
                jsonObject.put("service_rate", portalLineNumSheet.getSERVICE_RATE());
                jsonObject.put("service_status", portalLineNumSheet.getSERVICE_STATUS());
                jsonObject.put("active_path", portalLineNumSheet.getACTIVE_PATH());
                jsonObject.put("traffic_status", portalLineNumSheet.getTRAFFIC_STATUS());
                jsonObject.put("home_path", portalLineNumSheet.getHOME_PATH());
                jsonObject.put("latency", portalLineNumSheet.getLATENCY());
                jsonObject.put("cable_creation_date", portalLineNumSheet.getCABLE_CREATION_DATE());
                jsonObject.put("network_cable_number", portalLineNumSheet.getNETWORK_CABLE_NUMBER());
                jsonObject.put("writer", portalLineNumSheet.getWRITER());
                jsonObject.put("remarks", portalLineNumSheet.getREMARKS());
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

                JSONArray linkJsonArray = (JSONArray) parser.parse(portalLinkMng.getLINK());

                jsonObject.put("hola_link_mng_id", portalLinkMng.getHOLA_SDN_LINK_MNG_ID());
                jsonObject.put("vendor", portalLinkMng.getVENDOR());
                jsonObject.put("link", linkJsonArray);
                jsonObject.put("admin_weight", portalLinkMng.getADMIN_WEIGHT());
                jsonObject.put("maximum_usage_ratio", portalLinkMng.getMAXIMUM_USAGE_RATIO());
                jsonObject.put("memory", portalLinkMng.getMEMORY());
                jsonObject.put("usage_ratio", portalLinkMng.getUSAGE_RATIO());
                jsonObject.put("all_memory", portalLinkMng.getALL_MEMORY());
                jsonObject.put("all_usage_ratio", portalLinkMng.getALL_USAGE_RATIO());
                jsonObject.put("distance", portalLinkMng.getDISTANCE());
                jsonObject.put("srlg", portalLinkMng.getSRLG());
                jsonObject.put("roadm_path", portalLinkMng.getROADM_PATH());
                jsonObject.put("remarks", portalLinkMng.getREMARKS());

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
