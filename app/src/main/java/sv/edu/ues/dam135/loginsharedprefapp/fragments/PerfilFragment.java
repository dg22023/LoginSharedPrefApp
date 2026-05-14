package sv.edu.ues.dam135.loginsharedprefapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sv.edu.ues.dam135.loginsharedprefapp.R;

public class PerfilFragment extends Fragment {
    public PerfilFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //return inflater.inflate(R.layout.fragment_perfil, container, false);

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        TextView tvPerfil = view.findViewById(R.id.tvPerfil);

        SharedPreferences prefs = requireActivity().getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        // Si guardaste el usuario actual en SharedPreferences con clave "usuario_actual", recupéralo
        String usuarioActual = prefs.getString("usuario_actual", "Usuario");
        tvPerfil.setText("Perfil de: " + usuarioActual);

        return view;

    }
}
