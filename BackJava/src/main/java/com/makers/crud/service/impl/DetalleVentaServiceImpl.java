package com.makers.crud.service.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makers.crud.model.dto.DetalleVentasListDto;
import com.makers.crud.model.entity.DetalleVenta;
import com.makers.crud.model.entity.FullDetailVenta;
import com.makers.crud.model.entity.FullDetalleVenta;
import com.makers.crud.repository.DetalleVentaRepository;
import com.makers.crud.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVentasListDto getAllDetalleVentas() {
        // TODO Auto-generated method stub
        DetalleVentasListDto detalleVentaListDto = new DetalleVentasListDto();
        detalleVentaListDto.setDetalleVentas(detalleVentaRepository.findAll());
        return detalleVentaListDto;
    }

    @Override
    public Optional<DetalleVenta> getDetalleVentaById(Long id) {
        // TODO Auto-generated method stub
        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta) {
        // TODO Auto-generated method stub
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Long id, DetalleVenta updatedDetalleVenta) {
        // TODO Auto-generated method stub
        // DetalleVenta DetalleVentaDB=detalleVentaRepository.getById(id);
        updatedDetalleVenta.setId(id);
        return detalleVentaRepository.save(updatedDetalleVenta);
    }

    @Override
    public void deleteDetalleVenta(Long id) {
        // TODO Auto-generated method stub
        detalleVentaRepository.deleteById(id);
    }


    @Override
    public List<FullDetalleVenta> getFullDetalleVentas(Long id) {
        List<Object[]> result = detalleVentaRepository.findDetalleVentaByIdVenta(id);

        List<FullDetalleVenta> fullDetalleVentaList = new ArrayList<>();

        for (Object[] row : result) {
            FullDetalleVenta fullDetalleVenta = new FullDetalleVenta();
            String tipoDato0 = row[0].getClass().getSimpleName();
            String tipoDato1 = row[1].getClass().getSimpleName();
            String tipoDato2 = row[2].getClass().getSimpleName();
            String tipoDato3 = row[3].getClass().getSimpleName();
            System.out.println("Tipo de dato 0: " + tipoDato0);
            System.out.println("Tipo de dato 1: " + tipoDato1);
            System.out.println("Tipo de dato 2: " + tipoDato2);
            System.out.println("Tipo de dato 3: " + tipoDato3);

            fullDetalleVenta.setNombre((String) row[0]);
            fullDetalleVenta.setPrecio((String) row[1]); 
            fullDetalleVenta.setCantidad((Integer) row[2]); 
            fullDetalleVenta.setSubtotal((Integer) row[3]);
            fullDetalleVentaList.add(fullDetalleVenta);
        }
        return fullDetalleVentaList;
    }

   
}
