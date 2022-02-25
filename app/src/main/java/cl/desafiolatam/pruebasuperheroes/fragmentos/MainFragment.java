package cl.desafiolatam.pruebasuperheroes.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatam.pruebasuperheroes.R;
import cl.desafiolatam.pruebasuperheroes.adapter.SupersAdapter;
import cl.desafiolatam.pruebasuperheroes.databinding.FragmentMainBinding;
import cl.desafiolatam.pruebasuperheroes.viewmodel.SupersViewModel;

public class MainFragment extends Fragment {
    private FragmentMainBinding b;
    private SupersViewModel m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentMainBinding.inflate(inflater, container, false);
        m = new ViewModelProvider(getActivity()).get(SupersViewModel.class);

        SupersAdapter adapter = new SupersAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        b.recyclerLista.setLayoutManager(gridLayoutManager);
        b.recyclerLista.setAdapter(adapter);


        adapter.setListener(item -> {
            m.cargarSuper(item);
            Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_detalleFragment);
        });

        m.getMutableSupers().observe(getViewLifecycleOwner(), superheroes -> {
            adapter.setLista(superheroes);
        });

        return b.getRoot();
    }
}