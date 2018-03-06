def runCommand = { command ->
  
  def proc = [ 
    "bash", 
    "-c", 
    command ].execute()

  proc.waitFor()
  
  return [proc.exitValue(), proc.text]
}