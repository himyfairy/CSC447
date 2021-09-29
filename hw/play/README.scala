// The src directory is meant for code that will be run with automated tests.
// Put other code in this directory.
//
// sbt requires that all files in src/main/scala must compile.
// That can be a pain when you want to experiment.
//
// In the scala console, you can load this file by typing
//    scala> :load play/README.scala
//    scala> length1(xs)
//

/*
val xs = List(11, 21, 31)
val xss = List(List(11, 21), List(), List(31), List(41, 51, 61))

def log[X](prefix: String, d: Int = 0)(computeResult: => X) =
  val indent = "  " * d
  println(s"${indent}${prefix}")
  val result = computeResult
  println(s"${indent}${prefix} : ${result}")
  result

*/

// This is the length function from the first lecture on scala, with logging
// This version is right recursive, computing the operator with the RESULT of
// recursive call.

/*
def length1[X](xs: List[X]): Int =
log(s"length($xs)") {
  xs match
    case Nil     => 0
    case _ :: ys => 1 + length1(ys)
}

*/

// Here is a version that recurs into the parameter instead of the result. This
// version is left recursive, AKA tail recursive, computing the operator into a
// PARAMETER of the recursive call.
//
// This version also uses the optional parameter d to indicate the call depth.

/*
def length2[X](xs: List[X], accumulator: Int = 0, d: Int = 0): Int =
  log(s"length($xs, $accumulator)", d) {
    xs match
      case Nil     => accumulator
      case _ :: ys => length2(ys, 1 + accumulator, d + 1)
  }

  */

// Try this:
//    scala> :load play/README.scala
//    scala> length1(xs)
//    scala> length2(xs)
// Try changing length1 to use a depth parameter for indentation.

// @main def m() = 
//   println("hello world")

// @main def m(args: String*) = 
//   println("hello, " + args(0) + "!")

// @main def m(name: String) = 
//   println("hello, " + name + "!")

// @main def m(name: String*) = 
//   var i = 0
//   while i < name.length do
//     println(name(i))
//     i += 1

// @main def m(name: String*) = 
//   var i = 0
//   while i < name.length do
//     if i!= 0 then
//       print(" ")
//     print(name(i))
//     i += 1
//   println()

// @main def m(args: String*) = 
//   args.foreach((a: String) => println(a))

// @main def m(args: String*) = 
//   args.foreach(println)

// @main def m(args: String*) = 
//   for a <- args do
//     println(a)

// var big = new java.math.BigInteger("123")

// @main def fun() = 
//   val greetStr = new Array[String](3)
//   greetStr(0) = "qilu"
//   greetStr(1) = "is"
//   greetStr(2) = "p1"
//   for i <- 0 to 2 do
//     println(greetStr(i))

//   for a <- greetStr do
//     println(a)

//   greetStr.foreach(str => println(str))

// @main def fun() = 
//   val greetStr = new Array[String](3)
//   greetStr.update(0, "qilu")
//   greetStr.update(1, "is")
//   greetStr.update(2, "p1")
//   for i <- 0.to(2) do
//     println(greetStr(i))

// @main def fun() = 
//   val l1 = List(1, 2)
//   val l2 = List(3, 4)
//   val l3 = l1 ::: l2
//   val l4 = List(2, 3)
//   val l5 = 1 :: l4
//   val l6 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
//   println("l1 is " + l1)
//   println("l2 is " + l2)
//   println("l3 is " + l3)
//   println("l4 is " + l4)
//   println("l5 is " + l5)
//   println("l6 is " + l6)

import java.util.NoSuchElementException
import scala.collection.mutable
import scala.collection.immutable
import scala.compiletime.ops.int
import scala.language.postfixOps
import scala.io.StdIn.readLine

object test66:

  def log[X](prefix: String)(computeResult: => X) =
    println(prefix)
    val result = computeResult
    println(s"prefix $prefix : rs $result")
    result

  def fact(n: Int): Int =
    if n <= 1 then 1
    else n * fact(n - 1)

  def factLog(n: Int): Int =
    log(s"fact($n)") {
      if n <= 1 then 1
      else n * factLog(n - 1)
    }

  def fib(n: Int): Int =
  // TODO: Provide definition here.
    if n < 0 then
      throw UnsupportedOperationException()
    if n == 0 || n == 1 then n
    else fib(n-1) + fib(n-2)

  def sum(xs: List[Int]) : Int =
    if xs.isEmpty then throw UnsupportedOperationException()
    if xs.length == 1 then xs.head
    else xs.head + sum(xs.tail)
  
  def max(xs: List[Int]): Int =
    if xs.isEmpty then throw java.util.NoSuchElementException()
    if xs.length == 1 then xs.head
    else (xs.head max max(xs.tail))

  def otpu(start: Int, end: Int): List[Int] =
    if start < end then Nil
    else start :: otpu(start-1, end)

  def formatArgs(args: List[String]) = args.mkString("\n")

  def sumTailAux(xs: List[Int], accumulator: Int): Int =
    xs match
      case Nil     => accumulator
      case y :: ys => sumTailAux(ys, accumulator + y)
  
  def sumTail(xs: List[Int]): Int =
    if xs.isEmpty then throw UnsupportedOperationException()
    else sumTailAux(xs.tail, xs.head)

  def maxTailAux(xs: List[Int], accumulator: Int): Int =
    if xs.length == 1 then (accumulator max xs.head)
    else (accumulator max maxTailAux(xs.tail, xs.head))

  def maxTail(xs: List[Int]): Int =
    xs match
      case Nil     => throw NoSuchElementException()
      case y :: ys => maxTailAux(ys, y)

  def ***() = 
    println("---")

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toArray

  def gcdLoop(x: Long, y: Long): Long =
    var a = x
    var b = y
    while a != 0 do
      val temp = a
      a = b % a
      b = temp
      println(s"---a:$a b:$b")
    b
  
  def printMultiTable() =
    var i = 1
    // only i in scope here
    while i <= 10 do
      var j = 1
      // both i and j in scope here
      while j <= 10 do
        val prod = (i * j).toString
        // i, j, and prod in scope here
        var k = prod.length
        // i, j, prod, and k in scope here
        while k < 4 do
          print(" ")
          k += 1
        print(prod)
        j += 1
        // i and j still in scope; prod and k out of scope
      println()
      i += 1
    // i still in scope; j, prod, and k out of scope

  def twice(op: Double => Double, x: Double) = op(op(x))

  def isort(xs: List[Int]): List[Int] =
    if xs.isEmpty then Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if xs.isEmpty || x <= xs.head then x :: xs
    else xs.head :: insert(x, xs.tail)

  // def append[T](xs: List[T], ys: List[T]): List[T] =
  //   xs match
  //   case List() => ys
  //   case x :: xs1 => x :: append(xs1, ys)
    // case x :: xs1 => x :: xs1 :: ys


  def map[A, B](xs: List[A], f: A => B): List[B] =
    xs match
      case List() => Nil
      case x::xs1 => f(xs.head) :: map(xs.tail, f)
  
  def myfilter[A](xs: List[A], f: A => Boolean): List[A] =
    xs match
      case List() => Nil
      case x::xs1 => 
        if f(xs.head) then xs.head :: myfilter(xs.tail, f)
        else myfilter(xs.tail, f)

  def append[A](xs: List[A], ys: List[A]): List[A] =
    xs match
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)

  // def myappend[A](xs: List[A], ys: List[A]): List[A] =
  //   ys match
  //     case List() => xs
  //     case y::ys1 =>
  //       val newlist[A] = xs:::ys.head
  //       myappend(newlist, ys.tail)

  def flatten[A](xss: List[List[A]]): List[A] =
    xss match
      case List() => Nil
      case x :: xs1 => append(x, flatten(xs1))

  def mysum(xs: List[Int]): Int = xs.foldLeft(1)(_ + _)

  def foldLeft[A, B](xs: List[A], e: B, f: (B, A) => B): B =
    xs match 
      case List() => e
      case x :: xs1 => foldLeft(xs1, f(e, x), f)
  
  def foldRight[A, B](xs: List[A], e: B, f: (A, B) => B): B =
    xs match 
      case List() => e
      case x :: xs1 => f(x, foldRight(xs1, e, f))

  def fkh(s : String, n : Int) : String = s + "[" + n + "]"

  def fkh2(n : Int, s : String) : String = s + "[" + n + "]"

  def joinTerminateRight(xs: List[String], term: String): String =
    foldRight(xs, "", (_+term+_))

  def joinTerminateLeft(xs: List[String], term: String): String =
    foldLeft(xs, "", (_+_+term))

  // def plusTerm(a: String, term: String) = a + term
  def plusTerm(a: String, t: String) : String = a + t

  def testFun(a: String, b: String): String = a + b + ";"


  def firstNumGreaterThan(a: Int, xs: List[Int]): Int =
    xs match 
      case List() => throw java.util.NoSuchElementException()
      case x :: xs1 => 
        if x >= a then x
        else firstNumGreaterThan(a, xs1)

  // def firstIndexNumGreaterThan(a: Int, xs: List[Int]): Int =
  //   xs.indexOf(firstNumGreaterThan(a, xs))

  def firstIndexNumGreaterThan(a: Int, xs: List[Int]): Int =
    xs match 
      case List() => throw java.util.NoSuchElementException()
      case x :: xs1 => 
        if x >= a then xs.indexOf(x)
        else firstIndexNumGreaterThan(a, xs1)

  // def hahahaha(xs: List[String]): List[String] = xs.foldLeft("")(_ + _)

  @main def mmm() = 
  //List(a, b, c).foldLeft(z)(op) equals op(op(op(z, a), b), c)
    println("-------")


    // val xs = List("a", "b", "c", "d")
    // val a = foldLeft(xs, "", testFun)
    // val a = joinTerminateLeft(xs, ";")
    // val a = joinTerminateRight(xs, ";")
    // val a = hahahaha(xs)

    // val b = xs.foldLeft("")(_+_+";")
    // println(s"b:$b")

    val xs = List(1, 2, 3, 4, 5, 3)
    val a = firstIndexNumGreaterThan(2, xs)
    // val a = firstNumGreaterThan(2, xs)
    // val a = foldLeft(xs, "@", fkh)
    // val ys = List(6, 7, 8)
    // val a = map(xs, (x) => x+1)
    // val a = myfilter(xs, _ > 2)
    // val a = append(xs, ys)
    // val a = xs.head :: ys
    // val a = List(xs, ys)
    // val b = flatten(a)
    // println(a)
    // println(b)
    // val a = mysum(ys)
    // val a = foldLeft(xs, "@", fangkuohao)
    // val a = xs.init
    // val a = foldRight(xs, "@", fangkuohao2)
    // val a = foldRight(xs.reverse, "@", plusTerm)
    // val a = joinTerminateRight(xs, ";")
    // val a = foldLeft(xs, "@", plusTerm)
    println(a)



    // val a = List.range(1, 5).flatMap(
    //           i => List.range(1, i).map(
    //             j => (i, j)
    //           )
    //         )
    // println(a)
    // val multiplication = List.tabulate(5,5)(_ * _)
    // println(multiplication)

    // val a = (List(10, 20).zip(List(3, 4, 5)))
    // val a = (List("abc", "de").lazyZip(List(3, 2))).forall(_.length == _)
    // println(a)


    // val l1 = List(1, 2, 3)
    // val l2 = List(4, 5, 6)
    // val l1 = List("audi", "bmw", "mercedes")
    // val l2 = List("honda", "toyota", "mazada")
    // val l3 = l1::l2::Nil
    // println(l3)
    // val l4 = l3.flatten
    // println(l4)

    // val xs = List(1,2,3,4,5)
    // val xs = List("audi", "bmw", "mercedes", "honda", "toyota")
    // println(xs.reverse.init)
    // println(xs.tail.reverse)
    // println(xs.splitAt(3))
    // println(xs.take(3))
    // println(xs.drop(2))
    // println("head: " + xs.head)
    // println("tail: " + xs.tail)
    // println("init: " + xs.init)
    // println("last: " + xs.last)
    // println(xs.apply(1))
    // println(xs.indices)
    // println(xs.indices.zip(xs))
    // println(xs.zipWithIndex.unzip.last)
    // println(xs)
    // println(xs.toString)
    // println(xs.mkString)

    // val abcde = List('a', 'b', 'c', 'd', 'e')
    // val abcde = List("a","b","c","d","e")
    // val zipped = abcde.zip(List(1, 2, 3))
    // println(zipped)

    // val list = List(8, 6)
    // val sorted = isort(list)
    // println(sorted)
    
    // val emptyList = List(1)
    // println(emptyList.head)
    // println(emptyList.tail)

    // println(twice(_ + 1, 10))

    // printMultiTable()

    // val list = List(1,2,3,4,5)
    // println(list.exists(_ < 2))
    // list.foreach(x => 
    //   println(x)
    // )
    // list.foreach((x: Int) => 
    //   println(x)
    // )
    // val list2 = list.filter(x =>
    //   x > 3
    // )
    // val list2 = list.filter(
    //   _ > 3
    // )
    // println(list2)
    
    // val re = gcdLoop(17, 8)
    // println(re)

    // var line = scala.io.StdIn.readLine()

    // var array = List(2, 5, 1, 2, 3)
    // val a0 = array(0)
    // println(a0)
    // a0 match
    //   case 1 =>
    //     println("is 111")
    //   case 2 =>
    //     println("is 222")
    //   case 3 =>
    //     println("is 333")
    //   case _ =>
    //     println("is ---")
    
    
    // val str = 
    // a0 match
    //   case 1 => "one"
    //   case 2 => "two"
    //   case 3 => "three"
    //   case _ => "default"
    // println(s"str: $str")



    // while (line = scala.io.StdIn.readLine()) != "" do
    //   println(s"Read: $line")

    // while
    //   val line = readLine()
    //   println(s"Read: $line")
    //   line != "!"
    // do ()

    // val result = sumTail(List.empty)
    // val result = maxTail(List.empty)
    // println(s"result: $result")

    // val list = List(100, 32, 345, 774, 105)
    // val b = max(list)
    // println(s"b: $b")

    // val countList = otpu(5, -3)
    // println(countList)

    // println("""|welcome to chicago 3000.
    //            |type "help" for help.""".stripMargin)
    // println(f"${math.Pi}%.5f")

    // val aa = f"$pi is approximately ${math.Pi}%.8f."
    // println(aa)

    // var str = "\\\\'"
    // var str = raw"\\\\'"
    // println(str)


    // val num = factLog(3)
    // println("num is " + num)

    // val factTest: Int = factLog(5)
    // println("factTest is " + factTest)
    // val factTest: List[Int] =
    //   List(fact(1), fact(2), fact(3), fact(4), fact(5))
    // println("factTest : " + factTest)
    // val n = 6
    // val result = fib(n)
    // println("num : " + n + " result : " + result)

    // val ll = List.empty
    // val result = sum(ll)
    // println("result : " + result)
    
    // val pair = (44, "Lewis")
    // val num = pair(0)
    // val name = pair(1)
    // println(s"num: $num - name: $name")

    // pair(3) = 33
    // pair(4) = "Max"
    // val num2 = pair(3)
    // val name2 = pair(4)
    // println(s"num2: $num2 - name2: $name2")

    // var jet = Set("Boeing", "Airbus")
    // jet += "CAAC"
    // println(s"jet: $jet")

    // var mutSet = mutable.Set("a", "b")
    // mutSet += "c"
    
    // scala    swift
    // array    mutablearray
    // list     immutablearray
    // turple   turple
    // set      set
    // map      dictionary

    // val map1 = mutable.Map.empty[Int, String]
    // map1 += (1 -> "a")
    // map1.+=(2 -> "b")
    // map1.update(3, "c")
    // println(s"map1: $map1")
    // println("map1(2): " + map1(2))

    // val map2 = Map(
    //   "a" -> 1,
    //   "b" -> 2,
    //   "c" -> 3
    // )
    // println(s"map2: $map2")
    // println("map2(\"c\"): " + map2("c"))

  //  val list = List("hello", "qilu", "Lewis")
  //  val list2 = formatArgs(list)
  //  println(list2)

  //  val brand = List("audi", "bmw", "mercedes")
  //  val newStr = brand.map(element => element + " car")
  //  println(s"newStr: $newStr")

  //  val str2 = 
  //    for ele <- brand yield
  //      ele + " car"
  //  println(s"str2: $str2")

  //  val ques = Vector("Who", "What", "When", "Where", "Why")
  //  val usingMap = ques.map(e => e.toLowerCase + "?")
  //  val usingYield = 
  //    for e <- ques yield
  //      e.toLowerCase + "?"
  //  println(s"usingMap: $usingMap")
  //  println(s"usingYield: $usingYield")

  //  val startsW = ques.find(q => q.startsWith("W"))
  //  val startsH = ques.find(q => q.startsWith("H"))
  //  val endso = ques.find(q => q.endsWith("o"))
  //  val hasLen4 = ques.find(q => q.length == 4)
  //  val hasLen5 = ques.find(q => q.length == 5)

  //  println(s"startsW: $startsW")
  //  println(s"startsH: $startsH")
  //  println(s"endso: $endso")
  //  println(s"hasLen4: $hasLen4")
  //  println(s"hasLen5: $hasLen5")

  //  val newstr = startsW.map(s => s.toUpperCase)
  //  println("newstr: " + newstr)

  //  val newstr2 = startsH.map(s => s.toUpperCase)
  //  println("newstr2: " + newstr2)
    // val a = -2.0
    // val a = (2.0).unary_-
    // println(a)

    // val str1 = "Hello World!"
    // val str2 = str1 toLowerCase
    // println(s"str1: $str1")
    // println(s"str2: $str2")
    // println(1==1.0f)
    // for i <- 1 until 10 do
    //   println(i)
    // val filesHere = (new java.io.File(".")).listFiles
    // for file <- filesHere do
    //   println(file)

    // for file <- filesHere
    //   if file.isFile
    //   if file.getName.endsWith(".scala") do
    //     println(file)
    // val forLineLengths =
    //   for
    //     file <- filesHere
    //     if file.getName.endsWith(".scala")
    //     line <- fileLines(file)
    //     trimmed = line.trim
    //     if trimmed.matches(".*for.*")
    //   yield trimmed.length
    // println(s"forLineLengths : $forLineLengths")

    // val a = {var x=1; x = x + 1; x} * {var x = 1; x = x + 1; x}
    // println(a)
    // val a = List(List(1,2,3),List(4,5,6))
    // val a = (1::2::3::Nil).reverse
    // val a = (1::2::3::Nil) ::: (4::5::6::Nil)
    // println(a)

  