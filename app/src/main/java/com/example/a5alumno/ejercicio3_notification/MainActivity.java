package com.example.a5alumno.ejercicio3_notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int NOTIF_ID = 2;
    public static final int NOTIF_ID2 = 3;

    NotificationActivity mNotificationActivity = new NotificationActivity();
    //private int notif_count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startAct_Btn = (Button) this.findViewById(R.id.notifBtn);
        startAct_Btn.setOnClickListener(this);

        final Button startAct_Btn2 = (Button) this.findViewById(R.id.customBtn);
        startAct_Btn2.setOnClickListener(this);



        //mNotifManager.notify(NOTIF_ID,mBuilder.build());
    }

    @Override
    public void onClick(View view) {

        /*******NOTIFICATION DEFAULT*********/
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My notification")
                //.setContentText("The number of notifications is "+notif_count);
                .setContentText("The number of notifications is "+NotificationActivity.notif_count);
        //Creats an explicit intent for an Actifity in the app

        Intent notificationIntent = new Intent(this,NotificationActivity.class);

        PendingIntent mPendingIntent = PendingIntent
                .getActivity(this,1,notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        mBuilder.setContentIntent(mPendingIntent);
        NotificationManager mNotifManager = (NotificationManager)this
                .getSystemService(Service.NOTIFICATION_SERVICE);

        /*******NOTIFICATION CUSTOM*********/
        NotificationCompat.Builder mCustomBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("My notification");
                //.setContentText("The number of notifications is "+notif_count);
        RemoteViews mRemoteViews = new RemoteViews(this.getPackageName(),R.layout.custom_notification_layout);

        mCustomBuilder.setContent(mRemoteViews);

        //Creates an explicit intent for an Activity in the app

        Intent notificationIntent2 = new Intent(this,NotificationActivity.class);

        PendingIntent mPendingIntent2 = PendingIntent
                .getActivity(this,1,notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        mCustomBuilder.setContentIntent(mPendingIntent);
        NotificationManager mNotifManager2 = (NotificationManager)this
                .getSystemService(Service.NOTIFICATION_SERVICE);


        if(view.getId()==R.id.notifBtn) {
           // notif_count+=1;
            NotificationActivity.notif_count+=1;
            mNotifManager.notify(NOTIF_ID,mBuilder.build());
        }

        else if(view.getId()==R.id.customBtn){
            mNotifManager.notify(NOTIF_ID2,mCustomBuilder.build());
           // mNotifManager.notify(NOTIF_ID,mBuilder.build());
        }

    }
}
