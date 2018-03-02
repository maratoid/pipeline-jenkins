def runCommand = { command ->
  assert(command instanceof String )
  
  def proc = command.execute()
  // proc.in.eachLine { line -> println line }
  proc.out.close()
  proc.waitFor()

  assert !proc.exitValue()

  return proc.in
}