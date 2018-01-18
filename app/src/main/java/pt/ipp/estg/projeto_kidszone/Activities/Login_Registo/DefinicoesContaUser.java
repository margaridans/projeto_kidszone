package pt.ipp.estg.projeto_kidszone.Activities.Login_Registo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projeto_kidszone.database_library.Database.MyDbHelper;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by Bernardino on 18/01/2018.
 */

public class DefinicoesContaUser extends Activity implements View.OnClickListener {
TextView  txtNomeUserEd;
EditText edPass, edPassConf;
Button btnPass;

    MyDbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.definicao_conta_user);

        myDb = new MyDbHelper(this);

        Intent intentEntrar = getIntent();
        String username = intentEntrar.getStringExtra("username");


        txtNomeUserEd = findViewById(R.id.nomeUsuarioEdit);
        txtNomeUserEd.setText(username);

        btnPass =  findViewById(R.id.btnAlterarPass);
        btnPass.setOnClickListener(this);

        edPass =  findViewById(R.id.editTextPasswordConta);
        edPass.setVisibility(View.GONE);

        edPassConf = findViewById(R.id.editTextConfirmPasswordConta);
        edPassConf.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnAlterarPass) {
            edPass.setVisibility(View.VISIBLE);
            edPassConf.setVisibility(View.VISIBLE);

        }
    }
}