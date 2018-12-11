package com.example.pc.pruebaintent;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
Button boton;
    AppCompatActivity estaActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estaActividad = this;

        boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                PendingIntent i = PendingIntent.getActivity(estaActividad, 0, getIntent(), 0);

                NotificationCompat.Builder mensaje = new NotificationCompat.Builder(estaActividad, "CH_ID");

                mensaje.setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setPriority(Notification.PRIORITY_MAX) // No válido en API 26
                        .setContentTitle("Este es el título")
                        .setContentText("Este es el contenido del mensaje. Hemos utilizado el objeto Notification")
                        .setContentIntent(i);

                NotificationManager nM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nM.notify(1, mensaje.build());

            }
        });
    }
}
