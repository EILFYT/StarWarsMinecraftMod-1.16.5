package com.eilfyt.starwarsinminecraft.util;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.eilfyt.starwarsinminecraft.client.render.PlayerFishHatRenderer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestUtils {

    public static JsonObject getResponse(String urlString) {

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String input;
                StringBuilder response = new StringBuilder();

                while ((input = in.readLine()) != null) {
                    response.append(input);
                }
                in.close();

                Gson gson = new Gson();

                return gson.fromJson(response.toString(), JsonObject.class);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new JsonObject();
    }


    public static void refreshRepo() {
        StarWarsInMinecraft.data = getResponse("https://raw.githubusercontent.com/EILFYT/StarWarsInMinecraftHatNames/main/data.json");
        PlayerFishHatRenderer.users = StarWarsInMinecraft.data.get("hat_names").getAsJsonObject().entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
