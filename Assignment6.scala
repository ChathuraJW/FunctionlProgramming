object Assignment6 {
  def main(args: Array[String]): Unit = {
    val p1 = Point(2, 3)
    val p2 = Point(2, 4)
    println(p1 + p2)
    println(p1.move(3, 3))
    println(p1.distance(p2))
    println(p1.invert())
  }

  case class Point(a: Int, b: Int) {
    var x: Int = a
    var y: Int = b

    def +(p2: Point): Point = {
      Point(this.x + p2.x, this.y + p2.y)
    }

    def move(dx: Int, dy: Int): Point = {
      Point(this.x + dx, this.y + dy)
    }

    def distance(p2: Point): Double = {
      val d = math.pow((this.x - p2.x), 2) + math.pow((this.y - p2.y), 2)
      math.sqrt(d)
    }

    def invert(): Point = {
      Point(this.y, this.x)
    }

  }

}