def jenkins = jenkins.model.Jenkins.getInstance()

slack = jenkins.getDescriptorByType(jenkins.plugins.slack.SlackNotifier.DescriptorImpl)
slack.baseUrl = "template me"
slack.teamDomain = "template me"
slack.token = "template me"
slack.sendAs = "template me"
slack.tokenCredentialId ="template me"
slack.save()