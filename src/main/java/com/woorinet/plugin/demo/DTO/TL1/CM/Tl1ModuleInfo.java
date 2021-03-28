package com.woorinet.plugin.demo.DTO.TL1.CM;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Setter
@Getter
@Table(name = "tl1_module_info")
public class Tl1ModuleInfo {
    @Id
    @GeneratedValue
    int moduleInfoId;
    String tid;
    String subnetwork;
    String aid;
    String mid;
    String midContext;
    String pmid;
    String pmidContext;
    String operationState;
    String operationStateReason;
    String cryptoMode;
    String syncDate;

    public Tl1ModuleInfo() {
    }

    public Tl1ModuleInfo(String tid, String subnetwork, String aid, String mid, String midContext, String pmid, String pmidContext, String operationState, String operationStateReason, String cryptoMode, String syncDate) {
        this.tid = tid;
        this.subnetwork = subnetwork;
        this.aid = aid;
        this.mid = mid;
        this.midContext = midContext;
        this.pmid = pmid;
        this.pmidContext = pmidContext;
        this.operationState = operationState;
        this.operationStateReason = operationStateReason;
        this.cryptoMode = cryptoMode;
        this.syncDate = syncDate;
    }

    public Tl1ModuleInfo(String[] fields, String syncDate) {
        this.tid = fields[0];
        this.subnetwork = fields[1];
        this.aid = fields[2];
        this.mid = fields[3];
        this.midContext = fields[4];
        this.pmid = fields[5];
        this.pmidContext = fields[6];
        this.operationState = fields[7];
        this.operationStateReason = fields[8];
        this.cryptoMode = fields[9];
        this.syncDate = syncDate;
    }

    @Override
    public String toString() {
        return "Tl1ModuleInfo{" +
                "tid='" + tid + '\'' +
                ", subnetwork='" + subnetwork + '\'' +
                ", aid='" + aid + '\'' +
                ", mid='" + mid + '\'' +
                ", midContext='" + midContext + '\'' +
                ", pmid='" + pmid + '\'' +
                ", pmidContext='" + pmidContext + '\'' +
                ", operationState='" + operationState + '\'' +
                ", operationStateReason='" + operationStateReason + '\'' +
                ", cryptoMode='" + cryptoMode + '\'' +
                ", syncDate='" + syncDate + '\'' +
                '}';
    }
}
