import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import jenkins.model.JenkinsLocationConfiguration

jenkinsLocation = JenkinsLocationConfiguration.get()
jenkinsLocation.setUrl("{{ .Values.master.jenkinsUrl }}") 
jenkinsLocation.setAdminAddress("{{ .Values.master.adminEmail }}")
jenkinsLocation.save()
