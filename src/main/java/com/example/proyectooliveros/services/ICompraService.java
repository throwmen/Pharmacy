package com.example.proyectooliveros.services;

import com.example.proyectooliveros.modelentity.Compra;

import java.util.List;

public interface ICompraService {
    public List<Compra> findAll();
    public Compra save(Compra purchase);

    public Compra findById(Long id);

    public void deleteById(Long id);

    public Compra update(Long id, Compra client);

    List<Compra> findByClientId(Long clientId);
}
