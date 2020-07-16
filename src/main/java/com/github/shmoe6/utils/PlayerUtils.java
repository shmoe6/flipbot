package com.github.shmoe6.utils;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import java.net.URL;

public class PlayerUtils {

    public static String getUUID(String playerName) {
        try {
            String url = "https://api.mojang.com/users/profiles/minecraft/" + playerName;

           // String UUIDJson = IOUtils.toString(new URL(url));

           // JSONObject UUIDObject = (JSONObject) JSONValue.parseWithException(UUIDJson);

           // String uuid = UUIDObject.get("id").toString();
           // return uuid;
            return "placeholder return";

        } catch (Exception e) {
            return "error";
        }
    }

}
