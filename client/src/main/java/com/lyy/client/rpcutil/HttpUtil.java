package com.lyy.client.rpcutil;

import com.alibaba.fastjson.JSON;
import com.lyy.client.model.Result;
import okhttp3.*;

import java.util.HashMap;
import java.util.Map;

public class HttpUtil {

    public static synchronized Result callRemoteService(String identifier, String methodName, String argTypes, String argValues) {
        try {
            Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put("identifier", identifier);
            paramsMap.put("methodName", methodName);
            paramsMap.put("argTypes", argTypes);
            paramsMap.put("argValues", argValues);


            String result = sendPost("http://127.0.0.1:1234", paramsMap);
            return JSON.parseObject(result, Result.class);
        } catch (Exception e) {
            return Result.getFailResult("触发远程调用失败");
        }
    }

    private static synchronized String sendPost(String url, Map<String, String> paramsMap) throws Exception {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            //追加表单信息
            builder.add(key, paramsMap.get(key));
        }
        RequestBody formBody = builder.build();

        Response execute = null;
        try {
            Request request = new Request.Builder().url(url).post(formBody).build();
            execute = new OkHttpClient().newCall(request).execute();
            if (execute.isSuccessful()) {
                return execute.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((execute != null)) {
                execute.close();
            }
        }

        return "";
    }
}
