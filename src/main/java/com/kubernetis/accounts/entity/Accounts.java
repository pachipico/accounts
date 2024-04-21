package com.kubernetis.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Long customerId;

    private String accountType;

    private String branchAddress;

    public Accounts(Long customerId, String accountType, String branchAddress) {
        super(LocalDateTime.now(), "tester", null, null);
        this.customerId = customerId;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
    }
}
