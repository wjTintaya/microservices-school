package com.nttdata.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Client {
    private Integer id;
    private String name;
    private String direction;
    private Integer type;
}
