package com.bookstoreapi.service;

import com.bookstoreapi.dto.CustomerDTO;
import com.bookstoreapi.mapper.CustomerMapper;
import com.bookstoreapi.model.Customer;
import com.bookstoreapi.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
        customer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toCustomerDTO(customer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        return CustomerMapper.INSTANCE.toCustomerDTO(customer);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toCustomerDTO(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper.INSTANCE::toCustomerDTO)
                .collect(Collectors.toList());
    }
}


