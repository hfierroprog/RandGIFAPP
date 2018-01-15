package com.hfierroprog.randgifapp.utilidades;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class jsontolink {

    private InputStream is;
    private JSONObject jsonObject;

    public JSONObject jsontolink(String link) throws IOException {
        try {
            is = new URL(link).openStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            String jsonText = readAll(rd);

            jsonObject = new JSONObject(jsonText);

        } catch (IOException e) {
            System.out.println("Error con el flujo input output");
        } catch (JSONException e) {
            System.out.println("Error al parsear JSON");
        }finally {
            is.close();
        }

        return jsonObject;
    }

    private String readAll(Reader rd) throws IOException{
        StringBuilder sb = new StringBuilder();
        int cp;

        while((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }

        return sb.toString();
    }
}
