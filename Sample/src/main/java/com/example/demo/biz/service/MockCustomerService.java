package com.example.demo.biz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.biz.service.domain.Customer;

@Service
public class MockCustomerService implements CustomerService {
	private List<Customer> customers = new ArrayList<Customer>() {
		{
			add(new Customer(1, "a", "a@ng.foo.baz", new Date(2001, 1, 1), 1));
			add(new Customer(2, "b", "b@ng.foo.baz", new Date(2002, 2, 2), 2));
			add(new Customer(3, "c", "c@ng.foo.baz", new Date(2003, 3, 3), 3));
		}
	};

	@Override
	public List<Customer> findAll() {
		return customers;
	}

	@Override
	public Customer findById(int id) throws DataNotFounfException {
		Customer taregt = customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
		if (taregt == null) {
			throw new DataNotFounfException();
		}
		return taregt;
	}

	@Override
	public Customer register(Customer customer) throws DataNotFounfException {
		customers.add(customer);
		return customer;
	}

	@Override
	public void update(Customer customer) throws DataNotFounfException {
		for (Customer target : customers) {
			if (target.getId() == customer.getId()) {
				target = customer;
				return;
			}
		}
	}

	@Override
	public void delete(Customer customer) throws DataNotFounfException {
		customers.removeIf(c -> c.getId() == customer.getId());
	}

}
