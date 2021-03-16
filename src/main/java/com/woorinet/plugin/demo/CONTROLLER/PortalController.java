package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.HOLA.HolaLineNumSheet;
import com.woorinet.plugin.demo.DTO.HOLA.HolaLinkMng;
import com.woorinet.plugin.demo.Repository.HOLA.*;
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
    @GetMapping(value = "/lineNumSheet/list")
    @ResponseBody
    public ResponseEntity selectLineNumSheetList() {
        if(holaLineNumSheetRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {

            for(HolaLineNumSheet holaLineNumSheet : holaLineNumSheetRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject EPStartJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getENDPOINT_CLIENT_START());
                JSONObject TCStartJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getTRANSMIT_CLIENT_START());
                JSONObject LStartJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getLINK_START());
                JSONObject RMStartJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getROADM_MUX_START());
                JSONObject RMEndJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getROADM_MUX_END());
                JSONObject LEndJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getLINK_END());
                JSONObject TCEndJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getTRANSMIT_CLIENT_END());
                JSONObject EPENDJsonObj = (JSONObject) parser.parse(holaLineNumSheet.getENDPOINT_CLIENT_END());


                jsonObject.put("line_num_sheet_id", holaLineNumSheet.getLINE_NUM_SHEET_ID());
                jsonObject.put("group", holaLineNumSheet.getGROUP());
                jsonObject.put("domain_type", holaLineNumSheet.getDOMAIN_TYPE());
                jsonObject.put("area_start", holaLineNumSheet.getAREA_START());
                jsonObject.put("area_end", holaLineNumSheet.getAREA_END());
                jsonObject.put("node_start", holaLineNumSheet.getNODE_START());
                jsonObject.put("node_end",holaLineNumSheet.getNODE_END());
                jsonObject.put("circuit_id",holaLineNumSheet.getCIRCUIT_ID());
                jsonObject.put("auto_service_name",holaLineNumSheet.getAUTO_SERVICE_NAME());
                jsonObject.put("input_service_name",holaLineNumSheet.getINPUT_SERVICE_NAME());
                jsonObject.put("service_type",holaLineNumSheet.getSERVICE_TYPE());
                jsonObject.put("vendor",holaLineNumSheet.getVENDOR());
                jsonObject.put("constraint_id",holaLineNumSheet.getCONSTRAINT_ID());
                jsonObject.put("protection_type",holaLineNumSheet.getPROTECTIOM_TYPE());
                jsonObject.put("service_rate",holaLineNumSheet.getSERVICE_RATE());
                jsonObject.put("service_status",holaLineNumSheet.getSERVICE_STATUS());
                jsonObject.put("active_path",holaLineNumSheet.getACTIVE_PATH());
                jsonObject.put("traffic_status",holaLineNumSheet.getTRAFFIC_STATUS());
                jsonObject.put("home_path",holaLineNumSheet.getHOME_PATH());
                jsonObject.put("latency",holaLineNumSheet.getLATENCY());
                jsonObject.put("cable_creation_date",holaLineNumSheet.getCABLE_CREATION_DATE());
                jsonObject.put("network_cable_number",holaLineNumSheet.getNETWORK_CABLE_NUMBER());
                jsonObject.put("writer",holaLineNumSheet.getWRITER());
                jsonObject.put("remarks",holaLineNumSheet.getREMARKS());
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
        if(holaLinkMngRepository.findAll() == null) return ResponseEntity.notFound().build();

        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for (HolaLinkMng holaLinkMng : holaLinkMngRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONArray linkJsonArray = (JSONArray) parser.parse(holaLinkMng.getLINK());

                jsonObject.put("hola_link_mng_id", holaLinkMng.getHOLA_SDN_LINK_MNG_ID());
                jsonObject.put("vendor", holaLinkMng.getVENDOR());
                jsonObject.put("link", linkJsonArray);
                jsonObject.put("admin_weight", holaLinkMng.getADMIN_WEIGHT());
                jsonObject.put("maximum_usage_ratio",holaLinkMng.getMAXIMUM_USAGE_RATIO());
                jsonObject.put("memory",holaLinkMng.getMEMORY());
                jsonObject.put("usage_ratio",holaLinkMng.getUSAGE_RATIO());
                jsonObject.put("all_memory",holaLinkMng.getALL_MEMORY());
                jsonObject.put("all_usage_ratio",holaLinkMng.getALL_USAGE_RATIO());
                jsonObject.put("distance",holaLinkMng.getDISTANCE());
                jsonObject.put("srlg",holaLinkMng.getSRLG());
                jsonObject.put("roadm_path",holaLinkMng.getROADM_PATH());
                jsonObject.put("remarks",holaLinkMng.getREMARKS());

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
        if(holaTrunkUsageRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaTrunkUsageRepository.findAll());
    }

    @ApiOperation(value = "get inventory detail", notes = "전체 상새 inventory 현황 조회")
    @GetMapping(value = "/inventoryDetail/list")
    @ResponseBody
    public ResponseEntity selectInventoryDetail() {
        if(holaInventroyDetailRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaInventroyDetailRepository.findAll());
    }

    @ApiOperation(value = "get otn node usage", notes = "전체 otn node 사용현황 조회")
    @GetMapping(value = "/otnNodeUsage/list")
    @ResponseBody
    public ResponseEntity selectOtnNodeUsage() {
        if(holaOtnNodeUsageRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaOtnNodeUsageRepository.findAll());
    }

    @ApiOperation(value = "get otn material", notes = "전체 otn 물자현황 조회")
    @GetMapping(value = "/otnMaterial/list")
    @ResponseBody
    public ResponseEntity selectOtnMaterial() {
        if(holaOtnMaterialRepository.findAll() == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(holaOtnMaterialRepository.findAll());
    }
}
