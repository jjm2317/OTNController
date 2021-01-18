package com.woorinet.plugin.demo.QNET;

import com.woorinet.plugin.demo.DTO.QNET.*;
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
                System.out.println(node.toString());



            }
        }
    }

    public void QNETSyncKMSNodeLinks(List nodeLinks, QNETMapper qnetMapper) throws Exception{
        if (nodeLinks != null) {
            Iterator nodeLinksIterator = nodeLinks.iterator();
            while (nodeLinksIterator.hasNext()){
                Map<String, Object> nodeLink = (Map) nodeLinksIterator.next();

                String[] fields = new String[9];
                fields[0] =  nodeLink.get("id") == null ? "" : nodeLink.get("id").toString();
                fields[1] =  nodeLink.get("name") == null ? "" :nodeLink.get("name").toString();
                fields[2] =  nodeLink.get("uid") == null ? "" :nodeLink.get("uid").toString();
                fields[3] = nodeLink.get("type") == null ? "" :nodeLink.get("type").toString();
                fields[4] =  nodeLink.get("algorithm") == null ? "" :nodeLink.get("algorithm").toString();
                fields[5] =  nodeLink.get("weight") == null ? "" :nodeLink.get("weight").toString();
                fields[6] =  nodeLink.get("psk") == null ? "" :nodeLink.get("psk").toString();
                fields[7] =  nodeLink.get("source") == null ? "" :nodeLink.get("source").toString();
                fields[8] =  nodeLink.get("dest") == null ? "" :nodeLink.get("dest").toString();

                qnetMapper.insertNodeLink(new NODELINK(fields));
                System.out.println(nodeLink.toString());


            }
        }
    }

    public void QNETSyncKMSConsumerLinks(List consumerLinks,QNETMapper qnetMapper) throws Exception{
        if (consumerLinks != null) {
            Iterator consumerLinksIterator = consumerLinks.iterator();
            while (consumerLinksIterator.hasNext()){
                Map<String, Object> consumerLink = (Map) consumerLinksIterator.next();

                String[] fields = new String[8];
                fields[0] =  consumerLink.get("id") == null ? "" : consumerLink.get("id").toString();
                fields[1] =  consumerLink.get("uid") == null ? "" :consumerLink.get("uid").toString();
                fields[2] =  consumerLink.get("name") == null ? "" :consumerLink.get("name").toString();
                fields[3] = consumerLink.get("operMode") == null ? "" :consumerLink.get("operMode").toString();
                fields[4] =  consumerLink.get("source") == null ? "" :consumerLink.get("source").toString();
                fields[5] =  consumerLink.get("dest") == null ? "" :consumerLink.get("dest").toString();
                fields[6] =  consumerLink.get("presharedKey") == null ? "" :consumerLink.get("presharedKey").toString();
                fields[7] =  consumerLink.get("qkeyStore") == null ? "" :consumerLink.get("qkeyStore").toString();

                qnetMapper.insertConsumerLink(new CONSUMERLINK(fields));
                System.out.println(consumerLink.toString());
            }
        }
    }

    public void QNETSyncKMSProviderLinks(List providerLinks,QNETMapper qnetMapper) throws Exception{
        if (providerLinks != null) {
            Iterator providerLinksIterator = providerLinks.iterator();
            while (providerLinksIterator.hasNext()){
                Map<String, Object> providerLink = (Map) providerLinksIterator.next();

                String[] fields = new String[8];
                fields[0] =  providerLink.get("id") == null ? "" : providerLink.get("id").toString();
                fields[1] =  providerLink.get("uid") == null ? "" :providerLink.get("uid").toString();
                fields[2] =  providerLink.get("name") == null ? "" :providerLink.get("name").toString();
                fields[3] = providerLink.get("mode") == null ? "" :providerLink.get("mode").toString();
                fields[4] =  providerLink.get("source") == null ? "" :providerLink.get("source").toString();
                fields[5] =  providerLink.get("destination") == null ? "" :providerLink.get("destination").toString();
                fields[7] =  providerLink.get("qkeyStore") == null ? "" :providerLink.get("qkeyStore").toString();

                qnetMapper.insertProviderLink(new PROVIDERLINK(fields));

                System.out.println(providerLink.toString());
            }
        }
    }

    public void QNETSyncKMSPaths(List paths, QNETMapper qnetMapper) throws Exception{
        if (paths != null) {
            Iterator pathsIterator = paths.iterator();
            while (pathsIterator.hasNext()){
                Map<String, Object> path = (Map) pathsIterator.next();

                String[] fields = new String[8];
                fields[0] =  path.get("id") == null ? "" : path.get("id").toString();
                fields[1] =  path.get("failbackMode") == null ? "" :path.get("failbackMode").toString();
                fields[2] =  path.get("failbackPeriod") == null ? "" :path.get("failbackPeriod").toString();
                fields[3] = path.get("consumerLink") == null ? "" :path.get("consumerLink").toString();
                fields[4] =  path.get("primary") == null ? "" :path.get("primary").toString();
                fields[5] =  path.get("secondary") == null ? "" :path.get("secondary").toString();
                fields[7] =  path.get("remark") == null ? "" :path.get("remark").toString();

                qnetMapper.insertPath(new PATH(fields));
                System.out.println(path.toString());
            }
        }
    }
}
