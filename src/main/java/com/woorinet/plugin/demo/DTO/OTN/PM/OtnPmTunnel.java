package com.woorinet.plugin.demo.DTO.OTN.PM;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Setter
@Getter
@Table(name = "otn_pm_tunnel")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnPmTunnel {
    @Id
    @GeneratedValue
    int pmTunnelId;
    String tid;
    String systemType;
    String slot;
    String port;
    String time;
    String name;
    String ingPackets;
    String ingBytes;
    String ingRate;
    String egrPackets;
    String egrBytes;
    String egrRate;
    String date;
    String syncDate;

    public OtnPmTunnel() {

    }

    @Override
    public String toString() {
        return "OtnPmTunnel{" +
                "tid='" + tid + '\'' +
                ", systemType='" + systemType + '\'' +
                ", slot='" + slot + '\'' +
                ", port='" + port + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", ingPackets='" + ingPackets + '\'' +
                ", ingBytes='" + ingBytes + '\'' +
                ", ingRate='" + ingRate + '\'' +
                ", egrPackets='" + egrPackets + '\'' +
                ", egrBytes='" + egrBytes + '\'' +
                ", egrRate='" + egrRate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public OtnPmTunnel(String tid, String systemType, String slot, String port, String time, String name, String ingPackets, String ingBytes, String ingRate, String egrPackets, String egrBytes, String egrRate, String date, String syncDate) {
        this.tid = tid;
        this.systemType = systemType;
        this.slot = slot;
        this.port = port;
        this.time = time;
        this.name = name;
        this.ingPackets = ingPackets;
        this.ingBytes = ingBytes;
        this.ingRate = ingRate;
        this.egrPackets = egrPackets;
        this.egrBytes = egrBytes;
        this.egrRate = egrRate;
        this.date = date;
        this.syncDate = syncDate;
    }
}
