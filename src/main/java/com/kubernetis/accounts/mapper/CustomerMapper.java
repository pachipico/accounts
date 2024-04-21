package com.kubernetis.accounts.mapper;

import com.kubernetis.accounts.dto.CustomerDto;
import com.kubernetis.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto dto) {
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setMobileNumber(customer.getMobileNumber());
        return dto;
    }

    public static Customer mapToCustomer(CustomerDto dto, Customer customer) {
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());
        return customer;
    }

}
