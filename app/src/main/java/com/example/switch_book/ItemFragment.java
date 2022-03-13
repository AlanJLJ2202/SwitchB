package com.example.switch_book;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ItemFragment extends Fragment {

    Button btnAgregar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        btnAgregar = (Button) view.findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistroFragment fragment = new RegistroFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameCard, fragment, "HOLA");
                ft.addToBackStack(null);  //optional, si quieres agregarlo a la pila
                ft.commit();
            }
        });
        return view;
    }
}