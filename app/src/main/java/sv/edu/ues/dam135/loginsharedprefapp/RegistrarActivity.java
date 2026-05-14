package sv.edu.ues.dam135.loginsharedprefapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    private EditText edtUser, edtEmail, edtPass, edtConfirm;
    private Button btnGuardar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);

        edtUser = findViewById(R.id.edtUser);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        edtConfirm = findViewById(R.id.edtConfirm);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnGuardar.setOnClickListener(v -> guardarUsuario());
        btnRegresar.setOnClickListener(v -> finish());
    }

    private void guardarUsuario() {
        String user = edtUser.getText().toString();
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        String confirm = edtConfirm.getText().toString();

        if (user.length() < 3) {
            Toast.makeText(this, "Usuario debe tener al menos 3 caracteres", Toast.LENGTH_LONG).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email inválido", Toast.LENGTH_LONG).show();
            return;
        }

        if (pass.length() < 5) {
            Toast.makeText(this, "Password debe tener al menos 5 caracteres", Toast.LENGTH_LONG).show();
            return;
        }

        if (!pass.equals(confirm)) {
            Toast.makeText(this, "Passwords no coinciden", Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(user, pass);
        editor.apply();

        Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_LONG).show();

        edtUser.setText("");
        edtEmail.setText("");
        edtPass.setText("");
        edtConfirm.setText("");
    }
}
