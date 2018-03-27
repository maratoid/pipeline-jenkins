# Jenkins Base Helm Chart

Jenkins cluster utilizing the Jenkins Kubernetes plugin

* https://github.com/samsung-cnct/jenkins-base

## Chart Details
This chart will do the following:

* 1 x Jenkins Master with port 8080 exposed using Kubernetes Deployments
* Optional Ingress
* Optional Job history persistence
* Optional Jenkins metrics (NOT IMPLEMENTED)


After Jenkins starts the chart will mount a secret to the [post-initialization script location](https://wiki.jenkins.io/display/JENKINS/Post-initialization+script) with [configuration groovy scripts](charts/pipeline-jenkins/groovy); configuring jenkins with all of the required credentials, cloud configurations, global pipeline libraries, etc.

## Vault

This chart relies on a pre-existing Hashicorp vault server from which it pulls all of the required secrets using the `.vault.token` from values yaml.

## Pipeline library

This chart will setup a [default Jenkinsfile](https://github.com/vaimr/pipeline-multibranch-defaults-plugin) for use by the CNCT pipeline library-base jobs.

See https://github.com/samsung-cnct/pipeline-library for details.

## Job configurations

This chart will create and run a seed job to instantiate job configurations from `.github.jobsOrg/.github.jobsRepo`.

See https://github.com/samsung-cnct/pipeline-jobs for details.

## Configuration

Documented inline in [values.yaml](charts/pipeline-jenkins/values.yaml)



