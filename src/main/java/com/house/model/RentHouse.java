package com.house.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "renthouse")
public class RentHouse {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String uuid;
	@Column(name = "houseId")
	private String houseId;// ����ķ���
	@Column(name = "rentYear")
	private int rentYear;// ������
	@Column(name = "rentMonth")
	private int rentMonth;// ��
	@Column(name = "payType")
	private String payType;// ���ʽ��Ѻһ��һ��Ѻһ���������ȣ����꣬����
	@Column(name = "roomType")
	private String roomType;// ���ԡ����ԡ����ϡ�����
	@Column(name = "rentPeople")
	private String rentPeople;// �⻧
	@Column(name = "rentCellphone")
	private String rentCellphone;// �⻧��ϵ��ʽ

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public int getRentYear() {
		return rentYear;
	}

	public void setRentYear(int rentYear) {
		this.rentYear = rentYear;
	}

	public int getRentMonth() {
		return rentMonth;
	}

	public void setRentMonth(int rentMonth) {
		this.rentMonth = rentMonth;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRentPeople() {
		return rentPeople;
	}

	public void setRentPeople(String rentPeople) {
		this.rentPeople = rentPeople;
	}

	public String getRentCellphone() {
		return rentCellphone;
	}

	public void setRentCellphone(String rentCellphone) {
		this.rentCellphone = rentCellphone;
	}

}
