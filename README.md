# Jenkins Base Helm Chart

Jenkins cluster utilizing the Jenkins Kubernetes plugin

* https://github.com/samsung-cnct/jenkins-base

## Chart Details
This chart will do the following:

* 1 x Jenkins Master with port 8080 exposed
* All using Kubernetes Deployments

## Configuration

The following tables lists the configurable parameters of the Jenkins chart and their default values.

### GitHub, Authentication, images
| Parameter | Description | Default |
| --- | --- | --- |
| `adminEmail` | Administrator email address | `me@email.com` |
| `javaOptions` | Java runtime options | `-Xms1024m -Xmx1024m -Djenkins.install.runSetupWizard=false` |
| `jenkinsUrl` | Jenkins URL | `jenkins.cnct.io` |
| `jobsRepo` | Jenkins jobs repo | `https://github.com/pipeline-jobs` |
| `jenkinsHookUrl` | Jenkins web url | `optional` |
| `workflowRepo` | Jenkins jobs repo | `https://github.com/samsung-cnct/cnct-pipeline-library` |
| `seedJobToken` | Seed job token | `seed` |
| `images.jenkinsgradle` | Image name with gradle tools installed | `set me` |
| `images.jenkinsagent` | Image name with gke tools installed | `set me` |
| `images.jenkinsmaster` | Master jenkins image | `set me` |
| `images.jenkinsshelldev` | BATS image image | `set me` |


### Slack
| Parameter | Description | Default |
| --- | --- | --- |
| `slack.slackDomain` | Slack domain | `change me` |
| `slack.slackRoom` | Slack room name | `#ping-jenkins` |
| `slack.slackApiToken` | Slack API token | `change me` |

### GitHub
| Parameter | Description | Default |
| --- | --- | --- |
| `github.clientId` | GitHub client Id | `change me` |
| `github.botUser` | GitHub user name | `change me` |
| `github.clientKey` | GitHub client key | `change me` |
| `github.admins` | GitHub admin usernames | `change me` |

### GKE
| Parameter | Description | Default |
| --- | --- | --- |
| `gke.clusterName` | GKE cluster name | `production-cluster` |
| `gke.clusterPrimaryZone` | GKE cluster primary zone | `us-east1-b` |
| `gke.gkeProject` | GKE project | `change me` |
| `gke.svcAccountId` | GKE service account Id | `change me` |
| `gke.svcAccountKey` | GKE service account key | `change me` |

### SSH
| Parameter | Description | Default |
| --- | --- | --- |
| `ssh.sshPrivateKey` | SSH private key | `change me` |
| `ssh.sshPublicKey` | SSH public key | `change me` |

### Persistence
| Parameter | Description | Default |
| --- | --- | --- |
| `persistence.enabled` | Enable the use of a Jenkins PVC | `false` |
| `persistence.accessMode` | The PVC access mode | `ReadWriteOnce` |
| `persistence.reclaiming` | PV reclaim policy | `Retain` |
| `persistence.size` | The size of the PVC | `200Gi` |
| `persistence.claimName` | PV, PVC and GCE PD names | `dr-jenkins-jobs` |


### Agent
| Parameter | Description | Default |
| --- | --- | --- |
| `agent.cpu` | Agent requested cpu | `200m` |
| `agent.memory` | Agent requested memory | `1024Mi` |
| `agent.port` | Agent requested port | `50000` |

### Master
| Parameter | Description | Default |
| --- | --- | --- |
| `master.cpu` | Master requested cpu | `200m` |
| `master.memory` | Master requested memory | `1024Mi` |
| `master.port` | k8s service port | `8080` |
| `master.serviceType` | k8s service type | `NodePort` |
| `master.nodePort` | k8s node port | `30061` |

### Helm
| Parameter | Description | Default |
| --- | --- | --- |
| `helm.serviceAccount` | Helm service account Id | `change me` |
