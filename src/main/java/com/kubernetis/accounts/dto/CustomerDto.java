package com.kubernetis.accounts.dto;

import com.kubernetis.accounts.entity.Accounts;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private String name;

    private String email;

    private String mobileNumber;

    private AccountsDto accounts;

}
