evaluate(new File("tools.groovy"))

def getKV = { boolean tls, String server, String token, String backend, String key, String field='value', String api='v1' ->
    
  def curl = "" 

  if (tls) {
    curl = "curl --connect-timeout 1 \
      --cert /etc/vault/tls/vault-client.pem \
      --cert-type PEM \
      --key /etc/vault/tls/vault-client-key.pem \
      --key-type PEM \
      --cacert /etc/vault/tls/ca.pem \
      --location \
      -s \
      --header \"X-Vault-Token: ${token}\" \
      ${server}/${api}/${backend}/${key}"
  } else {
    curl = "curl --connect-timeout 1 \
      --location \
      -s \
      --header \"X-Vault-Token: ${token}\" \
      ${server}/${api}/${backend}/${key}"
  }

  return runCommand(curl)
}
