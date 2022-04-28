package com.example.apr.transferService;

public class interBankingTransferService implements interBankingTransferInterface{

    @Override
    public boolean pingServer() {
        return true;
    }

    @Override
    public void openConnection() {

    }

    @Override
    public void closeConnection() {

    }

    @Override
    public void checkFunds() {

    }

    @Override
    public boolean CheckCountryBlackList(String countryCode) {
        if(countryCode.equals("abc"))
            return true;
        return false;
    }

    @Override
    public void sendMoney() {

    }
}
