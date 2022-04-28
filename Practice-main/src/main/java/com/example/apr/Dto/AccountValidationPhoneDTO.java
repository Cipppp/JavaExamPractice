package com.example.apr.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class AccountValidationPhoneDTO extends AccountValidationDTO{
    private String phoneNumber;
}
