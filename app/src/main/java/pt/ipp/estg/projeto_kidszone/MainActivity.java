package pt.ipp.estg.projeto_kidszone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.Dicas.DicasActivity;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.Jogo;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.ActivityMainUser;
import pt.ipp.estg.projeto_kidszone.Activities.Login_Registo.Login;
import pt.ipp.estg.projeto_kidszone.ListaLocais.LocaisActivity;
import pt.ipp.estg.projeto_kidszone.NotifiAndProgBar.NotificationService;


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

        Button btnLocais = findViewById(R.id.btnLocais);
        btnLocais.setOnClickListener(this);

        startService(new Intent(this, NotificationService.class));

        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        String nome = prefs.getString("username", null);

        if (nome != null) {
            Intent intentSaiuSemLogout = new Intent(this, ActivityMainUser.class);
            intentSaiuSemLogout.putExtra("login", "normal");
            startActivity(intentSaiuSemLogout);
            finish();
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
        } else if (v.getId() == R.id.btnLocais) {
            Intent intentLocais = new Intent(this, LocaisActivity.class);
            startActivity(intentLocais);
        }
    }

}
