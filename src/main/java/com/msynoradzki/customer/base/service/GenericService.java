package com.msynoradzki.customer.base.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msynoradzki.customer.base.persistance.BaseEntity;

public interface GenericService<T extends BaseEntity, PK extends Serializable> {
	
	JpaRepository<T, PK> getRepository();

	void save(T entity);

	void delete(PK id);

	void delete(T entity);

	Collection<T> getAll();

	T findById(PK id);
}
