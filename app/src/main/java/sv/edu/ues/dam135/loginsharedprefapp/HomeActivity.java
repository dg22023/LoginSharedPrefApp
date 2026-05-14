package sv.edu.ues.dam135.loginsharedprefapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.ues.dam135.loginsharedprefapp.fragments.InicioFragment;
import sv.edu.ues.dam135.loginsharedprefapp.fragments.PerfilFragment;
import sv.edu.ues.dam135.loginsharedprefapp.fragments.ProductosFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        bottomNav = findViewById(R.id.bottomNav);

        // Cargar fragment inicial
        loadFragment(new InicioFragment());

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selected = null;
            int id = item.getItemId();
            if (id == R.id.nav_inicio) selected = new InicioFragment();
            else if (id == R.id.nav_productos) selected = new ProductosFragment();
            else if (id == R.id.nav_perfil) selected = new PerfilFragment();

            if (selected != null) loadFragment(selected);
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }
}
