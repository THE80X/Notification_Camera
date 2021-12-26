package com.example.notification_camera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Build;

import android.Manifest;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;

public class Notification_Camera extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 112;




    Button btnCamera;
    Button btnNotify;

    SurfaceView sv;

    SurfaceHolder holder;



    final boolean FULL_SCREEN = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_camera);

        btnCamera = findViewById(R.id.btnCamera);
        btnNotify = findViewById(R.id.notify_btn);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(Notification_Camera.this,"My Notification");
                builder.setContentTitle("Соловьев Иван ИКБО-07-20");
                builder.setContentText("Курсовая работа Tickets Wallet Application");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Notification_Camera.this);
                managerCompat.notify(1,builder.build());

            }
        });




        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
            }
        });
    }






    public void checkPermission(String permission, int requestCode) {

        if (ContextCompat.checkSelfPermission(Notification_Camera.this, permission) == PackageManager.PERMISSION_DENIED) {

            //take permissions
            ActivityCompat.requestPermissions(Notification_Camera.this, new String[]{permission}, requestCode);
        } else {

            Toast.makeText(Notification_Camera.this, "Permission", Toast.LENGTH_LONG).show();


        }
    }





    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                btnCamera.setText("Permission Granted");

                Camera camera = Camera.open();
                SurfaceView surfaceView = findViewById(R.id.surfaceView);
                SurfaceHolder surfaceHolder = surfaceView.getHolder();
                try {
                    camera.setPreviewDisplay(surfaceHolder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                camera.startPreview();

            } else {
                Toast.makeText(Notification_Camera.this, "Camera permission Denied", Toast.LENGTH_SHORT).show();
            }

        }
    }
}