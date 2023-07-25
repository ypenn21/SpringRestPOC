# SpringRestPOC

## Setup a database locally

```bash
sudo yum install -y postgresql-server
sudo /usr/bin/postgresql-setup initdb
sudo systemctl enable postgresql
sudo systemctl start postgresql
sudo systemctl status postgresql
psql
create user myuser password '...';
create database mce owner myuser;
\q
psql mce
create table hat(id serial primary key, type text, color text, description text);
alter table hat owner to myuser;
\q
```

# Run SpringRestPOC locally

```bash
mvn clean install 
SPRING_DATASOURCE_USERNAME=myuser SPRING_DATASOURCE_PASSWORD=... SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/mce mvn spring-boot:run
```

This requires java 8 or higher 

# Test the SpringRESTPOC API

curl http://localhost:8080/hats; echo
curl -X POST -H "Content-Type: application/json" -d '{ "color":"Red", "type":"Fedora" }' http://localhost:8080/hats; echo
curl -X POST -H "Content-Type: application/json" -d '{ "color":"White", "type":"White Sox Hat" }' http://localhost:8080/hats; echo
