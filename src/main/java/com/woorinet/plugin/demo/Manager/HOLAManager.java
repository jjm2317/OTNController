package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.HOLA.*;
import com.woorinet.plugin.demo.DTO.SDN.*;
import com.woorinet.plugin.demo.Repository.HOLA.*;
import com.woorinet.plugin.demo.Repository.SDN.SdnConnectorRepository;

import java.util.Arrays;
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

    SdnConnectorRepository sdnConnectorRepository;

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
                       SdnConnectorRepository sdnConnectorRepository,
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

        this.sdnConnectorRepository = sdnConnectorRepository;

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
        HolaSyncLinkMng();
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

                Optional<SdnConnector> srcSdnConnector = sdnConnectorList.stream().
                        filter(connector -> connector.getConnect_id().equals(sdnService.getSrc_connector_id()))
                        .findAny();

                Optional<SdnConnector> dstSdnConnector = sdnConnectorList.stream().
                        filter(connector -> connector.getConnect_id().equals(sdnService.getDst_connector_id()))
                        .findAny();

                Optional<SdnLink> sdnLink = sdnLinkList.stream().
                        filter(link -> link.getLink_id().equals(sdnService.getSrc_connector_id() + ":" + sdnService.getDst_connector_id()))
                        .findAny();

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
                String[] endPointClientStartFields = {"", "", "", "", "", "", "", "", "", ""};

                String[] transmitClientStartFields = {
                        "OTN",
                        "",
                        "Woorinet",
                        "",
                        sdnService.getSrc_ne_name(),
                        srcSdnConnector.map(connector -> connector.getUnit_type()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getShelf_id()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getSlot_id()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getPort_id()).orElse(""),
                        ""
                };

                String[] linkStartFields = {
                        "OTN",
                        "",
                        "Woorinet",
                        "",
                        sdnLink.map(link -> link.getSrc_ne_name()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getUnit_type()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getShelf_id()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getSlot_id()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getPort_id()).orElse(""),
                        ""
                };

                String[] roadmMuxStartFields = {"", "", "", "", "", "", "", "", "", ""};

                String[] roadmMuxEndFields = {"", "", "", "", "", "", "", "", "", ""};

                String[] linkEndFields = {
                        "OTN",
                        "",
                        "Woorinet",
                        "",
                        sdnLink.map(link -> link.getDst_ne_name()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getUnit_type()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getShelf_id()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getSlot_id()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getPort_id()).orElse(""),
                        ""
                };

                String[] transmitClientEndFields = {
                        "OTN",
                        "",
                        "Woorinet",
                        "",
                        sdnService.getDst_ne_name(),
                        dstSdnConnector.map(connector -> connector.getUnit_type()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getShelf_id()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getSlot_id()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getPort_id()).orElse(""),
                        ""
                };

                String[] endPointClientEndFields = {"", "", "", "","", "", "", "", "", ""};

                holaLineNumSheet.setENDPOINT_CLIENT_START(holaLineNumSheet.getNodeRef(endPointClientStartFields));
                holaLineNumSheet.setTRANSMIT_CLIENT_START(holaLineNumSheet.getNodeRef(transmitClientStartFields));
                holaLineNumSheet.setLINK_START(holaLineNumSheet.getNodeRef(linkStartFields));
                holaLineNumSheet.setROADM_MUX_START(holaLineNumSheet.getNodeRef(roadmMuxStartFields));
                holaLineNumSheet.setROADM_MUX_END(holaLineNumSheet.getNodeRef(roadmMuxEndFields));
                holaLineNumSheet.setLINK_END(holaLineNumSheet.getNodeRef(linkEndFields));
                holaLineNumSheet.setTRANSMIT_CLIENT_END(holaLineNumSheet.getNodeRef(transmitClientEndFields));
                holaLineNumSheet.setENDPOINT_CLIENT_END(holaLineNumSheet.getNodeRef(endPointClientEndFields));

                return holaLineNumSheet;
            });
        holaSdnLineNumSheetStream.forEach(holaLineNumSheetRepository::save);
    }

    private void HolaSyncLinkMng() throws Exception {
        Stream<HolaLinkMng> holaLinkMngStream = sdnLinkList
            .stream()
            .filter(sdnLink -> {
                String [] halfOflinkId = sdnLink.getLink_id().split(":");
                return (halfOflinkId[0].split("_")[2].charAt(0) < halfOflinkId[1].split("_")[2].charAt(0));
            })
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


                String[] firstHalfOfLinkIdSplits = sdnLink.getLink_id().split(":")[0].split("\\.");//ex) [WOORI-NET, otn, EMS_1000_B, 1, S03, 1]
                String[] secondHalfOfLinkIdSplits = sdnLink.getLink_id().split(":")[1].split("\\.");//ex) [WOORI-NET, otn, EMS_1000_C, 1, S02, 3]


                String[] firstLinkFields = {
                        firstHalfOfLinkIdSplits[2],
                        firstHalfOfLinkIdSplits[3],
                        firstHalfOfLinkIdSplits[4],
                        firstHalfOfLinkIdSplits[5],
                        secondHalfOfLinkIdSplits[2],
                        secondHalfOfLinkIdSplits[3],
                        secondHalfOfLinkIdSplits[4],
                        secondHalfOfLinkIdSplits[5]
                };
                String[] secondLinkFields = {
                        secondHalfOfLinkIdSplits[2],
                        secondHalfOfLinkIdSplits[3],
                        secondHalfOfLinkIdSplits[4],
                        secondHalfOfLinkIdSplits[5],
                        firstHalfOfLinkIdSplits[2],
                        firstHalfOfLinkIdSplits[3],
                        firstHalfOfLinkIdSplits[4],
                        firstHalfOfLinkIdSplits[5]
                };

                holaLinkMng.setLink(firstLinkFields, secondLinkFields);


                return holaLinkMng;
            });

        holaLinkMngStream.forEach(item -> {
            System.out.println(item);
            holaLinkMngRepository.save(item);
        });
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
                //sdnNode와 매치되는 sdnConnector들의 stream
                Stream<SdnConnector> sdnConnectorStream = sdnConnectorList
                        .stream()
                        .filter(connector -> connector.getNe_name().equals(sdnNode.getNe_name()));
                /* sdnNode 별 Otn 물자현황 데이터 생성, unitList필드는 아래에서 생성*/
                HolaOtnMaterial holaOtnMaterial = new HolaOtnMaterial(
                        sdnNode.getVendor(), //vendor
                        "", //cell
                        sdnNode.getNe_name(), //node
                        sdnNode.getIp_addr(), //ip
                        sdnConnectorStream.findAny().map(connector -> connector.getShelf_id()).orElse(""), //shelf_id
                        "" //unit_list
                );

                /* HolaOtnMaterial 인스턴스의 unitList 필드값 생성 */
                // sdnConnector에 있는 unit_type 종류 조회 by Jpa query
                List<String> unitList = sdnConnectorRepository.findAllUnitTypesNative();

                // unitListValue: holaOtnMaterial의 unitList 필드값을 담을 변수
                String unitListValue = "";

                unitList.stream().forEach(unitType -> {
//                    int unitCount = Long.valueOf(sdnConnectorStream.
//                            filter( connector -> connector.getUnit_type().equals(unitType))
//                            .count()).intValue();
//                    int allPortCount = unitCount * getPortCountOfUnitType(unitType);
//                    int usagePortCount sdnConnectorRepository.
//
//                    String[] UnitFields = {
//                            unitType, //unit_type
//                            String.valueOf(unitCount), //unit_count
//                            String.valueOf(allPortCount), //all_port_count
//
//
//
//
//
//                    };
                });


//                holaOtnMaterial.setUNIT_LIST();

                return holaOtnMaterial;
            });
        holaSdnOtnMaterialStream.forEach(holaOtnMaterialRepository::save);
    }

    private int getPortCountOfUnitType (String unitType) {
        switch (unitType) {
            case "O208CLU":
                return 8;
            case "OC201SU":
                return 1;
            case "O210SU":
                return 10;
            case "O220SU":
                return 20;
            case "O210U":
                return 10;
            default:
                return 0;
        }
    }


}
