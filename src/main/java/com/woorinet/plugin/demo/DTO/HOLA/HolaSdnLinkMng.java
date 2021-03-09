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
@Table(name="hola_sdn_link_mng")
public class HolaSdnLinkMng {
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

    public HolaSdnLinkMng() {
    }

    public HolaSdnLinkMng(String VENDOR, String LINK, String ADMIN_WEIGHT, String MAXIMUM_USAGE_RATIO, String MEMORY, String USAGE_RATIO, String ALL_MEMORY, String ALL_USAGE_RATIO, String DISTANCE, String SRLG, String ROADM_PATH, String REMARKS) {
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
}
