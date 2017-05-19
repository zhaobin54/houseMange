package com.house.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "equipment")
public class Equipment {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String uuid;
	@Column(name = "bedNum")
	private int bedNum;// ´²
	@Column(name = "airNum")
	private int airNum;// ¿Õµ÷
	@Column(name = "keyNum")
	private int keyNum;// Ô¿³×
	@Column(name = "deskNum")
	private int deskNum;// Êé×À
	@Column(name = "powerNum")
	private int powerNum;// µç¿¨
	@Column(name = "waterCardNum")
	private int waterCardNum;// Ë®¿¨
	@Column(name = "gasCardNum")
	private int gasCardNum;// È¼Æø¿¨
	@Column(name = "washMachNum")
	private int washMachNum;// Ï´ÒÂ»ú
	@Column(name = "ovenNum")
	private int ovenNum;// Î¢²¨Â¯
	@Column(name = "chairNum")
	private int chairNum;// ÒÎ×Ó
	@Column(name = "tvNum")
	private int tvNum;// µçÊÓ
	@Column(name = "remark")
	private String remark;// ±¸×¢

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getBedNum() {
		return bedNum;
	}

	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}

	public int getAirNum() {
		return airNum;
	}

	public void setAirNum(int airNum) {
		this.airNum = airNum;
	}

	public int getKeyNum() {
		return keyNum;
	}

	public void setKeyNum(int keyNum) {
		this.keyNum = keyNum;
	}

	public int getDeskNum() {
		return deskNum;
	}

	public void setDeskNum(int deskNum) {
		this.deskNum = deskNum;
	}

	public int getPowerNum() {
		return powerNum;
	}

	public void setPowerNum(int powerNum) {
		this.powerNum = powerNum;
	}

	public int getWaterCardNum() {
		return waterCardNum;
	}

	public void setWaterCardNum(int waterCardNum) {
		this.waterCardNum = waterCardNum;
	}

	public int getGasCardNum() {
		return gasCardNum;
	}

	public void setGasCardNum(int gasCardNum) {
		this.gasCardNum = gasCardNum;
	}

	public int getWashMachNum() {
		return washMachNum;
	}

	public void setWashMachNum(int washMachNum) {
		this.washMachNum = washMachNum;
	}

	public int getOvenNum() {
		return ovenNum;
	}

	public void setOvenNum(int ovenNum) {
		this.ovenNum = ovenNum;
	}

	public int getChairNum() {
		return chairNum;
	}

	public void setChairNum(int chairNum) {
		this.chairNum = chairNum;
	}

	public int getTvNum() {
		return tvNum;
	}

	public void setTvNum(int tvNum) {
		this.tvNum = tvNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
