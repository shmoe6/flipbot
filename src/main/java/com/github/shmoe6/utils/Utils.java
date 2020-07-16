package com.github.shmoe6.utils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;

public class Utils {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }

    //If the item id doesn't match the item's name in game. Will add more as more ids are discovered
    public static String formatItemID(String s) {
        s = StringUtils.chop(s.toUpperCase().replaceAll("\\s+", "_"));

        switch(s) {
            default:
                break;
            case "ASPECT_OF_THE_DRAGONS":
                s = StringUtils.chop(s);
                break;
            case "ROD_OF_LEGENDS":
                s = "LEGEND_ROD";
                break;
            case "ROD_OF_CHAMPIONS":
                s = "CHAMP_ROD";
                break;
        }

        return s;
    }

    public static String addCommas(int i) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);
        return numberFormat.format(i);
    }

    public static String removeSpaces (String s) {
        StringBuilder removeSpace = new StringBuilder();

        for (int i = 0; i<s.length();i++){
            if(!Character.isWhitespace(s.charAt(i))) {
                removeSpace=removeSpace.append(s.charAt(i));
            }
        }

        return removeSpace.toString();
    }

    public static String getTrimmedUUID(String s) throws IOException {
        String UUID;

        try {
            JSONObject json = Utils.readJsonFromUrl("https://api.mojang.com/users/profiles/minecraft/".concat(s));
            UUID = json.get("id").toString();
        } catch (Exception e) {
            UUID = "An error has occurred. Please try again and if the error still persists, message Shmoe6#1746 with details on the issue";
        }

        return UUID;
    }
}
