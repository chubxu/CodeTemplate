FROM nginx

MAINTAINER chubxu
EXPOSE 9999
LABEL version="1.0.1" description="携带前端静态资源的nginx镜像" by="chubxu"

COPY dist /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/