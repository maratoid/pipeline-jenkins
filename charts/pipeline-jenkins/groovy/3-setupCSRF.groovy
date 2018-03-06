import hudson.security.csrf.DefaultCrumbIssuer
import jenkins.model.Jenkins

Jenkins.instance.setCrumbIssuer(new DefaultCrumbIssuer(true))
Jenkins.instance.save()