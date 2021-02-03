package com.example.librosapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.librosapp.R;

public class FragmentInicio extends Fragment {

    Button btIrALibros, btIrAVentas;

    public FragmentInicio() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btIrALibros = view.findViewById(R.id.btIrFragLibros);
        btIrAVentas = view.findViewById(R.id.btIrFragVender);

        NavController navController = Navigation.findNavController(view);

        btIrALibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragmentInicio_to_fragmentoLibros);

            }
        });

        btIrAVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragmentInicio_to_fragmentoVentas);

            }
        });

    }

}