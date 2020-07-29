object Assignment5 {
  def main(args: Array[String]): Unit = {

    //Question 1
        var x = new RationalNumber(3, 4)
        var y = new RationalNumber(5, 8)
        var z = new RationalNumber(2, 7)

    //Question 2
        print("x-y-z="+x.sub(y.add(z)))

    //Question 3
    var a = new Account("121213", 100001, 6000)
    var b = new Account("121214", 100002, 5000)
    var c = new Account("121215", 100003, -1000)

        a.transfer(b,1000)
        println(a)
        println(b)

    //Question 4
    var bank = new Bank(Iterator(a, b, c))
    //Question 4.1 ==>
//     bank.overDraft
    //Question 4.2 ==>
//     println("Total Account Balance: "+bank.allSUM)
    //Question 4.3 ==>
//     println("Total Account Balance (After): "+bank.finalBalance)

  }

  class RationalNumber(p: Int, q: Int) {
    var numerator: Int = p
    var denominator: Int = q

    def add(r: RationalNumber): RationalNumber = {
      var numerator = (this.numerator * r.denominator) + (r.numerator * this.denominator)
      var denominator = this.denominator * r.denominator
      val divider = math.abs(gcd(numerator, denominator))
      if (numerator * denominator < 0)
        if (denominator < 0) {
          denominator = math.abs(denominator)
          numerator = numerator * (-1)
        }
        else if (denominator < 0) {
          numerator = math.abs(numerator)
          denominator = math.abs(denominator)
        }
      new RationalNumber(numerator / divider, denominator / divider)
    }

    def neg(): Unit = {
      this.numerator = this.numerator * (-1)
    }

    def sub(r: RationalNumber): RationalNumber = {
      r.neg
      this.add(r)
    }

    override def toString: String = numerator + "/" + denominator
  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  class Account(nic: String, acn: Int, balance: Double) {
    var NIC: String = nic
    var acNumber: Int = acn
    var accountBalance: Double = balance

    def transfer(ref: Account, amount: Int): Unit = {
      if (this.balance >= amount) {
        ref.accountBalance = ref.accountBalance + amount
        this.accountBalance = this.accountBalance - amount
        println("Fund transfer successful...")
      } else {
        println("No sufficient amount to transfer...")
      }
    }

    override def toString: String = "Acc Number: " + this.acNumber + " Account Balance is: " + this.accountBalance
  }

  class Bank(initAccountList: Iterator[Account]) {
    var accountList: Iterator[Account] = initAccountList

    def overDraft(): Unit = {
      while (accountList.hasNext) {
        val temp = accountList.next()
        if (temp.accountBalance < 0)
          println(temp)
      }
    }

    def allSUM(): Double = {
      var tot = 0.0
      val tList = accountList
      while (tList.hasNext) {
        val temp = tList.next()
        tot = tot + temp.accountBalance
      }
      tot
    }

    def finalBalance(): Double = {
      val tList = accountList
      var tot = 0.0
      while (tList.hasNext) {
        val temp = tList.next()
        if (temp.accountBalance < 0) {
          temp.accountBalance = temp.accountBalance - temp.accountBalance * 0.001
        } else {
          temp.accountBalance = temp.accountBalance + temp.accountBalance * 0.0005
        }
        tot = tot + temp.accountBalance
      }
      tot
    }

  }

}
