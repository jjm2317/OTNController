package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.PORTAL.*;
import com.woorinet.plugin.demo.DTO.OTN.*;
import com.woorinet.plugin.demo.Repository.PORTAL.*;
import com.woorinet.plugin.demo.Repository.OTN.OtnConnectorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class PortalManager {
    PortalLinkbookRepository portalLinkBookRepository;
    PortalLinkmngRepository portalLinkMngRepository;
    PortalTrunkUsageRepository portalTrunkUsageRepository;
    PortalStatsInventoryRepository portalStatsInventoryRepository;
    PortalStatsNodeRepository portalStatsNodeRepository;
    PortalStatsSuppliesRepository portalStatsSuppliesRepository;

    OtnConnectorRepository otnConnectorRepository;

    List<OtnNode> otnNodeList;
    List<OtnConnector> otnConnectorList;
    List<OtnLink> otnLinkList;
    List<OtnService> otnServiceList;
    List<OtnPath> otnPathList;
    List<OtnConstraint> otnConstraintList;
    List<OtnAccessIf> otnAccessIfList;


    public PortalManager(PortalLinkbookRepository portalLinkBookRepository,
                         PortalLinkmngRepository portalLinkMngRepository,
                         PortalTrunkUsageRepository portalTrunkUsageRepository,
                         PortalStatsInventoryRepository portalStatsInventoryRepository,
                         PortalStatsNodeRepository portalStatsNodeRepository,
                         PortalStatsSuppliesRepository portalStatsSuppliesRepository,
                         OtnConnectorRepository otnConnectorRepository,
                         List<OtnNode> otnNodeList,
                         List<OtnConnector> otnConnectorList,
                         List<OtnLink> otnLinkList,
                         List<OtnService> otnServiceList,
                         List<OtnPath> otnPathList,
                         List<OtnConstraint> otnConstraintList,
                         List<OtnAccessIf> otnAccessIfList
                       ) throws Exception{
        this.portalLinkBookRepository = portalLinkBookRepository;
        this.portalLinkMngRepository = portalLinkMngRepository;
        this.portalTrunkUsageRepository = portalTrunkUsageRepository;
        this.portalStatsInventoryRepository = portalStatsInventoryRepository;
        this.portalStatsNodeRepository = portalStatsNodeRepository;
        this.portalStatsSuppliesRepository = portalStatsSuppliesRepository;

        this.otnConnectorRepository = otnConnectorRepository;

        this.otnNodeList = otnNodeList;
        this.otnConnectorList = otnConnectorList;
        this.otnLinkList = otnLinkList;
        this.otnServiceList = otnServiceList;
        this.otnPathList = otnPathList;
        this.otnConstraintList = otnConstraintList;
        this.otnAccessIfList = otnAccessIfList;

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
        Stream<PortalLinkbook> holaSdnLineNumSheetStream = otnServiceList
            .stream()
            .map(otnService -> {

                Optional<OtnConnector> srcSdnConnector = otnConnectorList.stream().
                        filter(connector -> connector.getConnectId().equals(otnService.getSrcConnectorId()))
                        .findAny();

                Optional<OtnConnector> dstSdnConnector = otnConnectorList.stream().
                        filter(connector -> connector.getConnectId().equals(otnService.getDstConnectorId()))
                        .findAny();

                Optional<OtnLink> sdnLink = otnLinkList.stream().
                        filter(link -> link.getLinkId().equals(otnService.getSrcConnectorId() + ":" + otnService.getDstConnectorId()))
                        .findAny();

                PortalLinkbook portalLinkBook = new PortalLinkbook(
                        "", // group
                        "Single", //domain_type
                        "", //area_start, userinput
                        "", //area_end, userinput
                        otnService.getSrcNeName() ,//node_start
                        otnService.getDstNeName() ,//node_end
                        "", //circuit_id
                        otnService.getServiceName(), //auto_service_name
                        "", //input_service_name, userinput
                        "", //service_type, userinput
                        "Woorinet", //vendor
                        "", //constraint_id
                        "no protection", //protection_type, otn 장비는 보호타입이 no protection
                        otnService.getServiceRate(), //service_rate,
                        "", //service_status, 일반적으로 서비스 상태는 값이 나오는데 여긴 없음, 모비젠에 문의 해야됨
                        otnService.getActivePath().contains("active") ? "주" : "예비", //active_path, 주의 기준??
                        "active", //traffic_status, 어디 있지??
                        "", //home_path
                        "", //latency
                        otnService.getCreationDate(), //cable_creation_date
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
                        otnService.getSrcNeName(),
                        srcSdnConnector.map(connector -> connector.getUnitType()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getShelfId()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getSlotId()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getPortId()).orElse(""),
                        ""
                };

                String[] linkStartFields = {
                        "OTN",
                        "",
                        "Woorinet",
                        "",
                        sdnLink.map(link -> link.getSrcNeName()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getUnitType()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getShelfId()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getSlotId()).orElse(""),
                        srcSdnConnector.map(connector -> connector.getPortId()).orElse(""),
                        ""
                };

                String[] roadmMuxStartFields = {"", "", "", "", "", "", "", "", "", ""};

                String[] roadmMuxEndFields = {"", "", "", "", "", "", "", "", "", ""};

                String[] linkEndFields = {
                        "OTN",
                        "",
                        "Woorinet",
                        "",
                        sdnLink.map(link -> link.getDstNeName()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getUnitType()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getShelfId()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getSlotId()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getPortId()).orElse(""),
                        ""
                };

                String[] transmitClientEndFields = {
                        "OTN",
                        "",
                        "Woorinet",
                        "",
                        otnService.getDstNeName(),
                        dstSdnConnector.map(connector -> connector.getUnitType()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getShelfId()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getSlotId()).orElse(""),
                        dstSdnConnector.map(connector -> connector.getPortId()).orElse(""),
                        ""
                };

                String[] endPointClientEndFields = {"", "", "", "","", "", "", "", "", ""};

                portalLinkBook.setEndpointClientStart(portalLinkBook.getNodeRef(endPointClientStartFields));
                portalLinkBook.setTransmitClientStart(portalLinkBook.getNodeRef(transmitClientStartFields));
                portalLinkBook.setLinkStart( portalLinkBook.getNodeRef(linkStartFields));
                portalLinkBook.setRoadmMuxStart(portalLinkBook.getNodeRef(roadmMuxStartFields));
                portalLinkBook.setRoadmMuxEnd(portalLinkBook.getNodeRef(roadmMuxEndFields));
                portalLinkBook.setLinkEnd(portalLinkBook.getNodeRef(linkEndFields));
                portalLinkBook.setTransmitClientEnd(portalLinkBook.getNodeRef(transmitClientEndFields));
                portalLinkBook.setEndpointClientEnd(portalLinkBook.getNodeRef(endPointClientEndFields));

                return portalLinkBook;
            });
        holaSdnLineNumSheetStream.forEach(portalLinkBookRepository::save);
    }

    private void HolaSyncLinkMng() throws Exception {
        Stream<PortalLinkmng> holaLinkMngStream = otnLinkList
            .stream()
            .filter(otnLink -> {
                String [] halfOflinkId = otnLink.getLinkId().split(":");
                return (halfOflinkId[0].split("_")[2].charAt(0) < halfOflinkId[1].split("_")[2].charAt(0));
            })
            .map(otnLink -> {
                PortalLinkmng portalLinkMng = new PortalLinkmng(
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


                String[] firstHalfOfLinkIdSplits = otnLink.getLinkId().split(":")[0].split("\\.");//ex) [WOORI-NET, otn, EMS_1000_B, 1, S03, 1]
                String[] secondHalfOfLinkIdSplits = otnLink.getLinkId().split(":")[1].split("\\.");//ex) [WOORI-NET, otn, EMS_1000_C, 1, S02, 3]


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

                portalLinkMng.setLink(firstLinkFields, secondLinkFields);


                return portalLinkMng;
            });

        holaLinkMngStream.forEach(item -> {
            System.out.println(item);
            portalLinkMngRepository.save(item);
        });
    }

    private void HolaSyncSdnInventoryDetail() throws Exception {
        Stream<PortalStatsInventory> holaSdnInventoryDetailStream = otnConnectorList
            .stream()
            .map(otnConnector -> {
                Optional<OtnNode> sdnNode = otnNodeList.stream().
                        filter(node -> node.getNeName().equals(otnConnector.getNeName()))
                            .findAny();



                Optional<OtnLink> sdnLink = otnLinkList.stream().
                        filter(link -> link.getLinkId().contains(otnConnector.getConnectId()))
                        .findAny();

                PortalStatsInventory portalStatsInventory = new PortalStatsInventory(
                        "Woorinet", //vendor
                        "", //cell
                        otnConnector.getNeName(), //tid
                        otnConnector.getShelfId(), //shelf_id
                        sdnNode.map(node -> node.getIpAddr()).orElse(""), //ip
                        "", //ne_type
                        otnConnector.getUnitType(), //unit_type
                        otnConnector.getConnectPec(), // unit_pec
                        otnConnector.getConnectSerial(), //serial_number
                        otnConnector.getSlotId(), //slot_id
                        otnConnector.getPortId(), //port_id
                        otnConnector.getConnectIdle(), //connect_status
                        "", //llcf
                        otnConnector.getModuleName(), //module_name
                        otnConnector.getConnectPec(), //module_pec
                        sdnLink.map(link -> link.getDistance()).orElse(""), //distance
                        "", //module_description
                        "", //cable_name
                        "" //remarks_list
                );
                return portalStatsInventory;
            });

        holaSdnInventoryDetailStream.forEach(portalStatsInventoryRepository::save);

    }

    private void HolaSyncSdnOtnNodeUsage() throws Exception {
        PortalStatsNode holaSdnOtnNodeUsage = new PortalStatsNode(
                "수도권", //area
                "", //city
                "" //mounting_status
        );

        portalStatsNodeRepository.save(holaSdnOtnNodeUsage);
    }

    private void HolaSyncSdnOtnMaterial() throws Exception {
        Stream<PortalStatsSupplies> portalOtnMaterialStream = otnNodeList
            .stream()
            .map(otnNode -> {
                //otnConnectorStream : otnNode의 ne_name(예: EMS_1000_B)과 매치되는 otnConnector들의 stream
                Stream<OtnConnector> otnConnectorStream = otnConnectorList
                        .stream()
                        .filter(connector -> connector.getNeName().equals(otnNode.getNeName()));

                /* sdnNode 별 Otn 물자현황 데이터 생성, unitList필드는 아래에서 생성*/
                PortalStatsSupplies portalStatsSupplies = new PortalStatsSupplies(
                        otnNode.getVendor(), //vendor
                        "", //cell
                        otnNode.getNeName(), //node
                        otnNode.getIpAddr(), //ip
                        otnConnectorStream.findAny().map(connector -> connector.getShelfId()).orElse(""), //shelf_id
                        "" //unit_list
                );

                /* unitList 필드값 생성 */
                // sdnConnector에 있는 unit_type 종류 조회 by Jpa query
                List<String> unitList = otnConnectorRepository.findUnitTypes();

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

                return portalStatsSupplies;
            });
        portalOtnMaterialStream.forEach(portalStatsSuppliesRepository::save);
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
