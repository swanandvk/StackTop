package stacktop.swanand.com.stacktop.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import androidx.core.app.NotificationCompat;
import stacktop.swanand.com.stacktop.R;
import stacktop.swanand.com.stacktop.ui.MainActivity;

public class DailyNotificationService extends JobService {
    @Override
    public boolean onStartJob(JobParameters job) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            String id = "id_question";
            // The user-visible name of the channel.
            CharSequence name = "Question";
            // The user-visible description of the channel.
            String description = "Notifications regarding our questions";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(id, name, importance);
            // Configure the notification channel.
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            // Sets the notification light color for notifications posted to this
            // channel, if the device supports this feature.
            mChannel.setLightColor(Color.RED);
            notificationManager.createNotificationChannel(mChannel);


            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 123, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(),"id_product")
                    .setSmallIcon(R.drawable.ic_stack_exchange_symbol) //your app icon
                    .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL) //your app icon
                    .setChannelId(id)
                    .setContentTitle("New Question")
                    .setAutoCancel(true).setContentIntent(pendingIntent)
                    .setNumber(1)
                    .setColor(255)
                    .setContentText("Content text")
                    .setWhen(System.currentTimeMillis());
            notificationManager.notify(1, notificationBuilder.build());
        }

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return true;
    }
}
