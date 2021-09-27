FROM adoptopenjdk/openjdk8-openj9:alpine-slim
VOLUME /home/web_project/web-deploy-test/server1
ADD /target/server1-0.0.1-SNAPSHOT.jar app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

# Install cURL 为openJdk安装字体，详情：https://github.com/alibaba/easyexcel/issues/157
RUN echo -e "https://mirrors.aliyun.com/alpine/v3.6/main/\nhttps://mirrors.aliyun.com/alpine/v3.6/community/" > /etc/apk/repositories  && apk update  && apk upgrade && apk --no-cache add ttf-dejavu fontconfig && rm -rf /var/cache/apk/*

COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas