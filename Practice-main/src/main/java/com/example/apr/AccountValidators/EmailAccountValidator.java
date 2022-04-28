package com.example.apr.AccountValidators;

import com.example.apr.Dto.AccountValidationDTO;
import com.example.apr.Dto.AccountValidationEmailDTO;
import com.example.apr.exceptions.FormatEmailException;

public class EmailAccountValidator extends AccountValidator {

    private boolean validateEmail(String email) throws FormatEmailException {
        if (!email.contains("@"))
            throw new FormatEmailException();
        else
            return true;
    }
    @Override
    public boolean isAuthorized(AccountValidationDTO accountValidationDTO) throws FormatEmailException {
        if (accountValidationDTO instanceof AccountValidationEmailDTO)
            return validateEmail(((AccountValidationEmailDTO) accountValidationDTO).getEmail());
        else
            return next.isAuthorized(accountValidationDTO);
    }

    public EmailAccountValidator() {
        this.next = new PhoneAccountValidator();
    }
}
