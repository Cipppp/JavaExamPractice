Pentru a isi putea crea un cont la DB, un viitor client trebuie sa isi valideze identitatea inainte de a putea face operatiuni.
### Pentru validarea identitatii, DB foloseste mai multe metode:
- poza la buletin, din care se extrage CNP-ul si seria buletinului
- poza la pasaport, din care se extrage seria pasaportului
- validare prin SMS : se va trimite un cod SMS la client, si acesta va introduce in aplicatie codul
- validare prin Email : se va trimite un cod prin Email, si clientul trebuie sa il introduca.

Filtrele care fac aceasta verificare vor fi implementate sub forma unui Chain of Responsibility.
Dupa ce a trecut de validarea contului, utilizatorul isi poate crea un card, ori de debit, ori de credit, si isi poate deschide conturi de salariu, de economii sau de valuta.
Vom crea cardurile si conturile folosind cate un factory.
Un card are numar, CVV si owner, iar un cont are un IBAN si un owner.

Operatiile pe conturi, vor fi efectuate printr-un pattern de tipul strategy. Operatiile posibile sunt : depunerea de bani, retragere numerar, interogare sold.

Atunci cand un utilizator doreste sa transfere bani dintr-un cont de la DB intr-un cont de la alta banca, operatiunile bancare din spate sunt destul de complexe, si necesita API calls pentru API-ul bancii respective. Noi vom simula aceste API calls printr-o clasa ce implementeaza interfata oferita deja.

### Procedura pentru un transfer bancar este complexa, si necesita urmatorii pasi :
- ping la banca partener pentru a verifica daca serverul functioneaza
- interogarea soldului contului curent
- verificarea daca exista suficiente fonduri
- verificarea daca tara unde se trimit banii nu este pe lista neagra
- trimiterea banilor
- inchiderea conexiunii

Deoarece toate aceste operatiuni se executa de fiecare data, aplicatia noastra nu este interesata de executarea in particular a fiecarei operatiuni, asa ca vom implementa un Facade pentru tranferuri bancare.
Acest Facade va avea doar o singura metoda : send money


## Cerinte:

- implementati sistemul de verificare a identitatii
- implementati sistemul de creare cont
- implementati sistemul de tranfer interbancar
- implementati SwaggerUI

## Exceptii posibile:

- eroare la validarea CNP-ului
- eroare la validarea seriei buletinului si a pasaportului
- cod de validare incorect
- fonduri insuficiente
- tranfer blocat : tara e pe lista neagra








## Interfata pentru transferuri bancare:

public interface interBankingTransferInterface{
boolean pingServer();
void openConnection();
void closeConnection();
void checkFunds();
// will receive a country code : RO, UK, USA, GER,SUI, RU, etc
boolean CheckCountryBlackList(String countryCode);
void sendMoney();

}