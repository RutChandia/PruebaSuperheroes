package cl.desafiolatam.pruebasuperheroes.cliente;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRetrofit {
    private static Retrofit instance;

    private ClienteRetrofit(){}

    public synchronized static Retrofit getInstance(){
        if(instance == null)
        {
            instance = new Retrofit.Builder()
                    .baseUrl("https://akabab.github.io/superhero-api/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
