package com.github.sanchezih.customer.service;

import java.util.List;

import com.github.sanchezih.customer.entity.Customer;
import com.github.sanchezih.customer.entity.Region;

public interface CustomerService {
	public List<Customer> findCustomerAll();

	public List<Customer> findCustomersByRegion(Region region);

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Customer customer);

	public Customer getCustomer(Long id);
}