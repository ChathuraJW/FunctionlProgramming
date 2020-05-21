object Assignment {
  def main(args: Array[String]) = {
   tempConvertor(35);
    volumCalculator(5);
    bookPriceCal(60);
  }

  //Question (1)
  def tempConvertor(cTemp: Int): Unit ={
    var fTemp=cTemp*1.8000+32;
    println(fTemp+" F");
  }
  //Question (2)
  def volumCalculator(rad:Int): Unit ={
    var volum=(3/4.0)*math.Pi*math.pow(rad,3);
    println(volum+" cube unit");
  }
  //Question (3)
  def bookPriceCal(count:Int): Unit ={
    var totPrice=0.00;
    if(count>=0){
      if(count<51){
        totPrice=(count*24.95)*0.6+3;
      }else{
        totPrice=(count*24.95)*0.6+3+(count-50)*0.75;
      }
      println("Total price for "+count+" books(includ shiping): Rs."+totPrice +"(Rounded amount Rs. "+totPrice.round+")");
    }else{
      println("Invalid Book Count");
    }
  }
}