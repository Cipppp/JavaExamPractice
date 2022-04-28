package com.example.apr.AccountValidators;

import com.example.apr.Dto.AccountValidationBuletinDTO;
import com.example.apr.Dto.AccountValidationDTO;

public class BuletinAccountValidator extends AccountValidator {

    private boolean validateBuletin(String CNP){
        return true;
    }
    @Override
    public boolean isAuthorized(AccountValidationDTO accountValidationDTO) {
        if (accountValidationDTO instanceof AccountValidationBuletinDTO)
            return validateBuletin(((AccountValidationBuletinDTO) accountValidationDTO).getCNP());
        else
            return false;
    }

    public BuletinAccountValidator() {
        this.next = null;
    }
}
