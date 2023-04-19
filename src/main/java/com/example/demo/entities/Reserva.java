package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.DateTimeSyntax;
import java.text.DecimalFormat;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva", nullable = false)
    private Integer idReserva;

    @Column(name = "fecha_reserva", nullable = false)
    private DateTimeSyntax fecha_reserva;

    @Column(name = "precio_total", nullable = false)
    private DecimalFormat precio_total;

    @Column(name = "estado_pago",nullable = false)
    private String estado_pago;

    @ManyToOne
    @JoinColumn(name = "user_iduser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vuelo_idvuelo")
    private Vuelo vuelo;

}