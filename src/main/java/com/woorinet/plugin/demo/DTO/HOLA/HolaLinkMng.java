package com.woorinet.plugin.demo.DTO.HOLA;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Data
@Entity
@Table(name="hola_link_mng")
public class HolaLinkMng {
    @Id
    @GeneratedValue
    int HOLA_SDN_LINK_MNG_ID;
    String VENDOR;
    String LINK;
    String ADMIN_WEIGHT;
    String MAXIMUM_USAGE_RATIO;
    String MEMORY;
    String USAGE_RATIO;
    String ALL_MEMORY;
    String ALL_USAGE_RATIO;
    String DISTANCE;
    String SRLG;
    String ROADM_PATH;
    String REMARKS;

    public HolaLinkMng() {
    }

    public HolaLinkMng(String VENDOR, String LINK, String ADMIN_WEIGHT, String MAXIMUM_USAGE_RATIO, String MEMORY, String USAGE_RATIO, String ALL_MEMORY, String ALL_USAGE_RATIO, String DISTANCE, String SRLG, String ROADM_PATH, String REMARKS) {
        this.VENDOR = VENDOR;
        this.LINK = LINK;
        this.ADMIN_WEIGHT = ADMIN_WEIGHT;
        this.MAXIMUM_USAGE_RATIO = MAXIMUM_USAGE_RATIO;
        this.MEMORY = MEMORY;
        this.USAGE_RATIO = USAGE_RATIO;
        this.ALL_MEMORY = ALL_MEMORY;
        this.ALL_USAGE_RATIO = ALL_USAGE_RATIO;
        this.DISTANCE = DISTANCE;
        this.SRLG = SRLG;
        this.ROADM_PATH = ROADM_PATH;
        this.REMARKS = REMARKS;
    }

    @Override
    public String toString() {
        return "HolaSdnLinkMng{" +
                "VENDOR='" + VENDOR + '\'' +
                ", LINK='" + LINK + '\'' +
                ", ADMIN_WEIGHT='" + ADMIN_WEIGHT + '\'' +
                ", MAXIMUM_USAGE_RATIO='" + MAXIMUM_USAGE_RATIO + '\'' +
                ", MEMORY='" + MEMORY + '\'' +
                ", USAGE_RATIO='" + USAGE_RATIO + '\'' +
                ", ALL_MEMORY='" + ALL_MEMORY + '\'' +
                ", ALL_USAGE_RATIO='" + ALL_USAGE_RATIO + '\'' +
                ", DISTANCE='" + DISTANCE + '\'' +
                ", SRLG='" + SRLG + '\'' +
                ", ROADM_PATH='" + ROADM_PATH + '\'' +
                ", REMARKS='" + REMARKS + '\'' +
                '}';
    }

    class link {
        String SOURCE_NODE;
        String SOURCE_SHELF_ID;
        String SOURCE_SLOT_ID;
        String SOURCE_PORT_ID;
        String DESTINATION_NODE;
        String DESTINATION_SHELF_ID;
        String DESTINATION_SLOT_ID;
        String DESTIMATION_PORT_ID;


        public link() {
        }

        public link(String SOURCE_NODE, String SOURCE_SHELF_ID, String SOURCE_SLOT_ID, String SOURCE_PORT_ID, String DESTINATION_NODE, String DESTINATION_SHELF_ID, String DESTINATION_SLOT_ID, String DESTIMATION_PORT_ID) {
            this.SOURCE_NODE = SOURCE_NODE;
            this.SOURCE_SHELF_ID = SOURCE_SHELF_ID;
            this.SOURCE_SLOT_ID = SOURCE_SLOT_ID;
            this.SOURCE_PORT_ID = SOURCE_PORT_ID;
            this.DESTINATION_NODE = DESTINATION_NODE;
            this.DESTINATION_SHELF_ID = DESTINATION_SHELF_ID;
            this.DESTINATION_SLOT_ID = DESTINATION_SLOT_ID;
            this.DESTIMATION_PORT_ID = DESTIMATION_PORT_ID;
        }

        @Override
        public String toString() {
            return "{" +
                    "SOURCE_NODE='" + SOURCE_NODE + '\'' +
                    ", SOURCE_SHELF_ID='" + SOURCE_SHELF_ID + '\'' +
                    ", SOURCE_SLOT_ID='" + SOURCE_SLOT_ID + '\'' +
                    ", SOURCE_PORT_ID='" + SOURCE_PORT_ID + '\'' +
                    ", DESTINATION_NODE='" + DESTINATION_NODE + '\'' +
                    ", DESTINATION_SHELF_ID='" + DESTINATION_SHELF_ID + '\'' +
                    ", DESTINATION_SLOT_ID='" + DESTINATION_SLOT_ID + '\'' +
                    ", DESTIMATION_PORT_ID='" + DESTIMATION_PORT_ID + '\'' +
                    '}';
        }
    }
}
