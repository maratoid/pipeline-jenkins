import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;
import org.jenkinsci.plugins.plaincredentials.*
import org.jenkinsci.plugins.plaincredentials.impl.*
import hudson.util.Secret;

// TODO read all of these from vault

Credentials githubScanCreds = (Credentials) new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "template me id", 
  "template me credentials", 
  "template me user", 
  "template me github access token")

SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  githubScanCreds)

Credentials secretText = (Credentials) new StringCredentialsImpl(
  CredentialsScope.GLOBAL,
  "template me",
  "Secret Text Description",
  Secret.fromString("template me"))

SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  githubScanCreds)
SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  secretText)
