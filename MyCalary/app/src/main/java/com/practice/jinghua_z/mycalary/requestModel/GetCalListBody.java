package com.practice.jinghua_z.mycalary.requestModel;

/**
 * Created by nancy on 10/20/18.
 */

public class GetCalListBody {
    private String time;
    private int uid;

    public GetCalListBody(int uid) {
        this.time = "";
        this.uid = uid;
    }

    // Getter Methods
    public String getTime() {
        return time;
    }
    public int getUid() {
        return uid;
    }

    // Setter Methods
    public void setTime(String time) {
        this.time = time;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
