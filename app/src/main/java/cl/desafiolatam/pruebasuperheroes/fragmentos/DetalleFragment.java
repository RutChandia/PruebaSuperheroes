package cl.desafiolatam.pruebasuperheroes.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayoutMediator;

import cl.desafiolatam.pruebasuperheroes.R;
import cl.desafiolatam.pruebasuperheroes.adapter.TabsAdapter;
import cl.desafiolatam.pruebasuperheroes.databinding.FragmentDetalleBinding;


public class DetalleFragment extends Fragment {
    private FragmentDetalleBinding b;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentDetalleBinding.inflate(inflater, container, false);

        b.viewPager.setAdapter(new TabsAdapter(this));
        new TabLayoutMediator(b.tabLayout, b.viewPager, (tab, position) -> {
            tab.setText(R.string.tab1 + position);
        }).attach();

        return b.getRoot();
    }
}