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
@Getter
@Setter
@Table(name = "otn_pm_optic_temperature")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnPmOpticTemperature {
    @Id
    @GeneratedValue
    int pmOpticTemperatureId;
    String tid;
    String systemType;
    String slot;
    String time;
    String max;
    String min;
    String average;
    String date;

    public OtnPmOpticTemperature() {
    }

    @Override
    public String toString() {
        return "OtnPmOpticTemperature{" +
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

    public OtnPmOpticTemperature(String tid, String systemType, String slot, String time, String max, String min, String average, String date) {
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
