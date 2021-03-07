package com.woorinet.plugin.demo.DTO.SDN;


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
@Table(name="sdn_crypto_module")
public class SdnCryptoModule {
    @Id
    @GeneratedValue
    int CRYPTO_MODULE_ID;
    String AID;
    String MODULE_ACT_TYPE;
    String MID;
    String PMID;
    String MID_CONTEXT;
    String PMID_CONTEXT;
    String BYPASS_MODE;
    String CRYPTO_MODE;
    String CRYPTO_MODULE_PKG_VERSION;
    String CRYPTO_MODULE_FPGA_VERSION;
    String CRYPTO_MODULE_CPLD_VERSION;
    String CRYPTO_MODULE_HW_VERSION;

    public SdnCryptoModule() {
    }

    public SdnCryptoModule(String AID, String MODULE_ACT_TYPE, String MID, String PMID, String MID_CONTEXT, String PMID_CONTEXT, String BYPASS_MODE, String CRYPTO_MODE, String CRYPTO_MODULE_PKG_VERSION, String CRYPTO_MODULE_FPGA_VERSION, String CRYPTO_MODULE_CPLD_VERSION, String CRYPTO_MODULE_HW_VERSION) {
        this.AID = AID;
        this.MODULE_ACT_TYPE = MODULE_ACT_TYPE;
        this.MID = MID;
        this.PMID = PMID;
        this.MID_CONTEXT = MID_CONTEXT;
        this.PMID_CONTEXT = PMID_CONTEXT;
        this.BYPASS_MODE = BYPASS_MODE;
        this.CRYPTO_MODE = CRYPTO_MODE;
        this.CRYPTO_MODULE_PKG_VERSION = CRYPTO_MODULE_PKG_VERSION;
        this.CRYPTO_MODULE_FPGA_VERSION = CRYPTO_MODULE_FPGA_VERSION;
        this.CRYPTO_MODULE_CPLD_VERSION = CRYPTO_MODULE_CPLD_VERSION;
        this.CRYPTO_MODULE_HW_VERSION = CRYPTO_MODULE_HW_VERSION;
    }

    @Override
    public String toString() {
        return "SdnCryptoModule{" +
                "AID='" + AID + '\'' +
                ", MODULE_ACT_TYPE='" + MODULE_ACT_TYPE + '\'' +
                ", MID='" + MID + '\'' +
                ", PMID='" + PMID + '\'' +
                ", MID_CONTEXT='" + MID_CONTEXT + '\'' +
                ", PMID_CONTEXT='" + PMID_CONTEXT + '\'' +
                ", BYPASS_MODE='" + BYPASS_MODE + '\'' +
                ", CRYPTO_MODE='" + CRYPTO_MODE + '\'' +
                ", CRYPTO_MODULE_PKG_VERSION='" + CRYPTO_MODULE_PKG_VERSION + '\'' +
                ", CRYPTO_MODULE_FPGA_VERSION='" + CRYPTO_MODULE_FPGA_VERSION + '\'' +
                ", CRYPTO_MODULE_CPLD_VERSION='" + CRYPTO_MODULE_CPLD_VERSION + '\'' +
                ", CRYPTO_MODULE_HW_VERSION='" + CRYPTO_MODULE_HW_VERSION + '\'' +
                '}';
    }
}
