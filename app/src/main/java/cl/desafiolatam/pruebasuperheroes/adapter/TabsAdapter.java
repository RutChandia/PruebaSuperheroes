package cl.desafiolatam.pruebasuperheroes.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import cl.desafiolatam.pruebasuperheroes.fragmentos.InfoFragment;
import cl.desafiolatam.pruebasuperheroes.fragmentos.ResumenFragment;
import cl.desafiolatam.pruebasuperheroes.fragmentos.StatsFragment;


public class TabsAdapter extends FragmentStateAdapter {

    public TabsAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: return new InfoFragment();
            case 2: return new StatsFragment();
            default: return new ResumenFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
