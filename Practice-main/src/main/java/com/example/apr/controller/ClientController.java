package com.example.apr.controller;

import com.example.apr.Dto.AccountValidationBuletinDTO;
import com.example.apr.Dto.AccountValidationEmailDTO;
import com.example.apr.Dto.AccountValidationPhoneDTO;
import com.example.apr.Dto.newClientDTO;
import com.example.apr.exceptions.FormatEmailException;
import com.example.apr.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/account-Validation/buletin")
    public ResponseEntity<String> accountValidationBuletin(AccountValidationBuletinDTO input) throws FormatEmailException {
        clientService.validateClient(input);
        return new ResponseEntity<>("input added", HttpStatus.OK);
    }

    @PostMapping("/account-Validation/email")
    public ResponseEntity<String> accountValidationEmail(AccountValidationEmailDTO input) throws FormatEmailException {
        clientService.validateClient(input);
        return new ResponseEntity<>("input added", HttpStatus.OK);
    }

    @PostMapping("/account-Validation/phone")
    public ResponseEntity<String> accountValidationPhone(AccountValidationPhoneDTO input) throws FormatEmailException {
        clientService.validateClient(input);
        return new ResponseEntity<>("input added", HttpStatus.OK);
    }

    @PostMapping("/add-New-Client")
    public ResponseEntity<String> addNewClientDTO(@RequestBody newClientDTO clientDTO){
        clientService.newClient(clientDTO);
        return new ResponseEntity<>("Client created", HttpStatus.OK);
    }

}
