package com.ineng.utils;

import cn.hutool.core.io.IoUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpUtil {
    public static String get(String url) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(new HttpGet(url));
        if (200 == response.getStatusLine().getStatusCode()) {
            return IoUtil.read(response.getEntity().getContent(), "utf-8");
        }
        return "";
    }
}
