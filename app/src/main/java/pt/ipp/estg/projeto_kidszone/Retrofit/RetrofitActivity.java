package pt.ipp.estg.projeto_kidszone.Retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import pt.ipp.estg.projeto_kidszone.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class RetrofitActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<POI> poiList;
    private Context ct;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Intent it=getIntent();
        apiInterface = ApiUtils.getApiPOI().create(ApiInterface.class);
        Call<List<POI>> call = apiInterface.getListPointsOfInterest(it.getStringExtra("location").toString(), it.getStringExtra("category").toString() /*it.getStringExtra("name").toString()*/);

        call.enqueue(new Callback<List<POI>>() {
            @Override
            public void onResponse(Response<List<POI>> response, Retrofit retrofit) {
                poiList=response.body();
                adapter=new RecyclerAdapter(poiList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }

//            @Override
//            public void onResponse(Call<List<POI>> call, Response<List<POI>> response) {
//                poiList=response.body();
//                adapter=new RecyclerAdapter(poiList);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<POI>> call, Throwable t) {
//
//            }
        });
    }


}
