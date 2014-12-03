package adapterview

/**
 * Created by satanson on 2014/12/4.
 */

//import scala.Predef.{_,intWrapper=>_} //WildCard import must be in last position
//intWrapper in scala.Predef(in fact,in LowPriorityImplicits) causes ambiguity
//because there are two implicit function :Int=>Ordered[Int]
//so not import intWrapper
import scala.Predef.{intWrapper=>_,_}

object listcmpare {
//  implicit def list2ordered[T](L:List[T])(implicit t2ordered:T=>Ordered[T]): Ordered[List[T]] ={
//    class ListOrdered(lhs:List[T]) extends Ordered[List[T]]{
//      def compare(rhs:List[T]):Int={
//        if (lhs.isEmpty && !rhs.isEmpty)return 1
//        else if(lhs.isEmpty && rhs.isEmpty)return 0
//        else if(!lhs.isEmpty && rhs.isEmpty)return -1
//        else {
//          if (lhs.head!=rhs.head) {
//            return t2ordered(lhs.head).compare(rhs.head)
//          }else
//            return new ListOrdered(lhs.tail).compare(rhs.tail)
//        }
//      }
//    }
//    new ListOrdered(L)
//  }
//  implicit def list2orderedA[T](L:List[T])(implicit t2ordered:T=>Ordered[T]): Ordered[List[T]] ={
//    class ListOrdered(lhs:List[T]) extends Ordered[List[T]]{
//      def compare(rhs:List[T]):Int={
//        if (lhs.isEmpty && !rhs.isEmpty) 1
//        else if(lhs.isEmpty && rhs.isEmpty) 0
//        else if(!lhs.isEmpty && rhs.isEmpty) -1
//        else {
//          if (lhs.head!=rhs.head) {
//            lhs.head compare rhs.head
//          }else
//            lhs.tail compare rhs.tail
//        }
//      }
//    }
//    new ListOrdered(L)
//  }

  implicit def list2orderedB[T<%Ordered[T]](L:List[T]): Ordered[List[T]] ={
    class ListOrdered(lhs:List[T]) extends Ordered[List[T]]{
      def compare(rhs:List[T]):Int={
        if (lhs.isEmpty && !rhs.isEmpty) 1
        else if(lhs.isEmpty && rhs.isEmpty) 0
        else if(!lhs.isEmpty && rhs.isEmpty) -1
        else {
          if (lhs.head!=rhs.head) {
            lhs.head compare rhs.head
          }else
            lhs.tail compare rhs.tail
        }
      }
    }
    new ListOrdered(L)
  }
  implicit def Int2Ordered(i:Int):Ordered[Int]={
    class IntOrdered(lhs:Int) extends Ordered[Int]{
      def compare(rhs:Int):Int=rhs-lhs
    }
    new IntOrdered(i)
  }
  def main(args:Array[String]):Unit={
    val L1=List(1,2,3)
    val L2=List(1,2,2)
    println(L1<L2)
    println(L1>L2)
    println(L1==L1)
  }
}
