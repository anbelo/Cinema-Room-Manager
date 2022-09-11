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

    fun menu(): Int {
        println("""
            
            1. Show the seats
            2. Buy a ticket
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

    fun buyTicket() {
        println("""
            
            Enter a row number:
        """.trimIndent())
        val row = readln().toInt()
        println("Enter a seat number in that row:")
        val seat = readln().toInt()

        val ticketPrice = if (rows * seats <= 60) {
            price
        } else {
            if (row <= rows / 2) price else discountPrice
        }
        println("Ticket price: \$$ticketPrice")
        theatre[row - 1][seat - 1] = 'B'
    }

}