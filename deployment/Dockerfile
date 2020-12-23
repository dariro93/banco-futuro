FROM postgres:9.6

RUN apt-get update
RUN apt-get install wget -y;

# Install Java 8
WORKDIR /opt
RUN wget -O AdoptOpenJDK-8u265b01.tar.gz https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u265-b01/OpenJDK8U-jdk_x64_linux_hotspot_8u265b01.tar.gz
RUN tar -xf AdoptOpenJDK-8u265b01.tar.gz
ENV JAVA_HOME /opt/jdk8u265-b01
ENV PATH $JAVA_HOME/bin:$PATH

# Set running environment
ENV CONFIG_FILES_PATH="/opt"
COPY entrypoint.sh $CONFIG_FILES_PATH
COPY starter.sh $CONFIG_FILES_PATH
COPY application.yml $CONFIG_FILES_PATH
COPY banco-del-futuro-solution-1.0.jar $CONFIG_FILES_PATH

# Copy script to create schema on startup
COPY db/schema.sql /docker-entrypoint-initdb.d/

RUN chmod +x /opt/*.sh

ENTRYPOINT ["/opt/starter.sh"]