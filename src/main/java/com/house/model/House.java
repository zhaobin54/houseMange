package com.house.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 房屋
 * @author ZHAO130
 *
 */
@Entity
@Table(name = "house")
public class House {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String uuid;
	@Column(name = "houseName")
	private String houseName;// 小区名
	@Column(name = "province")
	private String province;
	@Column(name = "city")
	private String city;
	@Column(name = "district")
	private String district;
	@Column(name = "address")
	private String address;
	@Column(name = "houseAutor")
	private String houseAutor;// 房主姓名
	@Column(name = "cellphone")
	private String cellphone;// 房主手机号
	@Column(name = "room")
	private int room;// 室
	@Column(name = "office")
	private int office;// 厅
	@Column(name = "toilet")
	private int toilet;// 卫
	@Column(name = "floor")
	private int floor;// 层
	@Column(name = "elevator")
	private int elevator;// 0-无电梯 1-有电梯
	@Column(name = "decoration")
	private String decoration;// 精装修，中等装修，简单装修
	@Column(name = "rentType")
	private int rentType;// 0-整租 1-合租
	@Column(name = "isPartition")
	private int isPartition;//0-非隔断 1-隔断
	@Column(name = "signEmployee")
	private String signEmployee;// 签约人
	@Column(name = "signAmount")
	private Long signAmount;// 签约金额
	@Column(name = "signYear")
	private double signYear;// 签约年数
	@Column(name = "startDate")
	private Date startDate;// 开始时间
	@Column(name = "enDate")
	private Date enDate;// 到期时间

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseAutor() {
		return houseAutor;
	}

	public void setHouseAutor(String houseAutor) {
		this.houseAutor = houseAutor;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getOffice() {
		return office;
	}

	public void setOffice(int office) {
		this.office = office;
	}

	public int getToilet() {
		return toilet;
	}

	public void setToilet(int toilet) {
		this.toilet = toilet;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getElevator() {
		return elevator;
	}

	public void setElevator(int elevator) {
		this.elevator = elevator;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public int getRentType() {
		return rentType;
	}

	public void setRentType(int rentType) {
		this.rentType = rentType;
	}

	public String getSignEmployee() {
		return signEmployee;
	}

	public void setSignEmployee(String signEmployee) {
		this.signEmployee = signEmployee;
	}

	public Long getSignAmount() {
		return signAmount;
	}

	public void setSignAmount(Long signAmount) {
		this.signAmount = signAmount;
	}

	public double getSignYear() {
		return signYear;
	}

	public void setSignYear(double signYear) {
		this.signYear = signYear;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEnDate() {
		return enDate;
	}

	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}

}
