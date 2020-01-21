package com.enigma.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date enterDate;
	private Date exitDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private MasterUserEntity user;

	@ManyToOne
	@JoinColumn(name = "parking_dock_id")
	private ParkingDockEntity dock;
	private Long status;

	public TransactionEntity() {

	}

	public TransactionEntity(Long id, Date enterDate, Date exitDate, MasterUserEntity user, ParkingDockEntity dock,
			Long status) {
		this.enterDate = enterDate;
		this.exitDate = exitDate;
		this.user = user;
		this.dock = dock;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public MasterUserEntity getUser() {
		return user;
	}

	public void setUser(MasterUserEntity user) {
		this.user = user;
	}

	public ParkingDockEntity getDock() {
		return dock;
	}

	public void setDock(ParkingDockEntity dock) {
		this.dock = dock;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
}
