package com.woorinet.plugin.demo.HOLA;

import com.woorinet.plugin.demo.DTO.HOLA.HolaSdnInventoryDetail;
import com.woorinet.plugin.demo.DTO.HOLA.HolaSdnLineNumSheet;
import com.woorinet.plugin.demo.DTO.HOLA.HolaSdnLinkMng;
import com.woorinet.plugin.demo.DTO.HOLA.HolaSdnTrunkUsage;
import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.Repository.HOLA.*;

import java.util.List;
import java.util.stream.Stream;

public class HOLAManager {
    HolaSdnLineNumSheetRepository holaSdnLineNumSheetRepository;
    HolaSdnLinkMngRepository holaSdnLinkMngRepository;
    HolaSdnTrunkUsageRepository holaSdnTrunkUsageRepository;
    HolaSdnInventroyDetailRepository holaSdnInventroyDetailRepository;
    HolaSdnOtnNodeUsageRepository holaSdnOtnNodeUsageRepository;
    HolaSdnOtnMaterialRepository holaSdnOtnMaterialRepository;

    List<SdnNode> sdnNodeList;
    List<SdnConnector> sdnConnectorList;
    List<SdnLink> sdnLinkList;
    List<SdnService> sdnServiceList;
    List<SdnPath> sdnPathList;
    List<SdnConstraint> sdnConstraintList;
    List<SdnAccessIf> sdnAccessIfList;


    public HOLAManager(HolaSdnLineNumSheetRepository holaSdnLineNumSheetRepository,
                       HolaSdnLinkMngRepository holaSdnLinkMngRepository,
                       HolaSdnTrunkUsageRepository holaSdnTrunkUsageRepository,
                       HolaSdnInventroyDetailRepository holaSdnInventroyDetailRepository,
                       HolaSdnOtnNodeUsageRepository holaSdnOtnNodeUsageRepository,
                       HolaSdnOtnMaterialRepository holaSdnOtnMaterialRepository,
                       List<SdnNode> sdnNodeList,
                       List<SdnConnector> sdnConnectorList,
                       List<SdnLink> sdnLinkList,
                       List<SdnService> sdnServiceList,
                       List<SdnPath> sdnPathList,
                       List<SdnConstraint> sdnConstraintList,
                       List<SdnAccessIf> sdnAccessIfList
                       ) throws Exception{
        this.holaSdnLineNumSheetRepository = holaSdnLineNumSheetRepository;
        this.holaSdnLinkMngRepository = holaSdnLinkMngRepository;
        this.holaSdnTrunkUsageRepository = holaSdnTrunkUsageRepository;
        this.holaSdnInventroyDetailRepository = holaSdnInventroyDetailRepository;
        this.holaSdnOtnNodeUsageRepository = holaSdnOtnNodeUsageRepository;
        this.holaSdnOtnMaterialRepository = holaSdnOtnMaterialRepository;

        this.sdnNodeList = sdnNodeList;
        this.sdnConnectorList = sdnConnectorList;
        this.sdnLinkList = sdnLinkList;
        this.sdnServiceList = sdnServiceList;
        this.sdnPathList = sdnPathList;
        this.sdnConstraintList = sdnConstraintList;
        this.sdnAccessIfList = sdnAccessIfList;

        makeHashMap();
    }

    private void makeHashMap() {

    }

    public void HOLASyncStart() throws Exception {
        //선번장 테이블 생성
        HolaSyncSdnLineNumSheet();
        //LinkMng 테이블 생성
        HolaSyncSdnLinkMng();
    }

    private void HolaSyncSdnLineNumSheet() throws Exception {
        Stream<HolaSdnLineNumSheet> holaSdnLineNumSheetStream = sdnServiceList
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
                        "", //constraint_id
                        "no protection", //protection_type, otn 장비는 보호타입이 no protection
                        sdnService.getService_rate(), //service_rate,
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
                        "", //roadm_mux_start
                        "", //roadm_mux_end
                        "", //link_end
                        "", //transmit_client_end
                        "", //endpoint_client_end
                        "", //main_path
                        "" //bypass_path
                );

                return holaSdnLineNumSheet;
            });
        holaSdnLineNumSheetStream.forEach(holaSdnLineNumSheetRepository::save);
    }

    private void HolaSyncSdnLinkMng() throws Exception {
        Stream<HolaSdnLinkMng> holaSdnLinkMngStream = sdnLinkList
            .stream()
            .map(sdnLink -> {
                HolaSdnLinkMng holaSdnLinkMng = new HolaSdnLinkMng(
                        "Woorinet", //vendor
                        "", // link
                        "", // admin_weight, user input
                        "", //maximum_usage_ratio, user input
                        "", //memory
                        "", //usage_ratio
                        "", //all_memory
                        "", //all_usage_ratio
                        "", //distance, user input
                        "", //srlg
                        "", //roadm_path
                        "" //remarks, user input


                );

                return holaSdnLinkMng;
            });

        holaSdnLinkMngStream.forEach(holaSdnLinkMngRepository::save);
    }


}
