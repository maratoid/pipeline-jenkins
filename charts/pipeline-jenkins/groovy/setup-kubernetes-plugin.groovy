import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import org.csanchez.jenkins.plugins.kubernetes.*

@Grab('com.bettercloud:vault-java-driver:3.0.0')
import com.bettercloud.vault.*


def kubernetesCloud = new KubernetesCloud(
  'template me',
  null,
  'kubernetes svc template me',
  'namespace template me',
  'jenkins url template me',
  'container cap template me', 
  0, // connection timeout template me 
  0, // read timeout template me
  5 // retention timeout template me
)


kubernetesCloud.setSkipTlsVerify(false)

// read kubernetes server certificate key form vault
// TODO
final VaultConfig config = new VaultConfig()
  .address("template me")
  .token("template me")
  .build();
final Vault vault = new Vault(config);
kubernetesCloud.setCredentialsId('template me')

Jenkins.getInstance().clouds.replace(kubernetesCloud)
Jenkins.getInstance().save()