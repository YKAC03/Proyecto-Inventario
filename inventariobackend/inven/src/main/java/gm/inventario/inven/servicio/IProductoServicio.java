package gm.inventario.inven.servicio;

import java.util.List;

import gm.inventario.inven.modelo.Producto;

public interface IProductoServicio {
    public List<Producto> listarProductos();
    public Producto buscarProductoPorId(Integer id);
    public List<Producto> buscarProducto(String nombre);
    public Producto agregarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
    
}
