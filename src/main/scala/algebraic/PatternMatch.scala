package algebraic

/**
 * Created by satanson on 2014/12/11.
 */
class Abs{}
case object A extends Abs {}
case object B extends Abs {}
object PatternMatch {
  def func:Abs=>String ={
    case A =>"A"
    case B =>"B"
  }
  def main(args:Array[String]):Unit={
    println (func(A))
  }
}
