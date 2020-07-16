object fpMod {
  def main(args: Array[String]): Unit = {
    var shiftCount = 0
    println("----Initiating System----")
    print("Input Shift Count:\n>>>")
    shiftCount = scala.io.StdIn.readInt() % 26
    printf("Real Shift Count is: %d\n", shiftCount)
    println("--- Welcome to Caesar cipher ---")
    var key = 0
    do {
      println("Press 1 for Encrypt")
      println("Press 2 for Decrypt")
      print("Press 0 for Exit\n>>>")
      key = scala.io.StdIn.readInt()
      if (key == 1) {
        print("Input String You Need to Encrypt:\n>>>")
        val text = scala.io.StdIn.readLine().toString.toUpperCase
        print("Encrypted>>>")
        Encryption(text, shiftCount)
        println("\n")
      } else if (key == 2) {
        print("Input String You Need to Decrypt:\n>>>")
        val text = scala.io.StdIn.readLine().toString
        print("Decrypted>>>")
        Decryption(text, shiftCount)
        println("\n")
      } else {
        key = 0
      }
    } while (key != 0)
  }

  def Encryption(text: String, sc: Int): Unit = {
    charShift(text, sc)
  }

  def Decryption(text: String, sc: Int): Unit = {
    charShift(text, -sc)
  }

  def charShift(text: String, sc: Int): Unit = {
    val textList = text.split(" ")
    val shiftChar = (c: Char) => if (c > 96 && c < 123 || c > 64 && c < 91) c.toInt + sc % 26 else c
    val shiftFilter = (c: Int) => if (!(c > 64 && c < 91)) c + (if (sc > 0) -26 else +26) else c
    for (i <- textList) {
      for (j <- i.map(shiftChar).toList.map(shiftFilter)) {
        print(j.toChar)
      }
      print(" ")
    }
  }
}
