FROM openjdk:8u342

MAINTAINER chubxu
EXPOSE 8080
LABEL version="1.0.1" description="安装openssh-server的openjdk镜像" by="chubxu"

ADD mb.jar /mb/mb.jar
ADD ma.jar /mb/ma.jar
ADD ssb.jar /mb/ssb.jar

RUN apt update && apt install -y openssh-server
RUN echo "PermitRootLogin yes" >> /etc/ssh/sshd_config
RUN echo "root:123456" | chpasswd

CMD /etc/init.d/ssh start; java -jar /mb/mb.jar