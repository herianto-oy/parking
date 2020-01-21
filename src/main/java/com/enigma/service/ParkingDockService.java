package com.enigma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.entity.ParkingDockEntity;
import com.enigma.repository.ParkingDockRepository;

@Service
public class ParkingDockService {
	@Autowired
	private ParkingDockRepository dockRepository;

	public ParkingDockEntity createDock(ParkingDockEntity dock) {
		try {
			dock.setStatus(1l);
			return dockRepository.save(dock);
		} catch (Exception e) {
			return null;
		}
	}

	public ParkingDockEntity updateDock(ParkingDockEntity dock) {
		try {
			ParkingDockEntity update =  findDockById(dock.getId());
			if (dock.getDock() != null) {
				update.setDock(dock.getDock());
			}
			return dockRepository.save(update);
		} catch (Exception e) {
			return null;
		}
	}

	public ParkingDockEntity deleteDock(Long id) {
		try {
			ParkingDockEntity delete = findDockById(id);
			delete.setStatus(0l);
			return dockRepository.save(delete);
		} catch (Exception e) {
			return null;
		}
	}
	
	public ParkingDockEntity findDockById(Long id) {
		try {
			return dockRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	public Page<ParkingDockEntity> findAllDock(Integer page, Integer size) {
		try {
			Pageable paging = PageRequest.of(page, size);
			return dockRepository.findAll(paging);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Page<ParkingDockEntity> findAllDockStatus(Integer page, Integer size, Long status) {
		try {
			Pageable paging = PageRequest.of(page, size);
			return dockRepository.findAllByStatus(paging, status);
		} catch (Exception e) {
			return null;
		}
	}
}
