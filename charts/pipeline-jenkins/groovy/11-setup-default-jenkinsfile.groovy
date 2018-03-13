import hudson.*
import hudson.model.*
import jenkins.model.*
import jenkins.model.Jenkins.*
import org.jenkinsci.plugins.configfiles.*
import org.jenkinsci.lib.configprovider.model.*
import org.jenkinsci.plugins.configfiles.groovy.*
import org.jenkinsci.plugins.configfiles.*
import org.jenkinsci.plugins.scriptsecurity.scripts.*
import org.jenkinsci.plugins.scriptsecurity.scripts.languages.*

GlobalConfigFiles globalConfigFiles = Jenkins.getInstance().getExtensionList(GlobalConfigFiles.class).get(GlobalConfigFiles.class);
ConfigFileStore store = globalConfigFiles.get();



String defaultJenkinsfile = """import io.cnct.pipeline.*
new cnctPipeline().execute()"""

ApprovalContext approvalContext = ApprovalContext.create();
String defaultJenkinsfileHash = new ScriptApproval.PendingScript(
  defaultJenkinsfile, 
  GroovyLanguage.get(), 
  approvalContext).getHash();

Config config = new GroovyScript(
  'Jenkinsfile', 
  'Jenkinsfile', 
  'Default pipeline Jenkinsfile', 
  defaultJenkinsfile,
  'org.jenkinsci.plugins.configfiles.groovy.GroovyScript');
store.save(config);

ScriptApproval.get().approveScript(defaultJenkinsfileHash)