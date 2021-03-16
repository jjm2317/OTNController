package com.woorinet.plugin.demo.CONTROLLER;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.woorinet.plugin.demo.DTO.QKD.QkdLink;
import com.woorinet.plugin.demo.DTO.QKD.QkdNode;
import com.woorinet.plugin.demo.DTO.QKD.QkdPath;
import com.woorinet.plugin.demo.DTO.QKD.QkdService;
import com.woorinet.plugin.demo.Repository.QKD.*;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
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
    private QkdNodeRepository qkdNodeRepository;
    @Autowired
    private QkdServiceRepository qkdServiceRepository;
    @Autowired
    private QkdLinkRepository qkdLinkRepository;
    @Autowired
    private QkdPathRepository qkdPathRepository;
    @Autowired
    private QkdProviderNodeRepository qkdProviderNodeRepository;
    @Autowired
    private QkdProviderLinkRepository qkdProviderLinkRepository;
    @Autowired
    private QkdAppNodeRepository qkdAppNodeRepository;
    @Autowired
    private QkdAppLinkRepositroy qkdAppLinkRepositroy;


    @ApiOperation(value = "get kms node list", notes = "전체 KMS 노드 조회")
    @GetMapping(value = "/node/list")
    @ResponseBody
    public ResponseEntity selectNodeList() {
        if(qkdNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for (QkdNode qkdNode : qkdNodeRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject networkJsonObject = (JSONObject) parser.parse(qkdNode.getNETWORK());
                JSONArray consumersJsonArray = (JSONArray) parser.parse(qkdNode.getCONSUMERS());
                JSONArray providersJsonArray = (JSONArray) parser.parse(qkdNode.getPROVIDERS());


                jsonObject.put("qkd_node_id", qkdNode.getQKD_NODE_ID());
                jsonObject.put("id", qkdNode.getID());
                jsonObject.put("uid", qkdNode.getUID());
                jsonObject.put("name", qkdNode.getNAME());
                jsonObject.put("enabled", qkdNode.getENABLED());
                jsonObject.put("description", qkdNode.getDESCRIPTION());
                jsonObject.put("group_id", qkdNode.getGROUP_ID());
                jsonObject.put("group", qkdNode.getGROUP());
                jsonObject.put("unique_id", qkdNode.getUNIQUE_ID());
                jsonObject.put("qnc_web_api_url", qkdNode.getQNC_WEB_API_URL());
                jsonObject.put("qnc_web_api_auth", qkdNode.getQNC_WEB_API_AUTH());
                jsonObject.put("cert", qkdNode.getCERT());
                jsonObject.put("network", networkJsonObject);
                jsonObject.put("kems_cert", qkdNode.getKEMS_CERT());
                jsonObject.put("consumers", consumersJsonArray);
                jsonObject.put("providers", providersJsonArray);
                jsonObject.put("loc_x", qkdNode.getLOC_X());
                jsonObject.put("loc_y", qkdNode.getLOC_Y());

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd service list", notes = "전체 kms service 조회")
    @GetMapping(value = "/service/list")
    @ResponseBody
    public ResponseEntity selectServiceList() {
        if(qkdServiceRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for(QkdService qkdService : qkdServiceRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdService.getOPER_MODE());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdService.getSOURCE());
                JSONObject destJsonObject = (JSONObject) parser.parse(qkdService.getDEST());
                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdService.getQKEY_STORE());

                jsonObject.put("qkd_service_id", qkdService.getQKD_SERVICE_ID());
                jsonObject.put("id", qkdService.getID());
                jsonObject.put("uid", qkdService.getUID());
                jsonObject.put("name", qkdService.getNAME());
                jsonObject.put("oper_mode", operModeJsonObject);
                jsonObject.put("source", sourceJsonObject);
                jsonObject.put("dest", destJsonObject);
                jsonObject.put("preshared_key", qkdService.getPRESHARED_KEY());
                jsonObject.put("q_key_store", qKeyStoreJsonObject);

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd link list", notes = "전체 QKD Link 조회")
    @GetMapping(value = "/link/list")
    @ResponseBody
    public ResponseEntity selectQkdLinkList() {
        if(qkdLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdLink qkdLink : qkdLinkRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject typeJsonObject = (JSONObject) parser.parse(qkdLink.getTYPE());
                JSONObject algorithmJsonObject = (JSONObject) parser.parse(qkdLink.getALGORITHM());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdLink.getSOURCE());
                JSONObject destJsonObject = (JSONObject) parser.parse(qkdLink.getDEST());

                jsonObject.put("qkd_link_id", qkdLink.getQKD_LINK_ID());
                jsonObject.put("id", qkdLink.getID());
                jsonObject.put("name", qkdLink.getNAME());
                jsonObject.put("uid", qkdLink.getUID());
                jsonObject.put("type", typeJsonObject);
                jsonObject.put("algorithm", algorithmJsonObject);
                jsonObject.put("weight", qkdLink.getWEIGHT());
                jsonObject.put("psk", qkdLink.getPSK());
                jsonObject.put("source", sourceJsonObject);
                jsonObject.put("dest", destJsonObject);

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd path list", notes = "전체 QKD Path 조회")
    @GetMapping(value = "/path/list")
    @ResponseBody
    public ResponseEntity selectQkdPathList() {
        if(qkdPathRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdPath qkdPath : qkdPathRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject consumerLinkJsonObject = (JSONObject) parser.parse(qkdPath.getCONSUMER_LINK());
                JSONArray primaryJsonArray = (JSONArray) parser.parse(qkdPath.getPRIMARY());
                JSONArray secondaryJsonArray = (JSONArray) parser.parse(qkdPath.getSECONDARY());

                jsonObject.put("qkd_path_id", qkdPath.getQKD_PATH_ID());
                jsonObject.put("id", qkdPath.getID());
                jsonObject.put("fail_back_mode", qkdPath.getFAIL_BACK_MODE());
                jsonObject.put("fail_back_period", qkdPath.getFAIL_BACK_PERIOD());
                jsonObject.put("consumer_link", consumerLinkJsonObject);
                jsonObject.put("primary", primaryJsonArray);
                jsonObject.put("primary_usage", qkdPath.getPRIMARY_USAGE());
                jsonObject.put("primary_fault", qkdPath.getPRIMARY_FAULT());
                jsonObject.put("secondary", secondaryJsonArray);
                jsonObject.put("secondary_usage", qkdPath.getSECONDARY_USAGE());
                jsonObject.put("secondary_fault", qkdPath.getSECONDARY_FAULT());
                jsonObject.put("remark", qkdPath.getREMARK());
                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

//    @ApiOperation(value = "get qkd ", notes = "")
//    @GetMapping(value = "")
//    @ResponseBody
//    public ResponseEntity selectQkdLinkList() {
//        if(qkdLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
//        JSONArray jsonArray = new JSONArray();
//        JSONParser parser = new JSONParser();
//
//        try {
//            for(QkdService qkdService : qkdServiceRepository.findAll()) {
//                JSONObject jsonObject = new JSONObject();
//                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdService.getOPER_MODE());
//                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdService.getSOURCE());
//                JSONObject destJsonObject = (JSONObject) parser.parse(qkdService.getDEST());
//                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdService.getQ_KEY_STORE());
//
//                jsonObject.put("qkd_service_id;", qkdService.getQKD_SERVICE_ID());
//                jsonObject.put("id;", qkdService.getID());
//                jsonObject.put("uid;", qkdService.getUID());
//                jsonObject.put("name;", qkdService.getNAME());
//                jsonObject.put("oper_mode;", operModeJsonObject);
//                jsonObject.put("source;", sourceJsonObject);
//                jsonObject.put("dest;", destJsonObject);
//                jsonObject.put("preshared_key;", qkdService.getPRESHARED_KEY());
//                jsonObject.put("q_key_store;", qKeyStoreJsonObject);
//
//                jsonArray.add(jsonObject);
//            }
//        } catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return ResponseEntity.ok();
//    }

//    @ApiOperation(value = "get qkd ", notes = "")
//    @GetMapping(value = "")
//    @ResponseBody
//    public ResponseEntity selectQkdLinkList() {
//        if(qkdLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
//        JSONArray jsonArray = new JSONArray();
//        JSONParser parser = new JSONParser();
//
//        try {
//            for(QkdService qkdService : qkdServiceRepository.findAll()) {
//                JSONObject jsonObject = new JSONObject();
//                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdService.getOPER_MODE());
//                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdService.getSOURCE());
//                JSONObject destJsonObject = (JSONObject) parser.parse(qkdService.getDEST());
//                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdService.getQ_KEY_STORE());
//
//                jsonObject.put("qkd_service_id;", qkdService.getQKD_SERVICE_ID());
//                jsonObject.put("id;", qkdService.getID());
//                jsonObject.put("uid;", qkdService.getUID());
//                jsonObject.put("name;", qkdService.getNAME());
//                jsonObject.put("oper_mode;", operModeJsonObject);
//                jsonObject.put("source;", sourceJsonObject);
//                jsonObject.put("dest;", destJsonObject);
//                jsonObject.put("preshared_key;", qkdService.getPRESHARED_KEY());
//                jsonObject.put("q_key_store;", qKeyStoreJsonObject);
//
//                jsonArray.add(jsonObject);
//            }
//        } catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return ResponseEntity.ok();
//    }

//    @ApiOperation(value = "get qkd ", notes = "")
//    @GetMapping(value = "")
//    @ResponseBody
//    public ResponseEntity selectQkdLinkList() {
//        if(qkdLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
//        JSONArray jsonArray = new JSONArray();
//        JSONParser parser = new JSONParser();
//
//        try {
//            for(QkdService qkdService : qkdServiceRepository.findAll()) {
//                JSONObject jsonObject = new JSONObject();
//                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdService.getOPER_MODE());
//                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdService.getSOURCE());
//                JSONObject destJsonObject = (JSONObject) parser.parse(qkdService.getDEST());
//                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdService.getQ_KEY_STORE());
//
//                jsonObject.put("qkd_service_id;", qkdService.getQKD_SERVICE_ID());
//                jsonObject.put("id;", qkdService.getID());
//                jsonObject.put("uid;", qkdService.getUID());
//                jsonObject.put("name;", qkdService.getNAME());
//                jsonObject.put("oper_mode;", operModeJsonObject);
//                jsonObject.put("source;", sourceJsonObject);
//                jsonObject.put("dest;", destJsonObject);
//                jsonObject.put("preshared_key;", qkdService.getPRESHARED_KEY());
//                jsonObject.put("q_key_store;", qKeyStoreJsonObject);
//
//                jsonArray.add(jsonObject);
//            }
//        } catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return ResponseEntity.ok();
//    }

//    @ApiOperation(value = "get qkd ", notes = "")
//    @GetMapping(value = "")
//    @ResponseBody
//    public ResponseEntity selectQkdLinkList() {
//        if(qkdLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
//        JSONArray jsonArray = new JSONArray();
//        JSONParser parser = new JSONParser();
//
//        try {
//            for(QkdService qkdService : qkdServiceRepository.findAll()) {
//                JSONObject jsonObject = new JSONObject();
//                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdService.getOPER_MODE());
//                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdService.getSOURCE());
//                JSONObject destJsonObject = (JSONObject) parser.parse(qkdService.getDEST());
//                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdService.getQ_KEY_STORE());
//
//                jsonObject.put("qkd_service_id;", qkdService.getQKD_SERVICE_ID());
//                jsonObject.put("id;", qkdService.getID());
//                jsonObject.put("uid;", qkdService.getUID());
//                jsonObject.put("name;", qkdService.getNAME());
//                jsonObject.put("oper_mode;", operModeJsonObject);
//                jsonObject.put("source;", sourceJsonObject);
//                jsonObject.put("dest;", destJsonObject);
//                jsonObject.put("preshared_key;", qkdService.getPRESHARED_KEY());
//                jsonObject.put("q_key_store;", qKeyStoreJsonObject);
//
//                jsonArray.add(jsonObject);
//            }
//        } catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return ResponseEntity.ok();
//    }
//
//    @ApiOperation(value = "get qkd ", notes = "")
//    @GetMapping(value = "")
//    @ResponseBody
//    public ResponseEntity selectQkdLinkList() {
//        if(qkdLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
//        JSONArray jsonArray = new JSONArray();
//        JSONParser parser = new JSONParser();
//
//        try {
//            for(QkdService qkdService : qkdServiceRepository.findAll()) {
//                JSONObject jsonObject = new JSONObject();
//                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdService.getOPER_MODE());
//                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdService.getSOURCE());
//                JSONObject destJsonObject = (JSONObject) parser.parse(qkdService.getDEST());
//                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdService.getQ_KEY_STORE());
//
//                jsonObject.put("qkd_service_id;", qkdService.getQKD_SERVICE_ID());
//                jsonObject.put("id;", qkdService.getID());
//                jsonObject.put("uid;", qkdService.getUID());
//                jsonObject.put("name;", qkdService.getNAME());
//                jsonObject.put("oper_mode;", operModeJsonObject);
//                jsonObject.put("source;", sourceJsonObject);
//                jsonObject.put("dest;", destJsonObject);
//                jsonObject.put("preshared_key;", qkdService.getPRESHARED_KEY());
//                jsonObject.put("q_key_store;", qKeyStoreJsonObject);
//
//                jsonArray.add(jsonObject);
//            }
//        } catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return ResponseEntity.ok();
//    }
//
//    @ApiOperation(value = "get qkd node list", notes = "전체 qkd 노드 조회")
//    @GetMapping(value = "/provider_node/list")
//    @ResponseBody
//    public ResponseEntity selectProviderNodeList() {
//        if(qkdProviderNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(qkdProviderNodeRepository.findAll());
//    }


}
