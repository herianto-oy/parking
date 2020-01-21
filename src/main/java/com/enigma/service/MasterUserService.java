package com.enigma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.entity.MasterUserEntity;
import com.enigma.repository.MasterUserRepository;

@Service
public class MasterUserService {
	@Autowired
	private MasterUserRepository masterUserRepository;

	public MasterUserEntity createUser(MasterUserEntity user) {
		try {
			user.setStatus(1l);
			return masterUserRepository.save(user);
		} catch (Exception e) {
			return null;
		}
	}

	public MasterUserEntity updateUser(MasterUserEntity user) {
		try {
			MasterUserEntity update = findUserById(user.getId());
			if (user.getFullname() != null) {
				update.setFullname(user.getFullname());
			}

			if (user.getAddress() != null) {
				update.setAddress(user.getAddress());
			}
			return masterUserRepository.save(update);
		} catch (Exception e) {
			return null;
		}
	}

	public MasterUserEntity deleteUser(Long id) {
		try {
			MasterUserEntity delete = findUserById(id);
			delete.setStatus(0l);
			return masterUserRepository.save(delete);
		} catch (Exception e) {
			return null;
		}
	}

	public MasterUserEntity findUserById(Long id) {
		try {
			return masterUserRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	public Page<MasterUserEntity> findAllUser(Integer page, Integer size) {
		try {
			Pageable paging = PageRequest.of(page, size);
			return masterUserRepository.findAll(paging);
		} catch (Exception e) {
			return null;
		}
	}
}
