package com.practice.jinghua_z.mycalary.responseModel;

/**
 * Created by nancy on 10/20/18.
 */

public class GetCalListResponse {
    private Data[] data;

    public Data[] getData() {
        return this.data;
    }

    public class Data{
        private String item;
        private int calorie;

        // Getter Methods
        public String getItem() {
            return item;
        }

        public int getCalorie() {
            return calorie;
        }

        // Setter Methods
        public void setItem(String item) {
            this.item = item;
        }

        public void setCalorie(int calorie) {
            this.calorie = calorie;
        }

        @Override
        public String toString() {
            String s = "";
            for (int i = 0; i < data.length; i++) {
                s = s + "item: " + data[i].item + " ";
                s = s + "calory: " + data[i].calorie + " ";
            }
            return s;
        }
    }

}
