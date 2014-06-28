package com.msynoradzki.customer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.msynoradzki.customer.base.persistance.BaseEntity;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "CHIEF_ID")
	private Customer chief;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getChief() {
		return chief;
	}

	public void setChief(Customer chief) {
		this.chief = chief;
	}
}
