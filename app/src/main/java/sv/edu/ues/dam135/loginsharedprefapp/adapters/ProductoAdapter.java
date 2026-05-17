package sv.edu.ues.dam135.loginsharedprefapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;
import sv.edu.ues.dam135.loginsharedprefapp.R;
import sv.edu.ues.dam135.loginsharedprefapp.models.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private List<Producto> listaProductos;

    public ProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.tvNombre.setText(producto.getNombre());
        holder.tvPrecio.setText(String.format(Locale.getDefault(), "%.2f", producto.getPrecio()));
        holder.tvStock.setText(String.valueOf(producto.getStock()));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvPrecio, tvStock;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvProductName);
            tvPrecio = itemView.findViewById(R.id.tvPriceValue);
            tvStock = itemView.findViewById(R.id.tvStockValue);
        }
    }
}