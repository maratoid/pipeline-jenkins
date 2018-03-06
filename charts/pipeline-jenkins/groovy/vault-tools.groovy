evaluate(new File("tools.groovy"))

def getKV = { boolean tls, String token, String path, String field='value', String api='v1' ->
   
  def curl = "curl --connect-timeout 1 -s --location --header \"X-Vault-Token: ${token}\"" 
  def location = "{{ .Values.vault.server }}/${api}/${path}"
   
  if (tls) {
    curl = curl + " --cert {{ .Values.vault.tls.mount }}/{{ .Values.vault.tls.cert }} --cert-type PEM --key {{ .Values.vault.tls.mount }}/{{ .Values.vault.tls.key }} --key-type PEM --cacert {{ .Values.vault.tls.mount }}/{{ .Values.vault.tls.ca }} "
  } 
  
  curl += location

  def exitCode = 0
  def output = ""
  
  (exitCode, output) =  runCommand(curl)
  assert(!exitCode)
  
  def jq = "echo '" + output + "' | " + "jq --raw-output .data.${field}" 
  (exitCode, output) =  runCommand(jq)
  assert(!exitCode)  
  
  return output
}