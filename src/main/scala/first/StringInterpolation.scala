package first

/**
 * Created by satanson on 2014/12/13.
 */
object StringInterpolation {
  def main(args:Array[String]):Unit={
    val intValue=10
    println(raw"$intValue foo$intValue${1+3}${1}")
  }
}
