package com.kubernetis.accounts.mapper;

import com.kubernetis.accounts.dto.AccountsDto;
import com.kubernetis.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto dto) {
        dto.setAccountNumber(accounts.getAccountNumber());
        dto.setAccountType(accounts.getAccountType());
        dto.setBranchAddress(accounts.getBranchAddress());
        return dto;
    }

    public static Accounts mapToAccounts(AccountsDto dto, Accounts accounts) {
        accounts.setAccountNumber(dto.getAccountNumber());
        accounts.setAccountType(dto.getAccountType());
        accounts.setBranchAddress(dto.getBranchAddress());
        return accounts;
    }

}
