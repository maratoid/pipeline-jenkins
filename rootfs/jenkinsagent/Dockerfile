FROM golang:1.8.0

ENV KUBERNETES_VERSION=v1.8.2 \
  HELM_VERSION=v2.8.0 

RUN apt-get update -qq && apt-get install -qqy \
    apt-transport-https \
    ca-certificates \
    bash \
    curl \
    git \
    make \
    dnsutils \
    lsb-release \
    wget \
    html-xml-utils \
    && rm -rf /var/lib/apt/lists/*

# Install kubectl
RUN wget -O /usr/bin/kubectl https://storage.googleapis.com/kubernetes-release/release/${KUBERNETES_VERSION}/bin/linux/amd64/kubectl \
    && chmod +x /usr/bin/kubectl

# Install helm
RUN wget http://storage.googleapis.com/kubernetes-helm/helm-${HELM_VERSION}-linux-amd64.tar.gz \
  && tar xzf ./helm-${HELM_VERSION}-linux-amd64.tar.gz \
  && mv linux-amd64/helm /usr/local/bin \
  && rm -rf helm-${HELM_VERSION}-linux-amd64.tar.gz linux-amd64

# Install Docker from Docker Inc. repositories.   
RUN curl -sSL https://get.docker.com/ | sh

# install go packages: ginkgo, gomega, dep, and k8s client
RUN go get github.com/onsi/ginkgo/ginkgo \
    && go get github.com/onsi/gomega
    
