package com.example.demo.biz.service.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void test() {
		Customer customer = new Customer(1, "who", "who@ng.foo.buz", new Date(2000, 1, 1), 1);
		assertFalse(customer.isNgEmail());
	}
}
