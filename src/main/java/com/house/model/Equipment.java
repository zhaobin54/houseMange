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
	private int bedNum;// ��
	@Column(name = "airNum")
	private int airNum;// �յ�
	@Column(name = "keyNum")
	private int keyNum;// Կ��
	@Column(name = "deskNum")
	private int deskNum;// ����
	@Column(name = "powerNum")
	private int powerNum;// �翨
	@Column(name = "waterCardNum")
	private int waterCardNum;// ˮ��
	@Column(name = "gasCardNum")
	private int gasCardNum;// ȼ����
	@Column(name = "washMachNum")
	private int washMachNum;// ϴ�»�
	@Column(name = "ovenNum")
	private int ovenNum;// ΢��¯
	@Column(name = "chairNum")
	private int chairNum;// ����
	@Column(name = "tvNum")
	private int tvNum;// ����
	@Column(name = "remark")
	private String remark;// ��ע

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
