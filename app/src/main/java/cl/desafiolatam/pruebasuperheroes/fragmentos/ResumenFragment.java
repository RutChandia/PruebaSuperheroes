package cl.desafiolatam.pruebasuperheroes.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import cl.desafiolatam.pruebasuperheroes.databinding.FragmentResumenBinding;
import cl.desafiolatam.pruebasuperheroes.viewmodel.SupersViewModel;


public class ResumenFragment extends Fragment {

    private FragmentResumenBinding b;
    private SupersViewModel m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentResumenBinding.inflate(inflater, container, false);
        m = new ViewModelProvider(getActivity()).get(SupersViewModel.class);
        b.setLifecycleOwner(getViewLifecycleOwner());
        b.setResumen(m.getDetalle().getValue());
        m.getDetalle().observe(getViewLifecycleOwner(), superheroe -> {
            Picasso.get().load(superheroe.getImages().getLg()).into(b.imgHeroeDetalle);
        });

        return b.getRoot();
    }
}
