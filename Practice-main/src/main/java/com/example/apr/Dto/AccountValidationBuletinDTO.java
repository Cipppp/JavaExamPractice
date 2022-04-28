package com.example.apr.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class AccountValidationBuletinDTO extends AccountValidationDTO {
    private String CNP;
}
