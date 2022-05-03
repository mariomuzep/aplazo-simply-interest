# aplazo-simply-interest
Proyecto-Ejercicio para Aplazo - Backend Developer


# Docker comandos:
>mvn clean install

>docker build -t aplazo-simply-interest:latest .

>docker run -p8081:8080 --name servicio-aplazo aplazo-simply-interest

# Prueba de servicio
>curl -X POST \
  http://localhost:8081/simplyinterest/table \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
"amount": 1000,
"terms":5,
"rate":10
}
