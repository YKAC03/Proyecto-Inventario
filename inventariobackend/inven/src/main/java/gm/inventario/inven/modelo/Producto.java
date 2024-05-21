package gm.inventario.inven.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name="productos")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @Column(name = "nombre_producto")
    private String nombre_producto;

    @Column(name = "precio_producto")
    private Float precio_producto;

    @Column(name = "lote_producto")
    private int lote_producto;

    @Column(name = "descripcion_producto")
    private String descripcion_producto;

    @Column(name = "cantidad_producto")
    private Integer cantidad_producto;
    

}
