package com.msynoradzki.customer.base.controller;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;

import com.msynoradzki.customer.base.persistance.BaseEntity;

//TODO 
public class GenericCRUDControllerImpl<T extends BaseEntity, PK extends Serializable>
		implements GenericCrudController<T, PK> {

}
