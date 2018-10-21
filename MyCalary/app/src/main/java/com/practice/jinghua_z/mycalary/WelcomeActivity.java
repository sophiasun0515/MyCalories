package com.practice.jinghua_z.mycalary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import android.graphics.Typeface;

//API call import
import com.practice.jinghua_z.mycalary.httpService.GetCaloriesService;
import com.practice.jinghua_z.mycalary.requestModel.GetCaloriesBodyString;
import com.practice.jinghua_z.mycalary.responseModel.GetCaloriesResponse;
import com.practice.jinghua_z.mycalary.httpService.GetCalListService;
import com.practice.jinghua_z.mycalary.requestModel.GetCalListBody;
import com.practice.jinghua_z.mycalary.responseModel.GetCalListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WelcomeActivity extends AppCompatActivity {

    protected static final int RESULT_SPEECH = 1;
    private TextView txtText, txtTextInt, calTxt;
    private Button voice_button;
    private Button detail_button;
    private int[] total_calaries = new int[]{0};
    String str;

    private static final String baseUrl = "https://radiant-brook-49591.herokuapp.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("My Calories");
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_welcome);


        voice_button = (Button) findViewById(R.id.voice_button);
        detail_button = (Button) findViewById(R.id.detail_button);
        txtTextInt = (TextView) findViewById(R.id.textView1);
        txtText = (TextView) findViewById(R.id.textView2);
        calTxt = (TextView) findViewById(R.id.textView3);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/handwriting.ttf");

        txtText.setTypeface(font);
        txtTextInt.setTypeface(font);
        calTxt.setTypeface(font);


        getCurrCal(1, total_calaries);

//        Log.d("sophia", Integer.toString(total_calaries[0]));


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text =  null;
                    text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    while (text == null) {
                    }

                    str = text.get(0);


                    getCalories(str, total_calaries);
//                    if(text != null) break;
                    break;

                }

            }
        }
    }


    public void getCalories(String voiceInput,  final int[] calareis) {

        Retrofit getCaloriesRetrofit = new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        GetCaloriesService getCaloriesService = getCaloriesRetrofit.create(GetCaloriesService.class);
        GetCaloriesBodyString getCaloriesBodyString = new GetCaloriesBodyString(voiceInput);
        Call<GetCaloriesResponse> getCaloriesResponse = getCaloriesService.getCalories("application/json",getCaloriesBodyString);

        getCaloriesResponse.enqueue(new Callback<GetCaloriesResponse>() {
            @Override
            public void onResponse(Call<GetCaloriesResponse> call, Response<GetCaloriesResponse> response) {
                Log.d("nancy", response.toString());
                if (response.body() != null) {
                    Log.d("nancy", Integer.toString(response.body().getCalorie()));
                    int calorie = response.body().getCalorie();
                    if(calorie != -1) {
                        calareis[0] += calorie;
                        txtText.setText("+" + Integer.toString(calorie));
                    } else {
                        Toast t3 = Toast.makeText(getApplicationContext(),
                                "Opps! Your input is not valid",
                                Toast.LENGTH_SHORT);
                        t3.show();
                    }

                    Log.d("stella", Integer.toString(calareis[0]));
                    setLevelText(txtTextInt, txtText, calareis[0], calTxt);
                }
            }


            @Override
            public void onFailure(Call<GetCaloriesResponse> call, Throwable t) {
                Log.d("nancy error", t.toString());
            }
        });

    }



    public void setLevelText(TextView level, TextView txt, int calory_num, TextView calary) {
        txt.setText(Integer.toString(calory_num));
        if(calory_num <= 1500) {
            level.setText("Low");
            txt.setTextColor(Color.parseColor("#FFA500"));
            level.setTextColor(Color.parseColor("#FFA500"));
            calary.setTextColor(Color.parseColor("#FFA500"));
        }
        else if(calory_num <= 3000){
            level.setText("Standard");
            level.setTextColor(Color.parseColor("#8BC34A"));
            txt.setTextColor(Color.parseColor("#8BC34A"));
            calary.setTextColor(Color.parseColor("#8BC34A"));
        }
        else {
            level.setText("High");
            level.setTextColor(Color.RED);
            txt.setTextColor(Color.RED);
            calary.setTextColor(Color.RED);
        }
        return;
    }



    public void getCurrCal(int uid, final int[] calaries) {

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

                        calaries[0] += calorie;

                    }

                    setLevelText(txtTextInt, txtText, total_calaries[0], calTxt);
                    Log.d("stella", "before voice");


                    voice_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast t = Toast.makeText(getApplicationContext(),
                                    "E.g. one bowl of rice",
                                    Toast.LENGTH_SHORT);
                            t.show();

                            Log.d("stella", "into voice");

                            Intent intent = new Intent(
                                    RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

                            try {
                                Log.d("stella", "into voice");
                                startActivityForResult(intent, RESULT_SPEECH);
                            } catch (ActivityNotFoundException a) {
                                Log.d("tag", a.toString());
                                Toast t2 = Toast.makeText(getApplicationContext(),
                                        "Opps! Your device doesn't support Speech to Text",
                                        Toast.LENGTH_SHORT);
                                t2.show();
                            }
                        }
                    });

                    detail_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, DetailActivity.class));

//                Intent myIntent = new Intent(this, DetailActivity.class);
//                startActivity(myIntent);
                        }
                    });


                }
            }

            @Override
            public void onFailure(Call<GetCalListResponse> call, Throwable t) {
                Log.d("nancy error", t.toString());
            }
        });

    }




}
