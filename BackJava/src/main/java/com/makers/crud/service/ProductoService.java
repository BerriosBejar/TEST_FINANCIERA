package com.makers.crud.service;

import java.util.List;
import java.util.Optional;

import com.makers.crud.model.dto.ProductosListDto;
import com.makers.crud.model.entity.Producto;



public interface ProductoService {
    ProductosListDto getAllProductos();
    
    Optional<Producto> getProductoById(Long id);

    Producto createProducto(Producto producto);

    Producto updateProducto(Long id, Producto updatedProdcuto);

    void deleteProducto(Long id);
}