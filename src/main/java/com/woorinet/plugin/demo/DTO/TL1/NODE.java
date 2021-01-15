package com.woorinet.plugin.demo.DTO.TL1;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NODE {
    String TID_ID;
    String TID;
    String NODE_TYPE;
    String IP_ADDR;
    String MANUFACTURE;
    String HARDWARE;
    String SOFTWARE;
    String SERIAL_NUMBER;
    String NODE_STATUS;
    String SUBNET;
    String SUBNET_ID;
    String SYSTEM_TYPE;

    public NODE(String TID_ID, String TID, String NODE_TYPE, String IP_ADDR, String MANUFACTURE, String HARDWARE, String SOFTWARE, String SERIAL_NUMBER, String NODE_STATUS, String SUBNET, String SUBNET_ID, String SYSTEM_TYPE) {
        this.TID_ID = TID_ID;
        this.TID = TID;
        this.NODE_TYPE = NODE_TYPE;
        this.IP_ADDR = IP_ADDR;
        this.MANUFACTURE = MANUFACTURE;
        this.HARDWARE = HARDWARE;
        this.SOFTWARE = SOFTWARE;
        this.SERIAL_NUMBER = SERIAL_NUMBER;
        this.NODE_STATUS = NODE_STATUS;
        this.SUBNET = SUBNET;
        this.SUBNET_ID = SUBNET_ID;
        this.SYSTEM_TYPE = SYSTEM_TYPE;
    }

    public NODE(String[] fields) {
        TID_ID = fields[0];
        TID = fields[1];
        NODE_TYPE = fields[2];
        IP_ADDR = fields[3];
        MANUFACTURE = fields[4];
        HARDWARE = fields[5];
        SOFTWARE = fields[6];
        SERIAL_NUMBER = fields[7];
        NODE_STATUS = fields[8];
        SUBNET = fields[9];
        SUBNET_ID = fields[10];
        SYSTEM_TYPE = fields[11];
    }

    @Override
    public String toString() {
        return "Node{" +
                "TID_ID='" + TID_ID + '\'' +
                ", TID='" + TID + '\'' +
                ", NODE_TYPE='" + NODE_TYPE + '\'' +
                ", IP_ADDR='" + IP_ADDR + '\'' +
                ", MANUFACTURE='" + MANUFACTURE + '\'' +
                ", HARDWARE='" + HARDWARE + '\'' +
                ", SOFTWARE='" + SOFTWARE + '\'' +
                ", SERIAL_NUMBER='" + SERIAL_NUMBER + '\'' +
                ", NODE_STATUS='" + NODE_STATUS + '\'' +
                ", SUBNET='" + SUBNET + '\'' +
                ", SUBNET_ID='" + SUBNET_ID + '\'' +
                ", SYSTEM_TYPE='" + SYSTEM_TYPE + '\'' +
                '}';
    }
}
