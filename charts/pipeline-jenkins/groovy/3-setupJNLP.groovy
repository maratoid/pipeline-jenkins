import jenkins.model.Jenkins

Set<String> agentProtocolsList = ['JNLP4-connect', 'Ping']
Jenkins.instance.setAgentProtocols(agentProtocolsList)
Jenkins.instance.setSlaveAgentPort({{ .Values.agent.port }})

Jenkins.instance.save()