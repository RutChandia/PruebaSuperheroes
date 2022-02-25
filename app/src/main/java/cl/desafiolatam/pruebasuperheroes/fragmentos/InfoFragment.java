package cl.desafiolatam.pruebasuperheroes.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatam.pruebasuperheroes.databinding.FragmentInfoBinding;
import cl.desafiolatam.pruebasuperheroes.viewmodel.SupersViewModel;


public class InfoFragment extends Fragment {
    private FragmentInfoBinding b;
    private SupersViewModel m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentInfoBinding.inflate(inflater, container, false);
        m = new ViewModelProvider(getActivity()).get(SupersViewModel.class);
        b.setLifecycleOwner(getViewLifecycleOwner());
        b.setInfo(m.getDetalle().getValue());


        return b.getRoot();
    }
}