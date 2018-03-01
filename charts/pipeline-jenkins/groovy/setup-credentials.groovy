import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;


Credentials githubScanCreds = (Credentials) new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  "template me id", 
  "template me credentials", 
  "template me user", 
  "template me github access token")

SystemCredentialsProvider.getInstance().getStore().addCredentials(
  Domain.global(), 
  githubScanCreds)