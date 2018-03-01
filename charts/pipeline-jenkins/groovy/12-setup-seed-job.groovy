import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import jenkins.model.Jenkins.*
import javaposse.jobdsl.dsl.*
import javaposse.jobdsl.plugin.*
import org.jenkinsci.plugins.scriptsecurity.scripts.*
import org.jenkinsci.plugins.scriptsecurity.scripts.languages.*

JenkinsJobManagement jm = new JenkinsJobManagement(System.out, [:], new File('.'));

String seedJob = """
job('{{ .Values.github.jobsRepo }}-jobs') {

  displayName('Re-create {{ .Values.github.jobsRepo }} jobs')
  description('Re-create all jobs from the {{ .Values.github.jobsRepo }} repository')

  blockOn('.*-pipeline') {
    blockLevel('GLOBAL')
    scanQueueFor('ALL')
  }

  logRotator {
    artifactDaysToKeep(10)
  }

  scm {
    git {    
      branch('master')

      remote {
        credentials('github-access')
        url('https://{{ .Values.github.baseUrl }}/{{ .Values.github.jobsOrg }}/{{ .Values.github.jobsRepo }}')
      }
    }
  }

  steps {
    jobDsl {
      additionalClasspath(['lib/*.jar','src/main/groovy'].join('\\n'))
      ignoreExisting(false)
      removedJobAction('DELETE')
      removedViewAction('DELETE')
      sandbox(true)
      targets('jobdsl/**/*.groovy')
    }
  }
}
"""
ApprovalContext approvalContext = ApprovalContext.create();
String seedJobHash = new ScriptApproval.PendingScript(
  seedJob, 
  GroovyLanguage.get(), 
  approvalContext).getHash();
ScriptApproval.get().approveScript(seedJobHash)

DslScriptLoader dslScriptLoader = new DslScriptLoader(jm)
dslScriptLoader.runScript(seedJob)

def job = Jenkins.getInstance().getItem('{{ .Values.github.jobsRepo }}-jobs')
job.scheduleBuild()