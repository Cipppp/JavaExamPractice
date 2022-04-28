package com.example.apr.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class AccountValidationEmailDTO extends  AccountValidationDTO{
    private String email;
}
