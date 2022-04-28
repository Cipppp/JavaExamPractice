package com.example.apr.AccountValidators;

import com.example.apr.Dto.AccountValidationDTO;
import com.example.apr.Dto.AccountValidationPhoneDTO;

public class PhoneAccountValidator extends  AccountValidator {

    private boolean validatePhone(String phoneNumber){
        return true;
    }
    @Override
    public boolean isAuthorized(AccountValidationDTO accountValidationDTO) {
        if (accountValidationDTO instanceof AccountValidationPhoneDTO)
            return validatePhone(((AccountValidationPhoneDTO) accountValidationDTO).getPhoneNumber());
        else
            return next.isAuthorized(accountValidationDTO);
    }

    public PhoneAccountValidator() {
        this.next = new BuletinAccountValidator();
    }
}