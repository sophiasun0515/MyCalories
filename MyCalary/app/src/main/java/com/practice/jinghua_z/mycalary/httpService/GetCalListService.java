package com.practice.jinghua_z.mycalary.httpService;

/**
 * Created by nancy on 10/20/18.
 */

import com.practice.jinghua_z.mycalary.requestModel.GetCalListBody;
import com.practice.jinghua_z.mycalary.responseModel.GetCalListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Header;

public interface GetCalListService {
    @POST("getRecordList")
    Call<GetCalListResponse> getList(
            @Header("Content-Type") String contentType,
            @Body GetCalListBody voiceInput);
}
