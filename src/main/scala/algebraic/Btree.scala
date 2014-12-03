package algebraic

/**
 * Created by satanson on 2014/12/4.
 */


class BTree[T] {}

case class Leaf[T](v: T) extends BTree[T] {}

case class Branch[T](v: T, left: BTree[T], right: BTree[T]) extends BTree[T] {}

class Maybe[+T]

case class Just[+T](x: T) extends Maybe[T]

case object None extends Maybe[Nothing]

object Maybe {
  def Just[T](x: T) = new Just(x)
}

object BTree {
  def preorder[E, T >: BTree[E] <: BTree[E]](root: Maybe[T]): List[E] = root match {
    case None => List()
    case Just(r) => r match {
      case Leaf(x) => List(x)
      case Branch(x, l, r) => List[E](x) ++ preorder[E, T](Maybe.Just(l)) ++ preorder[E, T](Maybe.Just(r))
    }
  }

  def inorder[E, T >: BTree[E] <: BTree[E]](root: Maybe[T]): List[E] = root match {
    case None => List()
    case Just(r) => r match {
      case Leaf(x) => List(x)
      case Branch(x, l, r) => preorder[E, T](Maybe.Just(l)) ++ List[E](x) ++ preorder[E, T](Maybe.Just(r))
    }
  }

  def postorder[E, T >: BTree[E] <: BTree[E]](root: Maybe[T]): List[E] = root match {
    case None => List()
    case Just(r) => r match {
      case Leaf(x) => List(x)
      case Branch(x, l, r) => preorder[E, T](Maybe.Just(l)) ++ preorder[E, T](Maybe.Just(r)) ++ List[E](x)
    }
  }

  def Leaf[T](x: T) = new Leaf(x)

  def Branch[T](x: T, l: BTree[T], r: BTree[T]) = new Branch(x, l, r)

  def main(args: Array[String]): Unit = {
    val root =
      Branch(0,
        Branch(1,
          Branch(2,
            Leaf(3), Branch(4, Leaf(5), Leaf(6))),
          Branch(7, Leaf(8), Leaf(9))),
        Branch(10, Leaf(11), Leaf(12)));
    preorder[Int, BTree[Int]](None) foreach { x => print(x + "\t")}
    println
    inorder[Int, BTree[Int]](None) foreach { x => print(x + "\t")}
    println
    postorder[Int, BTree[Int]](None) foreach { x => print(x + "\t")}
    preorder[Int, BTree[Int]](None) foreach { x => print(x + "\t")}
    println
    inorder[Int, BTree[Int]](Maybe.Just(root)) foreach { x => print(x + "\t")}
    println
    postorder[Int, BTree[Int]](Maybe.Just(root)) foreach { x => print(x + "\t")}
    println
  }
}