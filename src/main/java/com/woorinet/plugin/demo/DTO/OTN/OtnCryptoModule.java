package com.woorinet.plugin.demo.DTO.OTN;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@Table(name="otn_crypto_module")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OtnCryptoModule {
    @Id
    @GeneratedValue
    int cryptoModuleId;
    String aid;
    String moduleActType;
    String mid;
    String pmid;
    String midContext;
    String pmidContext;
    String bypassMode;
    String cryptoMode;
    String cryptoModulePkgVersion;
    String cryptoModuleFpgaVersion;
    String cryptoModuleCpldVersion;
    String cryptoModuleHwVersion;

    public OtnCryptoModule() {
    }

    public OtnCryptoModule(String aid, String moduleActType, String mid, String pmid, String midContext, String pmidContext, String bypassMode, String cryptoMode, String cryptoModulePkgVersion, String cryptoModuleFpgaVersion, String cryptoModuleCpldVersion, String cryptoModuleHwVersion) {
        this.aid = aid;
        this.moduleActType = moduleActType;
        this.mid = mid;
        this.pmid = pmid;
        this.midContext = midContext;
        this.pmidContext = pmidContext;
        this.bypassMode = bypassMode;
        this.cryptoMode = cryptoMode;
        this.cryptoModulePkgVersion = cryptoModulePkgVersion;
        this.cryptoModuleFpgaVersion = cryptoModuleFpgaVersion;
        this.cryptoModuleCpldVersion = cryptoModuleCpldVersion;
        this.cryptoModuleHwVersion = cryptoModuleHwVersion;
    }

    @Override
    public String toString() {
        return "OtnCryptoModule{" +
                "aid='" + aid + '\'' +
                ", moduleActType='" + moduleActType + '\'' +
                ", mid='" + mid + '\'' +
                ", pmid='" + pmid + '\'' +
                ", midContext='" + midContext + '\'' +
                ", pmidContext='" + pmidContext + '\'' +
                ", bypassMode='" + bypassMode + '\'' +
                ", cryptoMode='" + cryptoMode + '\'' +
                ", cryptoModulePkgVersion='" + cryptoModulePkgVersion + '\'' +
                ", cryptoModuleFpgaVersion='" + cryptoModuleFpgaVersion + '\'' +
                ", cryptoModuleCpldVersion='" + cryptoModuleCpldVersion + '\'' +
                ", cryptoModuleHwVersion='" + cryptoModuleHwVersion + '\'' +
                '}';
    }
}
