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
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.MainActivity;
import pt.ipp.estg.projeto_kidszone.R;


public class Login extends AppCompatActivity /*implements View.OnClickListener */{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

//        Toolbar toolbarLogin = (Toolbar) findViewById(R.id.toolbarLogin);
//        setSupportActionBar(toolbarLogin);
//
//        /*Faz com que os icons sejam clicáveis. Este método apenas tornará o ícone
//        e o título pressionáveis, mas na verdade não adicionarão a funcionalidade de navegar para cima*/
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//
//
//    /*Voltar para trás*/
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
//
//
//    public void EntraComCampos(View V) {
//
//        final Context context;
//        context = getApplication();
//        final Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.login);
//        dialog.setTitle("Login");
//
//        final EditText editTextUserName = (EditText) dialog
//                .findViewById(R.id.editTextUser);
//        final EditText editTextPassword = (EditText) dialog
//                .findViewById(R.id.editTextUser);
//
//        Button btnSignIn = (Button) dialog.findViewById(R.id.btnLogin);
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//
//                String userName = editTextUserName.getText().toString();
//                String password = editTextPassword.getText().toString();
//                String guardarSenha = getPassword(userName);
//                if (password.equals(guardarSenha)) {
//                    Toast.makeText(context, "Login efetuado com sucesso", Toast.LENGTH_LONG).show();
//                    dialog.dismiss();
//                } else {
//                    Toast.makeText(context, "Username e password não correspondem", Toast.LENGTH_LONG).show();
//                }
//            }
//
//        });
//
//        dialog.show();
//    }
//
//
//    public SQLiteDatabase db;
//    private final Context context;
//    private MyDbHelper dbHelper;
//
//    public Login(Context _context) {
//        context = _context;
//        dbHelper = new MyDbHelper(context);
//    }
//
//    public Login open() throws SQLException {
//        db = dbHelper.getWritableDatabase();
//        return this;
//    }
//
//    public void close() {
//        db.close();
//    }
//
//    public SQLiteDatabase getDatabaseInstance() {
//        return db;
//    }
//
//    public void inserirCampos(String nome_user, String pass_user) {
//        ContentValues newValues = new ContentValues();
//        newValues.put("username", nome_user);
//        newValues.put("password", pass_user);
//        db.insert("tblUser", null, newValues);
//
//    }
//
//
//    public String getPassword(String userName) {
//        Cursor cursor = db.query("tblUser", null, " username=?",
//                new String[]{userName}, null, null, null);
//        if (cursor.getCount() < 1) {
//            cursor.close();
//            return "Não existe nenhum utilizador com esses dados";
//        }
//        cursor.moveToFirst();
//        String password = cursor.getString(cursor.getColumnIndex("password"));
//        cursor.close();
//        return password;
//    }
//
//    public void atualizarCampos(String userName, String password) {
//        ContentValues updatedValues = new ContentValues();
//        updatedValues.put("username", userName);
//        updatedValues.put("password", password);
//
//        String where = "username = ?";
//        db.update("tblUser", updatedValues, where, new String[]{userName});
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.btnRegistar) {
//            Intent intentRegisto = new Intent(this, Registo.class);
//            startActivity(intentRegisto);
//        } else if (v.getId() == R.id.btnEntrar) {
//            Intent intentEntrar = new Intent(this, MainActivity.class);
//            startActivity(intentEntrar);
//        }
//    }
}