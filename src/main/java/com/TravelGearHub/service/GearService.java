package com.TravelGearHub.service;

import com.TravelGearHub.dto.AddGearRequest;
import com.TravelGearHub.dto.GearResponse;
import com.TravelGearHub.entity.Gear;
import com.TravelGearHub.entity.User;
import com.TravelGearHub.repository.GearRepository;
import com.TravelGearHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GearService {

    @Autowired private GearRepository gearRepository;
    @Autowired private UserRepository userRepository;

    public GearResponse addGear(AddGearRequest request) {
        User seller = userRepository.findById(request.getSellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        Gear gear = new Gear();
        gear.setName(request.getName());
        gear.setType(request.getType());
        gear.setDescription(request.getDescription());
        gear.setPricePerDay(request.getPricePerDay());
        gear.setDepositAmount(request.getDepositAmount());
        gear.setLocation(request.getLocation());
        gear.setImageUrl(request.getImageUrl());
        gear.setSeller(seller);
        gear.setAvailable(true);
        gear.setActive(true);

        gearRepository.save(gear);
        return mapToResponse(gear);
    }

    public List<GearResponse> getAllGear() {
        return gearRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public GearResponse getGearById(Long id) {
        Gear gear = gearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gear not found"));
        return mapToResponse(gear);
    }

    public GearResponse updateGear(Long id, AddGearRequest request) {
        Gear gear = gearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gear not found"));

        gear.setName(request.getName());
        gear.setType(request.getType());
        gear.setDescription(request.getDescription());
        gear.setPricePerDay(request.getPricePerDay());
        gear.setDepositAmount(request.getDepositAmount());
        gear.setLocation(request.getLocation());
        gear.setImageUrl(request.getImageUrl());

        Gear updated = gearRepository.save(gear);
        return mapToResponse(updated);
    }

    public void deleteGear(Long id) {
        Gear gear = gearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gear not found"));
        gearRepository.delete(gear);
    }

    private GearResponse mapToResponse(Gear gear) {
        GearResponse response = new GearResponse();
        response.setId(gear.getId());
        response.setName(gear.getName());
        response.setType(gear.getType());
        response.setDescription(gear.getDescription());
        response.setPricePerDay(gear.getPricePerDay());
        response.setDepositAmount(gear.getDepositAmount());
        response.setLocation(gear.getLocation());
        response.setAvailable(gear.isAvailable());
        response.setAverageRating(gear.getAverageRating());
        response.setImageUrl(gear.getImageUrl());
        response.setSellerName(gear.getSeller().getFullName());
        response.setSellerEmail(gear.getSeller().getUsername());
        return response;
    }
}
