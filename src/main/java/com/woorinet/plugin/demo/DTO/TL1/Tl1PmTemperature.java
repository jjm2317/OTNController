package com.woorinet.plugin.demo.DTO.TL1;

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
@Table(name = "tl1_pm_temperature")
public class Tl1PmTemperature {
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

    public Tl1PmTemperature() {

    }

    @Override
    public String toString() {
        return "Tl1PmTemperature{" +
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

    public Tl1PmTemperature(String tid, String systemType, String slot, String time, String max, String min, String average, String date) {
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
