#!/usr/bin/env bash

#----------------------------------- 启动单独镜像的脚本 -----------------------------------#

# 构建MySQL镜像, 在mysql文件夹下面执行
docker build -t mb-mysql .
# 启动MySQL镜像
# -d 后台运行; 
# --name 指定实例名称; 
# -p 指定容器和宿主机的端口映射; 
# -e 设置 MySQL 服务 root 用户的密码
# 这里启动自己制作的MySQL镜像, 包含初始库表
docker run -d \
  --name mb-mysql \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=123456 \
mb-mysql


# 启动Elasticsearch镜像
docker run -d \
  