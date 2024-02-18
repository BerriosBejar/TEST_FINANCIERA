package com.makers.crud.model.dto;

import java.util.List;

import com.makers.crud.model.entity.FullDetailVenta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailVentasListDto {
    List<FullDetailVenta> fullDetailVenta;
}
