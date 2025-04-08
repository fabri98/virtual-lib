package com.VirtualLibWeb.VirtualLib.persistence.entity;

import com.VirtualLibWeb.VirtualLib.utils.ValidacionMensaje;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "alumnos")
public class AlumnoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="legajo", nullable = false, unique = true)
    @NotNull(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    private Long legajo;
    
    @Column(name="nombre", nullable = false)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 2, max = 50)
    private String nombre;

    @Column(name="apellido", nullable = false)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Size(min = 2, max = 50)
    private String apellido;

    @Column(name="telefono", nullable = false)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Pattern(regexp = "^\\+54\\d{10}$", message = ValidacionMensaje.FORMATO_TELEFONO_INVALIDO)
    private String telefono;

    @Column(name="email", nullable = false, unique = true)
    @NotBlank(message = ValidacionMensaje.CAMPO_OBLIGATORIO)
    @Email(message = ValidacionMensaje.FORMATO_EMAIL_INVALIDO)
    private String email;

}
