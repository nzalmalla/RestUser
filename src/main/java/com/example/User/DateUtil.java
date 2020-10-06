package com.example.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    public static Date stringToDate(String stringDate){
        if(stringDate!=null && !stringDate.isEmpty()){
            try {
                return sdf.parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
