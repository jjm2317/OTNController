package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.QKD.QkdLink;
import com.woorinet.plugin.demo.DTO.QKD.QkdNode;
import com.woorinet.plugin.demo.DTO.QKD.QkdPath;
import com.woorinet.plugin.demo.DTO.QKD.QkdService;
import com.woorinet.plugin.demo.Repository.QKD.QkdLinkRepository;
import com.woorinet.plugin.demo.Repository.QKD.QkdNodeRepository;
import com.woorinet.plugin.demo.Repository.QKD.QkdPathRepository;
import com.woorinet.plugin.demo.Repository.QKD.QkdServiceRepository;
import com.woorinet.plugin.demo.UTIL.ThrowingConsumer;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QkdManager {
    QkdNodeRepository qkdNodeRepository;
    QkdServiceRepository qkdServiceRepository;
    QkdLinkRepository qkdLinkRepository;
    QkdPathRepository qkdPathRepository;

    public QkdManager(QkdNodeRepository qkdNodeRepository, QkdServiceRepository qkdServiceRepository, QkdLinkRepository qkdLinkRepository, QkdPathRepository qkdPathRepository) throws Exception {
        this.qkdNodeRepository = qkdNodeRepository;
        this.qkdServiceRepository = qkdServiceRepository;
        this.qkdLinkRepository = qkdLinkRepository;
        this.qkdPathRepository = qkdPathRepository;
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
                    kemsnode.get("network") == null ? "" :kemsnode.get("network").toString(),
                    kemsnode.get("consumers") == null ? "" :kemsnode.get("consumers").toString(),
                    kemsnode.get("providers") == null ? "" :kemsnode.get("providers").toString(),
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
                    kemsConsumerLink.get("operMode") == null ? "" :kemsConsumerLink.get("operMode").toString(),
                    kemsConsumerLink.get("source") == null ? "" :kemsConsumerLink.get("source").toString(),
                    kemsConsumerLink.get("dest") == null ? "" :kemsConsumerLink.get("dest").toString(),
                    kemsConsumerLink.get("presharedKey") == null ? "" :kemsConsumerLink.get("presharedKey").toString(),
                    kemsConsumerLink.get("qkeyStore") == null ? "" :kemsConsumerLink.get("qkeyStore").toString()
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
                kemsNodeLink.get("type") == null ? "" :kemsNodeLink.get("type").toString(),
                kemsNodeLink.get("algorithm") == null ? "" :kemsNodeLink.get("algorithm").toString(),
                kemsNodeLink.get("weight") == null ? "" :kemsNodeLink.get("weight").toString(),
                kemsNodeLink.get("psk") == null ? "" :kemsNodeLink.get("psk").toString(),
                kemsNodeLink.get("source") == null ? "" :kemsNodeLink.get("source").toString(),
                kemsNodeLink.get("dest") == null ? "" :kemsNodeLink.get("dest").toString()
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
                kemsPath.get("consumerLink") == null ? "" :kemsPath.get("consumerLink").toString(),
                kemsPath.get("primary") == null ? "" :kemsPath.get("primary").toString(),
                kemsPath.get("primaryUsage") == null ? "":kemsPath.get("primaryUsage").toString(),
                kemsPath.get("primaryFault") == null ? "":kemsPath.get("primaryFault").toString(),
                kemsPath.get("secondary") == null ? "" :kemsPath.get("secondary").toString(),
                kemsPath.get("secondaryUsage") == null ? "":kemsPath.get("primaryUsage").toString(),
                kemsPath.get("secondaryFault") == null ? "":kemsPath.get("primaryFault").toString(),
                kemsPath.get("remark") == null ? "" :kemsPath.get("remark").toString()
            );
            qkdPathRepository.save(qkdPath);
        }
    }






}
