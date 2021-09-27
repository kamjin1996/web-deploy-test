FROM adoptopenjdk/openjdk8-openj9:alpine-slim
VOLUME /home/web_project/web-deploy-test/server1
ADD /target/server1-0.0.1-SNAPSHOT.jar app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

# Install cURL 为openJdk安装字体，详情：https://github.com/alibaba/easyexcel/issues/157
RUN echo -e "https://mirrors.aliyun.com/alpine/v3.6/main/\nhttps://mirrors.aliyun.com/alpine/v3.6/community/" > /etc/apk/repositories  && apk update  && apk upgrade && apk --no-cache add ttf-dejavu fontconfig && rm -rf /var/cache/apk/*

# copy arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas

ENV JAVA_OPTS="\
-server \
-XX:+UseParallelGC \
-XX:ParallelGCThreads=4 \
-XX:+UseParallelOldGC \
-XX:+UseAdaptiveSizePolicy \
-XX:+PrintGCDetails \
-XX:+PrintTenuringDistribution \
-XX:+PrintGCTimeStamps \
-XX:+PrintGCDateStamps \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/home/web_project/deploy_test/ \
-Xloggc:/home/web_project/deploy_test/gc.log \
-XX:NumberOfGCLogFiles=5 \
-XX:GCLogFileSize=20M \
-Xdump:heap \
-XX:+HeapDumpOnCtrlBreak \
-Xshareclasses \
-Xquickstart \
-Djava.security.egd=file:/dev/./urandom \
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=20200 \
-Dspring.profiles.active=dev \
-Duser.timezone=GMT+08 "
ENTRYPOINT  java  -jar ${JAVA_OPTS}  /app.jar