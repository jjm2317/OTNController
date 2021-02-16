package com.woorinet.plugin.demo.DTO.SDN;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LINK {
    int ems_id;
    int dst_ems_id;
    String link_id;
    String link_nm;
    String src_ne_id;
    String src_ne_name;
    String src_node_connector_id;
    String dst_ne_id;
    String dst_ne_name;
    String dst_node_connector_id;
    String link_ype;
    String link_stats;
    String link_category;
    String high_order_tunnel;
    String latency;
    String distance;
    String srlg;
    String ovpn;
    String timeslot;
    String lambda;
    int maximum_odu0s;
    int maximum_odu1s;
    int maximum_odu2s;
    int maximum_odu2es;
    int maximum_odu3s;
    int maximum_odu4s;
    int maximum_odu4cns;
    int maximum_odu4flexs;
    int available_odu0s;
    int available_odu1s;
    int available_odu2s;
    int available_odu2es;
    int available_odu3s;
    int available_odu4s;
    int available_odu4cns;
    int available_oduflexs;
    public LINK() {

    }

    public LINK(int ems_id, int dst_ems_id, String link_id, String link_nm, String src_ne_id, String src_ne_name, String src_node_connector_id, String dst_ne_id, String dst_ne_name, String dst_node_connector_id, String link_ype, String link_stats, String link_category, String high_order_tunnel, String latency, String distance, String srlg, String ovpn, String timeslot, String lambda, int maximum_odu0s, int maximum_odu1s, int maximum_odu2s, int maximum_odu2es, int maximum_odu3s, int maximum_odu4s, int maximum_odu4cns, int maximum_odu4flexs, int available_odu0s, int available_odu1s, int available_odu2s, int available_odu2es, int available_odu3s, int available_odu4s, int available_odu4cns, int available_oduflexs) {
        this.ems_id = ems_id;
        this.dst_ems_id = dst_ems_id;
        this.link_id = link_id;
        this.link_nm = link_nm;
        this.src_ne_id = src_ne_id;
        this.src_ne_name = src_ne_name;
        this.src_node_connector_id = src_node_connector_id;
        this.dst_ne_id = dst_ne_id;
        this.dst_ne_name = dst_ne_name;
        this.dst_node_connector_id = dst_node_connector_id;
        this.link_ype = link_ype;
        this.link_stats = link_stats;
        this.link_category = link_category;
        this.high_order_tunnel = high_order_tunnel;
        this.latency = latency;
        this.distance = distance;
        this.srlg = srlg;
        this.ovpn = ovpn;
        this.timeslot = timeslot;
        this.lambda = lambda;
        this.maximum_odu0s = maximum_odu0s;
        this.maximum_odu1s = maximum_odu1s;
        this.maximum_odu2s = maximum_odu2s;
        this.maximum_odu2es = maximum_odu2es;
        this.maximum_odu3s = maximum_odu3s;
        this.maximum_odu4s = maximum_odu4s;
        this.maximum_odu4cns = maximum_odu4cns;
        this.maximum_odu4flexs = maximum_odu4flexs;
        this.available_odu0s = available_odu0s;
        this.available_odu1s = available_odu1s;
        this.available_odu2s = available_odu2s;
        this.available_odu2es = available_odu2es;
        this.available_odu3s = available_odu3s;
        this.available_odu4s = available_odu4s;
        this.available_odu4cns = available_odu4cns;
        this.available_oduflexs = available_oduflexs;
    }

    @Override
    public String toString() {
        return "LINK{" +
                "ems_id=" + ems_id +
                ", dst_ems_id=" + dst_ems_id +
                ", link_id='" + link_id + '\'' +
                ", link_nm='" + link_nm + '\'' +
                ", src_ne_id='" + src_ne_id + '\'' +
                ", src_ne_name='" + src_ne_name + '\'' +
                ", src_node_connector_id='" + src_node_connector_id + '\'' +
                ", dst_ne_id='" + dst_ne_id + '\'' +
                ", dst_ne_name='" + dst_ne_name + '\'' +
                ", dst_node_connector_id='" + dst_node_connector_id + '\'' +
                ", link_ype='" + link_ype + '\'' +
                ", link_stats='" + link_stats + '\'' +
                ", link_category='" + link_category + '\'' +
                ", high_order_tunnel='" + high_order_tunnel + '\'' +
                ", latency='" + latency + '\'' +
                ", distance='" + distance + '\'' +
                ", srlg='" + srlg + '\'' +
                ", ovpn='" + ovpn + '\'' +
                ", timeslot='" + timeslot + '\'' +
                ", lambda='" + lambda + '\'' +
                ", maximum_odu0s=" + maximum_odu0s +
                ", maximum_odu1s=" + maximum_odu1s +
                ", maximum_odu2s=" + maximum_odu2s +
                ", maximum_odu2es=" + maximum_odu2es +
                ", maximum_odu3s=" + maximum_odu3s +
                ", maximum_odu4s=" + maximum_odu4s +
                ", maximum_odu4cns=" + maximum_odu4cns +
                ", maximum_odu4flexs=" + maximum_odu4flexs +
                ", available_odu0s=" + available_odu0s +
                ", available_odu1s=" + available_odu1s +
                ", available_odu2s=" + available_odu2s +
                ", available_odu2es=" + available_odu2es +
                ", available_odu3s=" + available_odu3s +
                ", available_odu4s=" + available_odu4s +
                ", available_odu4cns=" + available_odu4cns +
                ", available_oduflexs=" + available_oduflexs +
                '}';
    }
}
