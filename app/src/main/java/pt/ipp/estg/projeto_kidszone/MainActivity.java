package pt.ipp.estg.projeto_kidszone;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.net.URI;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Dicas.DicasActivity;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.Login;


public class MainActivity extends Activity implements View.OnClickListener {

    MyDbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        myDb = new MyDbHelper(this);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        Button btnJogar = findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);

        Button btnDicas = findViewById(R.id.btnDicas);
        btnDicas.setOnClickListener(this);

    }


    public void gerarNotificao(View view) {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent vamosJogar = new Intent(this, MenuJogo.class);
        vamosJogar.setAction( "action-ok-vamos" );
        PendingIntent vamosJogarPI = PendingIntent.getActivity(this,0,vamosJogar,0);
        NotificationCompat.Action vamosJogarAC = new NotificationCompat.Action(R.drawable.entrar_noti,"Sim, vamos",vamosJogarPI);

        Intent cancelar = new Intent(this, MainActivity.class);
        vamosJogar.setAction( "action-cancelar" );
        PendingIntent cancelarPI = PendingIntent.getActivity(this,0,cancelar,0);
        NotificationCompat.Action cancelarAC = new NotificationCompat.Action(R.drawable.cancel_noti,"Cancelar",cancelarPI);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);


        builder.setContentTitle("Vamos jogar?");
        builder.setContentText("Que tal pores o teu conhecimento à prova?");
        builder.setSmallIcon(R.drawable.logo);
        builder.setContentIntent(vamosJogarPI);
        builder .addAction(vamosJogarAC);
        builder .addAction(cancelarAC);
        Notification n = builder.build();
        n.vibrate = new long[]{150, 300, 150, 600};
        nm.notify(R.drawable.sad, n);

        try {
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(this, som);
            toque.play();
        } catch (Exception e) {
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnJogar) {
            Intent intentJogar = new Intent(this, MenuJogo.class);
            startActivity(intentJogar);
        } else if (v.getId() == R.id.btnDicas) {
            Intent intentDicas = new Intent(this, DicasActivity.class);
            startActivity(intentDicas);
        } else if (v.getId() == R.id.btnLogin) {
            Intent intentLogin = new Intent(this, Login.class);
            startActivity(intentLogin);
        }
    }

}
