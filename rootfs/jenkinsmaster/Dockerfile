FROM jenkins
MAINTAINER Samsung CNCT <maratoid@gmail.com>

ENV JENKINS_VERSION 2.111

VOLUME /var/jenkins_home
VOLUME /etc/jenkins_jobs

USER root
COPY plugins.txt /usr/share/jenkins/plugins.txt

# update jenkins to latest and install kubernetes and other plugins
RUN mkdir -p /usr/share/jenkins/ref/secrets/ \
    && echo "false" > /usr/share/jenkins/ref/secrets/slave-to-master-security-kill-switch \
    && rm -f /usr/share/jenkins/jenkins.war \
    && wget https://repo.jenkins-ci.org/public/org/jenkins-ci/main/jenkins-war/${JENKINS_VERSION}/jenkins-war-${JENKINS_VERSION}.war  -O /usr/share/jenkins/jenkins.war 

# install plugins
RUN /usr/local/bin/install-plugins.sh $(cat /usr/share/jenkins/plugins.txt | tr '\n' ' ')

# install additional tools
RUN apt-get update && apt-get install -y --force-yes html-xml-utils jq

User jenkins