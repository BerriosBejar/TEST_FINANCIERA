package com.makers.crud.service;

import java.util.List;
import java.util.Optional;

import com.makers.crud.model.dto.DetalleVentasListDto;
import com.makers.crud.model.entity.DetalleVenta;
import com.makers.crud.model.entity.FullDetalleVenta;


public interface DetalleVentaService {
    DetalleVentasListDto getAllDetalleVentas();
    
    Optional<DetalleVenta>  getDetalleVentaById(Long id);

    DetalleVenta createDetalleVenta(DetalleVenta detalleVenta);

    DetalleVenta updateDetalleVenta(Long id, DetalleVenta updatedDetalleVenta);

    void deleteDetalleVenta(Long id);

    List<FullDetalleVenta> getFullDetalleVentas(Long id);
}