package com.example.proyectooliveros.modelentity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDate;

@Entity()
@Table(name = "compras")
@Data()
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Cliente client;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Producto product;

    @Column()
    @Min(value = 1, message = "La cantidad comprada debe ser al menos de una unidad")
    private int quantityPurchased;
}
