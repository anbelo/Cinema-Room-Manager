package cinema

const val MIN_ROWS = 1
const val MIN_SEATS = 1

const val PRICE = 10
const val DISCOUNT_PRICE = 8

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    printCinema(rows, seats)

    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()

    val ticketPrice = if (rows * seats <= 60) {
        PRICE
    } else {
        if (row <= rows / 2) PRICE else DISCOUNT_PRICE
    }

    println()
    println("Ticket price: \$$ticketPrice")
    printCinema(rows, seats, listOf(Pair(row, seat)))
}

fun printCinema(rows: Int, seats: Int, booked: List<Pair<Int, Int>> = emptyList()) {
    println()
    println("Cinema:")
    println((MIN_SEATS..seats).joinToString(" ", "  "))
    for (row in MIN_ROWS..rows) {
        print("$row ")
        for (seat in MIN_SEATS until seats) {
            print(if (Pair(row, seat) in booked) "B " else "S ")
        }
        println("S")
    }
    println()
}