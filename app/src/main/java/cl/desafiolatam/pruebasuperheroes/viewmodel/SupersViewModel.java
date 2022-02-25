package cl.desafiolatam.pruebasuperheroes.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cl.desafiolatam.pruebasuperheroes.cliente.ClienteRetrofit;
import cl.desafiolatam.pruebasuperheroes.modelo.Superheroe;
import cl.desafiolatam.pruebasuperheroes.servicio.ServicioSupers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupersViewModel extends ViewModel {
    private MutableLiveData<List<Superheroe>> mutableSupers;
    private MutableLiveData<Superheroe> detalle;

    public SupersViewModel() {
        load();
        detalle = new MutableLiveData<>();
    }

    public MutableLiveData<List<Superheroe>> getMutableSupers() {
        return mutableSupers;
    }

    public MutableLiveData<Superheroe> getDetalle() {
        return detalle;
    }

    public void cargarSuper(Superheroe item) {
        detalle.setValue(item);
    }

    private void load() {
        mutableSupers = new MutableLiveData<>();
        ServicioSupers servicio = ClienteRetrofit.getInstance().create(ServicioSupers.class);
        Call<List<Superheroe>> call = servicio.getAll();
        call.enqueue(new Callback<List<Superheroe>>() {
            @Override
            public void onResponse(Call<List<Superheroe>> call, Response<List<Superheroe>> response) {
                if (response.isSuccessful()) {
                    List<Superheroe> h = response.body();
                    mutableSupers.setValue(h);
                }
            }

            @Override
            public void onFailure(Call<List<Superheroe>> call, Throwable t) {
                Log.d("failure: ", t.getMessage());
            }
        });
    }
}
