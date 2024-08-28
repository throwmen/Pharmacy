package com.example.proyectooliveros.modelentity;

import jakarta.persistence.*;
        import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity()
@Table(name = "productos")
@Data()
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    @Positive(message = "El precio debe ser mayor que cero")
    private double price;

    @Column()
    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;
}
