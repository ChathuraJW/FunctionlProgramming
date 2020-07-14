object Assignment4{
  var shiftCount=10;
  def main(args: Array[String]): Unit = {
    println("----Initiating System----");
    print("Input Shift Count:\n>>>");
    shiftCount=scala.io.StdIn.readInt()%26;
    printf("Real Shift Count is: %d\n",shiftCount);
    println("--- Welcome to Caesar cipher ---");
    var key=0;
    do{
      println("Press 1 for Encrypt");
      println("Press 2 for Decrypt");
      print("Press 0 for Exit\n>>>");
      key=scala.io.StdIn.readInt();
      if(key==1){
        print("Input String You Need to Encrypt:\n>>>");
        var text=scala.io.StdIn.readLine().toString;
        print("Encrypted>>>")
        Encryption(text, shiftCount);
        println("\n");
      }else if(key==2){
        print("Input String You Need to Decrypt:\n>>>");
        var text=scala.io.StdIn.readLine().toString;
        print("Decrypted>>>")
        Decryption(text, shiftCount);
        println("\n");
      }else{
        key=0;
      }
    }while(key!=0);
  }

  def Encryption(text: String,shiftCount:Int):Unit={
    for(x<-text){
      print(charShift(x,shiftCount).toChar);
    }
  }

  def Decryption(text: String,shiftCount:Int):Unit={
    for(x<-text){
      print(charShift(x,shiftCount*(-1)).toChar);
    }
  }

  def charShift(letter:Char,shiftCount:Int):Int={
    var assciVal=letter.toInt;
    if((assciVal>96 && assciVal<123) || (assciVal>64 && assciVal<91)){
      assciVal=assciVal+shiftCount;
      if(!((assciVal>96 && assciVal<123) || (assciVal>64 && assciVal<91))){
        assciVal=assciVal+ (if(shiftCount>0)-26 else +26);
      }
    }
    assciVal
  }
}