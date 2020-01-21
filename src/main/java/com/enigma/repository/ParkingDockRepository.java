package com.enigma.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.entity.ParkingDockEntity;

public interface ParkingDockRepository extends JpaRepository<ParkingDockEntity, Long> {
	Page<ParkingDockEntity> findAllByStatus(Pageable paging, Long status);
}
