package com.example.apr.transferService;

import com.example.apr.exceptions.CountryOnBlacklistException;
import com.example.apr.exceptions.ServerResponseException;
import com.example.apr.model.Account;

public class transferFacade {
    public void sendMoney(Integer sum, Account a) throws ServerResponseException, CountryOnBlacklistException {
        interBankingTransferService inter = new interBankingTransferService();

        if(!inter.pingServer())
            throw new ServerResponseException();

        if(inter.CheckCountryBlackList("RO"))
            throw new CountryOnBlacklistException();

        inter.sendMoney();
        // le adaugam pe toate din interBankingTransferInterface.

    }
}
