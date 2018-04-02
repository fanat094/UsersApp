package usersapp.yamschikovdima.dima.ua.usersapp.api;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    static APIClient usersAppApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/") //Базовая частина адреси
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необхідний для для перетвореняня JSON'а в обєкти
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        usersAppApi = retrofit.create(APIClient.class); // Объект, за допомогою якого киконуються запити
    }

    public static APIClient getApi() {
        return usersAppApi;
    }
}
