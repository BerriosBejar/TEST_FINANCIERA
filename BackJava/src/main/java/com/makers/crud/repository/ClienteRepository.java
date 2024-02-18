package com.makers.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makers.crud.model.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
