package pe.edu.pucp.gtics.lab1221.entity;

import javax.persistence.*;

@Entity
@Table(name="juegos")
public class Games {
    /** Completar*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego", nullable = false)
    private Integer id;

    @Column(name="nombre", length = 50)
    private String nombre;

    @Column(name="descripción", length = 200)
    private String descripcion;

    @Column(name="precio")
    private Double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="idplataforma")
    private Platforms idplataforma;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Platforms getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(Platforms idplataforma) {
        this.idplataforma = idplataforma;
    }
}
