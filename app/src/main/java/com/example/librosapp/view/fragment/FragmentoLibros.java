package com.example.librosapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.example.librosapp.view.adapter.RecyclerLibrosAdapter;
import com.example.librosapp.viewmodel.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentoLibros extends Fragment {

    RecyclerView recyclerView;
    ViewModel viewModel;
    List<Libro> libroList;
    NavController navController;
    TextView tvRvLibrosVacio;
    Button btAddLibro, btVolver;

    public FragmentoLibros() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_libros, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvLibros);
        tvRvLibrosVacio = view.findViewById(R.id.tvRvLibrosVacio);
        btAddLibro = view.findViewById(R.id.btAddLibro);
        btVolver = view.findViewById(R.id.btVolverLibrosFrag);

        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);

        navController = Navigation.findNavController(view);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragmentoLibros_to_fragmentInicio);

            }
        });

        btAddLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragmentoLibros_to_fragmentAddLibro);

            }
        });

        Call<List<Libro>> libroCall = viewModel.getLibroClient().getAllLibros();

        libroCall.enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {

                libroList = response.body();

                try {

                    Thread.sleep(100);

                } catch (InterruptedException e) {

                }

                initRecycler(view);

            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {

            }
        });

    }

    private void initRecycler(View view) {

        RecyclerLibrosAdapter adapter = new RecyclerLibrosAdapter(libroList, getContext(), getActivity(), view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        if(adapter.getItemCount() == 0) {

            tvRvLibrosVacio.setText("No se ha encontrado ningún libro");

        }

    }

}