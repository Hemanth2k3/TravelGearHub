package com.TravelGearHub.controller;

import com.TravelGearHub.entity.Gear;
import com.TravelGearHub.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/gear")
public class GearController {

    @Autowired
    private GearService gearService;

    // Get all gear items
    @GetMapping
    public ResponseEntity<List<Gear>> getAllGear() {
        return ResponseEntity.ok(gearService.getAllGear());
    }

    // Get gear by ID
    @GetMapping("/{id}")
    public ResponseEntity<Gear> getGearById(@PathVariable Long id) {
        return ResponseEntity.ok(gearService.getGearById(id));
    }

    // Add new gear
    @PostMapping
    public ResponseEntity<Gear> addGear(@RequestBody Gear gear) {
        return new ResponseEntity<>(gearService.saveGear(gear), HttpStatus.CREATED);
    }

    // Update gear
    @PutMapping("/{id}")
    public ResponseEntity<Gear> updateGear(@PathVariable Long id, @RequestBody Gear gear) {
        return ResponseEntity.ok(gearService.updateGear(id, gear));
    }

    // Delete gear
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGear(@PathVariable Long id) {
        gearService.deleteGear(id);
        return ResponseEntity.noContent().build();
    }
}