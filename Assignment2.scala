object Assignment2{
  def main(args: Array[String]): Unit = {
    salaryCal(40,20);
    profitCal(15,120);
  }
  //Question 1
  def salaryCal(normal:Int,ot:Int):Unit={
    //unit tax for normal hour
    var nt=40*(10.0/100.0);
    //unit tax for ot hour
    var ott=20*(10.0/100.0);

    var ntPay=normal*150*(100-nt)/100;
    var otPay=ott*75*(100-ott)/100;
    var totPay=ntPay+otPay;
    println("Weekly pay amount: Rs."+totPay);
  }

  def profitCal(TP:Int,AC:Int): Unit ={
    var profitAVG=(TP*AC)-(AC*3)-500;
    var profitHigh=(AC-20)*(TP+5-3)-500;
    var profitLow=(AC+20)*(TP-5-3)-500;
    println("TPAVG("+TP+")="+profitAVG+" "+ (if((profitAVG>profitHigh) && (profitAVG>profitLow))"✔" else "❌"));
    println("TPHIGH("+(TP+5)+")="+profitHigh+" "+(if((profitHigh>profitAVG) && (profitHigh>profitLow))"✔" else "❌"));
    println("TPLOW("+(TP-5)+")="+profitLow+" "+(if((profitLow>profitAVG) && (profitLow>profitHigh))"✔" else "❌"));
  }
}