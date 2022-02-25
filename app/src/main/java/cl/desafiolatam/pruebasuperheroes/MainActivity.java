package cl.desafiolatam.pruebasuperheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cl.desafiolatam.pruebasuperheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
    }
}