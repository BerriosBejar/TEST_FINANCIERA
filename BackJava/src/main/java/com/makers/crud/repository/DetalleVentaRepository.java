package com.makers.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.makers.crud.model.entity.DetalleVenta;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    @Query(value = "SELECT p.nombre AS nombreProducto, p.precio AS precioProducto, dv.cantidad,  dv.cantidad * p.precio AS subtotal " +
                   "FROM DETALLE_VENTA dv " +
                   "INNER JOIN PRODUCTO p ON dv.id_producto = p.id " +
                   "WHERE dv.id_venta = :id", nativeQuery = true)
    List<Object[]> findDetalleVentaByIdVenta(Long id);
}
