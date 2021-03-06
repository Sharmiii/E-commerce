package com.cts.mfpe.ecommerce.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.mfpe.ecommerce.model.Customer;
import com.cts.mfpe.ecommerce.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

	    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	    @Autowired
	    private CustomerRepository customerRepository;

	    @GetMapping("/list")
	    public ResponseEntity<List<Customer>> getCustomers() {
	        return ResponseEntity.ok(customerRepository.findAll());
	    }

	    @PostMapping
	    public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer){
	        LOGGER.info("Creating customer: {}", customer);
	        customerRepository.save(customer);
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    }

	    @GetMapping("/{customerId}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) {
	        LOGGER.info("Fetching customer with id: {}", customerId);
	        return ResponseEntity.ok(customerRepository.findById(customerId).orElseThrow(RuntimeException::new));
	    }
	    
	    @PutMapping("/{customerId}")
	    public ResponseEntity<Customer> updateCustomerById(@PathVariable("customerId") Integer customerId,@RequestBody @Valid Customer customer){
	    	LOGGER.info("Fetching customer with id: {}", customerId);
	        return ResponseEntity.ok(customerRepository.findById(customerId).orElseThrow(RuntimeException::new));
	    	
	    	}
	    	
	    
	}	

