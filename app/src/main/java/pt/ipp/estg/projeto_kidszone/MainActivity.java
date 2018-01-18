package pt.ipp.estg.projeto_kidszone;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Button;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Dicas.DicasActivity;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.ActivityMainUser;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.Login;



public class MainActivity extends Activity implements View.OnClickListener {

    MyDbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        myDb = new MyDbHelper(this);

        Button btnLogin =  findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        Button btnJogar =  findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);

        Button btnDicas =  findViewById(R.id.btnDicas);
        btnDicas.setOnClickListener(this);
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
