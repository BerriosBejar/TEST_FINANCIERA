package com.makers.crud.model.dto;

import java.util.List;

import com.makers.crud.model.entity.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosListDto  {
    List<Producto> productos;
}
