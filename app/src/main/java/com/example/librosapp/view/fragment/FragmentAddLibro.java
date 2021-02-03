package com.example.librosapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.librosapp.R;
import com.example.librosapp.model.pojo.Libro;
import com.example.librosapp.viewmodel.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAddLibro extends Fragment {

    Button btVolver, btAdd;
    ViewModel viewModel;
    NavController navController;
    EditText etTitulo, etEditorial, etPaginas, etAutor, etUrl;

    public FragmentAddLibro() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_libro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);

        viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);
        navController = Navigation.findNavController(view);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragmentAddLibro_to_fragmentoLibros);

            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titulo = etTitulo.getText().toString();
                String editorial = etEditorial.getText().toString();
                String paginas = etPaginas.getText().toString();
                String autor = etAutor.getText().toString();
                String url = etUrl.getText().toString();

                if (titulo.isEmpty() || editorial.isEmpty() || paginas.isEmpty() || autor.isEmpty() || url.isEmpty()) {

                    Toast.makeText(getContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();

                } else {

                    long paginasLong = Long.parseLong(paginas);

                    Libro libro = new Libro(titulo, editorial, paginasLong, autor, url, 0);

                    Call<Long> libroCall = viewModel.getLibroClient().postLibro(libro);

                    libroCall.enqueue(new Callback<Long>() {
                        @Override
                        public void onResponse(Call<Long> call, Response<Long> response) {

                            navController.navigate(R.id.action_fragmentAddLibro_to_fragmentoLibros);

                        }

                        @Override
                        public void onFailure(Call<Long> call, Throwable t) {

                        }
                    });

                }

            }
        });

    }

    private void init(View view) {

        btVolver = view.findViewById(R.id.btVolverAddLibroFrag);
        btAdd = view.findViewById(R.id.btAddLibro2);

        etTitulo = view.findViewById(R.id.etTituloLibroAdd);
        etEditorial = view.findViewById(R.id.etEditorialLibroAdd);
        etPaginas = view.findViewById(R.id.etPaginasLibroAdd);
        etAutor = view.findViewById(R.id.etAutorLibroAdd);
        etUrl = view.findViewById(R.id.etUrlLibroAdd);

    }

}