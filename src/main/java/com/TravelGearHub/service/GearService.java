package com.TravelGearHub.service;

import com.TravelGearHub.entity.Gear;
import com.TravelGearHub.exceptions.ResourceNotFoundException;
import com.TravelGearHub.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearService {

    @Autowired
    private GearRepository gearRepository;

    public List<Gear> getAllGear() {
        return gearRepository.findAll();
    }

    public Gear getGearById(Long id) {
        return gearRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gear not found"));
    }

    public Gear saveGear(Gear gear) {
        return gearRepository.save(gear);
    }

    public Gear updateGear(Long id, Gear gearDetails) {
        Gear gear = getGearById(id);
        gear.setName(gearDetails.getName());
        gear.setType(gearDetails.getType());
        gear.setPricePerDay(gearDetails.getPricePerDay());
        return gearRepository.save(gear);
    }

    public void deleteGear(Long id) {
        gearRepository.deleteById(id);
    }
}