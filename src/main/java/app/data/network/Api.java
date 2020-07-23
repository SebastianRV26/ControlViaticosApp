package app.data.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class exposes the server API to rest of the app.
 */
public class Api {

    private static Api instance;
    private static final String BASE_URL = "http://localhost:3000/";
    private Retrofit retrofit;

    // Services
    private UserService userService;

    /**
     * @return the unique instance of the API
     */
    public static synchronized Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    /**
     * Creates the retrofit instance and instantiates all the services.
     */
    private Api() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
    }

    // Services getters
    public UserService getUserService() {
        return userService;
    }
}