package com.example.proyectooliveros.dao;

import com.example.proyectooliveros.modelentity.Compra;
import com.example.proyectooliveros.modelentity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICompraDAO
        extends JpaRepository<Compra, Long> {
    List<Compra> findByClientId(Long clientId);
}
