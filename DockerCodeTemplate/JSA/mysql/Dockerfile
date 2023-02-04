FROM mysql:5.7

MAINTAINER chubxu
EXPOSE 3306
LABEL version="1.0.1" description="携带mb初始库表的MySQL镜像" by="chubxu"

ENV MYSQL_DATABASE=moonbox \
    MYSQL_ROOT_PASSWORD=123456

COPY ./ddl.sql /docker-entrypoint-initdb.d