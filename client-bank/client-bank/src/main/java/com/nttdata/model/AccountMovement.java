package com.nttdata.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AccountMovement {
    private Integer id;
    private int type;
    private Double amount;
    private LocalDate date;
    private Integer accountId;
}
