package com.woorinet.plugin.demo.DTO.SDN;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NODE {
    int ems_id;
    String ne_id;
    String ne_name;
    String ne_type;
    String ne_model;
    String ne_status;
    String sw_ver;
    String ip_addr;
    String vendor;
    String serial_num;
    String sys_type;

    public NODE() {

    }

    public NODE(int ems_id, String ne_id, String ne_name, String ne_type, String ne_model, String ne_status, String sw_ver, String ip_addr, String vendor, String serial_num, String sys_type) {
        this.ems_id = ems_id;
        this.ne_id = ne_id;
        this.ne_name = ne_name;
        this.ne_type = ne_type;
        this.ne_model = ne_model;
        this.ne_status = ne_status;
        this.sw_ver = sw_ver;
        this.ip_addr = ip_addr;
        this.vendor = vendor;
        this.serial_num = serial_num;
        this.sys_type = sys_type;
    }

    @Override
    public String toString() {
        return "NODE{" +
                "ems_id=" + ems_id +
                ", ne_id='" + ne_id + '\'' +
                ", ne_name='" + ne_name + '\'' +
                ", ne_type='" + ne_type + '\'' +
                ", ne_model='" + ne_model + '\'' +
                ", ne_status='" + ne_status + '\'' +
                ", sw_ver='" + sw_ver + '\'' +
                ", ip_addr='" + ip_addr + '\'' +
                ", vendor='" + vendor + '\'' +
                ", serial_num='" + serial_num + '\'' +
                ", sys_type='" + sys_type + '\'' +
                '}';
    }
}
