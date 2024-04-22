package com.kubernetis.accounts.controller;

import com.kubernetis.accounts.dto.CustomerDto;
import com.kubernetis.accounts.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("")
    @Transactional
    public Long save() {


        return 1L;
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.findById(id);
    }

}
