## INTRODUZIONE
Questa applicazione  permette di effettuare statistiche su dati  selezionati dalle [CORONAVIRUS COVID19 API](https://documenter.getpostman.com/view/10808728/SzS8rjbc#00030720-fae3-4c72-8aea-ad01ba17adf8).

## COSA SI PUO' FARE?
Diagramma dei casi d'uso:

<img src="https://github.com/alexxdediu/ProgettoPO/blob/master/UseCaseDiagramProject.jpg" width="400" height="300"> 




## QUALI RICHIESTE SI POSSONO EFFETTUARE?
Le richieste vengono effettuate con [POSTMAN](https://www.postman.com/).
Di seguito vengono riportate le possibili richieste:
|ROTTA | BODY | TIPO | 
|---|---|---|
| /data/summary | |GET|
|/data/dayone/{country}| |GET|
|/stats/maxrate|Stringa con massimo n paesi |POST|
|/stats/dayone/{country}| |GET|

 ### Descrizione delle rotte
 
 > **GET** /data/summary
 
 Utilizzando questa rotta si possono selezionare i dati da [***SUMMARY***](https://documenter.getpostman.com/view/10808728/SzS8rjbc#00030720-fae3-4c72-8aea-ad01ba17adf8),ignorando i campi non necessari.
 
 > **GET** /data/dayone/{country}
 
 Utilizzando questa rotta si possono ottenere i dati relativi ad un paese da [***DAY ONE ALL STATUS***](https://documenter.getpostman.com/view/10808728/SzS8rjbc#d0ca988a-ac5f-4d30-ab64-b188e45149e4).
 Vengono riportati i dati dal primo giorno di Pandemia alla data odierna.
 
 > **POST** /stats/maxrate
 
 Utilizzando questa rotta è possibile effettuare una statistica che riporta il paese con il maggior ***TASSO DI MORTALITA'*** tra i paesi inseriti dall'utente tramite un body.
 
 > **GET** /stats/dayone/{country}
 
 Utilizzando questa rotta è possibile effettuare una statistica che riporta il ***TASSO DI INCREMENTO GIORNALIERO*** del numero di decessi di un determinato paese inserito dall'utente
 
 
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
 ### Esempio statistica
 ```
 {
    "compareCountries": [
        "Germany",
        "Italy",
        "South-Africa"
    ],
    "countryName": "Italy",
    "maxRate": 36705
}
 ```
 ## UML
  ### Diagramma dei package
 <img src="https://github.com/alexxdediu/ProgettoPO/blob/master/PackageDiagram.jpg" width="400" height="300"> 
 
 ### Diagramma delle classi
 
 > **Controller**
 
<img src="https://github.com/alexxdediu/ProgettoPO/blob/master/ClassDiagramController.jpg" width="400" height="300"> 


> **Model**

<img src="https://github.com/alexxdediu/ProgettoPO/blob/master/ClassDiagramModel.jpg" width="700" height="400"> 

