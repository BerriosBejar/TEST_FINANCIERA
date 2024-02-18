package com.makers.crud.model.dto;

import java.util.List;

import com.makers.crud.model.entity.Venta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentasListDto {
    List<Venta> ventas;
}
