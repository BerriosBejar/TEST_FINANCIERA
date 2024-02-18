package com.makers.crud.service.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makers.crud.model.dto.VentasListDto;
import com.makers.crud.model.entity.FullDetailVenta;
import com.makers.crud.model.entity.Venta;
import com.makers.crud.repository.VentaRepository;
import com.makers.crud.service.VentaService;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;


@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public VentasListDto getAllVentas() {
        // TODO Auto-generated method stub
        VentasListDto ventasListDto = new VentasListDto();
        ventasListDto.setVentas(ventaRepository.findAll());
        return ventasListDto;
    }

    @Override
    public Optional<Venta> getVentaById(Long id) {
        // TODO Auto-generated method stub
        return ventaRepository.findById(id);
    }

    @Override
    public Venta createVenta(Venta venta) {
        // TODO Auto-generated method stub
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Long id, Venta updatedVenta) {
        // TODO Auto-generated method stub
        // Venta VentaDB=ventaRepository.getById(id);
        updatedVenta.setId(id);
        return ventaRepository.save(updatedVenta);
    }

    @Override
    public void deleteVenta(Long id) {
        // TODO Auto-generated method stub
        ventaRepository.deleteById(id);
    }

    @Override
    public List<FullDetailVenta> getFullDetailVentas(String filterDate) {
        List<Object[]> result = ventaRepository.findFullList();

        if (!filterDate.isEmpty()) {
            System.out.println("ENTRA EN EL FILTROOOOOOOOOOOOOOOOO");
            result = ventaRepository.findFullListFilter(filterDate);
        }

        List<FullDetailVenta> fullDetailVentaList = new ArrayList<>();

        for (Object[] row : result) {
            FullDetailVenta fullDetailVenta = new FullDetailVenta();
            fullDetailVenta.setId((BigInteger) row[0]);
            fullDetailVenta.setId_cliente((BigInteger) row[1]);
            fullDetailVenta.setNombres((String) row[2]);
            fullDetailVenta.setApellidos((String) row[3]);
            fullDetailVenta.setFecha((Date) row[4]);
            fullDetailVenta.setTotal((BigInteger) row[5]);
            fullDetailVentaList.add(fullDetailVenta);
        }
        return fullDetailVentaList;
    }


   
}
