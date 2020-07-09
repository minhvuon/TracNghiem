package com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.model.url_sever;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.model.custom_list_topbxh;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.model.topbxh;
import com.example.jackty.myassignment_tienhhhpd01762_networking.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_topbxh extends Fragment {

    private static ListView listView;
    private static View view;

    private static ArrayList<topbxh> topbxhArrayList;
    private static custom_list_topbxh adapter ;
    RequestQueue requestQueue;
    String data = "" ;


    public Fragment_topbxh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_topbxh, container, false);
        // Inflate the layout for this fragment

        innit();


        // get top

        gettopfromsever(url_sever.getalltop);



        return view;
    }

    private void innit() {
        topbxhArrayList = new ArrayList<topbxh>();
        listView = view.findViewById(R.id.listv_bxh);


    }


    private void gettopfromsever(String url)
    {
        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(getActivity()) ;
        // Casts results into the TextView found within the main layout XML with id jsonData

        JsonObjectRequest obreg = new JsonObjectRequest(Request.Method.GET,url,
                new Response.Listener<JSONObject>()
                {


                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray jsarray =  response.getJSONArray("topxh");


                            for (int i = 0; i < jsarray.length(); i++) {
                                JSONObject objitem = jsarray.getJSONObject(i);

                                String nameu = objitem.getString("nameu");
                                String score = objitem.getString("score");
                                String mail = objitem.getString("mail");








                                topbxhArrayList.add(new topbxh(nameu,score,mail));


                                data += topbxhArrayList.get(i).toString();




                            }






                            // show du lieu
                            Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
                            adapter = new custom_list_topbxh(getActivity(),R.layout.custom_lisview_top, topbxhArrayList);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();








                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );

        requestQueue.add(obreg);





    }

}
