#!/usr/bin/env bash

#----------------------------------- 启动单独镜像的脚本 -----------------------------------#

# 创建网段, 所有镜像在相同网段中才能相互通信
docker network create mb-network


# 构建MySQL镜像, 在mysql文件夹下面执行
docker build -t mb-mysql .
# 启动MySQL镜像
# -d 后台运行
# --name 指定实例名称
# -p 指定容器和宿主机的端口映射
# -e 设置 MySQL 服务 root 用户的密码
# --network 指定网段
# 这里启动自己制作的MySQL镜像, 包含初始库表
docker run -d \
  --name mb-mysql \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=123456 \
  --network mb-network \
mb-mysql


# 启动Elasticsearch镜像
# 由于这里使用的elasticsearch不需要其它处理, 因此使用官方镜像即可
# -d 后台运行
# --name 指定实例名称
# -p 指定容器和宿主机的端口映射
# -e ES_JAVA_OPS="-Xms512m -Xmx512m" 指定启动JVM参数
# -e "discovery.type=single-node" 表示单节点启动
# -v 挂载一系列文件和文件夹到宿主机上
# --network 指定网段
docker run -d \
  --name mb-elasticsearch \
  -p 9200:9200 \
  -p 9300:9300 \
  -e ES_JAVA_OPS="-Xms512m -Xmx512m" \
  -e "discovery.type=single-node" \
  -v /home/xu/Desktop/code/opensource/MoonBox-main/docker/elasticsearch/data:/usr/share/elasticsearch/data \
  -v /home/xu/Desktop/code/opensource/MoonBox-main/docker/elasticsearch/logs:/usr/share/elasticsearch/logs \
  -v /home/xu/Desktop/code/opensource/MoonBox-main/docker/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
  --network mb-network \
elasticsearch:7.16.2


# 构建springboot镜像, 在server文件夹下执行
docker build -t mb-server .
# 启动springboot镜像
# -d 后台运行
# --name 指定实例名称
# -p 指定容器和宿主机的端口映射
# --network 指定网段
docker run -d \
  --name mb-server \
  -p 8080:8080 \
  --network mb-network \
mb-server


# 构建前端镜像, 在web文件夹下执行
docker build -t mb-web .
# 启动前端镜像
# -d 后台运行
# --name 指定实例名称
# -p 指定容器和宿主机的端口映射
# --network 指定网段
docker run -d \
  --name mb-web \
  -p 9999:9999 \
  --network mb-network \
mb-web