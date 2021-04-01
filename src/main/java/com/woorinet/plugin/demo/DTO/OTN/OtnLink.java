package com.woorinet.plugin.demo.DTO.OTN;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Data
@Table(name="otn_link")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnLink {
    @Id
    @GeneratedValue
    String id;
    int emsId;
    int dstEmsId;
    String linkId;
    String linkNm;
    String srcNeId;
    String srcNeName;
    String srcNodeConnectorId;
    String dstNeId;
    String dstNeName;
    String dstNodeConnectorId;
    String linkType;
    String linkStatus;
    String linkCategory;
    String highOrderTunnel;
    String latency;
    String distance;
    String srlg;
    String ovpn;
    String timeslot;
    String lambda;
    int maximumOdu0s;
    int maximumOdu1s;
    int maximumOdu2s;
    int maximumOdu2es;
    int maximumOdu3s;
    int maximumOdu4s;
    int maximumOdu4cns;
    int maximumOduflexs;
    int availableOdu0s;
    int availableOdu1s;
    int availableOdu2s;
    int availableOdu2es;
    int availableOdu3s;
    int availableOdu4s;
    int availableOdu4cns;
    int availableOduflexs;
    String syncDate;

    public OtnLink() {

    }

    public OtnLink(int emsId, int dstEmsId, String linkId, String linkNm, String srcNeId, String srcNeName, String srcNodeConnectorId, String dstNeId, String dstNeName, String dstNodeConnectorId, String linkType, String linkStatus, String linkCategory, String highOrderTunnel, String latency, String distance, String srlg, String ovpn, String timeslot, String lambda, int maximumOdu0s, int maximumOdu1s, int maximumOdu2s, int maximumOdu2es, int maximumOdu3s, int maximumOdu4s, int maximumOdu4cns, int maximumOduflexs, int availableOdu0s, int availableOdu1s, int availableOdu2s, int availableOdu2es, int availableOdu3s, int availableOdu4s, int availableOdu4cns, int availableOduflexs, String syncDate) {
        this.emsId = emsId;
        this.dstEmsId = dstEmsId;
        this.linkId = linkId;
        this.linkNm = linkNm;
        this.srcNeId = srcNeId;
        this.srcNeName = srcNeName;
        this.srcNodeConnectorId = srcNodeConnectorId;
        this.dstNeId = dstNeId;
        this.dstNeName = dstNeName;
        this.dstNodeConnectorId = dstNodeConnectorId;
        this.linkType = linkType;
        this.linkStatus = linkStatus;
        this.linkCategory = linkCategory;
        this.highOrderTunnel = highOrderTunnel;
        this.latency = latency;
        this.distance = distance;
        this.srlg = srlg;
        this.ovpn = ovpn;
        this.timeslot = timeslot;
        this.lambda = lambda;
        this.maximumOdu0s = maximumOdu0s;
        this.maximumOdu1s = maximumOdu1s;
        this.maximumOdu2s = maximumOdu2s;
        this.maximumOdu2es = maximumOdu2es;
        this.maximumOdu3s = maximumOdu3s;
        this.maximumOdu4s = maximumOdu4s;
        this.maximumOdu4cns = maximumOdu4cns;
        this.maximumOduflexs = maximumOduflexs;
        this.availableOdu0s = availableOdu0s;
        this.availableOdu1s = availableOdu1s;
        this.availableOdu2s = availableOdu2s;
        this.availableOdu2es = availableOdu2es;
        this.availableOdu3s = availableOdu3s;
        this.availableOdu4s = availableOdu4s;
        this.availableOdu4cns = availableOdu4cns;
        this.availableOduflexs = availableOduflexs;
        this.syncDate = syncDate;
    }
}
