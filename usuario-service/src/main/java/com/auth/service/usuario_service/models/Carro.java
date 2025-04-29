package com.auth.service.usuario_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

    private String marca;
    private  String modelo;
    private int usuarioId;
}
