package fuzzy

import java.io.File

/**
  * Created by jta on 20/04/2017.
  */
object CompanyData {

  private[fuzzy] def fileTestPath = {
//    new File(this.getClass.getClassLoader.getResource("/Users/jta/spark/companytestlist.csv").toURI).getPath
    new File("file:/Users/jta/spark/companytestlist.csv").getPath
  }
  private[fuzzy] def filePath = {
//    new File(this.getClass.getClassLoader.getResource("/Users/jta/spark/ftse100companies.csv").toURI).getPath
    new File("file:/Users/jta/spark/ftse100companies.csv").getPath
//    new File("file://Users/jta/spark/companytestlist.csv").getPath
  }

  private[fuzzy] def parse(line: String): Company =  Company(line)

}
