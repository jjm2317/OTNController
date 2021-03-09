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
@Table
public class HolaSdnTrunkUsage {
    @Id
    @GeneratedValue
    int HOLA_SDN_TRUNK_USAGE;
}
