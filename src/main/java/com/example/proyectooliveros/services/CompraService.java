package com.example.proyectooliveros.services;

import com.example.proyectooliveros.dao.ICompraDAO;
import com.example.proyectooliveros.modelentity.Cliente;
import com.example.proyectooliveros.modelentity.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService implements ICompraService{

    @Autowired
    private ICompraDAO compraDAO;

    @Override
    public List<Compra> findAll() {
        return compraDAO.findAll();
    }

    @Override
    public Compra save(Compra purchase) {
        return compraDAO.save(purchase);
    }

    @Override
    public Compra findById(Long id) {
        return compraDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        compraDAO.deleteById(id);
    }

    @Override
    public Compra update(Long id, Compra purchase) {
        Compra existingPurchase = findById(id);
        if (existingPurchase == null) {
            throw new RuntimeException("Compra no encontrada");
        }
        if (purchase.getClient() != null) {
            existingPurchase.setClient(purchase.getClient());
        }
        if (purchase.getPurchaseDate() != null) {
            existingPurchase.setPurchaseDate(purchase.getPurchaseDate());
        }
        existingPurchase.setQuantityPurchased(purchase.getQuantityPurchased());
        if (purchase.getProduct() != null) {
            existingPurchase.setProduct(purchase.getProduct());
        }
        return compraDAO.save(existingPurchase);
    }

    @Override
    public List<Compra> findByClientId(Long clientId) {
        return compraDAO.findByClientId(clientId);
    }

}
