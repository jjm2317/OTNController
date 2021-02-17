package com.woorinet.plugin.demo.DTO.SDN;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Data
public class CONSTRAINT {
    int ems_id;
    String service_id;
    @Id
    @Generated
    String const_id;
    String const_type;
    String const_name;
    String const_value;
    String const_operator;

    public CONSTRAINT() {

    }

    public CONSTRAINT(int ems_id, String service_id, String const_id, String const_type, String const_name, String const_value, String const_operator) {
        this.ems_id = ems_id;
        this.service_id = service_id;
        this.const_id = const_id;
        this.const_type = const_type;
        this.const_name = const_name;
        this.const_value = const_value;
        this.const_operator = const_operator;
    }

    @Override
    public String toString() {
        return "CONSTRAINT{" +
                "ems_id=" + ems_id +
                ", service_id='" + service_id + '\'' +
                ", const_id='" + const_id + '\'' +
                ", const_type='" + const_type + '\'' +
                ", const_name='" + const_name + '\'' +
                ", const_value='" + const_value + '\'' +
                ", const_operator='" + const_operator + '\'' +
                '}';
    }
}
