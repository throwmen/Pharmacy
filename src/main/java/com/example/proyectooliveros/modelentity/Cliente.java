package com.example.proyectooliveros.modelentity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity()
@Table(name="clientes")
@Data()
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String direction;

    @Column()
    @Email(message = "El formato del correo electrónico no es válido")
    private String email;

    @Column()
    @Pattern(regexp = "[0-9]*$", message = "El número de teléfono debe contener solo dígitos")
    private String phoneNumber;
}
