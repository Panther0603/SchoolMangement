package com.example.demo.dto;

import lombok.Data;

@Data
public class Login {
    
    private String userName;
    private String password;
    private String token;
    private Boolean valid;
    private String type;
    
}
