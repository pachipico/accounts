package com.kubernetis.accounts.service;

import com.kubernetis.accounts.repository.CustomerRepository;
import com.kubernetis.accounts.service.impl.AccountsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final AccountsServiceImpl accountsServiceImpl;



}
