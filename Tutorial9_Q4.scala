object Tutorial9_Q4 {
  case class Account(accountNumber: Int, balance: Double)
  case class Bank(accounts: List[Account])

  def getNegativeBalances(bank: Bank): List[Account] = {
    bank.accounts.filter(_.balance < 0)
  }

  def calculateTotalBalance(bank: Bank): Double = {
    bank.accounts.map(_.balance).sum
  }

  def calculateFinalBalances(bank: Bank): List[Account] = {
    bank.accounts.map { account =>
      val interestRate = if (account.balance >= 0) 0.05 else 0.1
      val interestAmount = account.balance * interestRate
      Account(account.accountNumber, account.balance + interestAmount)
    }
  }

  def main(args: Array[String]): Unit = {
    val accounts = List(
      Account(1, 1000),
      Account(2, -500),
      Account(3, 200),
      Account(4, -100),
      Account(5, 1500)
    )

    val bank = Bank(accounts)

    val negativeBalances = getNegativeBalances(bank)
    println("Accounts with negative balances:")
    negativeBalances.foreach(account => println(s"Account ${account.accountNumber}: ${account.balance}"))

    val totalBalance = calculateTotalBalance(bank)
    println(s"Total balance of all accounts: $totalBalance")

    val finalBalances = calculateFinalBalances(bank)
    println("Final balances after applying interest:")
    finalBalances.foreach(account => println(s"Account ${account.accountNumber}: ${account.balance}"))
  }
}
