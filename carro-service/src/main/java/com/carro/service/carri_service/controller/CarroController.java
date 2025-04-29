package com.carro.service.carri_service.controller;

import com.carro.service.carri_service.Entities.Carro;
import com.carro.service.carri_service.servie.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
   private CarroService carroService;


    @GetMapping()
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroService.getCarros();
        if ((carros.isEmpty())){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(carros);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
        Carro carro = carroService.getCarroById(id);
        if(carro == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carro);
    }

   @PostMapping()
    public ResponseEntity<Carro>guardar(@RequestBody Carro carro){
        Carro carroAGuardar = carroService.save(carro);
        return ResponseEntity.ok(carroAGuardar);
   }

   @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>>listarCarrosPorUsuarioId(@PathVariable("usuarioId") int id){
        List<Carro> carros = carroService.getByUsuarioId(id);
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
   }

}
