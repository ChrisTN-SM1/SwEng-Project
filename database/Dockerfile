FROM postgres:alpine

ENV POSTGRES_USER=bugboard26admin
ENV POSTGRES_PASSWORD=admin1234
ENV POSTGRES_DB=bugboard26

COPY init.sql /docker-entrypoint-initdb.d/
