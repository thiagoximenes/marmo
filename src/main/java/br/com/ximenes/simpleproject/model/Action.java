package br.com.ximenes.simpleproject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String createDate;
	
	private BigDecimal value;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDateAutomatic;
	
	private int month;

	public Action(Long id, String name, String createDate, BigDecimal value, Date createDateAutomatic, int month) {
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.value = value;
		this.createDateAutomatic = createDateAutomatic;
		this.month = month;
	}
	
	public Action() {}
	
//	Calendar cal = Calendar.getInstance();
	
//	public int catchMonth() {
//		cal.setTime(this.getCreateDateAutomatic());
//		int month = 1 + cal.get(Calendar.MONTH);
//		return month;
//	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getCreateDateAutomatic() {
		return createDateAutomatic;
	}

	public void setCreateDateAutomatic(Date createDateAutomatic) {
		this.createDateAutomatic = createDateAutomatic;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
}
