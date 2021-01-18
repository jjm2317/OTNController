package com.woorinet.plugin.demo.DTO.QNET;

public class PROVIDERLINK {
    String ID;
    String UID;
    String NAME;
    String MODE;
    String SOURCE;
    String DESTINATION;
    String QKEYSTORE;

    public PROVIDERLINK(String ID, String UID, String NAME, String MODE, String SOURCE, String DESTINATION, String QKEYSTORE) {
        this.ID = ID;
        this.UID = UID;
        this.NAME = NAME;
        this.MODE = MODE;
        this.SOURCE = SOURCE;
        this.DESTINATION = DESTINATION;
        this.QKEYSTORE = QKEYSTORE;
    }

    public PROVIDERLINK(String[] fields) {
        ID = fields[0];
        UID = fields[1];
        NAME = fields[2];
        MODE = fields[3];
        SOURCE = fields[4];
        DESTINATION = fields[5];
        QKEYSTORE = fields[6];
    }

    @Override
    public String toString() {
        return "PROVIDERLINK{" +
                "ID='" + ID + '\'' +
                ", UID='" + UID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", MODE='" + MODE + '\'' +
                ", SOURCE='" + SOURCE + '\'' +
                ", DESTINATION='" + DESTINATION + '\'' +
                ", QKEYSTORE='" + QKEYSTORE + '\'' +
                '}';
    }
}
