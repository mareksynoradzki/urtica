package com.msynoradzki.customer.base.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.collect.Lists;
import com.msynoradzki.customer.base.persistance.BaseEntity;

public abstract class GenericServiceImpl<T extends BaseEntity,PK extends Long>
		implements GenericService<T, PK> {
	public abstract JpaRepository<T, PK> getRepository();

	@Override
	public void save(T entity) {
		getRepository().save(entity);
	}

	@Override
	public void delete(PK id) {
		getRepository().delete(id);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public T findById(PK id) {
		return getRepository().findOne(id);
	}

	@Override
    public Collection<T> getAll() {
        Collection<T> items = Lists.newArrayList();

        for (T item : getRepository().findAll()) {
            items.add(item);
        }
        return items;
    }
}
