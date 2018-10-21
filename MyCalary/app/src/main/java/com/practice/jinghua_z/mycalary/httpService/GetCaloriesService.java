package com.practice.jinghua_z.mycalary.httpService;

/**
 * Created by nancy on 10/20/18.
 */

import com.practice.jinghua_z.mycalary.requestModel.GetCaloriesBodyString;
import com.practice.jinghua_z.mycalary.responseModel.GetCaloriesResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Header;


public interface GetCaloriesService {
    @POST("getCalories")
    Call<GetCaloriesResponse> getCalories(
            @Header("Content-Type") String contentType,
            @Body GetCaloriesBodyString voiceInput);
}



