package com.auth.service.usuario_service.feingClient;


import com.auth.service.usuario_service.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "moto-service", url = "http://localhost:8081")
public interface MotoFeingClient {

    @PostMapping(value= "/moto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Moto save(@RequestBody Moto moto);

    @GetMapping("/moto")
    List<Moto> getData();

    @GetMapping("/moto/{id}")
    Moto getDataById(@PathVariable("id") Integer id);

    @GetMapping("/usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") int id);
}
