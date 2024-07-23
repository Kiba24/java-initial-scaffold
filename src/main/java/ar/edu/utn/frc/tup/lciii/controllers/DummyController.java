package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.entities.DummyEntity;
import ar.edu.utn.frc.tup.lciii.models.Dummy;
import ar.edu.utn.frc.tup.lciii.services.DummyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dummies")
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("")
    public ResponseEntity<List<Dummy>> getDummies(){
        return ResponseEntity.ok(dummyService.getDummies());
    }

    @PostMapping("")
    public ResponseEntity<Dummy> createDummy(@RequestBody Dummy dummy){
        return ResponseEntity.ok(dummyService.createDummy(dummy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dummy> getDummy(@PathVariable Long id){
        return ResponseEntity.ok(dummyService.getDummy(id));
    }

    @PutMapping("")
    public ResponseEntity<Dummy> updateDummy (@RequestBody Dummy dummy) {
        return ResponseEntity.ok(dummyService.updateDummy(dummy));
    }

}
