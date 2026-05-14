package sv.edu.ues.dam135.loginsharedprefapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtPassword;
    private Button btnIngresar;
    private Button btnSalir;
    private Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnSalir = findViewById(R.id.btnSalir);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RegistrarActivity.class);
            startActivity(i);
        });

        btnSalir.setOnClickListener(v -> finishAffinity());

        btnIngresar.setOnClickListener(v -> validarLogin());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void validarLogin() {
        String user = edtUsuario.getText().toString();
        String pass = edtPassword.getText().toString();

        SharedPreferences prefs = getSharedPreferences("usuarios", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("usuario_actual", user);
        editor.apply();

        String passGuardado = prefs.getString(user, null);

        if (passGuardado == null) {
            Toast.makeText(this, "Error: usuario no registrado", Toast.LENGTH_LONG).show();
            return;
        }

        if (!passGuardado.equals(pass)) {
            Toast.makeText(this, "Error: clave incorrecta", Toast.LENGTH_LONG).show();
            return;
        }

        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.opRegistrar) {
            startActivity(new Intent(this, RegistrarActivity.class));
        }
        if (item.getItemId() == R.id.opSalir) {
            finishAffinity();
        }
        return true;
    }

}