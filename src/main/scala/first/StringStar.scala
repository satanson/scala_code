package first

/**
 * Created by satanson on 2014/12/13.
 */
object StringStar {
  def variadic(args:String*):Unit={
    args foreach println _
  }
  //just like * in python: pack/unpack
  def main(args:Array[String]):Unit={
    variadic("foo","bar","foobar")
    variadic(List("foo","bar","foobar").toArray:_*)
  }
}
