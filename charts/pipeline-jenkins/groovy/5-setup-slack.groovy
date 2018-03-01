import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*

slack = Jenkins.getInstance().getDescriptorByType(jenkins.plugins.slack.SlackNotifier.DescriptorImpl)
slack.baseUrl = "{{ .Values.slack.baseUrl }}"
slack.teamDomain = "{{ .Values.slack.domain }}"
slack.sendAs = "{{ .Values.slack.sendAs }}"
slack.tokenCredentialId ="slack-access"
slack.room = "{{ .Values.slack.room }}"
slack.botUser = true
slack.save()