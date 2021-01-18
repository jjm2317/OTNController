package com.woorinet.plugin.demo.DTO.QNET;

public class CONSUMERLINK {
    String ID;
    String UID;
    String NAME;
    String OPERMODE;
    String SOURCE;
    String DEST;
    String PRESHAREDKEY;
    String QKEYSTORE;

    public CONSUMERLINK(String ID, String UID, String NAME, String OPERMODE, String SOURCE, String DEST, String PRESHAREDKEY, String QKEYSTORE) {
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.OPERMODE = OPERMODE;
        this.SOURCE = SOURCE;
        this.DEST = DEST;
        this.PRESHAREDKEY = PRESHAREDKEY;
        this.QKEYSTORE = QKEYSTORE;
    }

    public CONSUMERLINK(String[] fields) {
        ID = fields[0];
        UID = fields[1];
        NAME = fields[2];
        OPERMODE = fields[3];
        SOURCE = fields[4];
        DEST = fields[5];
        PRESHAREDKEY = fields[6];
        QKEYSTORE = fields[7];
    }

    @Override
    public String toString() {
        return "CONSUMERLINK{" +
                "ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", OPERMODE='" + OPERMODE + '\'' +
                ", SOURCE='" + SOURCE + '\'' +
                ", DEST='" + DEST + '\'' +
                ", PRESHAREDKEY='" + PRESHAREDKEY + '\'' +
                ", QKEYSTORE='" + QKEYSTORE + '\'' +
                '}';
    }
}
