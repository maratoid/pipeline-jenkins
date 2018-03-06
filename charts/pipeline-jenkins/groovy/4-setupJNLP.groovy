import jenkins.model.Jenkins

Set<String> agentProtocolsList = ['JNLP4-connect', 'Ping']
Jenkins.instance.setAgentProtocols(agentProtocolsList)
Jenkins.instance.save()