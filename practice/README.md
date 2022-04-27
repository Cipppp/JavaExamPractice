# O retea sociala (gen Facebook) are 4 componente principale :
- grupuri
- utilizatorii
- postarile
- comentarille
- reactiile (Like, love, haha, etc)


Avem urmatoarele relatii intre entitati : un grup are mai multe postari, si mai multi useri, o postare poate avea un singur autor, dar poate avea mai multe comentarii si reactii. Fiecare comentariu si reactie are un singur autor.

Atunci cand o postare primeste un comentariu nou, se trimite o notificare autorului (vom simula cu o alta clasa care va da print la un mesaj)
Pentru a crea o reactie noua, vom folosi un factory, care va crea o reactie noua, folosind ca argumente tipul reactiei si autorul.

Nu vom implementa partea de autentificare in aplicatie.

## Features ale aplicatiei :

- creaza postare
- adauga comentariu
- adauga reactie
- vezi toate postarile din grup, cu comentarii si reactii

## Error handling:

- daca se da like la o postare la care user-ul a dat deja like, se returneaza o exceptie custom
- daca se adauga un comment la o postare care nu mai ex