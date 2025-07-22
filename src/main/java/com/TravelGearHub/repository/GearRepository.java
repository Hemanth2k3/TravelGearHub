package com.TravelGearHub.repository;

import com.TravelGearHub.entity.Gear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GearRepository extends JpaRepository<Gear, Long> {
        List<Gear> findBySellerId(Long sellerId);


}