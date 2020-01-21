package com.enigma.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.dto.TransactionDto;
import com.enigma.entity.MasterUserEntity;
import com.enigma.entity.ParkingDockEntity;
import com.enigma.entity.TransactionEntity;
import com.enigma.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private MasterUserService masterUserService;

	@Autowired
	private ParkingDockService dockService;

	@Transactional
	public TransactionEntity checkIn(TransactionDto checkIn) {
		try {
			MasterUserEntity user = masterUserService.findUserById(checkIn.getUserId());
			if (user != null) {
				Page<ParkingDockEntity> dock = dockService.findAllDockStatus(0, 1, 1l);
				if (dock.getContent().size() != 0) {
					ParkingDockEntity dockTrx = dock.getContent().get(0);
					dockTrx.setStatus(0l);
					dockService.updateDock(dockTrx);

					Date date = new Date();
					TransactionEntity trx = new TransactionEntity(null, date, date, user, dock.getContent().get(0), 1l);
					return transactionRepository.save(trx);
				} else {
					return null;
				}
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}

	public TransactionEntity checkOut(Long id) {
		try {
			TransactionEntity trx = findById(id);
			if (trx != null) {
				trx.setExitDate(new Date());
				trx.setStatus(0l);
				return transactionRepository.save(trx);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public TransactionEntity findById(Long id) {
		try {
			return transactionRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	public Page<TransactionEntity> findByAll(Integer page, Integer size) {
		try {
			Pageable paging = PageRequest.of(page, size);
			return transactionRepository.findAll(paging);
		} catch (Exception e) {
			return null;
		}
	}

}
