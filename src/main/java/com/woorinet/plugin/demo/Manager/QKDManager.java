package com.woorinet.plugin.demo.Manager;

import com.woorinet.plugin.demo.DTO.QKD.QkdNode;
import com.woorinet.plugin.demo.Repository.QKD.QkdNodeRepository;
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

public class QKDManager {
    List<QkdNode> qkdNodeList;

    QkdNodeRepository qkdNodeRepository;


    public QKDManager(QkdNodeRepository qkdNodeRepository) throws Exception {
        this.qkdNodeList = new ArrayList<>();

        this.qkdNodeRepository = qkdNodeRepository;


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
                        QkdSyncNode((List) map.get("nodes"));
                        //qnetManager.QNETSyncKMSNodeLinks((List) map.get("nodeLinks"),qnetMapper);
                        //qnetManager.QNETSyncKMSConsumerLinks((List) map.get("consumerLinks"),qnetMapper);
                        //qnetManager.QNETSyncKMSProviderLinks((List) map.get("providerLinks"), qnetMapper);
                        //qnetManager.QNETSyncKMSPaths((List) map.get("paths"),qnetMapper);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "ok";
                })
                .block();

        System.out.println("response: " + response);

    }

    public void QkdSyncNode (List qkdNodeList) throws Exception {
        if(qkdNodeList == null) return;

        Iterator qkdNodeListIterator = qkdNodeList.iterator();
        while(qkdNodeListIterator.hasNext()) {
            Map<String, Object> node = (Map) qkdNodeListIterator.next();

            QkdNode qkdNode = new QkdNode(
                    node.get("id") == null ? "" : node.get("id").toString(),
                    node.get("uid") == null ? "" :node.get("uid").toString(),
                    node.get("name") == null ? "" :node.get("name").toString(),
                    node.get("enabled") == null ? "" :node.get("enabled").toString(),
                    node.get("description") == null ? "" :node.get("description").toString(),
                    node.get("groupId") == null ? "" :node.get("groupId").toString(),
                    node.get("group") == null ? "" :node.get("group").toString(),
                    node.get("uniqueId") == null ? "" :node.get("uniqueId").toString(),
                    node.get("qncWebApiUrl") == null ? "" :node.get("qncWebApiUrl").toString(),
                    node.get("qncWebApiAuth") == null ? "" :node.get("qncWebApiAuth").toString(),
                    node.get("cert") == null ? "" :node.get("cert").toString(),
                    node.get("kems-cert") == null ? "" :node.get("kems-cert").toString(),
                    node.get("network") == null ? "" :node.get("network").toString(),
                    node.get("consumers") == null ? "" :node.get("consumers").toString(),
                    node.get("providers") == null ? "" :node.get("providers").toString(),
                    node.get("locX") == null ? "" :node.get("locX").toString(),
                    node.get("locY") == null ? "" :node.get("locY").toString()
            );

            qkdNodeRepository.save(qkdNode);
        }




    }






}
