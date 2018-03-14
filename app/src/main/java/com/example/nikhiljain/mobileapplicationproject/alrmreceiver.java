package com.example.nikhiljain.mobileapplicationproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Nikhil Jain on 08-11-2017.
 */

public class alrmreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm set",Toast.LENGTH_LONG).show();

        Intent i= new Intent();
        i.setClassName("com.example.nikhiljain.mobileapplicationproject","com.example.nikhiljain.mobileapplicationproject.wakeup");
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
