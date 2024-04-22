package com.kubernetis.accounts.service;

import com.kubernetis.accounts.dto.CustomerDto;
import com.kubernetis.accounts.entity.Customer;
import com.kubernetis.accounts.exception.ResourceNotFoundException;
import com.kubernetis.accounts.mapper.CustomerMapper;
import com.kubernetis.accounts.repository.CustomerRepository;
import com.kubernetis.accounts.service.impl.AccountsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final AccountsServiceImpl accountsServiceImpl;


    public CustomerDto findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()) throw new ResourceNotFoundException("customer", "id", id.toString());
        return CustomerMapper.mapToCustomerDto(customer.get(), new CustomerDto());
    }
}
