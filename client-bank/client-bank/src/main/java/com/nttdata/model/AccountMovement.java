package com.nttdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class AccountMovement {
    private Integer id;
    private int type;
    private Double amount;
    private Date date;
    private Integer accountId;
}
