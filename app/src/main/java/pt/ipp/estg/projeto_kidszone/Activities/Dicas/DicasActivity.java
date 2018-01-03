package pt.ipp.estg.projeto_kidszone.Activities.Dicas;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Dicas;
import pt.ipp.estg.projeto_kidszone.Model.Dicas_Jogo;
import pt.ipp.estg.projeto_kidszone.R;

/**
 * Created by margarida on 30/12/2017.
 */

public class DicasActivity extends AppCompatActivity {

    private SensorManager sm;

    private float acelVal;
    private float acelLast;
    private float shake;

    private Dicas_Jogo sugestao;
    private Dicas dica;
    private TextView txtDica;
    private int id_lista = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas);

        ArrayList<Dicas> listaDicas = new ArrayList<>();
        sugestao = new Dicas_Jogo(this, -1);

        txtDica = (TextView) findViewById(R.id.txt_dica);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

        MyDbHelper dbHelper = new MyDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Dicas.getDicas(db, listaDicas);
        dica = listaDicas.get(id_lista);

    }

    private void setDicaToView() {
        dica = sugestao.getNextDica();
        if (dica != null) {
            txtDica.setText(dica.getDica_name());
        } else {
            Intent it = new Intent(this, FimDica.class);
            startActivity(it);
        }
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 12) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(500);

                setDicaToView();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

}
