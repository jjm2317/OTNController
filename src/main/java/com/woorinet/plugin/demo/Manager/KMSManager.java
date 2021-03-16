package com.woorinet.plugin.demo.Manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.woorinet.plugin.demo.DTO.KMS.KmsNode;
import com.woorinet.plugin.demo.Repository.KMS.KmsNodeRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class KMSManager {
    List<KmsNode> kmsNodeList;

    KmsNodeRepository kmsNodeRepository;


    public KMSManager (KmsNodeRepository kmsNodeRepository) throws Exception {
        this.kmsNodeList = new ArrayList<>();

        this.kmsNodeRepository = kmsNodeRepository;


    }

    public void KMSSyncStart() throws Exception {
        //kms node 데이터 업데이트
        KMSSyncNode();
    }

    public void KMSSyncNode () throws Exception {
        System.out.println(getResponse("https://1.226.250.42/v1/admin/node?consumers=true&providers=true&links=true"));
        JSONParser jsonParser = new JSONParser();
//        JSONObject jsonObject = (JSONObject)jsonParser.parse(prettify(getResponse("https://1.226.250.42/v1/admin/node?consumers=true&providers=true&links=true")));
//        System.out.println("json Object");
//        System.out.println(jsonObject);
        KmsNode kmsNode = new KmsNode(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );

        kmsNodeRepository.save(kmsNode);
    }

    public String getResponse (String strUrl) throws Exception{
        try {
            URL url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();;
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            StringBuilder response = new StringBuilder ();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            System.out.println(in);
            in.close();

            return response.toString();


        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return "";
    }

//    public String prettify (String json_text) throws Exception{
//        System.out.println("jsonText");
//        System.out.println(json_text);
//        JsonParser parser = new JsonParser();
//        JsonObject json = parser.parse(json_text).getAsJsonObject();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        return gson.toJson(json);
//    }




}
