package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.User;
import pt.ipp.estg.projeto_kidszone.R;


public class Registo extends AppCompatActivity {
    EditText editTextUserName, editTextPassword, editTextConfirmPassword;
    Button btnCreateAccount;
    Context context = this;
    Login login;

    MyDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo);

        db = new MyDbHelper(this);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount = (Button) findViewById(R.id.btnCriarConta);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();


                if (username.equals("")) {
                    Toast.makeText(Registo.this, "Username inválido", Toast.LENGTH_SHORT).show();
                } else if (password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(Registo.this, "Password inválida", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(Registo.this, "As passwords não coincidem", Toast.LENGTH_SHORT).show();
                } else {
                    long res = db.criarUtilizador(username, password);

                    if (!db.checkIFExistis(editTextUserName.getText().toString())) {
                        if (res > 0) {
                            Toast.makeText(Registo.this, "Registo efetuado com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registo.this, Login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Registo.this, "Ocorreu um erro. Não foi possível registar.", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(Registo.this, "Não é possível registar esse usuário, pois ele já existe", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}