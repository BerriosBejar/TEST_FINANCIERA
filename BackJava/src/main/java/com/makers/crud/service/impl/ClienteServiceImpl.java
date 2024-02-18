package com.makers.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makers.crud.model.dto.ClientesListDto;
import com.makers.crud.model.entity.Cliente;
import com.makers.crud.repository.ClienteRepository;
import com.makers.crud.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClientesListDto getAllClientes() {
        // TODO Auto-generated method stub
        ClientesListDto clienteListDto = new ClientesListDto();
        clienteListDto.setClientes(clienteRepository.findAll());
        return clienteListDto;
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        // TODO Auto-generated method stub
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente updatedCliente) {
        // TODO Auto-generated method stub
        // Cliente clienteDB=clienteRepository.getById(id);
        updatedCliente.setId(id);
        return clienteRepository.save(updatedCliente);
    }

    @Override
    public void deleteCliente(Long id) {
        // TODO Auto-generated method stub
        clienteRepository.deleteById(id);
    }

   
}
