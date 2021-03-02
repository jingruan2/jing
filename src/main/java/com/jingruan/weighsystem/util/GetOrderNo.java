package com.jingruan.weighsystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetOrderNo {
    public static String getOrderNo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowdate = sdf.format(new Date());
        return nowdate;
    }
}