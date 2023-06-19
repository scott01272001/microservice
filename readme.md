# Getting Started

### run db
docker-compose -f ./docker-compose.yml up -d

### keyclock
docker run -p 8010:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin --name keycloak quay.io/keycloak/keycloak:21.1.1 start-dev
