package com.makers.crud.model.dto;

import java.util.List;

import com.makers.crud.model.entity.DetalleVenta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleVentasListDto {
    List<DetalleVenta> detalleVentas;
}
