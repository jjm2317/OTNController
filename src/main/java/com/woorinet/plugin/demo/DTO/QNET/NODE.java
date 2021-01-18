package com.woorinet.plugin.demo.DTO.QNET;

public class NODE {
    String ID;
    String UID;
    String NAME;
    String ENABLED;
    String DESCRIPTION;
    String GROUPID;
    String GROUPSTR;
    String UNIQUEID;
    String QNCWEBAPIURL;
    String QNCWEBAPIAUTH;
    String CERT;
    String KEMS_CERT;
    String NETWORK;
    String CONSUMERS;
    String PROVIDERS;
    String LOCX;
    String LOCY;
    String LAT;
    String LON;

    public NODE(String ID, String UID, String NAME, String ENABLED, String DESCRIPTION, String GROUPID, String GROUPSTR, String UNIQUEID, String QNCWEBAPIURL, String QNCWEBAPIAUTH, String CERT, String KEMS_CERT, String NETWORK, String CONSUMERS, String PROVIDERS, String LOCX, String LOCY, String LAT, String LON) {
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.ENABLED = ENABLED;
        this.DESCRIPTION = DESCRIPTION;
        this.GROUPID = GROUPID;
        this.GROUPSTR = GROUPSTR;
        this.UNIQUEID = UNIQUEID;
        this.QNCWEBAPIURL = QNCWEBAPIURL;
        this.QNCWEBAPIAUTH = QNCWEBAPIAUTH;
        this.CERT = CERT;
        this.KEMS_CERT = KEMS_CERT;
        this.NETWORK = NETWORK;
        this.CONSUMERS = CONSUMERS;
        this.PROVIDERS = PROVIDERS;
        this.LOCX = LOCX;
        this.LOCY = LOCY;
        this.LAT = LAT;
        this.LON = LON;
    }

    public NODE(String[] fields) {
         ID  = fields[0];
         UID = fields[1];
         NAME = fields[2];
         ENABLED = fields[3];
         DESCRIPTION = fields[4];
         GROUPID = fields[5];
        GROUPSTR = fields[6];
         UNIQUEID = fields[7];
         QNCWEBAPIURL = fields[8];
         QNCWEBAPIAUTH = fields[9];
         CERT = fields[10];
         KEMS_CERT = fields[11];
         NETWORK = fields[12];
         CONSUMERS = fields[13];
         PROVIDERS = fields[14];
         LOCX = fields[15];
         LOCY = fields[16];
         LAT = fields[17];
         LON = fields[18];
    }


    @Override
    public String toString() {
        return "NODE{" +
                "ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ENABLED='" + ENABLED + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", GROUPID='" + GROUPID + '\'' +
                ", GROUPSTR='" + GROUPSTR + '\'' +
                ", UNIQUEID='" + UNIQUEID + '\'' +
                ", QNCWEBAPIURL='" + QNCWEBAPIURL + '\'' +
                ", QNCWEBAPIAUTH='" + QNCWEBAPIAUTH + '\'' +
                ", CERT='" + CERT + '\'' +
                ", KEMS_CERT='" + KEMS_CERT + '\'' +
                ", NETWORK='" + NETWORK + '\'' +
                ", CONSUMERS='" + CONSUMERS + '\'' +
                ", PROVIDERS='" + PROVIDERS + '\'' +
                ", LOCX='" + LOCX + '\'' +
                ", LOCY='" + LOCY + '\'' +
                ", LAT='" + LAT + '\'' +
                ", LON='" + LON + '\'' +
                '}';
    }



}
