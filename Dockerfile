# Docker image for springboot file run
# VERSION 0.0.1
# 基础镜像使用java
FROM java:14
# 作者
MAINTAINER yangyi <yangyi7351598@gmail.com>
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为springboot.jar
ADD qa_platform-1.0-SNAPSHOT.jar qa_platform.jar
# 运行jar包
RUN bash -c 'touch /qa_platform.jar'
ENTRYPOINT ["java","-jar","/qa_platform.jar"]