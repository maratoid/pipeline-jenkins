import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import com.datapipe.jenkins.vault.configuration.GlobalVaultConfiguration
import com.datapipe.jenkins.vault.configuration.VaultConfiguration
import jenkins.model.GlobalConfiguration

def globalVaultConfig = GlobalConfiguration.all().get(GlobalVaultConfiguration.class);
globalVaultConfig.setConfiguration(
  new VaultConfiguration(
    "{{ .Values.vault.server }}", 
    'vault-plugin'));
globalVaultConfig.save();