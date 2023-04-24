package com.example.demo.repository;

import com.example.demo.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into  reserva (fecha_reserva, precio_total, estado_pago, user_iduser, vuelo_idvuelo) values (CURRENT_TIMESTAMP,?1, 'procesado',?2,?3)")
    void reservar(Float precio, Integer iduser, Integer idvuelo);
}
