package com.example.proyectooliveros.services;

import com.example.proyectooliveros.modelentity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto save(Producto product);

    public Producto findById(Long id);

    public void deleteById(Long id);

    public Producto update(Long id, Producto product);
}
