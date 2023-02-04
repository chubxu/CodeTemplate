FROM openjdk:8u342

MAINTAINER chubxu
EXPOSE 8080
LABEL version="1.0.1" description="安装openssh-server的openjdk镜像" by="chubxu"

COPY moon-box-web /moonbox/
COPY moonbox-agent.tar /moonbox/moonbox-agent.tar
COPY sandbox-agent.tar /moonbox/sandbox-agent.tar
COPY moonbox-agent.tar /root/moonbox-agent-download/moonbox-agent-1.tar
COPY sandbox-agent.tar /root/moonbox-agent-download/sandbox-agent-1.tar

# 切换阿里镜像源
RUN sed -i s@/deb.debian.org/@/mirrors.aliyun.com/@g /etc/apt/sources.list
RUN apt-get clean
RUN apt-get update

RUN apt-get install dos2unix
RUN apt-get install lsof

RUN apt-get install -y openssh-server
RUN echo "PermitRootLogin yes" >> /etc/ssh/sshd_config
RUN echo "root:123456" | chpasswd

CMD /etc/init.d/ssh start; cd /bin; rm sh; ln -s bash sh; java -jar /moonbox/moon-box-web