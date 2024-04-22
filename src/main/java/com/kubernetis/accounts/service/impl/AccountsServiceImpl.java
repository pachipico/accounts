package com.kubernetis.accounts.service.impl;

import com.kubernetis.accounts.constants.AccountConstants;
import com.kubernetis.accounts.dto.AccountsDto;
import com.kubernetis.accounts.dto.CustomerDto;
import com.kubernetis.accounts.entity.Accounts;
import com.kubernetis.accounts.entity.Customer;
import com.kubernetis.accounts.exception.CustomerAlreadyExistsException;
import com.kubernetis.accounts.exception.ResourceNotFoundException;
import com.kubernetis.accounts.mapper.AccountsMapper;
import com.kubernetis.accounts.mapper.CustomerMapper;
import com.kubernetis.accounts.repository.AccountsRepository;
import com.kubernetis.accounts.repository.CustomerRepository;
import com.kubernetis.accounts.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountsServiceImpl implements IAccountsService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public void createAccount(CustomerDto dto) {
        if (customerRepository.findByMobileNumber(dto.getMobileNumber()).isPresent())
            throw new CustomerAlreadyExistsException("Customer Already Exists");
        Customer customer = CustomerMapper.mapToCustomer(dto, new Customer());
        Customer saved = customerRepository.save(customer);
        Accounts newAccount = createNewAccount(saved);
        accountsRepository.save(newAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        log.info("accounts : {}", accounts);
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccounts(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return customerDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> getCustomers() {
        return null;
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000 + new Random().nextInt(900000000);

        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        log.info("new account : {}", newAccount);
        return newAccount;
    }
}
