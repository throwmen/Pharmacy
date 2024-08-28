package com.example.proyectooliveros.services;

import com.example.proyectooliveros.dao.IProductoDAO;
import com.example.proyectooliveros.modelentity.Cliente;
import com.example.proyectooliveros.modelentity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Producto save(Producto product) {
        return productoDAO.save(product);
    }

    @Override
    public Producto findById(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
    }

    @Override
    public Producto update(Long id, Producto newProduct) {
        Producto existingProduct = findById(id);
        if (existingProduct == null) {
            throw new RuntimeException("Producto no encontrado");
        }
        if (newProduct.getName() != null) {
            existingProduct.setName(newProduct.getName());
        }
        if (newProduct.getName() != null) {
            existingProduct.setName(newProduct.getName());
        }
        if (newProduct.getDescription() != null) {
            existingProduct.setDescription(newProduct.getDescription());
        }
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setPrice(newProduct.getPrice());
        return productoDAO.save(existingProduct);
    }
}
