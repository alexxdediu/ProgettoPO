## INTRODUZIONE
L'applicazione presente in questa repository permette  effettuare statistiche su dati  selezionati dalle [CORONAVIRUS COVID19 API](https://documenter.getpostman.com/view/10808728/SzS8rjbc#00030720-fae3-4c72-8aea-ad01ba17adf8).

## COSA SI PUO' FARE?
## QUALI RICHIESTE SI POSSONO EFFETTUARE?
|ROTTA | BODY | TIPO | 
|---|---|---|---|
| /data/summary |  GET|
|/data/dayone/{country}|GET|
|"/stats/maxrate"|Stringa con massimo n paesi ||POST|
|/stats/dayone/{country}|GET|

 ### Descrizione delle rotta
 ### Esempio di risposta ottenuta da richiesta di tipo GET con dati selezionati
 ```
 [
    {
        "Country": "Afghanistan",
        "TotalConfirmed": "40357",
        "TotalRecovered": "33790",
        "TotalDeaths": "1499"
    },
    {
        "Country": "Albania",
        "TotalConfirmed": "17651",
        "TotalRecovered": "10225",
        "TotalDeaths": "458"
    }
  ]
 ```
 ### Esempio di body per le richieste di tipo POST
 ```
 {"countries" : ["Italy","Albania","Romania"]}
 ```
