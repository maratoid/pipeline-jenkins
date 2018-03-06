import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import org.jenkinsci.plugins.github.config.GitHubPluginConfig
import org.jenkinsci.plugins.github.config.GitHubServerConfig
import org.jenkinsci.plugins.github.config.HookSecretConfig

def global_settings = Jenkins.instance.getExtensionList(GitHubPluginConfig.class)[0]
def server = new GitHubServerConfig('github-plugin')

List configs = []

server.name = 'GitHub'
server.apiUrl = '{{ .Values.github.apiUrl }}'
server.manageHooks = {{ .Values.github.manageHooks }}
server.clientCacheSize = {{ .Values.github.clientCacheSize }}
configs << server

global_settings.hookUrl = null
{{- if .Values.github.overrideHookUrl }}
global_settings.hookUrl = {{ .Values.github.overrideHookUrl }}
{{- end }}

global_settings.configs = configs
global_settings.save()