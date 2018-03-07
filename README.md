# Jenkins Base Helm Chart

Jenkins cluster utilizing the Jenkins Kubernetes plugin

* https://github.com/samsung-cnct/jenkins-base

## Chart Details
This chart will do the following:

* 1 x Jenkins Master with port 8080 exposed
* All using Kubernetes Deployments

## Configuration

The following tables lists the configurable parameters of the Jenkins chart and their default values.

### images
| Parameter | Description | Default |
| --- | --- | --- |
| `images.jenkinsgradle` | Image name with gradle tools installed | `set me` |
| `images.jenkinsagent` | Image name with kubernetes, helm and other build/ops tools installed | `set me` |
| `images.jenkinsmaster` | Master jenkins image | `set me` |
| `images.jenkinsshelldev` | BATS image image | `set me` |

### kubernetes
| Parameter | Description | Default |
| --- | --- | --- |
| `kubernetes.cloudName` | K8s cloud name for Jenkins cloud management | `Kubernetes` |
| `kubernetes.apiServer` | K8s api server | `https://kubernetes.default.svc.cluster.local` |
| `kubernetes.namespace` | K8s namespace for agent pods  | `prod` |
| `kubernetes.containerCap` | Max agent containers | `10000` |
| `kubernetes.timeout` | Various connection timeouts | `60` |

### Slack
| Parameter | Description | Default |
| --- | --- | --- |
| `slack.baserl` | Slack base url | `https://samsung-cnct.slack.com/services/hooks/jenkins-ci/` |
| `slack.slackDomain` | Slack domain | `samsung-cnct` |
| `slack.slackRoom` | Slack room name | `#ping-jenkins` |

### GitHub
| Parameter | Description | Default |
| --- | --- | --- |
| `github.admins` | GitHub admin usernames | `change me` |
| `github.botUser` | Bot username| `SDSBot` |
| `github.pipelineOrg` | Org for the shared pipeline lib | `samsung-cnct` |
| `github.pipelineRepo` | Repo for the shared pipeline lib | `pipeline-library` |
| `github.overrideHookUrl` | Different url for webhook callbacks | `` |
| `github.manageHooks` | Jenkins manages github webhooks for all jobs | `true` |
| `github.orgNames` | GitHub org names to monitor | `change me` |

### vault
| Parameter | Description | Default |
| --- | --- | --- |

### Persistence
| Parameter | Description | Default |
| --- | --- | --- |

