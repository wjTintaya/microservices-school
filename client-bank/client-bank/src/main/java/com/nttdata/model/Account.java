package com.nttdata.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Account {
    private Integer id;
    private String accountNumber;
    private Integer accountType;
    private Double maintenanceFee;
    private Integer monthlyMovement;  //monthlyTransaction
    private Double balance;
    private Integer clientId;
}
