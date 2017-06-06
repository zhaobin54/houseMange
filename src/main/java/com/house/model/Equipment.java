package com.house.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 设施
 * @author ZHAO130
 *
 */
@Entity
@Table(name = "equipment")
public class Equipment {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String uuid;
	@Column(name = "bedNum")
	private int bedNum;// 床
	@Column(name = "airNum")
	private int airNum;// 空调
	@Column(name = "keyNum")
	private int keyNum;// 钥匙
	@Column(name = "deskNum")
	private int deskNum;// 书桌
	@Column(name = "powerNum")
	private int powerNum;// 电卡
	@Column(name = "waterCardNum")
	private int waterCardNum;// 水卡
	@Column(name = "gasCardNum")
	private int gasCardNum;// 燃气卡
	@Column(name = "washMachNum")
	private int washMachNum;// 洗衣机
	@Column(name = "ovenNum")
	private int ovenNum;// 微波炉
	@Column(name = "chairNum")
	private int chairNum;// 椅子
	@Column(name = "tvNum")
	private int tvNum;// 电视
	@Column(name = "remark")
	private String remark;// 备注

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
