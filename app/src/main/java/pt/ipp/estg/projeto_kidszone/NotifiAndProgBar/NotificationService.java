package pt.ipp.estg.projeto_kidszone.NotifiAndProgBar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 19/01/2018.
 */

public class NotificationService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private Timer mTimer;

    @Override
    public void onCreate() {
        super.onCreate();
        mTimer = new Timer();
        mTimer.schedule(timerTask, 2000, 300 * 1000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {

        } catch (Exception e) {

        }
        return super.onStartCommand(intent, flags, startId);
    }


    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Log.e("log", "running");
            notifiy();
        }
    };

    public void onDestroy() {
        try {
            mTimer.cancel();
            timerTask.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent it = new Intent("pt.ipp.estg.projeto_kidszone");
        it.putExtra("yourvalue", "torestore");
        sendBroadcast(it);
    }


    public void notifiy() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent vamosJogar = new Intent(this, MenuJogo.class);
        vamosJogar.setAction("action-ok-vamos");
        PendingIntent vamosJogarPI = PendingIntent.getActivity(this, 0, vamosJogar, 0);
        NotificationCompat.Action vamosJogarAC = new NotificationCompat.Action(R.drawable.entrar_noti, "Sim, vamos", vamosJogarPI);

        Intent cancelar = new Intent(this, MainActivity.class);
        vamosJogar.setAction("action-cancelar");
        PendingIntent cancelarPI = PendingIntent.getActivity(this, 0, cancelar, 0);
        NotificationCompat.Action cancelarAC = new NotificationCompat.Action(R.drawable.cancel_noti, "Cancelar", cancelarPI);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);


        builder.setContentTitle("Vamos jogar?");
        builder.setContentText("Que tal pores o teu conhecimento à prova?");
        builder.setSmallIcon(R.drawable.logo);
        builder.setContentIntent(vamosJogarPI).setAutoCancel(true);
        builder.addAction(vamosJogarAC).setAutoCancel(true);
        builder.addAction(cancelarAC).setAutoCancel(true);
        Notification n = builder.build();
        builder.setAutoCancel(true);
        n.vibrate = new long[]{150, 300, 150, 300};
        nm.notify(R.drawable.logo, n);
    }


}
