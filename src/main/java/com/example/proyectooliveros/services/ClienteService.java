package com.example.proyectooliveros.services;

import com.example.proyectooliveros.dao.IClienteDAO;
import com.example.proyectooliveros.dao.IProductoDAO;
import com.example.proyectooliveros.modelentity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Cliente save(Cliente client) {
        return clienteDAO.save(client);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        clienteDAO.deleteById(id);
    }

    @Override
    public Cliente update(Long id, Cliente newClient) {
        Cliente existingClient = findById(id);
        if (existingClient == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        if (newClient.getName() != null) {
            existingClient.setName(newClient.getName());
        }
        if (newClient.getDirection() != null) {
            existingClient.setDirection(newClient.getDirection());
        }
        if (newClient.getEmail() != null) {
            existingClient.setEmail(newClient.getEmail());
        }
        if (newClient.getPhoneNumber() != null) {
            existingClient.setPhoneNumber(newClient.getPhoneNumber());
        }
        return clienteDAO.save(existingClient);
    }
}
