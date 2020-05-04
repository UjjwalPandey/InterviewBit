package scala

object BulbsScala {
  def main(args: Array[String]): Unit = {
    val A = Array(0, 1, 0, 1)
    System.out.println(bulbs(A))
  }

  def bulbs(A: Array[Int]): Int = {
    var count = 0
    for (x <- A) {
      if (x == 0) {
        if(count%2 ==0 ){
          count = count + 1;
        }
      }
      else {
        if(count%2 !=0 ){
          count = count + 1;
        }
      }
    }
    count
  }
}
