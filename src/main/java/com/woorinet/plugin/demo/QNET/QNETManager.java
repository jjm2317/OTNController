package com.woorinet.plugin.demo.QNET;

import com.woorinet.plugin.demo.DTO.QNET.NODE;
import com.woorinet.plugin.demo.Mapper.QNETMapper;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class QNETManager {
    public void QNETSyncKMSGroups(List groups) {
        if (groups != null) {
            Iterator groupsIterator = groups.iterator();
            while (groupsIterator.hasNext()){
                Map<String, Object> group = (Map) groupsIterator.next();
                System.out.println(group.toString());
            }
        }
    }

    public void QNETSyncKMSNodes(List nodes, QNETMapper qnetMapper) throws Exception{

        if (nodes != null) {
            Iterator nodesIterator = nodes.iterator();
            while (nodesIterator.hasNext()){
                Map<String, Object> node = (Map) nodesIterator.next();

                String[] fields = new String[19];
                fields[0] =  node.get("id") == null ? "" : node.get("id").toString();
                fields[1] =  node.get("uid") == null ? "" :node.get("uid").toString();
                fields[2] =  node.get("name") == null ? "" :node.get("name").toString();
                fields[3] = node.get("enabled") == null ? "" :node.get("enabled").toString();
                fields[4] =  node.get("description") == null ? "" :node.get("description").toString();
                fields[5] =  node.get("groupId") == null ? "" :node.get("groupId").toString();
                fields[6] =  node.get("group") == null ? "" :node.get("group").toString();
                fields[7] =  node.get("uniqueId") == null ? "" :node.get("uniqueId").toString();
                fields[8] =  node.get("qncWebApiUrl") == null ? "" :node.get("qncWebApiUrl").toString();
                fields[9] =  node.get("qncWebApiAuth") == null ? "" :node.get("qncWebApiAuth").toString();
                fields[10] =  node.get("cert") == null ? "" :node.get("cert").toString();
                fields[11] =  node.get("kems-cert") == null ? "" :node.get("kems-cert").toString();
                fields[12] = node.get("network") == null ? "" :node.get("network").toString().toString();
                fields[13] = node.get("consumers") == null ? "" :node.get("consumers").toString();
                fields[14] = node.get("providers") == null ? "" :node.get("providers").toString();
                fields[15] = node.get("locX") == null ? "" :node.get("locX").toString();
                fields[16] = node.get("locY") == null ? "" :node.get("locY").toString();
                fields[17] = node.get("lat") == null ? "" :node.get("lat").toString();
                fields[18] = node.get("long") == null ? "" :node.get("long").toString();

                qnetMapper.insertNode(new NODE(fields));



            }
        }
    }

    public void QNETSyncKMSNodeLinks(List nodeLinks) {
        if (nodeLinks != null) {
            Iterator nodeLinksIterator = nodeLinks.iterator();
            while (nodeLinksIterator.hasNext()){
                Map<String, Object> nodeLink = (Map) nodeLinksIterator.next();
                System.out.println(nodeLink.toString());
            }
        }
    }

    public void QNETSyncKMSConsumerLinks(List consumerLinks) {
        if (consumerLinks != null) {
            Iterator consumerLinksIterator = consumerLinks.iterator();
            while (consumerLinksIterator.hasNext()){
                Map<String, Object> consumerLink = (Map) consumerLinksIterator.next();
                System.out.println(consumerLink.toString());
            }
        }
    }

    public void QNETSyncKMSProviderLinks(List providerLinks) {
        if (providerLinks != null) {
            Iterator providerLinksIterator = providerLinks.iterator();
            while (providerLinksIterator.hasNext()){
                Map<String, Object> providerLink = (Map) providerLinksIterator.next();
                System.out.println(providerLink.toString());
            }
        }
    }

    public void QNETSyncKMSPaths(List paths) {
        if (paths != null) {
            Iterator pathsIterator = paths.iterator();
            while (pathsIterator.hasNext()){
                Map<String, Object> path = (Map) pathsIterator.next();
                System.out.println(path.toString());
            }
        }
    }
}
