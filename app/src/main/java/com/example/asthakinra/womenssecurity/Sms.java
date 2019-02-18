package com.example.asthakinra.womenssecurity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity implements View.OnClickListener {
    Button backk;
    Button send;
    EditText phone_Number, message;
    String[] permission = {Manifest.permission.SEND_SMS};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);
        backk = findViewById(R.id.backk);
        backk.setOnClickListener(this);


        send = (Button) findViewById(R.id.Send_msg_Btn);
        phone_Number = (EditText) findViewById(R.id.EditText_PhoneNumber);
        message = (EditText) findViewById(R.id.MainActivity_Message);

        ActivityCompat.requestPermissions(Sms.this, permission, 0);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_Num = phone_Number.getText().toString();
                String send_msg = message.getText().toString();

                if (hasPermissions(getApplicationContext(), permission[0])) {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phone_Num, null, send_msg, null, null);
                    phone_Number.setText("");
                    message.setText("");
                    Toast.makeText(getApplicationContext(), "Sms Sent successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sms not sent", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean hasPermissions(Context context, String permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && context != null && permissions != null) {
            if (ActivityCompat.checkSelfPermission(context, permissions) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backk:
                Intent i = new Intent(Sms.this, Home.class);
                startActivity(i);
                break;
        }
    }
}