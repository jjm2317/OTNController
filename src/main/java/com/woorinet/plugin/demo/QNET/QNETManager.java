package com.woorinet.plugin.demo.QNET;

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

    public void QNETSyncKMSNodes(List nodes) {
        if (nodes != null) {
            Iterator nodesIterator = nodes.iterator();
            while (nodesIterator.hasNext()){
                Map<String, Object> node = (Map) nodesIterator.next();
                System.out.println(node.toString());


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
