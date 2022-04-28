package com.example.apr.AccountValidators;

import com.example.apr.Dto.AccountValidationDTO;
import com.example.apr.exceptions.FormatEmailException;

public abstract class AccountValidator {
    public AccountValidator next;
    public abstract boolean isAuthorized(AccountValidationDTO accountValidationDTO) throws FormatEmailException;
}
