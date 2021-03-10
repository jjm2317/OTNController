package com.woorinet.plugin.demo.DTO.HOLA;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Data
@Entity
@Table(name="hola_sdn_otn_material")
public class HolaSdnOtnMaterial {
    @Id
    @GeneratedValue
    int HOLA_SDN_OTN_MATERIAL;
    String VENDOR;
    String CELL;
    String NODE;
    String IP;
    String SHELF;
    String UNIT_LIST;
}
