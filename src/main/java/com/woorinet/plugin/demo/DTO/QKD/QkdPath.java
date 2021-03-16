package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@Table(name = "qkd_path")
public class QkdPath {
    @Id
    @GeneratedValue
    int QKD_PATH_ID;
    String ID;
    String FAIL_BACK_MODE;
    String FAIL_BACK_PERIOD;
    @Lob
    String CONSUMER_LINK;
    @Lob
    String PRIMARY;
    String PRIMARY_USAGE;
    String PRIMARY_FAULT;
    @Lob
    String SECONDARY;
    String SECONDARY_USAGE;
    String SECONDARY_FAULT;
    String REMARK;

    public QkdPath() {
    }

    public QkdPath(String ID, String FAIL_BACK_MODE, String FAIL_BACK_PERIOD, String CONSUMER_LINK, String PRIMARY, String PRIMARY_USAGE, String PRIMARY_FAULT, String SECONDARY, String SECONDARY_USAGE, String SECONDARY_FAULT, String REMARK) {
        this.ID = ID;
        this.FAIL_BACK_MODE = FAIL_BACK_MODE;
        this.FAIL_BACK_PERIOD = FAIL_BACK_PERIOD;
        this.CONSUMER_LINK = CONSUMER_LINK;
        this.PRIMARY = PRIMARY;
        this.PRIMARY_USAGE = PRIMARY_USAGE;
        this.PRIMARY_FAULT = PRIMARY_FAULT;
        this.SECONDARY = SECONDARY;
        this.SECONDARY_USAGE = SECONDARY_USAGE;
        this.SECONDARY_FAULT = SECONDARY_FAULT;
        this.REMARK = REMARK;
    }

    @Override
    public String toString() {
        return "QkdPath{" +
                "ID='" + ID + '\'' +
                ", FAIL_BACK_MODE='" + FAIL_BACK_MODE + '\'' +
                ", FAIL_BACK_PERIOD='" + FAIL_BACK_PERIOD + '\'' +
                ", CONSUMER_LINK='" + CONSUMER_LINK + '\'' +
                ", PRIMARY='" + PRIMARY + '\'' +
                ", PRIMARY_USAGE='" + PRIMARY_USAGE + '\'' +
                ", PRIMARY_FAULT='" + PRIMARY_FAULT + '\'' +
                ", SECONDARY='" + SECONDARY + '\'' +
                ", SECONDARY_USAGE='" + SECONDARY_USAGE + '\'' +
                ", SECONDARY_FAULT='" + SECONDARY_FAULT + '\'' +
                ", REMARK='" + REMARK + '\'' +
                '}';
    }
}
