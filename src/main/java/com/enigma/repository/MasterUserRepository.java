package com.enigma.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.entity.MasterUserEntity;

public interface MasterUserRepository extends JpaRepository<MasterUserEntity, Long> {
	Page<MasterUserEntity> findAllByStatus(Pageable paging, Long status);
}
