package com.example.a5alumno.ejercicio3_notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by A5Alumno on 23/11/2016.
 */
public class NotificationActivity extends AppCompatActivity {
    public static int notif_count = 1;

    private EditText mEdit;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("returnString", this.mEdit.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();

    }
}
