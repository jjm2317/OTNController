package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.QKD.QkdNode;
import com.woorinet.plugin.demo.DTO.QKD.QkdService;
import com.woorinet.plugin.demo.Repository.QKD.QkdNodeRepository;
import com.woorinet.plugin.demo.Repository.QKD.QkdServiceRepository;
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
    List<QkdNode> qkdNodeList;

    QkdNodeRepository qkdNodeRepository;
    QkdServiceRepository qkdServiceRepository;


    public QkdManager(QkdNodeRepository qkdNodeRepository, QkdServiceRepository qkdServiceRepository) throws Exception {
        this.qkdNodeList = new ArrayList<>();

        this.qkdNodeRepository = qkdNodeRepository;
        this.qkdServiceRepository = qkdServiceRepository;

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






}
