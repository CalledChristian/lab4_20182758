package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.DateTimeSyntax;
import java.sql.Timestamp;
import java.text.DecimalFormat;

@Getter
@Setter
@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvuelo", nullable = false)
    private Integer idVuelo;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "fecha_salida", nullable = false)
    private Timestamp fecha_salida;

    @Column(name = "fecha_llegada", nullable = false)
    private Timestamp fecha_llegada;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idaerolinea")
    private Aerolinea aerolinea;

    @Column(name = "asientos_disponibles", nullable = false)
    private Integer asientos_disponibles;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;


}