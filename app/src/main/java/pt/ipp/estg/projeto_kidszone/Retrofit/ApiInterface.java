package pt.ipp.estg.projeto_kidszone.Retrofit;

import android.view.View;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by margarida on 21/12/2017.
 */

public interface ApiInterface {

    @GET("getPlaces")
    Call<List<POI>> getListPointsOfInterest(@Query("location") String location,
                                            @Query("category") String category
                                            /*@Query("name") String name*/);

    void onClick(View v, int adapterPosition, boolean b);
}
