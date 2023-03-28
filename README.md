# shop-microservices
Booking products project using SpringBoot Microservices

In a way for more flexible interfaces, I used microservices architecture to build my shop.
I have 3 main services which are *products*, *booking* and *stock*

Further services are used for authorization, secret credentials storage, knowing services instances available and notifiers

- Since customer can't talk to services directly, they go through authentication process, where I used here **API Gateway** using **keycloak**

- For all services, they must be registered in **Discovery service** to know how many instances do we have in **eureka** web page for such a service to distribute the tasks

- You don't to rebuild the whole service inorder to change one of the credentials if you put them all in **Centralized configuration** and call it from the **Config server**

- Want more secure way for your DB credentials? 
what about using **Vault**
to start Vault:

1. run next command in vault setup directory:
vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"

2. put the following in the environment:
VAULT_ADDR=http://127.0.0.1:8200

3. use the following command at the directory of microservice json file (ex: bookingMicroservice.json) to be put in secret directory in vault: vault kv put secret/bookingMicroservice @bookingMicroservice.json


- - Note : "this command should be always resent when we close server, bec, they are saved in RAM not ROM of server"


4. the following command is used to get back your credentials:
vault kv get secret/bookingMicroservice

- I have tested two ways for notifieying services with any changes in Centralized configuration:

- - 1st: **RefreshScope** where we need to send the request for actuator refresh scope which is done for one microservice only then send the request and each microservice must be run manually. This isn't practical

- - 2nd: **message broker** using **busrefresh** where it runs once and notify all the interested microservices. For message broker, I ran **rabbitMQ** docker image to implement the "event-driven" communication pattern, where microservices communicate with each other by publishing events to RabbitMQ, which are then consumed by other microservices. This pattern allows microservices to be loosely coupled and scalable, as each microservice only needs to know about the events that it is interested in, rather than having to maintain direct connections to all other microservices in the system.

- I used **FeignClient** as a way for API calls
- In order not letting APIs calls are done even if the other API isn't available, I used **Circuit Breaker: resilience4j**











