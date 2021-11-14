package com.nttdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private Integer id;
    private String accountNumber;
    private String description;
    private Double maintenanceFee;
    private Integer monthlyMovement;  //monthlyTransaction
    private Double balance;
    private Integer clientId;
}
