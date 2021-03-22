package com.woorinet.plugin.demo.DTO.PORTAL;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name="tn2_stats_node")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PortalStatsNode {
    @Id
    @GeneratedValue
    @Column(name="tn2_stats_node_id")
    int portalStatsNodeId;
    String area;
    String city;
    String mountingStatus;

    public PortalStatsNode() {
    }

    public PortalStatsNode(String area, String city, String mountingStatus) {
        this.area = area;
        this.city = city;
        this.mountingStatus = mountingStatus;
    }

    @Override
    public String toString() {
        return "PortalOtnNodeUsage{" +
                "area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", mountingStatus='" + mountingStatus + '\'' +
                '}';
    }

    public String getMountingStatusRef(String[] fields)  {
        try {
            MountingStatus mountingStatus = new PortalStatsNode.MountingStatus(fields);
            ObjectMapper mapper = new ObjectMapper();

            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

            //return (new Gson()).toJson(nodeRef);

            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mountingStatus);
        } catch (Exception e){
            e.printStackTrace();
            return "{}";
        }
    }

    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    class MountingStatus {
        String xG;
        String tenG;
        String hundredG;
        String twoHundredG;

        public MountingStatus(String[] fields) {
            this.xG = fields[0];
            this.tenG = fields[1];
            this.hundredG = fields[2];
            this.twoHundredG = fields[3];
        }
    }
}
