package com.kubernetis.accounts.controller;

import com.kubernetis.accounts.constants.AccountConstants;
import com.kubernetis.accounts.dto.CustomerDto;
import com.kubernetis.accounts.dto.ResponseDto;
import com.kubernetis.accounts.service.impl.AccountsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final AccountsServiceImpl accountsServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto dto) {

        accountsServiceImpl.createAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch/{mobileNumber}")
    public ResponseEntity<CustomerDto> fetchAccount(@PathVariable(name = "mobileNumber") String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(accountsServiceImpl.fetchAccount(mobileNumber));
    }

}
