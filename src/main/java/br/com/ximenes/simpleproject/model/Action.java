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

}
