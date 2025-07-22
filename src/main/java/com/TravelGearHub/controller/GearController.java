package com.TravelGearHub.controller;

import com.TravelGearHub.dto.AddGearRequest;
import com.TravelGearHub.dto.GearResponse;
import com.TravelGearHub.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gear")
public class GearController {

    @Autowired private GearService gearService;

    @PostMapping("/add")
    public ResponseEntity<GearResponse> addGear(@RequestBody AddGearRequest request) {
        return new ResponseEntity<>(gearService.addGear(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GearResponse>> getAllGear() {
        return ResponseEntity.ok(gearService.getAllGear());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GearResponse> getGearById(@PathVariable Long id) {
        return ResponseEntity.ok(gearService.getGearById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GearResponse> updateGear(@PathVariable Long id, @RequestBody AddGearRequest request) {
        return ResponseEntity.ok(gearService.updateGear(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGear(@PathVariable Long id) {
        gearService.deleteGear(id);
        return ResponseEntity.noContent().build();
    }
}
