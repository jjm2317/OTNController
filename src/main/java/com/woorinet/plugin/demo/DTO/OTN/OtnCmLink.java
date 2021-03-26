package com.woorinet.plugin.demo.DTO.OTN;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
@Data
public class OtnCmLink {
    @Id
    @GeneratedValue
    int otnCmLinkId;
    String tid;
    String slot;
    String port;
    String unitType;
    String signal ;
    String mid;
    String midContext;
    String pmid;
    String pmidContext;
    String operationState;
    String operationStateReason;
    String cryptoMode;

    public OtnCmLink() {
    }

    public OtnCmLink(String tid, String slot, String port, String unitType, String signal, String mid, String midContext, String pmid, String pmidContext, String operationState, String operationStateReason, String cryptoMode) {
        this.tid = tid;
        this.slot = slot;
        this.port = port;
        this.unitType = unitType;
        this.signal = signal;
        this.mid = mid;
        this.midContext = midContext;
        this.pmid = pmid;
        this.pmidContext = pmidContext;
        this.operationState = operationState;
        this.operationStateReason = operationStateReason;
        this.cryptoMode = cryptoMode;
    }

    @Override
    public String toString() {
        return "OtnCmLink{" +
                "tid='" + tid + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", unitType='" + unitType + '\'' +
                ", signal='" + signal + '\'' +
                ", mid='" + mid + '\'' +
                ", midContext='" + midContext + '\'' +
                ", pmid='" + pmid + '\'' +
                ", pmidContext='" + pmidContext + '\'' +
                ", operationState='" + operationState + '\'' +
                ", operationStateReason='" + operationStateReason + '\'' +
                ", cryptoMode='" + cryptoMode + '\'' +
                '}';
    }
}
