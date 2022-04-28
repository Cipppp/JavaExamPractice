package com.example.apr.transferService;

public interface interBankingTransferInterface {
    boolean pingServer();

    void openConnection();

    void closeConnection();

    void checkFunds();

    // will receive a country code : RO, UK, USA, GER,SUI, RU, etc
    boolean CheckCountryBlackList(String countryCode);

    void sendMoney();
}
