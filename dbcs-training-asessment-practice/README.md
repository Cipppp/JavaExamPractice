# Implementati o aplicatie folosita de care un spital pentru managementul pacientilor.

In cadrul aplicatiei putem stoca mai multi medici, fiecare dintre ei avand o specializare si o lista de pacienti assignati lor. Fiecare pacient are mai multe vizite inregistrate.
Atunci cand un pacient nou est assignat unui medic, acel medic va primi un email (vom simula cu system.out.printIn). Implementati clasa patientObserver care va trimite aceste alerte. 

## Se solicita urmatoarele functionalitati de la aplicatie:
- afisarea tuturor medicilor
- adaugarea unui pacient la un medic - arunca o eroare custom cand medicul nu exista
- afisarea tuturor medicilor cu o anumita specializare (exemplu : cardiologie)
- arunca o eroare custom cand specializarea nu exista / nu sunt medici cu acea specializare
- afisarea tuturor pacientilor