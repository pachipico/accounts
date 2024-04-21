package com.kubernetis.accounts.service.impl;

import com.kubernetis.accounts.dto.CustomerDto;
import com.kubernetis.accounts.entity.Customer;
import com.kubernetis.accounts.mapper.CustomerMapper;
import com.kubernetis.accounts.repository.AccountsRepository;
import com.kubernetis.accounts.repository.CustomerRepository;
import com.kubernetis.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountsServiceImpl implements IAccountsService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public void createAccount(CustomerDto dto) {
        Customer customer = CustomerMapper.mapToCustomer(dto, new Customer());
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDto getCustomer(String id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> getCustomers() {
        return null;
    }
}
