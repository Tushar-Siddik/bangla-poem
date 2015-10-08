package com.android.microsoft.design;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Microsoft on 10/8/2015.
 */
public class JSONReader {

    public static String getPoemByPoet(Context context, String poemTitle) {
        String poem = null;

        JSONObject obj = null;
        try {
            obj = new JSONObject(loadJSONFromAsset(context, poemTitle));
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        JSONArray m_jArry = null;
        try {
            m_jArry = obj.getJSONArray("poet");
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> m_li;

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = null;
            try {
                jo_inside = m_jArry.getJSONObject(i);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            try {
                Log.d("Details-->%d", String.valueOf(jo_inside.getString("poetName")));
                Log.d("Details-->", String.valueOf(jo_inside.getString("poemTitle")));
                Log.d("Details-->", String.valueOf(jo_inside.getString("poemBody")));

            } catch (JSONException e1) {
                e1.printStackTrace();
            }
//            String formula_value = null;
//            try {
//                formula_value = jo_inside.getString("formule");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//            String url_value = null;
//            try {
//                url_value = jo_inside.getString("url");
//            } catch (JSONException e1) {
//                e1.printStackTrace();
//            }
//
//            //Add your values in your `ArrayList` as below:
//            m_li = new HashMap<String, String>();
//            m_li.put("formule", formula_value);
//            m_li.put("url", url_value);
//
//            formList.add(m_li);
        }
        return poem;
    }

    public static String loadJSONFromAsset(Context context, String poemTitle) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("poem.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
