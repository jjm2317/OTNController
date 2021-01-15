package com.woorinet.plugin.demo.DTO.KMS;

import java.util.List;

public class KMSGroup {
    String id;
    String uid;
    String name;
    String description;
    List<KMSNodeRef> nodes;
    List<KMSConsumerRef> consumers;
    List<KMSProviderRef> providers;
}
