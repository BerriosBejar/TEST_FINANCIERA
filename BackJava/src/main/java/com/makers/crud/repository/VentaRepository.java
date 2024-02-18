package com.makers.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.makers.crud.model.entity.Venta;
import java.util.List;


@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query(value = "SELECT " +
    "    v.id AS idVenta, " +
    "    c.id AS idCliente, " +
    "    c.nombres AS nombresCliente, " +
    "    c.apellidos AS apellidosCliente, " +
    "    v.fecha AS fechaVenta, " +
    "    SUM(p.precio * dv.cantidad) AS total " +
    "FROM VENTA v " +
    "INNER JOIN CLIENTE c ON v.id_cliente = c.id " +
    "INNER JOIN DETALLE_VENTA dv ON v.id = dv.id_venta " +
    "INNER JOIN PRODUCTO p ON dv.id_producto = p.id " +
    "GROUP BY v.id, c.id, c.nombres, c.apellidos, v.fecha", nativeQuery = true)
    List<Object[]> findFullList();

    @Query(value = "SELECT " +
    "    v.id AS idVenta, " +
    "    c.id AS idCliente, " +
    "    c.nombres AS nombresCliente, " +
    "    c.apellidos AS apellidosCliente, " +
    "    v.fecha AS fechaVenta, " +
    "    SUM(p.precio * dv.cantidad) AS total " +
    "FROM VENTA v " +
    "INNER JOIN CLIENTE c ON v.id_cliente = c.id " +
    "INNER JOIN DETALLE_VENTA dv ON v.id = dv.id_venta " +
    "INNER JOIN PRODUCTO p ON dv.id_producto = p.id " +
    "WHERE v.fecha = :filterDate " +
    "GROUP BY v.id, c.id, c.nombres, c.apellidos, v.fecha", nativeQuery = true)
    List<Object[]> findFullListFilter(String filterDate);


}

