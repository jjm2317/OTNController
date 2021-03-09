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
@Entity
@Data
@Table(name="hola_sdn_line_num_sheet")
public class HolaSdnLineNumSheet {
    @Id
    @GeneratedValue
    int LINE_NUM_SHEET_ID;
    String GROUP;
    String DOMAIN_TYPE;
    String AREA_START;
    String AREA_END;
    String NODE_START;
    String NODE_END;
    String CIRCUIT_ID;
    String AUTO_SERVICE_NAME;
    String INPUT_SERVICE_NAME;
    String SERVICE_TYPE;
    String VENDOR;
    String CONSTRAINT_ID;
    String PROTECTIOM_TYPE;
    String SERVICE_RATE;
    String SERVICE_STATUS;
    String ACTIVE_PATH;
    String TRAFFIC_STATUS;
    String HOME_PATH;
    String LATENCY;
    String CABLE_CREATION_DATE;
    String NETWORK_CABLE_NUMBER;
    String WRITER;
    String REMARKS;
    String ENDPOINT_CLIENT_START;
    String TRANSMIT_CLIENT_START;
    String LINK_START;
    String ROADM_MUX_START;
    String ROADM_MUX_END;
    String LINK_END;
    String TRANSMIT_CLIENT_END;
    String ENDPOINT_CLIENT_END;
    String MAIN_PATH;
    String BYPASS_PATH;

    public HolaSdnLineNumSheet() {
    }

    public HolaSdnLineNumSheet(String GROUP, String DOMAIN_TYPE, String AREA_START, String AREA_END, String NODE_START, String NODE_END, String CIRCUIT_ID, String AUTO_SERVICE_NAME, String INPUT_SERVICE_NAME, String SERVICE_TYPE, String VENDOR, String CONSTRAINT_ID, String PROTECTIOM_TYPE, String SERVICE_RATE, String SERVICE_STATUS, String ACTIVE_PATH, String TRAFFIC_STATUS, String HOME_PATH, String LATENCY, String CABLE_CREATION_DATE, String NETWORK_CABLE_NUMBER, String WRITER, String REMARKS, String ENDPOINT_CLIENT_START, String TRANSMIT_CLIENT_START, String LINK_START, String ROADM_MUX_START, String ROADM_MUX_END, String LINK_END, String TRANSMIT_CLIENT_END, String ENDPOINT_CLIENT_END, String MAIN_PATH, String BYPASS_PATH) {
        this.GROUP = GROUP;
        this.DOMAIN_TYPE = DOMAIN_TYPE;
        this.AREA_START = AREA_START;
        this.AREA_END = AREA_END;
        this.NODE_START = NODE_START;
        this.NODE_END = NODE_END;
        this.CIRCUIT_ID = CIRCUIT_ID;
        this.AUTO_SERVICE_NAME = AUTO_SERVICE_NAME;
        this.INPUT_SERVICE_NAME = INPUT_SERVICE_NAME;
        this.SERVICE_TYPE = SERVICE_TYPE;
        this.VENDOR = VENDOR;
        this.CONSTRAINT_ID = CONSTRAINT_ID;
        this.PROTECTIOM_TYPE = PROTECTIOM_TYPE;
        this.SERVICE_RATE = SERVICE_RATE;
        this.SERVICE_STATUS = SERVICE_STATUS;
        this.ACTIVE_PATH = ACTIVE_PATH;
        this.TRAFFIC_STATUS = TRAFFIC_STATUS;
        this.HOME_PATH = HOME_PATH;
        this.LATENCY = LATENCY;
        this.CABLE_CREATION_DATE = CABLE_CREATION_DATE;
        this.NETWORK_CABLE_NUMBER = NETWORK_CABLE_NUMBER;
        this.WRITER = WRITER;
        this.REMARKS = REMARKS;
        this.ENDPOINT_CLIENT_START = ENDPOINT_CLIENT_START;
        this.TRANSMIT_CLIENT_START = TRANSMIT_CLIENT_START;
        this.LINK_START = LINK_START;
        this.ROADM_MUX_START = ROADM_MUX_START;
        this.ROADM_MUX_END = ROADM_MUX_END;
        this.LINK_END = LINK_END;
        this.TRANSMIT_CLIENT_END = TRANSMIT_CLIENT_END;
        this.ENDPOINT_CLIENT_END = ENDPOINT_CLIENT_END;
        this.MAIN_PATH = MAIN_PATH;
        this.BYPASS_PATH = BYPASS_PATH;
    }

    @Override
    public String toString() {
        return "HolaSdnLineNumSheet{" +
                "LINE_NUM_SHEET_ID=" + LINE_NUM_SHEET_ID +
                ", GROUP='" + GROUP + '\'' +
                ", DOMAIN_TYPE='" + DOMAIN_TYPE + '\'' +
                ", AREA_START='" + AREA_START + '\'' +
                ", AREA_END='" + AREA_END + '\'' +
                ", NODE_START='" + NODE_START + '\'' +
                ", NODE_END='" + NODE_END + '\'' +
                ", CIRCUIT_ID='" + CIRCUIT_ID + '\'' +
                ", AUTO_SERVICE_NAME='" + AUTO_SERVICE_NAME + '\'' +
                ", INPUT_SERVICE_NAME='" + INPUT_SERVICE_NAME + '\'' +
                ", SERVICE_TYPE='" + SERVICE_TYPE + '\'' +
                ", VENDOR='" + VENDOR + '\'' +
                ", CONSTRAINT_ID='" + CONSTRAINT_ID + '\'' +
                ", PROTECTIOM_TYPE='" + PROTECTIOM_TYPE + '\'' +
                ", SERVICE_RATE='" + SERVICE_RATE + '\'' +
                ", SERVICE_STATUS='" + SERVICE_STATUS + '\'' +
                ", ACTIVE_PATH='" + ACTIVE_PATH + '\'' +
                ", TRAFFIC_STATUS='" + TRAFFIC_STATUS + '\'' +
                ", HOME_PATH='" + HOME_PATH + '\'' +
                ", LATENCY='" + LATENCY + '\'' +
                ", CABLE_CREATION_DATE='" + CABLE_CREATION_DATE + '\'' +
                ", NETWORK_CABLE_NUMBER='" + NETWORK_CABLE_NUMBER + '\'' +
                ", WRITER='" + WRITER + '\'' +
                ", REMARKS='" + REMARKS + '\'' +
                ", ENDPOINT_CLIENT_START='" + ENDPOINT_CLIENT_START + '\'' +
                ", TRANSMIT_CLIENT_START='" + TRANSMIT_CLIENT_START + '\'' +
                ", LINK_START='" + LINK_START + '\'' +
                ", ROADM_MUX_START='" + ROADM_MUX_START + '\'' +
                ", ROADM_MUX_END='" + ROADM_MUX_END + '\'' +
                ", LINK_END='" + LINK_END + '\'' +
                ", TRANSMIT_CLIENT_END='" + TRANSMIT_CLIENT_END + '\'' +
                ", ENDPOINT_CLIENT_END='" + ENDPOINT_CLIENT_END + '\'' +
                ", MAIN_PATH='" + MAIN_PATH + '\'' +
                ", BYPASS_PATH='" + BYPASS_PATH + '\'' +
                '}';
    }
}