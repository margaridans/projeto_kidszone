package pt.ipp.estg.projeto_kidszone.Activities.Jogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import pt.ipp.estg.projeto_kidszone.R;

public class FimJogo extends AppCompatActivity {
private String status;
private ImageView imageView;
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);


    }
}
