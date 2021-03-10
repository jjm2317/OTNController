package com.woorinet.plugin.demo.DTO.HOLA;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Data
@Entity
@Table(name="hola_sdn_otn_node_usage")
public class HolaSdnOtnNodeUsage {
    @Id
    @GeneratedValue
    int HOLA_SDN_OTN_NODE_USAGE;
    String AREA;
    String CITY;
    String MOUNTING_STATUS;
}
