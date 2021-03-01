package com.woorinet.plugin.demo.DTO.TL1;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Data
@Entity
@Table(name = "tl1_access_if")
public class Tl1AccessIf {
    String TID_ID;
    String TID;
    String SUBNET_ID;
    String SUBNET;
    @Id
    @Generated
    String ACCESS_IF_ID;
    String LOCAL_ID;
    String REQUEST_ID;
    String NAME;
    String ACCESS_IF_TYPE;
    String ACCESS_IF_OPERATIONAL_STATUS;
    String ACCESS_IF_CONFIGURATION_ACTION;
    String ACCESS_IF_CONFIGURATION_RESULT;
    String DEPLOYMENT_ENABLER;
    String DEPLOYMENT_STATUS;
    String CIR;
    String PIR;
    String SERVICE_TYPE;
    String CONSTRAINT_ID;
    String COMMON_CONSTRAINT_NAME;
    String COMMON_CONSTRAINT_VALUE;
    String COMMON_CONSTRAINT_OPERATOR;
    String PORT_CONSTRAINT_TYPE;
    String AC2AC_TYPE;

    public Tl1AccessIf() {

    }

    public Tl1AccessIf(String TID_ID, String TID, String SUBNET_ID, String SUBNET, String ACCESS_IF_ID, String LOCAL_ID, String REQUEST_ID, String NAME, String ACCESS_IF_TYPE, String ACCESS_IF_OPERATIONAL_STATUS, String ACCESS_IF_CONFIGURATION_ACTION, String ACCESS_IF_CONFIGURATION_RESULT, String DEPLOYMENT_ENABLER, String DEPLOYMENT_STATUS, String CIR, String PIR, String SERVICE_TYPE, String CONSTRAINT_ID, String COMMON_CONSTRAINT_NAME, String COMMON_CONSTRAINT_VALUE, String COMMON_CONSTRAINT_OPERATOR, String PORT_CONSTRAINT_TYPE, String AC2AC_TYPE) {
        this.TID_ID = TID_ID;
        this.TID = TID;
        this.SUBNET_ID = SUBNET_ID;
        this.SUBNET = SUBNET;
        this.ACCESS_IF_ID = ACCESS_IF_ID;
        this.LOCAL_ID = LOCAL_ID;
        this.REQUEST_ID = REQUEST_ID;
        this.NAME = NAME;
        this.ACCESS_IF_TYPE = ACCESS_IF_TYPE;
        this.ACCESS_IF_OPERATIONAL_STATUS = ACCESS_IF_OPERATIONAL_STATUS;
        this.ACCESS_IF_CONFIGURATION_ACTION = ACCESS_IF_CONFIGURATION_ACTION;
        this.ACCESS_IF_CONFIGURATION_RESULT = ACCESS_IF_CONFIGURATION_RESULT;
        this.DEPLOYMENT_ENABLER = DEPLOYMENT_ENABLER;
        this.DEPLOYMENT_STATUS = DEPLOYMENT_STATUS;
        this.CIR = CIR;
        this.PIR = PIR;
        this.SERVICE_TYPE = SERVICE_TYPE;
        this.CONSTRAINT_ID = CONSTRAINT_ID;
        this.COMMON_CONSTRAINT_NAME = COMMON_CONSTRAINT_NAME;
        this.COMMON_CONSTRAINT_VALUE = COMMON_CONSTRAINT_VALUE;
        this.COMMON_CONSTRAINT_OPERATOR = COMMON_CONSTRAINT_OPERATOR;
        this.PORT_CONSTRAINT_TYPE = PORT_CONSTRAINT_TYPE;
        this.AC2AC_TYPE = AC2AC_TYPE;
    }

    public Tl1AccessIf(String[] fields) {
        this.TID_ID = fields[0];
        this.TID = fields[1];
        this.SUBNET_ID = fields[2];
        this.SUBNET = fields[3];
        this.ACCESS_IF_ID = fields[4];
        this.LOCAL_ID = fields[5];
        this.REQUEST_ID = fields[6];
        this.NAME = fields[7];
        this.ACCESS_IF_TYPE = fields[8];
        this.ACCESS_IF_OPERATIONAL_STATUS = fields[9];
        this.ACCESS_IF_CONFIGURATION_ACTION = fields[10];
        this.ACCESS_IF_CONFIGURATION_RESULT = fields[11];
        this.DEPLOYMENT_ENABLER = fields[12];
        this.DEPLOYMENT_STATUS = fields[13];
        this.CIR = fields[14];
        this.PIR = fields[15];
        this.SERVICE_TYPE = fields[16];
        this.CONSTRAINT_ID = fields[17];
        this.COMMON_CONSTRAINT_NAME = fields[18];
        this.COMMON_CONSTRAINT_VALUE = fields[19];
        this.COMMON_CONSTRAINT_OPERATOR = fields[20];
        this.PORT_CONSTRAINT_TYPE = fields[21];
        this.AC2AC_TYPE = fields[22];
    }

    @Override
    public String toString() {
        return "ACCESS_IF{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", ACCESS_IF_ID='" + ACCESS_IF_ID + '\'' +
                ", LOCAL_ID='" + LOCAL_ID + '\'' +
                ", REQUEST_ID='" + REQUEST_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ACCESS_IF_TYPE='" + ACCESS_IF_TYPE + '\'' +
                ", ACCESS_IF_OPERATIONAL_STATUS='" + ACCESS_IF_OPERATIONAL_STATUS + '\'' +
                ", ACCESS_IF_CONFIGURATION_ACTION='" + ACCESS_IF_CONFIGURATION_ACTION + '\'' +
                ", ACCESS_IF_CONFIGURATION_RESULT='" + ACCESS_IF_CONFIGURATION_RESULT + '\'' +
                ", DEPLOYMENT_ENABLER='" + DEPLOYMENT_ENABLER + '\'' +
                ", DEPLOYMENT_STATUS='" + DEPLOYMENT_STATUS + '\'' +
                ", CIR='" + CIR + '\'' +
                ", PIR='" + PIR + '\'' +
                ", SERVICE_TYPE='" + SERVICE_TYPE + '\'' +
                ", CONSTRAINT_ID='" + CONSTRAINT_ID + '\'' +
                ", COMMON_CONSTRAINT_NAME='" + COMMON_CONSTRAINT_NAME + '\'' +
                ", COMMON_CONSTRAINT_VALUE='" + COMMON_CONSTRAINT_VALUE + '\'' +
                ", COMMON_CONSTRAINT_OPERATOR='" + COMMON_CONSTRAINT_OPERATOR + '\'' +
                ", PORT_CONSTRAINT_TYPE='" + PORT_CONSTRAINT_TYPE + '\'' +
                ", AC2AC_TYPE='" + AC2AC_TYPE + '\'' +
                '}';
    }
}
