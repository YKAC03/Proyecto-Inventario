package gm.inventario.inven.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gm.inventario.inven.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto,Integer>{
    @Query("SELECT p FROM Producto p WHERE p.nombre_producto LIKE %?1%")
    List<Producto> findByNombre(String name);
}
