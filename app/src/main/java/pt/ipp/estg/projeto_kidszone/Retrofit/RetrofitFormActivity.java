package pt.ipp.estg.projeto_kidszone.Retrofit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import pt.ipp.estg.projeto_kidszone.R;

public class RetrofitFormActivity extends Activity implements OnClickListener {
    Button button;
    RadioGroup locationGroup, categoryGroup;
    //EditText name;
    private String location;
    private String category;
    //private String name2;
    Spinner categorySpinner, locationSpinner;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        //Get the ids of view objects
        findAllViewsId();

//        RadioGroup radioGroupLocation = (RadioGroup) findViewById(R.id.locationGroup);
//        radioGroupLocation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                location = "";
//                if (R.id.londonRadio == checkedId) {
//                    location = "London";
//                } else if (R.id.amsterdamRadio == checkedId) {
//                    location = "Amsterdam";
//                } else if (R.id.barcelonaRadio == checkedId) {
//                    location = "Barcelona";
//                } else if (R.id.berlinRadio == checkedId) {
//                    location = "Berlin";
//                } else if (R.id.dubayRadio == checkedId) {
//                    location = "Dubay";
//                } else if (R.id.parisRadio == checkedId) {
//                    location = "Paris";
//                } else if (R.id.romeRadio == checkedId) {
//                    location = "Rome";
//                } else if (R.id.tuscanyRadio == checkedId) {
//                    location = "Tuscany";
//                }
//            }
//        });

        Spinner spinnerLocation=(Spinner) findViewById(R.id.locationSpinner);
        spinnerLocation.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                location=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RadioGroup radioGroupCategory = (RadioGroup) findViewById(R.id.categoryGroup);
        radioGroupCategory.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                category = "";
                if (R.id.attractionRadio == checkedId) {
                    category = "attraction";
                } else if (R.id.accomodationRadio == checkedId) {
                    category = "accommodation";
                } else if (R.id.restaurantRadio == checkedId) {
                    category = "restaurant";
                } else if (R.id.poiRadio == checkedId) {
                    category = "poi";
                }
            }
        });

//        Spinner spinnerCategory=(Spinner) findViewById(R.id.categorySpinner);
//        spinnerCategory.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                category=parent.getItemAtPosition(position).toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        //name2 = "";

        button.setOnClickListener(this);
    }

    private void findAllViewsId() {
        button = (Button) findViewById(R.id.submit);
        //name = (EditText) findViewById(R.id.name);
        locationSpinner=(Spinner) findViewById(R.id.locationSpinner);
        //locationGroup = (RadioGroup) findViewById(R.id.locationGroup);
        //categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        categoryGroup = (RadioGroup) findViewById(R.id.categoryGroup);
        //name = (EditText) findViewById(R.id.name);
    }

    @Override
    public void onClick(View v) {

        //start the DisplayActivity
        Intent inte = new Intent(getBaseContext(), RetrofitActivity.class);
        //inte.putExtra("name", name2);
        inte.putExtra("location", location);
        inte.putExtra("category", category);
        startActivity(inte);
    }


}