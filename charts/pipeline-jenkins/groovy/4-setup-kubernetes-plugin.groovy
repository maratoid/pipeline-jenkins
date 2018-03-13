import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import org.csanchez.jenkins.plugins.kubernetes.*

def vault = new GroovyScriptEngine( '.' ).with {
  loadScriptByName( '/var/jenkins_home/init.groovy.d/vault-tools' )
} 
this.metaClass.mixin vault

def kubernetesCloud = new KubernetesCloud(
  '{{ .Values.kubernetes.cloudName }}',
  null,
  '{{ .Values.kubernetes.apiServer }}',
  '{{ .Release.Namespace }}',
  'http://{{ template "jenkins.fullname" . }}:{{ .Values.master.port }}',
  '{{ .Values.kubernetes.containerCap }}', 
  {{ .Values.kubernetes.timeout }}, // connection timeout template me 
  {{ .Values.kubernetes.timeout }}, // read timeout template me
  {{ .Values.kubernetes.timeout }} // retention timeout template me
)

kubernetesCloud.setCredentialsId('kubernetes-access')
kubernetesCloud.setSkipTlsVerify(false)
kubernetesCloud.setMaxRequestsPerHostStr('{{ .Values.kubernetes.maxRequestsPerHost }}')
kubernetesCloud.setServerCertificate(
  getKV(
    true,  
    "{{ .Values.vault.token }}", 
    "{{ .Values.vault.kubernetes.path }}", 
    "{{ .Values.vault.kubernetes.serverCertKey }}" ))
kubernetesCloud.setJenkinsTunnel('{{ template "jenkins.fullname" . }}:{{ .Values.agent.port }}')

Jenkins.getInstance().clouds.replace(kubernetesCloud)
Jenkins.getInstance().save()