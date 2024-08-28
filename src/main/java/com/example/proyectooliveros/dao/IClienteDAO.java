package com.example.proyectooliveros.dao;

import com.example.proyectooliveros.modelentity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteDAO
        extends JpaRepository<Cliente, Long> {
}
