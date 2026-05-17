package sv.edu.ues.dam135.loginsharedprefapp.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import sv.edu.ues.dam135.loginsharedprefapp.R;
import sv.edu.ues.dam135.loginsharedprefapp.adapters.ProductoAdapter;
import sv.edu.ues.dam135.loginsharedprefapp.models.Producto;

public class ProductosFragment extends Fragment {

    public ProductosFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_productos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvProductos = view.findViewById(R.id.rvProductos);
        
        // Datos de ejemplo
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop Pro 14", 1299.99, 15));
        productos.add(new Producto("Smartphone X", 899.50, 24));
        productos.add(new Producto("Auriculares Bluetooth", 149.99, 45));
        productos.add(new Producto("Monitor 4K 27\"", 399.00, 10));
        productos.add(new Producto("Teclado Mecánico", 89.90, 30));
        productos.add(new Producto("Mouse Inalámbrico", 45.00, 50));

        ProductoAdapter adapter = new ProductoAdapter(productos);
        rvProductos.setAdapter(adapter);
    }
}