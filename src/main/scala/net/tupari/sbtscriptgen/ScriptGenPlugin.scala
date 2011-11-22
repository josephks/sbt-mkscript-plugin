import sbt._
import Keys._

object ScriptGenPlugin extends Plugin{
  // configuration points, like the built in `version`, `libraryDependencies`, or `compile`
  // by implementing Plugin, these are automatically imported in a user's `build.sbt`
  val generateRunScript = TaskKey[Unit]("generate-run-script")
  
  // a group of settings ready to be added to a Project
	// to automatically add them, do 
  val scriptGenSettings = Seq(
    generateRunScript <<=  (
//      dependencyClasspath in Runtime, artifactPath in Runtime, mainClass, streams) map { (dc, dir, mainClass, s) =>
      dependencyClasspath in Runtime, classDirectory in Compile, mainClass, streams) map { (dc, dir, mainClass, s) =>
        val file = new File(dir, "runscript.sh")
        val pw = new java.io.PrintWriter(file)
        pw.println("CLASSPATH=" + dc.map( _.data.toString).mkString(":"))
        pw.println("scala -cp $CLASSPATH " + mainClass.getOrElse("<main class goes here>"))
        pw.close()
        s.log.info("wrote out "+ file)        
                                                                             
}
    
	)//seq

	// alternatively, by overriding `settings`, they could be automatically added to a Project
	// override val settings = Seq(...)
}
