package br.com.ximenes.simpleproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public class Action implements Serializable {

	private static final long serialVersionUID = -5334628606139169714L;

	@Id
	@GeneratedValue
	private long id;
	
	@NotEmpty
	private String name; 
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@NotEmpty
	private float value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
