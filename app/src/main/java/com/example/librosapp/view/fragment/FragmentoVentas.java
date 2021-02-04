package com.example.librosapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.librosapp.R;
import com.example.librosapp.model.pojo.Libro;
import com.example.librosapp.view.adapter.RecyclerVentasAdapter;
import com.example.librosapp.viewmodel.ViewModel;

import java.util.List;

public class FragmentoVentas extends Fragment {

    RecyclerView recyclerView;
    ViewModel viewModel;
    List<Libro> libroList;
    NavController navController;
    TextView tvRvVentasVacio;
    Button btVolver;

    public FragmentoVentas() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ventas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvVentas);
        tvRvVentasVacio = view.findViewById(R.id.tvRvVentasVacio);
        btVolver = view.findViewById(R.id.btVolverVentasFrag);

        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);

        navController = Navigation.findNavController(view);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragmentoVentas_to_fragmentInicio);

            }
        });

        viewModel.mostrarLibros().observe(getActivity(), new Observer<List<Libro>>() {
            @Override
            public void onChanged(List<Libro> libroLista) {

                libroList = libroLista;
                initRecycler(view);

            }
        });

    }

    private void initRecycler(View view) {

        RecyclerVentasAdapter adapter = new RecyclerVentasAdapter(libroList, getContext(), getActivity(), view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        if(adapter.getItemCount() == 0) {

            tvRvVentasVacio.setText("No se puede vender ningún libro porque no existe ninguno");

        }

    }

}