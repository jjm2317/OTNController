package com.woorinet.plugin.demo.DTO.OTN.PM;

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
@Table(name = "otn_pm_temperature")
public class OtnPmTemperature {
    @Id
    @GeneratedValue
    int pmTemperatureId;
    String tid;
    String systemType;
    String slot;
    String time;
    String max;
    String min;
    String average;
    String date;

    public OtnPmTemperature() {
    }

    @Override
    public String toString() {
        return "OtnPmTemperature{" +
                "tid='" + tid + '\'' +
                ", systemType='" + systemType + '\'' +
                ", slot='" + slot + '\'' +
                ", time='" + time + '\'' +
                ", max='" + max + '\'' +
                ", min='" + min + '\'' +
                ", average='" + average + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public OtnPmTemperature(String tid, String systemType, String slot, String time, String max, String min, String average, String date) {
        this.tid = tid;
        this.systemType = systemType;
        this.slot = slot;
        this.time = time;
        this.max = max;
        this.min = min;
        this.average = average;
        this.date = date;
    }
}
