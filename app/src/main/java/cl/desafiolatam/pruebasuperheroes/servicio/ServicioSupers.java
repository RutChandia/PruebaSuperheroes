package cl.desafiolatam.pruebasuperheroes.servicio;

import java.util.List;

import cl.desafiolatam.pruebasuperheroes.modelo.Superheroe;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioSupers {
    @GET("all.json")
    Call<List<Superheroe>> getAll();
}
