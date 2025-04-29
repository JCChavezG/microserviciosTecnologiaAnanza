package com.auth.service.usuario_service.feingClient;

import com.auth.service.usuario_service.models.Carro;
import com.auth.service.usuario_service.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "carro-service", url = "http://localhost:8082")
public interface CarroFeingClient {

    @PostMapping(value= "/carro", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Carro save(@RequestBody Carro carro);

    @GetMapping("/carro")
    List<Carro> getData();

    @GetMapping("/carro/{id}")
    Carro getDataById(@PathVariable("id") Integer id);

    @GetMapping("/usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable("usuarioId") int id);

}
