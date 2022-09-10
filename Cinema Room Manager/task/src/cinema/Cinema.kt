package cinema

const val ROW_MIN = 1
const val ROW_MAX = 7
const val COL_MIN = 1
const val COL_MAX = 8

fun main() {
    println("Cinema:")
    println((COL_MIN..COL_MAX).joinToString(" ", "  "))
    for (row in ROW_MIN..ROW_MAX) {
        print("$row ")
        for (col in COL_MIN until COL_MAX) {
            print("S ")
        }
        println("S")
    }
}