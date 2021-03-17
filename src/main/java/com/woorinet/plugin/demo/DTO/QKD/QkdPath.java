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
    int qkdPathId;
    String id;
    String failBackMode;
    String failBackPeriod;
    @Lob
    String consumerLink;
    @Lob
    String primary;
    String primaryUsage;
    String primaryFault;
    @Lob
    String secondary;
    String secondaryUsage;
    String secondaryFault;
    String remark;

    public QkdPath() {
    }

    public QkdPath(String id, String failBackMode, String failBackPeriod, String consumerLink, String primary, String primaryUsage, String primaryFault, String secondary, String secondaryUsage, String secondaryFault, String remark) {
        this.id = id;
        this.failBackMode = failBackMode;
        this.failBackPeriod = failBackPeriod;
        this.consumerLink = consumerLink;
        this.primary = primary;
        this.primaryUsage = primaryUsage;
        this.primaryFault = primaryFault;
        this.secondary = secondary;
        this.secondaryUsage = secondaryUsage;
        this.secondaryFault = secondaryFault;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "QkdPath{" +
                "id='" + id + '\'' +
                ", failBackMode='" + failBackMode + '\'' +
                ", failBackPeriod='" + failBackPeriod + '\'' +
                ", consumerLink='" + consumerLink + '\'' +
                ", primary='" + primary + '\'' +
                ", primaryUsage='" + primaryUsage + '\'' +
                ", primaryFault='" + primaryFault + '\'' +
                ", secondary='" + secondary + '\'' +
                ", secondaryUsage='" + secondaryUsage + '\'' +
                ", secondaryFault='" + secondaryFault + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
