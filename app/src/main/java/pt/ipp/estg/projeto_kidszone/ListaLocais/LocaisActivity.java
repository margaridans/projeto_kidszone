package pt.ipp.estg.projeto_kidszone.ListaLocais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import pt.ipp.estg.projeto_kidszone.Activities.Dicas.DicasActivity;
import pt.ipp.estg.projeto_kidszone.Activities.Jogo.MenuJogo;
import pt.ipp.estg.projeto_kidszone.Map.MapsActivity;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by margarida on 20/01/2018.
 */

public class LocaisActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locais_activity);


        Button btnLista = findViewById(R.id.btnLista);
        btnLista.setOnClickListener(this);

        Button btnMapa = findViewById(R.id.btnMapa);
        btnMapa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLista) {
            Intent intentLista = new Intent(this, ListaLocaisActivity.class);
            startActivity(intentLista);
        } else if (v.getId() == R.id.btnMapa) {
            Intent intentMapa = new Intent(this, MapsActivity.class);
            startActivity(intentMapa);
        }
    }
}
