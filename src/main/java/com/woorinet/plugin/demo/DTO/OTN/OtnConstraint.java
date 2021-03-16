package com.woorinet.plugin.demo.DTO.OTN;


import lombok.Data;
import lombok.Generated;
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
@Table(name="otn_constraint")
public class OtnConstraint {
    @Id
    @GeneratedValue
    @Generated
    int id;
    int ems_id;
    String service_id;
    String const_id;
    String const_type;
    String const_name;
    String const_value;
    String const_operator;

    public OtnConstraint() {

    }

    public OtnConstraint(int ems_id, String service_id, String const_id, String const_type, String const_name, String const_value, String const_operator) {
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
