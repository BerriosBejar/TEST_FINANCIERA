package com.makers.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makers.crud.model.dto.ProductosListDto;
import com.makers.crud.model.entity.Producto;
import com.makers.crud.repository.ProductoRepository;
import com.makers.crud.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductosListDto getAllProductos() {
        // TODO Auto-generated method stub
        ProductosListDto productosListDto = new ProductosListDto();
        productosListDto.setProductos(productoRepository.findAll());
        return productosListDto;
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {
        // TODO Auto-generated method stub
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        // TODO Auto-generated method stub
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto updatedProducto) {
        // TODO Auto-generated method stub
        // Producto ProductoDB=productoRepository.getById(id);
        updatedProducto.setId(id);
        return productoRepository.save(updatedProducto);
    }

    @Override
    public void deleteProducto(Long id) {
        // TODO Auto-generated method stub
        productoRepository.deleteById(id);
    }

   
}
