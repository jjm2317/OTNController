package com.woorinet.plugin.demo.DTO.PORTAL;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Setter
@Getter
@Data
@Entity
@Table(name="portal_link_mng")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalLinkMng {
    @Id
    @GeneratedValue
    int holaSdnLinkMngId;
    String vendor;
    @Column(length = 1000)
    String link;
    String adminWeight;
    String maximumUsageRatio;
    String memory;
    String usageRatio;
    String allMemory;
    String allUsageRatio;
    String distance;
    String srlg;
    String roadmPath;
    String remarks;
    public PortalLinkMng() {
    }

    public PortalLinkMng(String vendor, String link, String adminWeight, String maximumUsageRatio, String memory, String usageRatio, String allMemory, String allUsageRatio, String distance, String srlg, String roadmPath, String remarks) {
        this.vendor = vendor;
        this.link = link;
        this.adminWeight = adminWeight;
        this.maximumUsageRatio = maximumUsageRatio;
        this.memory = memory;
        this.usageRatio = usageRatio;
        this.allMemory = allMemory;
        this.allUsageRatio = allUsageRatio;
        this.distance = distance;
        this.srlg = srlg;
        this.roadmPath = roadmPath;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PortalLinkMng{" +
                "vendor='" + vendor + '\'' +
                ", link='" + link + '\'' +
                ", adminWeight='" + adminWeight + '\'' +
                ", maximumUsageRatio='" + maximumUsageRatio + '\'' +
                ", memory='" + memory + '\'' +
                ", usageRatio='" + usageRatio + '\'' +
                ", allMemory='" + allMemory + '\'' +
                ", allUsageRatio='" + allUsageRatio + '\'' +
                ", distance='" + distance + '\'' +
                ", srlg='" + srlg + '\'' +
                ", roadmPath='" + roadmPath + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public void setLink(String[] firstLinkFields, String[] secondLinkFields) {
        Link firstLink = new Link(firstLinkFields);
        Link secondLink = new Link(secondLinkFields);
        String[] result = {(new Gson()).toJson(firstLink), (new Gson()).toJson(secondLink)};

        System.out.println(result);
        System.out.println("asdf");
        this.link = Arrays.toString(result);
    }

    class Link {
        String sourceNode;
        String sourceShelfId;
        String sourceSlotId;
        String sourcePortId;
        String destinationNode;
        String destinationShelfId;
        String destinationSlotId;
        String destimationPortId;


        public Link() {
        }

        public Link(String[] fields) {
            this.sourceNode = fields[0];
            this.sourceShelfId = fields[1];
            this.sourceSlotId = fields[2];
            this.sourcePortId = fields[3];
            this.destinationNode = fields[4];
            this.destinationShelfId = fields[5];
            this.destinationSlotId = fields[6];
            this.destimationPortId = fields[7];
        }

        public Link(String sourceNode, String sourceShelfId, String sourceSlotId, String sourcePortId, String destinationNode, String destinationShelfId, String destinationSlotId, String destimationPortId) {
            this.sourceNode = sourceNode;
            this.sourceShelfId = sourceShelfId;
            this.sourceSlotId = sourceSlotId;
            this.sourcePortId = sourcePortId;
            this.destinationNode = destinationNode;
            this.destinationShelfId = destinationShelfId;
            this.destinationSlotId = destinationSlotId;
            this.destimationPortId = destimationPortId;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "sourceNode='" + sourceNode + '\'' +
                    ", sourceShelfId='" + sourceShelfId + '\'' +
                    ", sourceSlotId='" + sourceSlotId + '\'' +
                    ", sourcePortId='" + sourcePortId + '\'' +
                    ", destinationNode='" + destinationNode + '\'' +
                    ", destinationShelfId='" + destinationShelfId + '\'' +
                    ", destinationSlotId='" + destinationSlotId + '\'' +
                    ", destimationPortId='" + destimationPortId + '\'' +
                    '}';
        }
    }
}
