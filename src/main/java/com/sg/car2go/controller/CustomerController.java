package com.sg.car2go.controller;

import com.sg.car2go.exception.ResourceNotFoundException;
import com.sg.car2go.model.Car;
import com.sg.car2go.model.Customer;
import com.sg.car2go.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * List all customers (with pagination support)
     *
     * @param pageable pagination information
     * @return List of Customers for given Page as per pagination input
     */
    @GetMapping("/customers")
    public Page<Customer> getCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }

    /**
     * Create new customer
     *
     * @param customerRequest Customer request object
     * @return Created customer
     */
    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customerRequest) {
        return customerRepository.save(customerRequest);
    }

    /**
     * Update Customer information
     *
     * @param customerId      Customer Id
     * @param customerRequest Customer Request Body
     * @return Updated Customer Object.
     */
    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @Valid @RequestBody Customer customerRequest) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                    customer.setFirstName(customerRequest.getFirstName());
                    customer.setLastName(customerRequest.getLastName());
                    customer.setBirthDate(customerRequest.getBirthDate());
                    customer.setDrivingLicenseNumber(customerRequest.getDrivingLicenseNumber());
                    customer.setDrivingLicenseIssueDate(customerRequest.getDrivingLicenseIssueDate());
                    customer.setGender(customerRequest.getGender());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }
    /**
     * Delete customer
     *
     * @param customerId customer id
     * @return http response with success or error information
     */
    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                    customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }
}
