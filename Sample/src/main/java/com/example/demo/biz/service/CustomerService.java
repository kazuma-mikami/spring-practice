package com.example.demo.biz.service;

import java.util.List;

import com.example.demo.biz.service.domain.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int id) throws DataNotFounfException;

	public Customer register(Customer customer) throws DataNotFounfException;

	public void update(Customer customer) throws DataNotFounfException;

	public void delete(Customer customer) throws DataNotFounfException;
}
