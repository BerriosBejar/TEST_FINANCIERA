package com.makers.crud.service;

import java.util.List;
import java.util.Optional;

import com.makers.crud.model.dto.VentasListDto;
import com.makers.crud.model.entity.FullDetailVenta;
import com.makers.crud.model.entity.Venta;

public interface VentaService {
    VentasListDto getAllVentas();
    
    Optional<Venta> getVentaById(Long id);

    Venta createVenta(Venta venta);

    Venta updateVenta(Long id, Venta updatedVenta);

    void deleteVenta(Long id);

    List<FullDetailVenta> getFullDetailVentas(String filterDate);
}