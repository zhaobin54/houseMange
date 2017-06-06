package com.house.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 工资
 * @author ZHAO130
 *
 */
@Entity
@Table(name = "wages")
public class Wages {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String uuid;
	@Column(name = "wagesMonth")
	private Date wagesMonth;// 工资月份
	@Column(name = "amount")
	private Long amount;
	@Column(name = "employeeName")
	private String employeeName;
	@Column(name = "employeeId")
	private String employeeId;
	@Column(name = "commission")
	private Double commission;// 提成

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getWagesMonth() {
		return wagesMonth;
	}

	public void setWagesMonth(Date wagesMonth) {
		this.wagesMonth = wagesMonth;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

}
