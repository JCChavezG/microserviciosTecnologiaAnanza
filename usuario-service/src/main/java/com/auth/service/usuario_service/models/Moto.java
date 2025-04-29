package com.auth.service.usuario_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moto {

    private String modelo;
    private String marca;
    private int usuarioId;
}
