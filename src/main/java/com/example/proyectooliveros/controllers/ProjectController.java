package com.example.proyectooliveros.controllers;

import com.example.proyectooliveros.modelentity.Cliente;
import com.example.proyectooliveros.modelentity.Compra;
import com.example.proyectooliveros.modelentity.Producto;
import com.example.proyectooliveros.services.IClienteService;
import com.example.proyectooliveros.services.IProductoService;
import com.example.proyectooliveros.services.ICompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private IProductoService productoService;
    @Autowired
    private IClienteService clienteService;
    @Autowired
    private ICompraService compraService;

    @GetMapping("/clients")
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAllProducts() {
        return productoService.findAll();
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> postProduct(@Valid @RequestBody Producto product) {
        Map<String,String> response= new HashMap<>();
        try{
            productoService.save(product);
        }catch(Exception e){
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(product);
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> postClient(@Valid @RequestBody Cliente client) {
        Map<String,String> response= new HashMap<>();
        try{
            clienteService.save(client);
        }catch(Exception e){
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(client);
    }

    @DeleteMapping("/products")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProduct(@Valid @RequestBody Long id) {
        Map<String,String> response= new HashMap<>();
        try {
            productoService.deleteById(id);
            return ResponseEntity.status(201).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(response + "is not a valid id");
        }
    }

    @DeleteMapping("/clients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteClient(@Valid @RequestBody Long id) {
        Map<String,String> response= new HashMap<>();
        try {
            clienteService.deleteById(id);
            return ResponseEntity.status(201).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(response + "is not a valid id");
        }
    }

    @PostMapping("/purchases")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> postPurchase(@Valid @RequestBody Compra purchase) {
        Map<String, String> response = new HashMap<>();
        try {
            compraService.save(purchase);
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(purchase);
    }

    @GetMapping("/clients/{clientId}/purchases")
    public ResponseEntity<?> getClientPurchases(@PathVariable Long clientId) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Compra> purchases = compraService.findByClientId(clientId);
            if (purchases.isEmpty()) {
                return ResponseEntity.status(404).body("No se encontraron compras para el cliente con ID: " + clientId);
            }
            response.put("purchases", purchases);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
