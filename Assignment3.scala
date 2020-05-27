object Assignment3{
  var i=0.0;
  def main(args: Array[String]): Unit = {
    println(prime(8));
    println(prime(5));
    primePrint(20);
    println();
    println(addNumber(5));
    println(checkEvenOdd(10));
    println(addEven(10));
    println( fibonacci(9));
  }
  //Question 1
  def prime(key:Int):Boolean={
    i=key/2;
    def primeCheck(keyValue:Int):Boolean ={
      if(i==1){
        return true;
      }else if(keyValue%i==0){
        return false;
      }else{
        i=i-1;
        primeCheck(keyValue);
      }
    }
    return primeCheck(key);
  }

  //Question 2
  def primePrint(limitVal:Int): Unit ={
    if(limitVal==1){
      return;
    }else if(limitVal!=2 && limitVal%2==0){
      primePrint(limitVal-1);
    }else if(limitVal!=3 && limitVal%3==0){
      primePrint(limitVal-1);
    }else if(limitVal!=5 && limitVal%5==0){
      primePrint(limitVal-1);
    }else if(limitVal!=7 && limitVal%7==0){
      primePrint(limitVal-1);
    }else{
      print(limitVal+" ");
      primePrint(limitVal-1);
    }
  }

  //Question 3
  def addNumber(limitVal:Int): Int ={
    if(limitVal==1){
      return 1;
    }else{
      return limitVal+addNumber(limitVal-1);
    }
  }

  //Question 4
  def checkEvenOdd(keyVal:Int): String ={
    if(keyVal==0){
      return "Even";
    }else if(keyVal==1){
      return "Odd";
    }else{
      checkEvenOdd(keyVal-2);
    }
  }

  //Question 5
  def addEven(limitKey:Int): Int ={
    if(limitKey==2){
      return 2;
    }else if (limitKey%2==0){
      return limitKey+addEven(limitKey-2);
    }else{
      addEven(limitKey-1);
    }
  }

  //Question 6
  def fibonacci(keyVal: Int): Int ={
    if (keyVal <= 1)
      return keyVal;
    return fibonacci(keyVal-1) + fibonacci(keyVal-2);
  }
}