package com.example.proyectooliveros.dao;

import com.example.proyectooliveros.modelentity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoDAO
        extends JpaRepository<Producto, Long> {
}
