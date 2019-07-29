
#####################
##    CURL TEST    ##
#####################

curl -X GET  -H 'content-type: application/json' http://localhost:8080/gamechanger/api/v1/declaracao
curl -X GET  -H 'content-type: application/json' http://localhost:8080/gamechanger/api/v1/onboarding
curl -X GET  -H 'content-type: application/json' http://localhost:8080/gamechanger/api/v1/onboarding/details



curl -X PUT -H 'content-type: application/json' http://localhost:8080/gamechanger/api/v1/onboarding \
    -d '{ 
        "data": "2018-12-02",
        "nome": "Projeto WON",
        "declaracoes": [
            { "id": 1,  "valor": true },
            { "id": 4,  "valor": true }
        ]
    }'
