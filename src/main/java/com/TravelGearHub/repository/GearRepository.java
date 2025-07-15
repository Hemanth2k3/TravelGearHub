package com.TravelGearHub.repository;

import com.TravelGearHub.entity.Gear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearRepository extends JpaRepository<Gear, Long> {
}