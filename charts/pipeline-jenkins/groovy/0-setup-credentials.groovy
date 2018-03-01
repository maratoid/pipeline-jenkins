import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;
import org.jenkinsci.plugins.plaincredentials.*
import org.jenkinsci.plugins.plaincredentials.impl.*
import org.jenkinsci.plugins.kubernetes.credentials.*
import com.datapipe.jenkins.vault.credentials.*
import hudson.util.Secret;

def vault = new GroovyScriptEngine( '.' ).with {
  loadScriptByName( '/var/jenkins_home/init.groovy.d/vault-tools' )
} 
this.metaClass.mixin vault

Credentials githubScanCreds = (Credentials) new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "github-access", 
  "github-access", 
  "{{ .Values.github.botUser }}", 
  getKV(
    true,  
    "{{ .Values.vault.token }}", 
    "{{ .Values.vault.github.path }}", 
    "{{ .Values.vault.github.botAccessToken }}" ))

Credentials slackToken = (Credentials) new StringCredentialsImpl(
  CredentialsScope.GLOBAL,
  "slack-access",
  "slack-access",
  Secret.fromString(
    getKV(
      true,  
      "{{ .Values.vault.token }}", 
      "{{ .Values.vault.slack.path }}", 
      "{{ .Values.vault.slack.apiTokenKey }}" )))

Credentials githubToken = (Credentials) new StringCredentialsImpl(
  CredentialsScope.GLOBAL,
  "github-plugin",
  "github-plugin",
  Secret.fromString(
    getKV(
      true,  
      "{{ .Values.vault.token }}", 
      "{{ .Values.vault.github.path }}", 
      "{{ .Values.vault.github.botAccessToken }}" )))

Credentials vaultToken = (Credentials) new VaultTokenCredential(
  CredentialsScope.GLOBAL, 
  "vault-plugin", 
  "vault-plugin", 
  Secret.fromString("{{ .Values.vault.token }}"));

Credentials serviceAccount = (Credentials) new FileSystemServiceAccountCredential(
  CredentialsScope.GLOBAL,
  "kubernetes-access",
  "kubernetes-access")

SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  githubScanCreds)
SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  slackToken)
SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  githubToken)
SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  serviceAccount)
SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  vaultToken)
