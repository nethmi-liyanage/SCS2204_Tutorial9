object Tutorial9_Q3 {

  class Account(val accountNumber: String, var balance: Double) {

    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(s"Deposited $amount. New balance: $balance")
      } else {
        println("Invalid deposit amount.")
      }
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println(s"Withdrew $amount. New balance: $balance")
      } else {
        println("Invalid withdrawal amount.")
      }
    }

    def transfer(amount: Double, toAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        toAccount.balance += amount
        println(s"Transferred $amount to ${toAccount.accountNumber}. Your new balance: $balance")
        println(s"Received $amount from ${accountNumber}. New balance: ${toAccount.balance}")
      } else {
        println("Invalid transfer amount.")
      }
    }

    override def toString: String = s"Account($accountNumber) - Balance: $balance"
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account("123456", 1000.0)
    val account2 = new Account("789012", 500.0)

    println(account1)
    println(account2)
    println()

    account1.deposit(200.0)
    account2.withdraw(100.0)
    println()

    println(account1)
    println(account2)
    println()

    account1.transfer(300.0, account2)
    println()

    println(account1)
    println(account2)
  }
}
