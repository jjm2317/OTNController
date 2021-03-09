package com.woorinet.plugin.demo.HOLA;

import com.woorinet.plugin.demo.DTO.HOLA.HolaSdnLineNumSheet;
import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.Repository.HOLA.HolaSdnLineNumSheetRepository;

import java.util.List;
import java.util.stream.Stream;

public class HOLAManager {
    HolaSdnLineNumSheetRepository sdnLineNumSheetRepository;

    List<SdnNode> sdnNodeList;
    List<SdnConnector> sdnConnectorList;
    List<SdnLink> sdnLinkList;
    List<SdnService> sdnServiceList;


    public HOLAManager(HolaSdnLineNumSheetRepository sdnLineNumSheetRepository,
                       List<SdnNode> sdnNodeList,
                       List<SdnConnector> sdnConnectorList,
                       List<SdnLink> sdnLinkList,
                       List<SdnService> sdnServiceList) throws Exception{
        this.sdnLineNumSheetRepository = sdnLineNumSheetRepository;



        this.sdnNodeList = sdnNodeList;
        this.sdnConnectorList = sdnConnectorList;
        this.sdnLinkList = sdnLinkList;
        this.sdnServiceList = sdnServiceList;

        makeHashMap();
    }

    private void makeHashMap() {

    }

    public void HOLASyncStart() throws Exception {

    }

    private void HolaSyncSdnLineNumSheet() throws Exception {
        Stream<SdnService> sdnServiceStream = sdnServiceList
            .stream()
            .map(sdnService -> {
                HolaSdnLineNumSheet holaSdnLineNumSheet = new HolaSdnLineNumSheet(
                        "", // group
                        "Single", //domain_type
                        "", //area_start, userinput
                        "", //area_end, userinput
                        sdnService.getSrc_ne_name() ,//node_start
                        sdnService.getDst_ne_name() ,//node_end
                        "", //circuit_id
                        sdnService.getService_name(), //auto_service_name
                        "", //input_service_name, userinput
                        "", //service_type, userinput
                        "Woorinet", //vendor
                        "no protection", //protection_type, otn 장비는 보호타입이 no protection
                        sdnService.getService_rate(), //service_rate
                        "", //service_status, 일반적으로 서비스 상태는 값이 나오는데 여긴 없음, 모비젠에 문의 해야됨
                        sdnService.getActive_path().contains("active") ? "주" : "예비", //active_path, 주의 기준??
                        "active", //traffic_status, 어디 있지??
                        "", //home_path
                        "", //latency
                        sdnService.getCreation_date(), //cable_creation_date
                        "", //network_cable_number
                        "", //writer
                        "", //remarks
                        "", //endpoint_client_start
                        "", //transmit_client_start
                        "", //link_start
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",



                )
            })
    }
}
