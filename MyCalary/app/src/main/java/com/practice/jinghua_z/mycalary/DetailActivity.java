package com.practice.jinghua_z.mycalary;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SimpleAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.graphics.Typeface;

import com.practice.jinghua_z.mycalary.httpService.GetCalListService;
import com.practice.jinghua_z.mycalary.requestModel.GetCalListBody;
import com.practice.jinghua_z.mycalary.responseModel.GetCalListResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    private static final String baseUrl = "https://radiant-brook-49591.herokuapp.com";
    private HashMap<String, Integer> itemMap = new HashMap<>();
    int uid = 1;

    String[] listviewTitle = new String[]{
            "ListView Title 1", "ListView Title 2",
    };


//    int[] listviewImage = new int[]{
//            R.drawable.apple, R.drawable.banana,
//    };

    String[] listviewShortDescription = new String[]{
        "Calories: 150", "Calories: 200",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Calories of the Day");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getCalList(uid, itemMap);

//        String[] from = {"listview_image", "listview_title", "listview_discription"};
//        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};
//
//        Set<String> keys = itemMap.keySet();
//
//        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
//
//
//
//        for (String k: keys) {
//            HashMap<String, String> hm = new HashMap<>();
//            hm.put("listview_title", k);
//            hm.put("listview_discription", Integer.toString(itemMap.get(k)));
//            hm.put("listview_image", Integer.toString(listviewImage[0]));
//            aList.add(hm);
//        }
//
//        Log.d("aList: ", aList.toString());
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
//        ListView androidListView = (ListView) findViewById(R.id.detailView);
//        androidListView.setAdapter(simpleAdapter);



//        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
//        for (int i = 0; i < 2; i++) {
//            HashMap<String, String> hm = new HashMap<String, String>();
//            hm.put("listview_title", listviewTitle[i]);
//            hm.put("listview_discription", listviewShortDescription[i]);
//            hm.put("listview_image", Integer.toString(listviewImage[i]));
//            aList.add(hm);
//        }
//
//        String[] from = {"listview_image", "listview_title", "listview_discription"};
//        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

//        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
//        ListView androidListView = (ListView) findViewById(R.id.detailView);
//        androidListView.setAdapter(simpleAdapter);

    }


    public void getCalList(int uid, final HashMap<String, Integer> itemMap) {

        Retrofit getCalListRetrofit = new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        GetCalListService getCalListService = getCalListRetrofit.create(GetCalListService.class);
        GetCalListBody getCalListBody = new GetCalListBody(uid);
        Call<GetCalListResponse> getCalListResponse = getCalListService.getList("application/json",getCalListBody);

        getCalListResponse.enqueue(new Callback<GetCalListResponse>() {
            @Override
            public void onResponse(Call<GetCalListResponse> call, Response<GetCalListResponse> response) {
                Log.d("nancy", response.toString());
                if (response.body() != null) {
                    GetCalListResponse.Data[] resultDataList = response.body().getData();
                    if (resultDataList != null) {
                        Log.d("nancy here", Integer.toString(resultDataList.length));
                    }

                    for (GetCalListResponse.Data d: resultDataList) {
//                        Log.d("nancy here", "in list");
                        String item = d.getItem();
                        int calorie = d.getCalorie();

                        if (itemMap.containsKey(item)) {
                            itemMap.put(item, itemMap.get(item) + calorie);
                        } else {
                            itemMap.put(item, calorie);
                        }
//                        Log.d("apple", itemMap.keySet().toString());

                    }

                    String[] from = {"listview_image", "listview_title", "listview_discription"};
                    int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

                    Set<String> keys = itemMap.keySet();

                    List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

                    int[] listviewImage = new int[keys.size()];

//                    for (int i=0; i<keys.size(); i++){
//                        int j = i + 1;
//                        listviewImage[i] = getResources().getIdentifier("c"+j,"drawable",getPackageName());
//                    }


                    for (String k: keys) {
                        HashMap<String, String> hm = new HashMap<>();
                        hm.put("listview_title", k);
                        hm.put("listview_discription", Integer.toString(itemMap.get(k)));
//                        hm.put("listview_image", Integer.toString(listviewImage[0]));
                        hm.put("listview_image", Integer.toString(getResources().getIdentifier(k, "drawable", getPackageName())));
                        aList.add(hm);
                    }

                    Log.d("aList: ", aList.toString());

                    SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
                    ListView androidListView = (ListView) findViewById(R.id.detailView);
                    androidListView.setAdapter(simpleAdapter);

                    //getItem() String
//                    int calorie = response.body().getCalorie();
//                    if(calorie != -1) {
//                        calareis[0] += calorie;
//                    }
//
//                    txtText.setText(Integer.toString(calorie));
//                    Log.d("stella", Integer.toString(calareis[0]));
//                    setLevelText(txtTextInt, txtText, calareis[0], calTxt);
                }
            }

            @Override
            public void onFailure(Call<GetCalListResponse> call, Throwable t) {
                Log.d("nancy error", t.toString());
            }
        });

    }

}
