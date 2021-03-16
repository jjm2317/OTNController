package com.woorinet.plugin.demo.DTO.PORTAL;


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
public class PortalLinkMng {
    @Id
    @GeneratedValue
    int HOLA_SDN_LINK_MNG_ID;
    String VENDOR;
    @Column(length = 1000)
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

    public PortalLinkMng() {
    }

    public PortalLinkMng(String VENDOR, String LINK, String ADMIN_WEIGHT, String MAXIMUM_USAGE_RATIO, String MEMORY, String USAGE_RATIO, String ALL_MEMORY, String ALL_USAGE_RATIO, String DISTANCE, String SRLG, String ROADM_PATH, String REMARKS) {
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


    public void setLink(String[] firstLinkFields, String[] secondLinkFields) {
        Link firstLink = new Link(firstLinkFields);
        Link secondLink = new Link(secondLinkFields);
        String[] result = {(new Gson()).toJson(firstLink), (new Gson()).toJson(secondLink)};

        System.out.println(result);
        System.out.println("asdf");
        this.LINK = Arrays.toString(result);
    }

    class Link {
        String SOURCE_NODE;
        String SOURCE_SHELF_ID;
        String SOURCE_SLOT_ID;
        String SOURCE_PORT_ID;
        String DESTINATION_NODE;
        String DESTINATION_SHELF_ID;
        String DESTINATION_SLOT_ID;
        String DESTIMATION_PORT_ID;


        public Link() {
        }

        public Link(String[] fields) {
            this.SOURCE_NODE = fields[0];
            this.SOURCE_SHELF_ID = fields[1];
            this.SOURCE_SLOT_ID = fields[2];
            this.SOURCE_PORT_ID = fields[3];
            this.DESTINATION_NODE = fields[4];
            this.DESTINATION_SHELF_ID = fields[5];
            this.DESTINATION_SLOT_ID = fields[6];
            this.DESTIMATION_PORT_ID = fields[7];
        }

        public Link(String SOURCE_NODE, String SOURCE_SHELF_ID, String SOURCE_SLOT_ID, String SOURCE_PORT_ID, String DESTINATION_NODE, String DESTINATION_SHELF_ID, String DESTINATION_SLOT_ID, String DESTIMATION_PORT_ID) {
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
