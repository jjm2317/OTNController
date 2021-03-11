package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.HOLA.*;
import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.Repository.HOLA.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HOLAManager {
    HolaLineNumSheetRepository holaLineNumSheetRepository;
    HolaLinkMngRepository holaLinkMngRepository;
    HolaTrunkUsageRepository holaTrunkUsageRepository;
    HolaInventroyDetailRepository holaInventroyDetailRepository;
    HolaOtnNodeUsageRepository holaOtnNodeUsageRepository;
    HolaOtnMaterialRepository holaOtnMaterialRepository;

    List<SdnNode> sdnNodeList;
    List<SdnConnector> sdnConnectorList;
    List<SdnLink> sdnLinkList;
    List<SdnService> sdnServiceList;
    List<SdnPath> sdnPathList;
    List<SdnConstraint> sdnConstraintList;
    List<SdnAccessIf> sdnAccessIfList;


    public HOLAManager(HolaLineNumSheetRepository holaLineNumSheetRepository,
                       HolaLinkMngRepository holaLinkMngRepository,
                       HolaTrunkUsageRepository holaTrunkUsageRepository,
                       HolaInventroyDetailRepository holaInventroyDetailRepository,
                       HolaOtnNodeUsageRepository holaOtnNodeUsageRepository,
                       HolaOtnMaterialRepository holaOtnMaterialRepository,
                       List<SdnNode> sdnNodeList,
                       List<SdnConnector> sdnConnectorList,
                       List<SdnLink> sdnLinkList,
                       List<SdnService> sdnServiceList,
                       List<SdnPath> sdnPathList,
                       List<SdnConstraint> sdnConstraintList,
                       List<SdnAccessIf> sdnAccessIfList
                       ) throws Exception{
        this.holaLineNumSheetRepository = holaLineNumSheetRepository;
        this.holaLinkMngRepository = holaLinkMngRepository;
        this.holaTrunkUsageRepository = holaTrunkUsageRepository;
        this.holaInventroyDetailRepository = holaInventroyDetailRepository;
        this.holaOtnNodeUsageRepository = holaOtnNodeUsageRepository;
        this.holaOtnMaterialRepository = holaOtnMaterialRepository;

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
        //상세 Inventory 현황 테이블 생성
        HolaSyncSdnInventoryDetail();
        //OTN NODE 사용현황 테이블 생성
        HolaSyncSdnOtnNodeUsage();
        //OTN 물자 현황 테이블 생성
        HolaSyncSdnOtnMaterial();

    }

    private void HolaSyncSdnLineNumSheet() throws Exception {
        Stream<HolaLineNumSheet> holaSdnLineNumSheetStream = sdnServiceList
            .stream()
            .map(sdnService -> {
                HolaLineNumSheet holaLineNumSheet = new HolaLineNumSheet(
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

                return holaLineNumSheet;
            });
        holaSdnLineNumSheetStream.forEach(holaLineNumSheetRepository::save);
    }

    private void HolaSyncSdnLinkMng() throws Exception {
        Stream<HolaLinkMng> holaSdnLinkMngStream = sdnLinkList
            .stream()
            .map(sdnLink -> {
                HolaLinkMng holaLinkMng = new HolaLinkMng(
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

                return holaLinkMng;
            });

        holaSdnLinkMngStream.forEach(holaLinkMngRepository::save);
    }

    private void HolaSyncSdnInventoryDetail() throws Exception {
        Stream<HolaInventoryDetail> holaSdnInventoryDetailStream = sdnConnectorList
            .stream()
            .map(sdnConnector -> {
                Optional<SdnNode> sdnNode = sdnNodeList.stream().
                        filter(node -> node.getNe_name().equals(sdnConnector.getNe_name()))
                            .findAny();



                Optional<SdnLink> sdnLink = sdnLinkList.stream().
                        filter(link -> link.getLink_id().contains(sdnConnector.getConnect_id()))
                        .findAny();

                HolaInventoryDetail holaInventoryDetail = new HolaInventoryDetail(
                        "Woorinet", //vendor
                        "", //cell
                        sdnConnector.getNe_name(), //tid
                        sdnConnector.getShelf_id(), //shelf_id
                        sdnNode.map(node -> node.getIp_addr()).orElse(""), //ip
                        "", //ne_type
                        sdnConnector.getUnit_type(), //unit_type
                        sdnConnector.getConnect_pec(), // unit_pec
                        sdnConnector.getConnect_serial(), //serial_number
                        sdnConnector.getSlot_id(), //slot_id
                        sdnConnector.getPort_id(), //port_id
                        sdnConnector.getConnect_idle(), //connect_status
                        "", //llcf
                        sdnConnector.getModule_name(), //module_name
                        sdnConnector.getConnect_pec(), //module_pec
                        sdnLink.map(link -> link.getDistance()).orElse(""), //distance
                        "", //module_description
                        "", //cable_name
                        "" //remarks_list
                );
                return holaInventoryDetail;
            });

        holaSdnInventoryDetailStream.forEach(holaInventroyDetailRepository::save);

    }

    private void HolaSyncSdnOtnNodeUsage() throws Exception {
        HolaOtnNodeUsage holaSdnOtnNodeUsage = new HolaOtnNodeUsage(
                "수도권", //area
                "", //city
                "" //mounting_status
        );

        holaOtnNodeUsageRepository.save(holaSdnOtnNodeUsage);
    }

    private void HolaSyncSdnOtnMaterial() throws Exception {
        Stream<HolaOtnMaterial> holaSdnOtnMaterialStream = sdnNodeList
            .stream()
            .map(sdnNode -> {

                SdnConnector sdnConnector = sdnConnectorList
                        .stream()
                        .filter(connector -> connector.getNe_name().equals(sdnNode.getNe_name()))
                        .findAny().get();

                HolaOtnMaterial holaOtnMaterial = new HolaOtnMaterial(
                        sdnNode.getVendor(), //vendor
                        "", //cell
                        sdnNode.getNe_name(), //node
                        sdnNode.getIp_addr(), //ip
                        sdnConnector.getShelf_id(), //shelf_id
                        "" //unit_list
                );

                return holaOtnMaterial;
            });
        holaSdnOtnMaterialStream.forEach(holaOtnMaterialRepository::save);
    }


}