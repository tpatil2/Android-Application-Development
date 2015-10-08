package example.csci567.simpleeventreceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tejas on 2/22/2015.
 */

public class ChargerConnected extends BroadcastReceiver {
    private static String message;
    private final static int my_id = 1;
    private NotificationManager mgr;

    public ChargerConnected(){}
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
        {
            //Testing in Log
            //Log.d(message, "Charger is connected!! ************");
            sendNotification(context, "Device is now put on charging");
        }
    }

    private void sendNotification(Context context, String message)
    {
        mgr=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);


        NotificationCompat.Builder notify_me = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(context.getString(R.string.hello_world))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message)).setContentText(message);

        notify_me.setContentIntent(pIntent);
        mgr.notify(my_id, notify_me.build());



    }
}