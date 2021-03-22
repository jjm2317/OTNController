package com.woorinet.plugin.demo.DTO.PORTAL;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Data
@Table(name="tn2_linkbook")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalLinkbook {
    @Id
    @GeneratedValue
    @Column(name="tn2_linkbook_id")
    int portalLinkbookId;
    String group;
    String domainType;
    String areaStart;
    String areaEnd;
    String nodeStart;
    String nodeEnd;
    String circuitId;
    String autoServiceName;
    String inputServiceName;
    String serviceType;
    String vendor;
    String constraintId;
    String protectionType;
    String serviceRate;
    String serviceStatus;
    String activePath;
    String trafficStatus;
    String homePath;
    String latency;
    String cableCreationDate;
    String networkCableNumber;
    String writer;
    String remarks;
    String endpointClientStart;
    String transmitClientStart;
    String linkStart;
    String roadmMuxStart;
    String roadmMuxEnd;
    String linkEnd;
    String transmitClientEnd;
    String endpointClientEnd;
    String mainPath;
    String bypassPath;

    public PortalLinkbook() {
    }


    public PortalLinkbook(String group, String domainType, String areaStart, String areaEnd, String nodeStart, String nodeEnd, String circuitId, String autoServiceName, String inputServiceName, String serviceType, String vendor, String constraintId, String protectionType, String serviceRate, String serviceStatus, String activePath, String trafficStatus, String homePath, String latency, String cableCreationDate, String networkCableNumber, String writer, String remarks, String endpointClientStart, String transmitClientStart, String linkStart, String roadmMuxStart, String roadmMuxEnd, String linkEnd, String transmitClientEnd, String endpointClientEnd, String mainPath, String bypassPath) {
        this.group = group;
        this.domainType = domainType;
        this.areaStart = areaStart;
        this.areaEnd = areaEnd;
        this.nodeStart = nodeStart;
        this.nodeEnd = nodeEnd;
        this.circuitId = circuitId;
        this.autoServiceName = autoServiceName;
        this.inputServiceName = inputServiceName;
        this.serviceType = serviceType;
        this.vendor = vendor;
        this.constraintId = constraintId;
        this.protectionType = protectionType;
        this.serviceRate = serviceRate;
        this.serviceStatus = serviceStatus;
        this.activePath = activePath;
        this.trafficStatus = trafficStatus;
        this.homePath = homePath;
        this.latency = latency;
        this.cableCreationDate = cableCreationDate;
        this.networkCableNumber = networkCableNumber;
        this.writer = writer;
        this.remarks = remarks;
        this.endpointClientStart = endpointClientStart;
        this.transmitClientStart = transmitClientStart;
        this.linkStart = linkStart;
        this.roadmMuxStart = roadmMuxStart;
        this.roadmMuxEnd = roadmMuxEnd;
        this.linkEnd = linkEnd;
        this.transmitClientEnd = transmitClientEnd;
        this.endpointClientEnd = endpointClientEnd;
        this.mainPath = mainPath;
        this.bypassPath = bypassPath;
    }

    @Override
    public String toString() {
        return "PortalLineNumSheet{" +
                "group='" + group + '\'' +
                ", domainType='" + domainType + '\'' +
                ", areaStart='" + areaStart + '\'' +
                ", areaEnd='" + areaEnd + '\'' +
                ", nodeStart='" + nodeStart + '\'' +
                ", nodeEnd='" + nodeEnd + '\'' +
                ", circuitId='" + circuitId + '\'' +
                ", autoServiceName='" + autoServiceName + '\'' +
                ", inputServiceName='" + inputServiceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", vendor='" + vendor + '\'' +
                ", constraintId='" + constraintId + '\'' +
                ", protectionType='" + protectionType + '\'' +
                ", serviceRate='" + serviceRate + '\'' +
                ", serviceStatus='" + serviceStatus + '\'' +
                ", activePath='" + activePath + '\'' +
                ", trafficStatus='" + trafficStatus + '\'' +
                ", homePath='" + homePath + '\'' +
                ", latency='" + latency + '\'' +
                ", cableCreationDate='" + cableCreationDate + '\'' +
                ", networkCableNumber='" + networkCableNumber + '\'' +
                ", writer='" + writer + '\'' +
                ", remarks='" + remarks + '\'' +
                ", endpointClientStart='" + endpointClientStart + '\'' +
                ", transmitClientStart='" + transmitClientStart + '\'' +
                ", linkStart='" + linkStart + '\'' +
                ", roadmMuxStart='" + roadmMuxStart + '\'' +
                ", roadmMuxEnd='" + roadmMuxEnd + '\'' +
                ", linkEnd='" + linkEnd + '\'' +
                ", transmitClientEnd='" + transmitClientEnd + '\'' +
                ", endpointClientEnd='" + endpointClientEnd + '\'' +
                ", mainPath='" + mainPath + '\'' +
                ", bypassPath='" + bypassPath + '\'' +
                '}';
    }
    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    class
    NodeRef {
        String system;
        String managementTeam;
        String vendor;
        String cell;
        String nodeName;
        String unitType;
        String shelfId;
        String slotId;
        String portId;
        String fdf;

        public NodeRef() {
        }

        public NodeRef(String[] fields) {
            this.system = fields[0];
            this.managementTeam = fields[1];
            this.vendor = fields[2];
            this.cell = fields[3];
            this.nodeName = fields[4];
            this.unitType = fields[5];
            this.shelfId = fields[6];
            this.slotId = fields[7];
            this.portId = fields[8];
            this.fdf = fields[9];
        }

        @Override
        public String toString() {
            return "NodeRef{" +
                    "system='" + system + '\'' +
                    ", managementTeam='" + managementTeam + '\'' +
                    ", vendor='" + vendor + '\'' +
                    ", cell='" + cell + '\'' +
                    ", nodeName='" + nodeName + '\'' +
                    ", unitType='" + unitType + '\'' +
                    ", shelfId='" + shelfId + '\'' +
                    ", slotId='" + slotId + '\'' +
                    ", portId='" + portId + '\'' +
                    ", fdf='" + fdf + '\'' +
                    '}';
        }
    }

    public String getNodeRef(String[] fields)  {
        try {
            NodeRef nodeRef = new NodeRef(fields);
            ObjectMapper mapper = new ObjectMapper();

            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

            //return (new Gson()).toJson(nodeRef);

            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nodeRef);
        } catch (Exception e){
            e.printStackTrace();
            return "{}";
        }
    }




}