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
	private String houseId;// 出租的房屋
	@Column(name = "rentYear")
	private int rentYear;// 出租年
	@Column(name = "rentMonth")
	private int rentMonth;// 月
	@Column(name = "payType")
	private String payType;// 付款方式，押一付一，押一付二，季度，半年，整年
	@Column(name = "roomType")
	private String roomType;// 主卧、次卧、隔断、整租
	@Column(name = "rentPeople")
	private String rentPeople;// 租户
	@Column(name = "rentCellphone")
	private String rentCellphone;// 租户联系方式

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
