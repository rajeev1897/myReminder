package com.example.rajeev.myapp;

import android.content.Context;
import android.util.Log;

import java.util.Calendar;

public class Run
{   int lastMinute;
    int currentMinute=0;

    Context context;

    public Run(Context context) {
        this.context = context;
    }


    public void valid()
    {
        System.out.print("hai");
        lastMinute = currentMinute;
        while (true)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            currentMinute = calendar.get(Calendar.MINUTE);
            if (currentMinute != lastMinute){
                lastMinute = currentMinute;
                System.out.println(currentMinute);
            }
        }
    }
}
