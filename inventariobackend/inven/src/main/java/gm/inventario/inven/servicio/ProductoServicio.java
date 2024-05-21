package gm.inventario.inven.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gm.inventario.inven.modelo.Producto;
import gm.inventario.inven.repositorio.ProductoRepositorio;
@Service

public class ProductoServicio implements IProductoServicio{
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        Producto producto=productoRepositorio.findById(id).orElse(null);
        return producto;
    }

    @Override
    public List<Producto> buscarProducto(String nombre) {
        List<Producto> producto=productoRepositorio.findByNombre(nombre);
        return producto;
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);
    }

}
