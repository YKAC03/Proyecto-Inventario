package gm.inventario.inven.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gm.inventario.inven.excepcion.RecursoNoEncontradoExcepcion;
import gm.inventario.inven.modelo.Producto;
import gm.inventario.inven.servicio.ProductoServicio;

@RestController
@CrossOrigin(value="http://localhost:3000")
@RequestMapping("inventario-app")
public class ProductoControlador {
    @SuppressWarnings("unused")
    private static final Logger logger=LoggerFactory.getLogger(ProductoControlador.class);
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos=productoServicio.listarProductos();
        
        return productos;
        
    }
    @PostMapping("/agregarProducto")
    public Producto agregarProducto(@RequestBody Producto producto){
       
        return productoServicio.agregarProducto(producto);
    }
    
    @GetMapping("/buscarProducto/{id}")
    public ResponseEntity<Producto> buscarProductoPorId (@PathVariable Integer id){
        Producto producto=productoServicio.buscarProductoPorId(id);
        if(producto ==null){
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: "+id);
        }
        return ResponseEntity.ok(producto);
    }
    @PutMapping("/buscarProducto/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoRecibido){
        Producto producto =productoServicio.buscarProductoPorId(id);
        if(producto==null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: "+id);
        }
        producto.setNombre_producto(productoRecibido.getNombre_producto());
        producto.setPrecio_producto(productoRecibido.getPrecio_producto());
        producto.setLote_producto(productoRecibido.getLote_producto());
        producto.setDescripcion_producto(productoRecibido.getDescripcion_producto());
        producto.setCantidad_producto(productoRecibido.getCantidad_producto());
        productoServicio.agregarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable Integer id){
        Producto producto=productoServicio.buscarProductoPorId(id);
        if(producto==null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe : "+id);

        }
        productoServicio.eliminarProducto(producto);
        Map<String,Boolean> respuesta=new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
