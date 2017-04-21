import java.util.Locale

import org.apache.commons.lang3.StringUtils._

getFuzzyDistance("British American Tobacco", "BAT", Locale.ENGLISH)
getFuzzyDistance( "BAT","British American Tobacco", Locale.ENGLISH)

//getFuzzyDistance("Barclays", "BAT", Locale.ENGLISH)
//getFuzzyDistance( "BAT","Barclays", Locale.ENGLISH)
val str = "Barclldddsafdasfdasfdddddddddd"
str.length
getFuzzyDistance( str,str, Locale.ENGLISH)
valu(str)
//getFuzzyDistance( "BAT","BAT", Locale.ENGLISH)

getJaroWinklerDistance("BAT", "British American Tobacco")
getJaroWinklerDistance("British American Tobacco", "BAT")

//"British American Tobacco".split(" ").map(_.charAt(0).toUpper).mkString



def valu(str: String) = str.length * 3 - 2

def value(str:String): Int = str match {
  case x if x.length == 1 => 1
  case x => 3 + value(x.substring(1))
}