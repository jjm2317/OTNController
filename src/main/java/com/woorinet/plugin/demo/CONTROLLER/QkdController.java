package com.woorinet.plugin.demo.CONTROLLER;

import com.woorinet.plugin.demo.DTO.QKD.*;
import com.woorinet.plugin.demo.Repository.QKD.*;
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
                jsonObject.put("qkey_store", qKeyStoreJsonObject);

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

    @ApiOperation(value = "get qkd provider_node list ", notes = "전체 provider(qkd) node 조회")
    @GetMapping(value = "/provider_node/list")
    @ResponseBody
    public ResponseEntity selectQkdProviderNodeList() {
        if(qkdProviderNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdProviderNode qkdProviderNode : qkdProviderNodeRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject agentJsonObject = (JSONObject) parser.parse(qkdProviderNode.getAGENT());
                JSONObject networkJsonObject = (JSONObject) parser.parse(qkdProviderNode.getNETWORK());
                JSONArray interfacesJsonArray = (JSONArray) parser.parse(qkdProviderNode.getINTERFACES());



                jsonObject.put("qkd_node_id", qkdProviderNode.getQKD_NODE_ID());
                jsonObject.put("kms_id", qkdProviderNode.getKMS_ID());
                jsonObject.put("kms_name", qkdProviderNode.getKMS_NAME());
                jsonObject.put("group_id", qkdProviderNode.getGROUP_ID());
                jsonObject.put("group_name", qkdProviderNode.getGROUP_NAME());
                jsonObject.put("id", qkdProviderNode.getID());
                jsonObject.put("uid", qkdProviderNode.getUID());
                jsonObject.put("name", qkdProviderNode.getNAME());
                jsonObject.put("description", qkdProviderNode.getDESCRIPTION());
                jsonObject.put("agent", agentJsonObject);
                jsonObject.put("network", networkJsonObject);
                jsonObject.put("qnc_web_api_url", qkdProviderNode.getQNC_WEB_API_URL());
                jsonObject.put("qnc_web_api_auth", qkdProviderNode.getQNC_WEB_API_AUTH());
                jsonObject.put("interfaces", interfacesJsonArray);
                jsonObject.put("node", qkdProviderNode.getNODE());
                jsonObject.put("loc_x", qkdProviderNode.getLOC_X());
                jsonObject.put("loc_y", qkdProviderNode.getLOC_Y());
                jsonObject.put("lat", qkdProviderNode.getLAT());
                jsonObject.put("long", qkdProviderNode.getLONG());

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd provider_link list ", notes = "전체 provider(qkd) link 조회")
    @GetMapping(value = "/provider_link/list")
    @ResponseBody
    public ResponseEntity selectQkdProviderLinkList() {
        if(qkdProviderLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdProviderLink qkdProviderLink : qkdProviderLinkRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject modeJsonObject = (JSONObject) parser.parse(qkdProviderLink.getMODE());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdProviderLink.getSOURCE());
                JSONObject destinationJsonObject = (JSONObject) parser.parse((qkdProviderLink.getDESTINATION()));
                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdProviderLink.getQKEY_STORE());

                jsonObject.put("qkd_provider_link", qkdProviderLink.getQKD_PROVIDER_LINK_ID());
                jsonObject.put("id", qkdProviderLink.getID());
                jsonObject.put("uid", qkdProviderLink.getUID());
                jsonObject.put("name", qkdProviderLink.getNAME());
                jsonObject.put("mode", modeJsonObject);
                jsonObject.put("source", sourceJsonObject);
                jsonObject.put("destination", destinationJsonObject);
                jsonObject.put("qkey_store", qKeyStoreJsonObject);

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd app_node list", notes = "전체 app node 조회")
    @GetMapping(value = "/app_node/list")
    @ResponseBody
    public ResponseEntity selectQkdAppNodeList() {
        if(qkdAppNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdAppNode qkdAppNode : qkdAppNodeRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject agentJsonObject = (JSONObject) parser.parse(qkdAppNode.getAGENT());
                JSONObject networkJsonObject = (JSONObject) parser.parse(qkdAppNode.getNETWORK());
                JSONArray interfacesJsonArray = (JSONArray) parser.parse(qkdAppNode.getINTERFACES());

                jsonObject.put("qkd_app_node_id", qkdAppNode.getQKD_APP_NODE_ID());
                jsonObject.put("level", qkdAppNode.getLEVEL());
                jsonObject.put("kms_id", qkdAppNode.getKMS_ID());
                jsonObject.put("kms_name", qkdAppNode.getKMS_NAME());
                jsonObject.put("group_id", qkdAppNode.getGROUP_ID());
                jsonObject.put("group_name", qkdAppNode.getGROUP_NAME());
                jsonObject.put("id", qkdAppNode.getID());
                jsonObject.put("uid", qkdAppNode.getUID());
                jsonObject.put("name", qkdAppNode.getNAME());
                jsonObject.put("description", qkdAppNode.getDESCRIPTION());
                jsonObject.put("agent", agentJsonObject);
                jsonObject.put("network", networkJsonObject);
                jsonObject.put("interfaces", interfacesJsonArray);
                jsonObject.put("loc_x", qkdAppNode.getLOC_X());
                jsonObject.put("loc_y", qkdAppNode.getLOC_Y());
                jsonObject.put("lat", qkdAppNode.getLAT());
                jsonObject.put("long", qkdAppNode.getLONG());


                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd app_link list", notes = "전체 app link 조회")
    @GetMapping(value = "/app_link/list")
    @ResponseBody
    public ResponseEntity selectQkdAppLinkList() {
        if(qkdAppLinkRepositroy.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdAppLink qkdAppLink : qkdAppLinkRepositroy.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdAppLink.getOPER_MODE());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdAppLink.getSOURCE());
                JSONObject destJsonObject = (JSONObject) parser.parse(qkdAppLink.getDEST());
                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdAppLink.getQKEY_STORE());

                jsonObject.put("qkd_app_link_id", qkdAppLink.getQKD_APP_LINK_ID());
                jsonObject.put("id", qkdAppLink.getID());
                jsonObject.put("uid", qkdAppLink.getUID());
                jsonObject.put("name", qkdAppLink.getNAME());
                jsonObject.put("oper_mode", operModeJsonObject);
                jsonObject.put("source", sourceJsonObject);
                jsonObject.put("dest", destJsonObject);
                jsonObject.put("preshared_key", qkdAppLink.getPRESHARED_KEY());
                jsonObject.put("qkey_store", qKeyStoreJsonObject);

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

//


}
