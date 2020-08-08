package com.example.notekeeper;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NoteReminderNotification extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        showNotification();

        Button buttonShowReminder = findViewById(R.id.action_set_reminder);

        buttonShowReminder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoteReminderNotification.this, NoteActivity.class) );
            }
        });
    }




    public void showNotification() {


        NotificationManager NotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("SET_REMINDER",
                    "NOTE_REMINDER",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Notes notification reminder");
            NotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "NoteReminder")
                .setSmallIcon(R.drawable.ic_stat_note_reminder)
                .setContentTitle("Note reminder")
                .setContentText("This is a note reminder")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


    }


    }

