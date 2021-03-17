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
    @GetMapping(value = "/node")
    @ResponseBody
    public ResponseEntity selectNodeList() {
        if(qkdNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for (QkdNode qkdNode : qkdNodeRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject networkJsonObject = (JSONObject) parser.parse(qkdNode.getNetwork());
                JSONArray consumersJsonArray = (JSONArray) parser.parse(qkdNode.getConsumers());
                JSONArray providersJsonArray = (JSONArray) parser.parse(qkdNode.getProviders());


                jsonObject.put("qkd_node_id", qkdNode.getQkdNodeId());
                jsonObject.put("id", qkdNode.getId());
                jsonObject.put("uid", qkdNode.getUid());
                jsonObject.put("name", qkdNode.getName());
                jsonObject.put("enabled", qkdNode.getEnabled());
                jsonObject.put("description", qkdNode.getDescription());
                jsonObject.put("group_id", qkdNode.getGroupId());
                jsonObject.put("group", qkdNode.getGroup());
                jsonObject.put("unique_id", qkdNode.getUniqueId());
                jsonObject.put("qnc_web_api_url", qkdNode.getQncWebApiUrl());
                jsonObject.put("qnc_web_api_auth", qkdNode.getQncWebApiAuth());
                jsonObject.put("cert", qkdNode.getCert());
                jsonObject.put("network", networkJsonObject);
                jsonObject.put("kems_cert", qkdNode.getKemsCert());
                jsonObject.put("apps", consumersJsonArray);
                jsonObject.put("providers", providersJsonArray);
                jsonObject.put("loc_x", qkdNode.getLocX());
                jsonObject.put("loc_y", qkdNode.getLocY());

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd service list", notes = "전체 kms service 조회")
    @GetMapping(value = "/service")
    @ResponseBody
    public ResponseEntity selectServiceList() {
        if(qkdServiceRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            for(QkdService qkdService : qkdServiceRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdService.getOperMode());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdService.getSource());
                JSONObject destJsonObject = (JSONObject) parser.parse(qkdService.getDest());
                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdService.getQkeyStore());

                jsonObject.put("qkd_service_id", qkdService.getQkdServiceId());
                jsonObject.put("id", qkdService.getId());
                jsonObject.put("uid", qkdService.getUid());
                jsonObject.put("name", qkdService.getName());
                jsonObject.put("oper_mode", operModeJsonObject);
                jsonObject.put("source", sourceJsonObject);
                jsonObject.put("dest", destJsonObject);
                jsonObject.put("preshared_key", qkdService.getPresharedKey());
                jsonObject.put("qkey_store", qKeyStoreJsonObject);

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd link list", notes = "전체 QKD Link 조회")
    @GetMapping(value = "/link")
    @ResponseBody
    public ResponseEntity selectQkdLinkList() {
        if(qkdLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdLink qkdLink : qkdLinkRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject typeJsonObject = (JSONObject) parser.parse(qkdLink.getType());
                JSONObject algorithmJsonObject = (JSONObject) parser.parse(qkdLink.getAlgorithm());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdLink.getSource());
                JSONObject destJsonObject = (JSONObject) parser.parse(qkdLink.getDest());

                jsonObject.put("qkd_link_id", qkdLink.getQkdLinkId());
                jsonObject.put("id", qkdLink.getId());
                jsonObject.put("name", qkdLink.getName());
                jsonObject.put("uid", qkdLink.getUid());
                jsonObject.put("type", typeJsonObject);
                jsonObject.put("algorithm", algorithmJsonObject);
                jsonObject.put("weight", qkdLink.getWeight());
                jsonObject.put("psk", qkdLink.getPsk());
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
    @GetMapping(value = "/path")
    @ResponseBody
    public ResponseEntity selectQkdPathList() {
        if(qkdPathRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdPath qkdPath : qkdPathRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject consumerLinkJsonObject = (JSONObject) parser.parse(qkdPath.getConsumerLink());
                JSONArray primaryJsonArray = (JSONArray) parser.parse(qkdPath.getPrimary());
                JSONArray secondaryJsonArray = (JSONArray) parser.parse(qkdPath.getSecondary());

                jsonObject.put("qkd_path_id", qkdPath.getQkdPathId());
                jsonObject.put("id", qkdPath.getId());
                jsonObject.put("fail_back_mode", qkdPath.getFailBackMode());
                jsonObject.put("fail_back_period", qkdPath.getFailBackPeriod());
                jsonObject.put("app_link", consumerLinkJsonObject);
                jsonObject.put("primary", primaryJsonArray);
                jsonObject.put("primary_usage", qkdPath.getPrimaryUsage());
                jsonObject.put("primary_fault", qkdPath.getPrimaryFault());
                jsonObject.put("secondary", secondaryJsonArray);
                jsonObject.put("secondary_usage", qkdPath.getSecondaryUsage());
                jsonObject.put("secondary_fault", qkdPath.getSecondaryFault());
                jsonObject.put("remark", qkdPath.getRemark());
                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd provider_node list ", notes = "전체 provider(qkd) node 조회")
    @GetMapping(value = "/provider_node")
    @ResponseBody
    public ResponseEntity selectQkdProviderNodeList() {
        if(qkdProviderNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdProviderNode qkdProviderNode : qkdProviderNodeRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject agentJsonObject = (JSONObject) parser.parse(qkdProviderNode.getAgent());
                JSONObject networkJsonObject = (JSONObject) parser.parse(qkdProviderNode.getNetwork());
                JSONArray interfacesJsonArray = (JSONArray) parser.parse(qkdProviderNode.getInterfaces());



                jsonObject.put("qkd_node_id", qkdProviderNode.getQkdNodeId());
                jsonObject.put("kms_id", qkdProviderNode.getKmsId());
                jsonObject.put("kms_name", qkdProviderNode.getKmsName());
                jsonObject.put("group_id", qkdProviderNode.getGroupId());
                jsonObject.put("group_name", qkdProviderNode.getGroupName());
                jsonObject.put("id", qkdProviderNode.getId());
                jsonObject.put("uid", qkdProviderNode.getUid());
                jsonObject.put("name", qkdProviderNode.getName());
                jsonObject.put("description", qkdProviderNode.getDescription());
                jsonObject.put("agent", agentJsonObject);
                jsonObject.put("network", networkJsonObject);
                jsonObject.put("qnc_web_api_url", qkdProviderNode.getQncWebApiUrl());
                jsonObject.put("qnc_web_api_auth", qkdProviderNode.getQncWebApiAuth());
                jsonObject.put("interfaces", interfacesJsonArray);
                jsonObject.put("node", qkdProviderNode.getNode());
                jsonObject.put("loc_x", qkdProviderNode.getLocX());
                jsonObject.put("loc_y", qkdProviderNode.getLocY());
                jsonObject.put("lat", qkdProviderNode.getLat());
                jsonObject.put("long", qkdProviderNode.getLongitude());

                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd provider_link list ", notes = "전체 provider(qkd) link 조회")
    @GetMapping(value = "/provider_link")
    @ResponseBody
    public ResponseEntity selectQkdProviderLinkList() {
        if(qkdProviderLinkRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdProviderLink qkdProviderLink : qkdProviderLinkRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject modeJsonObject = (JSONObject) parser.parse(qkdProviderLink.getMode());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdProviderLink.getSource());
                JSONObject destinationJsonObject = (JSONObject) parser.parse((qkdProviderLink.getDestination()));
                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdProviderLink.getQkeyStore());

                jsonObject.put("qkd_provider_link_id", qkdProviderLink.getQkdProviderLinkId());
                jsonObject.put("id", qkdProviderLink.getId());
                jsonObject.put("uid", qkdProviderLink.getUid());
                jsonObject.put("name", qkdProviderLink.getName());
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
    @GetMapping(value = "/app_node")
    @ResponseBody
    public ResponseEntity selectQkdAppNodeList() {
        if(qkdAppNodeRepository.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdAppNode qkdAppNode : qkdAppNodeRepository.findAll()) {
                JSONObject jsonObject = new JSONObject();

                JSONObject agentJsonObject = (JSONObject) parser.parse(qkdAppNode.getAgent());
                JSONObject networkJsonObject = (JSONObject) parser.parse(qkdAppNode.getNetwork());
                JSONArray interfacesJsonArray = (JSONArray) parser.parse(qkdAppNode.getInterfaces());

                jsonObject.put("qkd_app_node_id", qkdAppNode.getQkdAppNodeId());
                jsonObject.put("level", qkdAppNode.getLevel());
                jsonObject.put("kms_id", qkdAppNode.getKmsId());
                jsonObject.put("kms_name", qkdAppNode.getKmsName());
                jsonObject.put("group_id", qkdAppNode.getGroupId());
                jsonObject.put("group_name", qkdAppNode.getGroupName());
                jsonObject.put("id", qkdAppNode.getId());
                jsonObject.put("uid", qkdAppNode.getUid());
                jsonObject.put("name", qkdAppNode.getName());
                jsonObject.put("description", qkdAppNode.getDescription());
                jsonObject.put("agent", agentJsonObject);
                jsonObject.put("network", networkJsonObject);
                jsonObject.put("interfaces", interfacesJsonArray);
                jsonObject.put("loc_x", qkdAppNode.getLocX());
                jsonObject.put("loc_y", qkdAppNode.getLocY());
                jsonObject.put("lat", qkdAppNode.getLat());
                jsonObject.put("long", qkdAppNode.getLongitude());


                jsonArray.add(jsonObject);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    @ApiOperation(value = "get qkd app_link list", notes = "전체 app link 조회")
    @GetMapping(value = "/app_link")
    @ResponseBody
    public ResponseEntity selectQkdAppLinkList() {
        if(qkdAppLinkRepositroy.findAll() == null) return ResponseEntity.notFound().build();
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            for(QkdAppLink qkdAppLink : qkdAppLinkRepositroy.findAll()) {
                JSONObject jsonObject = new JSONObject();
                JSONObject operModeJsonObject = (JSONObject) parser.parse(qkdAppLink.getOperMode());
                JSONObject sourceJsonObject = (JSONObject) parser.parse(qkdAppLink.getSource());
                JSONObject destJsonObject = (JSONObject) parser.parse(qkdAppLink.getDest());
                JSONObject qKeyStoreJsonObject = (JSONObject) parser.parse(qkdAppLink.getQkeyStore());

                jsonObject.put("qkd_app_link_id", qkdAppLink.getQkdAppLinkId());
                jsonObject.put("id", qkdAppLink.getId());
                jsonObject.put("uid", qkdAppLink.getUid());
                jsonObject.put("name", qkdAppLink.getName());
                jsonObject.put("oper_mode", operModeJsonObject);
                jsonObject.put("source", sourceJsonObject);
                jsonObject.put("dest", destJsonObject);
                jsonObject.put("preshared_key", qkdAppLink.getPresharedKey());
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
