import hudson.*
import hudson.model.*
import jenkins.model.*
import jenkins.model.Jenkins.*
import org.jenkinsci.plugins.configfiles.GlobalConfigFiles
import org.jenkinsci.lib.configprovider.model.Config
import org.jenkinsci.plugins.configfiles.groovy.GroovyScript
import org.jenkinsci.plugins.configfiles.ConfigFileStore

GlobalConfigFiles globalConfigFiles = Jenkins.getInstance().getExtensionList(GlobalConfigFiles.class).get(GlobalConfigFiles.class);
ConfigFileStore store = globalConfigFiles.get();
Config config = new GroovyScript("default-jenkinsfile", "Jenkinsfile", "Default pipeline Jenkinsfile", "new cnctPipeline().execute()");
store.save(config);