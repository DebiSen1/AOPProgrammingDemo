package com.upgrad.course.demo.service.impl;

import com.upgrad.course.demo.dto.CustomerDTO;
import com.upgrad.course.demo.entity.CustomerEntity;
import com.upgrad.course.demo.exception.RecordNotFoundException;
import com.upgrad.course.demo.mapper.CustomerMapper;
import com.upgrad.course.demo.repository.CustomerRepo;
import com.upgrad.course.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* Service class to implement all the CRUD methods to communicate with the database.
* */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo; //object to CustomerRepository for accessing database via CRUD methods and access Customer objects

    @Override
    //DTO objects have the actual data of Customer
    public CustomerDTO saveCustomerData(CustomerDTO customerDTO) {
        //In order to save the Customer data to the repository as an Entity, we need to convert CustomerDTO object to CustomerEntity object
        CustomerEntity customerEntity = CustomerMapper.convertDTOToEntity(customerDTO);
        customerEntity = customerRepo.save(customerEntity);
        //converting again Entity object back to DTO object as a response from the method
        CustomerDTO customerDTOResponse = CustomerMapper.convertEntityToDTO(customerEntity);
        return customerDTOResponse;
    }

    @Override
    public CustomerDTO getCustomerData(int customerId) throws RecordNotFoundException {
        CustomerEntity customerEntity =
                customerRepo.findById(customerId)
                        .orElseThrow(() -> new RecordNotFoundException("Customer details for customer[" + customerId + "] does not exist"));
        //converting the found Entity object to its DTO equivalent as a response from the method
        CustomerDTO customerDTO = CustomerMapper.convertEntityToDTO(customerEntity);
        return customerDTO;
    }
}
