package cinema

const val PRICE = 10
const val DISCOUNT_PRICE = 8

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val cols = readln().toInt()
    val totalIncome = if (rows * cols <= 60) {
        rows * cols * PRICE
    } else {
        (rows / 2) * cols * PRICE + (rows - (rows / 2)) * cols * DISCOUNT_PRICE
    }
    println("""
        Total income:
        $$totalIncome
    """.trimIndent())
}