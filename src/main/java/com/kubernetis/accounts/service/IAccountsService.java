package com.kubernetis.accounts.service;

import com.kubernetis.accounts.dto.CustomerDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAccountsService {

    /**
     *
     * @param dto
     */
    void createAccount(CustomerDto dto);

    CustomerDto fetchAccount(String mobileNumber);

    List<CustomerDto> getCustomers();

}
