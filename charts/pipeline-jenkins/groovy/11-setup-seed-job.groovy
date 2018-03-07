import jenkins.*
import hudson.*
import hudson.model.*
import jenkins.model.*
import jenkins.model.Jenkins.*
import javaposse.jobdsl.dsl.*
import javaposse.jobdsl.plugin.*

JenkinsJobManagement jm = new JenkinsJobManagement(System.out, [:], new File('.'));
DslScriptLoader dslScriptLoader = new DslScriptLoader(jm)
dslScriptLoader.runScript("""
job('{{ .Values.github.jobsRepo }}-jobs') {

  displayName('Re-create {{ .Values.github.jobsRepo }} jobs')
  description('Re-create all jobs from the {{ .Values.github.jobsRepo }} repository')

  blockOn('.*-pipeline') {
    blockLevel('GLOBAL')
    scanQueueFor('ALL')
  }

  scm {
    github('samsung-cnct/pipeline-jobs', 'master', 'https', 'github.com')
  }

  steps {
    dsl {
      external 'jobdsl/**/*.groovy'
      additionalClasspath(['lib/*.jar','src/main/groovy'].join('\\n'))
      removeAction 'DELETE'
    }
  }
}
""")

def job = Jenkins.getInstance().getItem('{{ .Values.github.jobsRepo }}-jobs')
job.scheduleBuild()