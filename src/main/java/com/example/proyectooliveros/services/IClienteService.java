package com.example.proyectooliveros.services;

import com.example.proyectooliveros.modelentity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    public Cliente save(Cliente client);

    public Cliente findById(Long id);

    public void deleteById(Long id);

    public Cliente update(Long id, Cliente client);
}
