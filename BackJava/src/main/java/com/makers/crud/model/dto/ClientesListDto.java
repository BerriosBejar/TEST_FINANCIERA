package com.makers.crud.model.dto;

import java.util.List;

import com.makers.crud.model.entity.Cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientesListDto {
    List<Cliente> clientes;
}
