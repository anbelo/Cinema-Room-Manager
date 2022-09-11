package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val cinema = Cinema(rows, seats)
    do {
        when (cinema.menu()) {
            1 -> cinema.showSeats()
            2 -> cinema.buyTicket()
            3 -> cinema.statistics()
            0 -> return
            else -> println("Unknown action")
        }
    } while (true)
}

class Cinema(private val rows: Int, private val seats: Int) {

    private val price = 10
    private val discountPrice = 8
    private val minSeats = 1
    private val theatre = List(rows) { MutableList(seats) { 'S' } }
    private var purchasedTicketCount = 0
    private var currentIncome = 0
    private val totalIncome = if (rows * seats <= 60) {
        rows * seats * price
    } else {
        (rows / 2) * seats * price + (rows - (rows / 2)) * seats * discountPrice
    }
    private val discountedRow =  if (rows * seats <= 60) rows + 1 else rows / 2 + 1

    fun menu(): Int {
        println("""
            
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent())
        return readln().toInt()
    }

    fun showSeats() {
        println("""
            
            Cinema:
        """.trimIndent())
        println((minSeats..seats).joinToString(" ", "  "))
        for (rowIndex in theatre.indices) {
            print("${rowIndex + 1} ")
            for (seat in theatre[rowIndex]) {
                print("$seat ")
            }
            println()
        }
    }

    private fun getRowAndSeat(): Pair<Int, Int> {
        do {
            println("""
            
                Enter a row number:
            """.trimIndent()
            )
            val row = readln().toInt()
            println("Enter a seat number in that row:")
            val seat = readln().toInt()

            if (row < 1 || rows < row || seat < 1 || seats < seat) {
                println("""
                    
                    Wrong input!
                """.trimIndent())
                continue
            }

            if (theatre[row - 1][seat - 1] == 'B') {
                println("""
            
                   That ticket has already been purchased!
                """.trimIndent()
                )
                continue
            }
            return Pair(row, seat)
        } while (true)
    }

    fun buyTicket() {
        val (row, seat) = getRowAndSeat()
        val ticketPrice = if (row in 1 until discountedRow) price else discountPrice

        println("Ticket price: \$$ticketPrice")
        theatre[row - 1][seat - 1] = 'B'
        currentIncome += ticketPrice
        purchasedTicketCount++
    }

    fun statistics() {
        val percentage = purchasedTicketCount * 100.toFloat() / (rows * seats)
        println("""
            
            Number of purchased tickets: $purchasedTicketCount
            Percentage: ${"%.2f".format(percentage)}%
            Current income: $$currentIncome
            Total income: $$totalIncome
        """.trimIndent())
    }

}