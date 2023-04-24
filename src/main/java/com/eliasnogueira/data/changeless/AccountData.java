package com.eliasnogueira.data.changeless;

import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import com.eliasnogueira.model.Account;

public class AccountData {
    private static final JSONArray user_pool = getUsers();
    
    static int current=0;
    private static JSONArray getUsers() {

       return AccountData.getResources("user.json");

    }

    public static Account get() {
        String usr = getUsr();
        String pw = getPw();
        return new Account(usr, pw);
    }

    public static String getUsr() {

        return user_pool.getJSONObject(current).getString("username");
    }

    public static String getPw() {
        String pw = user_pool.getJSONObject(current).getString("password");
        return pw;
    }

    public static String getUsr(int index) {

        return user_pool.getJSONObject(index).getString("username");
    }

    public static String getPw(int index) {

        return user_pool.getJSONObject(index).getString("password");
    }


    public static JSONArray getResources(String fileName) {
        // File f = new File("/src/testData/"+fileName);
        String dataFilePath=System.getProperty("user.dir") + "//src//testData//"+fileName;
        // System.out.println(System.getProperty("user.dir")+"/src/testData/"+fileName);
        
        StringBuilder jsonData = new StringBuilder();
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(dataFilePath), StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                jsonData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // System.out.println(jsonData.toString());
        JSONObject obj=new JSONObject(jsonData.toString());
        return new JSONArray(obj.getJSONArray("users"));
    }

}
