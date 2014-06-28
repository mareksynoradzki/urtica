package com.msynoradzki.customer.base.controller;

import java.io.Serializable;

import com.msynoradzki.customer.base.persistance.BaseEntity;

public interface GenericCrudController<T extends BaseEntity, PK extends Serializable> {
	
}