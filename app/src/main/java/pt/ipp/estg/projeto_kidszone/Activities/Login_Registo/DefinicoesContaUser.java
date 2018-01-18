package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.User;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.JogoTreino;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 18/01/2018.
 */

public class DefinicoesContaUser extends Activity implements View.OnClickListener {

    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.definicao_conta_user);

        db = new MyDbHelper(this);

        TextView txtEliminarConta = findViewById(R.id.cancelarConta);
        txtEliminarConta.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancelarConta) {

            SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
            final String nome = prefs.getString("username", "default");

            onPause();
            AlertDialog.Builder alertaSair = new AlertDialog.Builder(DefinicoesContaUser.this);
            alertaSair.setTitle("Aviso");
            alertaSair.setMessage(nome + ", tens a certeza que queres eliminar a tua conta?");
            alertaSair.setCancelable(false);
            alertaSair.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onResume();
                }
            });
            alertaSair.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Boolean res = db.deleteUser(nome);

                    if (res == true) {


                        Toast.makeText(DefinicoesContaUser.this, "Conta eliminada com sucesso", Toast.LENGTH_SHORT).show();
                        Intent intentCancelarConta = new Intent(DefinicoesContaUser.this, MainActivity.class);
                        startActivity(intentCancelarConta);
                        finish();
                    }
                }
            });
            AlertDialog alertDialogo = alertaSair.create();
            alertDialogo.show();

        }
    }
}