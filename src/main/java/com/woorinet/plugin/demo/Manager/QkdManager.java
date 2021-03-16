package com.woorinet.plugin.demo.Manager;

import com.google.gson.Gson;
import com.woorinet.plugin.demo.DTO.QKD.*;
import com.woorinet.plugin.demo.Repository.QKD.*;
import com.woorinet.plugin.demo.UTIL.ThrowingConsumer;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QkdManager {
    Gson gson;
    List<Map<String,Object>> kemsProviderMapList;

    QkdNodeRepository qkdNodeRepository;
    QkdServiceRepository qkdServiceRepository;
    QkdLinkRepository qkdLinkRepository;
    QkdPathRepository qkdPathRepository;
    QkdProviderNodeRepository qkdProviderNodeRepository;
    QkdProviderLinkRepository qkdProviderLinkRepository;

    QkdAppNodeRepository qkdAppNodeRepository;
    QkdAppLinkRepositroy qkdAppLinkRepositroy;


    public QkdManager(QkdNodeRepository qkdNodeRepository,
                      QkdServiceRepository qkdServiceRepository,
                      QkdLinkRepository qkdLinkRepository,
                      QkdPathRepository qkdPathRepository,
                      QkdProviderNodeRepository qkdProviderNodeRepository,
                      QkdProviderLinkRepository qkdProviderLinkRepository
    ) throws Exception {
        this.gson = new Gson();
        this.kemsProviderMapList = new ArrayList<>();

        this.qkdNodeRepository = qkdNodeRepository;
        this.qkdServiceRepository = qkdServiceRepository;
        this.qkdLinkRepository = qkdLinkRepository;
        this.qkdPathRepository = qkdPathRepository;
        this.qkdProviderNodeRepository = qkdProviderNodeRepository;
        this.qkdProviderLinkRepository = qkdProviderLinkRepository;
    }

    public void QkdSyncStart() throws Exception {
        WebClient client1 = WebClient
                .builder()
                .baseUrl("https://1.226.250.42/v1/admin")
                .defaultHeaders( httpHeaders -> {
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, "Basic QWRtaW46QWRtaW4=");
                    httpHeaders.add(HttpHeaders.ACCEPT, "text/plain");
                })
                .clientConnector(
                        new ReactorClientHttpConnector(
                                HttpClient.create()
                                        .secure(
                                                ThrowingConsumer.unchecked(
                                                        sslContextSpec -> sslContextSpec.sslContext(
                                                                SslContextBuilder.forClient()
                                                                        .trustManager(InsecureTrustManagerFactory.INSTANCE)
                                                                        .build()
                                                        )
                                                )
                                        )
                        )
                )
                .build();

        WebClient.RequestBodySpec uri1 = client1
                .method(HttpMethod.GET)
                .uri("/node?consumers=true&providers=true&links=true");

        String response = uri1.retrieve()
                .bodyToMono(Map.class)
                .map(map -> (Map) map.get("configuration"))
                .map(map -> {
                    try {
                        QkdSyncNodeList((List) map.get("nodes"));
                        QkdSyncServiceList((List) map.get("consumerLinks"));
                        QkdSnycLinkList((List) map.get("nodeLinks"));
                        QkdSyncPathList((List) map.get("paths"));
                        QkdSyncProviderNodeList();
                        QkdSyncProviderLinkList((List) map.get("providerLinks"));
                        QkdSyncAppLinkList((List) map.get("consumerLinks"));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "ok";
                })
                .block();

        System.out.println("response: " + response);

    }

    private void QkdSyncNodeList (List kemsNodeList) throws Exception {
        if(kemsNodeList == null) return;

        qkdNodeRepository.deleteAll();

        Iterator kemsNodeListIterator = kemsNodeList.iterator();
        while(kemsNodeListIterator.hasNext()) {
            Map<String, Object> kemsnode = (Map) kemsNodeListIterator.next();

            prepareProvider((List)kemsnode.get("providers"));


            QkdNode qkdNode = new QkdNode(
                    kemsnode.get("id") == null ? "" : kemsnode.get("id").toString(),
                    kemsnode.get("uid") == null ? "" :kemsnode.get("uid").toString(),
                    kemsnode.get("name") == null ? "" :kemsnode.get("name").toString(),
                    kemsnode.get("enabled") == null ? "" :kemsnode.get("enabled").toString(),
                    kemsnode.get("description") == null ? "" :kemsnode.get("description").toString(),
                    kemsnode.get("groupId") == null ? "" :kemsnode.get("groupId").toString(),
                    kemsnode.get("group") == null ? "" :kemsnode.get("group").toString(),
                    kemsnode.get("uniqueId") == null ? "" :kemsnode.get("uniqueId").toString(),
                    kemsnode.get("qncWebApiUrl") == null ? "" :kemsnode.get("qncWebApiUrl").toString(),
                    kemsnode.get("qncWebApiAuth") == null ? "" :kemsnode.get("qncWebApiAuth").toString(),
                    kemsnode.get("cert") == null ? "" :kemsnode.get("cert").toString(),
                    kemsnode.get("kems-cert") == null ? "" :kemsnode.get("kems-cert").toString(),
                    kemsnode.get("network") == null ? "" :gson.toJson(kemsnode.get("network")),
                    kemsnode.get("consumers") == null ? "" :gson.toJson(kemsnode.get("consumers")),
                    kemsnode.get("providers") == null ? "" :gson.toJson(kemsnode.get("providers")),
                    kemsnode.get("locX") == null ? "" :kemsnode.get("locX").toString(),
                    kemsnode.get("locY") == null ? "" :kemsnode.get("locY").toString()
            );
            qkdNodeRepository.save(qkdNode);
        }
    }

    private void QkdSyncServiceList(List kemsConsumerLinkList) throws Exception {
        if(kemsConsumerLinkList == null) return;

        qkdServiceRepository.deleteAll();
        Iterator kemsConsumerLinkListIterator = kemsConsumerLinkList.iterator();
        while(kemsConsumerLinkListIterator.hasNext()) {
            Map<String, Object> kemsConsumerLink = (Map) kemsConsumerLinkListIterator.next();

            QkdService qkdService = new QkdService(
                    kemsConsumerLink.get("id") == null ? "" : kemsConsumerLink.get("id").toString(),
                    kemsConsumerLink.get("uid") == null ? "" :kemsConsumerLink.get("uid").toString(),
                    kemsConsumerLink.get("name") == null ? "" :kemsConsumerLink.get("name").toString(),
                    kemsConsumerLink.get("operMode") == null ? "" : gson.toJson(kemsConsumerLink.get("operMode")),
                    kemsConsumerLink.get("source") == null ? "" : gson.toJson(kemsConsumerLink.get("source")),
                    kemsConsumerLink.get("dest") == null ? "" : gson.toJson(kemsConsumerLink.get("dest")),
                    kemsConsumerLink.get("presharedKey") == null ? "" :kemsConsumerLink.get("presharedKey").toString(),
                    kemsConsumerLink.get("qkeyStore") == null ? "" : gson.toJson(kemsConsumerLink.get("qkeyStore"))
            );
            qkdServiceRepository.save(qkdService);
        }
    }

    private void QkdSnycLinkList(List kemsNodeLinkList) throws Exception {
        if(kemsNodeLinkList == null) return;

        qkdLinkRepository.deleteAll();
        Iterator kemsNodeLinkListIterator = kemsNodeLinkList.iterator();
        while(kemsNodeLinkListIterator.hasNext()) {
            Map<String, Object> kemsNodeLink = (Map) kemsNodeLinkListIterator.next();

            QkdLink qkdLink = new QkdLink(
                kemsNodeLink.get("id") == null ? "" : kemsNodeLink.get("id").toString(),
                kemsNodeLink.get("name") == null ? "" :kemsNodeLink.get("name").toString(),
                kemsNodeLink.get("uid") == null ? "" :kemsNodeLink.get("uid").toString(),
                kemsNodeLink.get("type") == null ? "" :gson.toJson(kemsNodeLink.get("type")),
                kemsNodeLink.get("algorithm") == null ? "" :gson.toJson(kemsNodeLink.get("algorithm")),
                kemsNodeLink.get("weight") == null ? "" :kemsNodeLink.get("weight").toString(),
                kemsNodeLink.get("psk") == null ? "" :kemsNodeLink.get("psk").toString(),
                kemsNodeLink.get("source") == null ? "" :gson.toJson(kemsNodeLink.get("source")),
                kemsNodeLink.get("dest") == null ? "" :gson.toJson(kemsNodeLink.get("dest"))
            );
            qkdLinkRepository.save(qkdLink);
        }
    }

    private void QkdSyncPathList(List kemsPathList) throws Exception {
        if(kemsPathList == null) return;

        qkdPathRepository.deleteAll();
        Iterator kemsPathListIterator = kemsPathList.iterator();
        while(kemsPathListIterator.hasNext()) {
            Map<String, Object> kemsPath = (Map) kemsPathListIterator.next();

            QkdPath qkdPath = new QkdPath(
                kemsPath.get("id") == null ? "" : kemsPath.get("id").toString(),
                kemsPath.get("failbackMode") == null ? "" :kemsPath.get("failbackMode").toString(),
                kemsPath.get("failbackPeriod") == null ? "" :kemsPath.get("failbackPeriod").toString(),
                kemsPath.get("consumerLink") == null ? "" :gson.toJson(kemsPath.get("consumerLink")),
                kemsPath.get("primary") == null ? "" :gson.toJson(kemsPath.get("primary")),
                kemsPath.get("primaryUsage") == null ? "":kemsPath.get("primaryUsage").toString(),
                kemsPath.get("primaryFault") == null ? "":kemsPath.get("primaryFault").toString(),
                kemsPath.get("secondary") == null ? "" :gson.toJson(kemsPath.get("secondary")),
                kemsPath.get("secondaryUsage") == null ? "":kemsPath.get("primaryUsage").toString(),
                kemsPath.get("secondaryFault") == null ? "":kemsPath.get("primaryFault").toString(),
                kemsPath.get("remark") == null ? "" :kemsPath.get("remark").toString()
            );
            qkdPathRepository.save(qkdPath);
        }
    }

    private void prepareProvider(List kemsProviderList) {
        Iterator kemsProviderListIterator = kemsProviderList.iterator();
        while(kemsProviderListIterator.hasNext()) {
            Map<String, Object> kemsProvider = (Map) kemsProviderListIterator.next();
            kemsProviderMapList.add(kemsProvider);

        }
    }

    private void QkdSyncProviderNodeList() throws Exception {
        qkdProviderNodeRepository.deleteAll();
        for(Map<String,Object> kemsProvider: kemsProviderMapList) {
            QkdProviderNode qkdProviderNode = new QkdProviderNode(
                    kemsProvider.get("kms_id") == null ? "" : kemsProvider.get("kmsId").toString(),
                    kemsProvider.get("kmsName") == null ? "" : kemsProvider.get("kmsName").toString(),
                    kemsProvider.get("groupId") == null ? "" : kemsProvider.get("groupId").toString(),
                    kemsProvider.get("groupName") == null ? "" : kemsProvider.get("groupName").toString(),
                    kemsProvider.get("id") == null ? "" : kemsProvider.get("id").toString(),
                    kemsProvider.get("uid") == null ? "" : kemsProvider.get("uid").toString(),
                    kemsProvider.get("name") == null ? "" : kemsProvider.get("name").toString(),
                    kemsProvider.get("description") == null ? "" : kemsProvider.get("description").toString(),
                    kemsProvider.get("agent") == null ? "" : gson.toJson(kemsProvider.get("agent")),
                    kemsProvider.get("network") == null ? "" : gson.toJson(kemsProvider.get("network")),
                    kemsProvider.get("qncWebApiUrl") == null ? "" : kemsProvider.get("qncWebApiUrl").toString(),
                    kemsProvider.get("qncWebApiAuth") == null ? "" : kemsProvider.get("qncWebApiAuth").toString(),
                    kemsProvider.get("interfaces") == null ? "" : gson.toJson(kemsProvider.get("interfaces")),
                    kemsProvider.get("node") == null ? "" : kemsProvider.get("node").toString(),
                    kemsProvider.get("locX") == null ? "" : kemsProvider.get("locX").toString(),
                    kemsProvider.get("locY") == null ? "" : kemsProvider.get("locY").toString(),
                    kemsProvider.get("lat") == null ? "" : kemsProvider.get("lat").toString(),
                    kemsProvider.get("long") == null ? "" : kemsProvider.get("long").toString()
            );
            qkdProviderNodeRepository.save(qkdProviderNode);
        }
    }

    private void QkdSyncProviderLinkList(List kemsProviderLinkList) throws Exception {
        if(kemsProviderLinkList == null) return;

        qkdProviderLinkRepository.deleteAll();

        Iterator kemsProviderLinkListIterator = kemsProviderLinkList.iterator();
        while(kemsProviderLinkListIterator.hasNext()) {
            Map<String, Object> kemsProviderLink = (Map)kemsProviderLinkListIterator.next();

            QkdProviderLink qkdProviderLink = new QkdProviderLink(
                kemsProviderLink.get("id") == null ? "" : kemsProviderLink.get("id").toString(),
                kemsProviderLink.get("uid") == null ? "" :kemsProviderLink.get("uid").toString(),
                kemsProviderLink.get("name") == null ? "" :kemsProviderLink.get("name").toString(),
                kemsProviderLink.get("mode") == null ? "" :gson.toJson(kemsProviderLink.get("mode")),
                kemsProviderLink.get("source") == null ? "" :gson.toJson(kemsProviderLink.get("source")),
                kemsProviderLink.get("destination") == null ? "" :gson.toJson(kemsProviderLink.get("destination")),
                kemsProviderLink.get("qkeyStore") == null ? "" :gson.toJson(kemsProviderLink.get("qkeyStore"))
            );
            qkdProviderLinkRepository.save(qkdProviderLink);
        }

    }
    private void QkdSyncAppLinkList(List kemsConsumerLinkList) throws Exception {
        if(kemsConsumerLinkList == null) return;

        qkdAppLinkRepositroy.deleteAll();
        Iterator kemsConsumerLinkListIterator = kemsConsumerLinkList.iterator();
        while(kemsConsumerLinkListIterator.hasNext()) {
            Map<String, Object> kemsConsumerLink = (Map) kemsConsumerLinkListIterator.next();

            QkdAppLink qkdAppLink = new QkdAppLink(
                    kemsConsumerLink.get("id") == null ? "" : kemsConsumerLink.get("id").toString(),
                    kemsConsumerLink.get("uid") == null ? "" :kemsConsumerLink.get("uid").toString(),
                    kemsConsumerLink.get("name") == null ? "" :kemsConsumerLink.get("name").toString(),
                    kemsConsumerLink.get("operMode") == null ? "" : gson.toJson(kemsConsumerLink.get("operMode")),
                    kemsConsumerLink.get("source") == null ? "" : gson.toJson(kemsConsumerLink.get("source")),
                    kemsConsumerLink.get("dest") == null ? "" : gson.toJson(kemsConsumerLink.get("dest")),
                    kemsConsumerLink.get("presharedKey") == null ? "" :kemsConsumerLink.get("presharedKey").toString(),
                    kemsConsumerLink.get("qkeyStore") == null ? "" : gson.toJson(kemsConsumerLink.get("qkeyStore"))
            );

            qkdAppLinkRepositroy.save(qkdAppLink);
        }

    }
}
