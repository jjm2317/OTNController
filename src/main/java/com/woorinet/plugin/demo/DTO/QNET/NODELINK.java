package com.woorinet.plugin.demo.DTO.QNET;

public class NODELINK {
    String ID;
    String NAME;
    String UID;
    String TYPE;
    String ALGORITHM;
    String WEIGHT;
    String PSK;
    String SOURCE;
    String DEST;

    public NODELINK(String ID, String NAME, String UID, String TYPE, String ALGORITHM, String WEIGHT, String PSK, String SOURCE, String DEST) {
        this.ID = ID;
        this.NAME = NAME;
        this.UID = UID;
        this.TYPE = TYPE;
        this.ALGORITHM = ALGORITHM;
        this.WEIGHT = WEIGHT;
        this.PSK = PSK;
        this.SOURCE = SOURCE;
        this.DEST = DEST;
    }

    public NODELINK(String[] fields) {
        ID = fields[0];
        NAME = fields[1];
        UID = fields[2];
        TYPE = fields[3];
        ALGORITHM = fields[4];
        WEIGHT = fields[5];
        PSK = fields[6];
        SOURCE = fields[7];
        DEST = fields[8];
    }

    @Override
    public String toString() {
        return "NODELINK{" +
                "ID='" + ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", UID='" + UID + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", ALGORITHM='" + ALGORITHM + '\'' +
                ", WEIGHT='" + WEIGHT + '\'' +
                ", PSK='" + PSK + '\'' +
                ", SOURCE='" + SOURCE + '\'' +
                ", DEST='" + DEST + '\'' +
                '}';
    }
}
