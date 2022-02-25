package cl.desafiolatam.pruebasuperheroes.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatam.pruebasuperheroes.databinding.FragmentStatsBinding;
import cl.desafiolatam.pruebasuperheroes.viewmodel.SupersViewModel;


public class StatsFragment extends Fragment {
    private FragmentStatsBinding b;
    private SupersViewModel m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentStatsBinding.inflate(inflater, container, false);
        m = new ViewModelProvider(getActivity()).get(SupersViewModel.class);
        b.setLifecycleOwner(getViewLifecycleOwner());
        b.setStats(m.getDetalle().getValue());


        return b.getRoot();
    }
}