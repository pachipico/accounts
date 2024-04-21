package com.kubernetis.accounts.service;

import com.kubernetis.accounts.dto.CustomerDto;

import java.util.List;

public interface IAccountsService {

    /**
     *
     * @param dto
     */
    void createAccount(CustomerDto dto);

    CustomerDto getCustomer(String id);

    List<CustomerDto> getCustomers();

}
