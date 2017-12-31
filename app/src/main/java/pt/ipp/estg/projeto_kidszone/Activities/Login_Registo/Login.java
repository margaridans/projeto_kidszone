package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.Activities.MainActivityUser;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;


public class Login extends AppCompatActivity implements View.OnClickListener {

    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        db=new MyDbHelper(this);

        TextView btnRegisto=(TextView) findViewById(R.id.btnRegistar);
        btnRegisto.setOnClickListener(this);

        final EditText et_username=(EditText) findViewById(R.id.editTextUser);
        final EditText et_password=(EditText) findViewById(R.id.editTextPass);

        Button btn_resgistar=(Button) findViewById(R.id.btnEntrar);
        btn_resgistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=et_username.getText().toString();
                String password=et_password.getText().toString();

                if(username.equals("")){
                    Toast.makeText(Login.this,"Username inválido",Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(Login.this,"Password inválida",Toast.LENGTH_SHORT).show();
                }else{
                    String res= db.validarUtilizador(username,password);

                    if(res.equals("OK")){
                        Toast.makeText(Login.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Login.this, "Login não efetuado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistar) {
            Intent intentRegisto = new Intent(this, Registo.class);
            startActivity(intentRegisto);
        }if(v.getId()==R.id.btnEntrar){
            Intent intentEntrar=new Intent(this,MainActivityUser.class);
            startActivity(intentEntrar);
        }
    }
}