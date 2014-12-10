package project.euler


/**
 * Created by satanson on 2014/12/7.
 */
object Problem_1_Multiples_of_3_and_5 {
  def Multiples_of_3_and_5(i:Int):Int={
    (1 to (i-1)).filter(x=>x % 3 == 0 || x % 5 == 0).sum
  }
  def main(args:Array[String]):Unit={
    List(10,1000) foreach {x=>println(Multiples_of_3_and_5(x))}
  }
}
