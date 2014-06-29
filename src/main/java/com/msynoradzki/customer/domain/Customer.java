package com.msynoradzki.customer.domain;

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

	@ManyToOne(fetch=FetchType.EAGER)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
