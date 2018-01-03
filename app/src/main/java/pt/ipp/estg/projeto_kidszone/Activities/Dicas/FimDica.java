package pt.ipp.estg.projeto_kidszone.Activities.Dicas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by margarida on 03/01/2018.
 */

public class FimDica extends AppCompatActivity {
    private String status;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_dica);


    }
}
