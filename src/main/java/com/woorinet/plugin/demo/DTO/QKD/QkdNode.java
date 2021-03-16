package com.woorinet.plugin.demo.DTO.QKD;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Setter
@Getter

public class QkdNode {
    @Id
    @GeneratedValue
    int QKD_NODE_ID;
}
