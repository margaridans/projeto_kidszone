package pt.ipp.estg.projeto_kidszone.Retrofit;


import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by margarida on 21/12/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://tour-pedia.org/api/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiPOI() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
