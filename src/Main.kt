fun isValidThreeDigitNumber(input: String): Boolean {
    return input.length == 3 && input.all { it.isDigit() }
}

fun main() {
    println("Программа создает двумерный массив трёхзначных чисел и подсчитывает количество различных цифр.")

    var rows: Int? = null
    var columns: Int? = null

    while (rows == null) {
        println("Введите количество строк массива:")
        val input = readln().trim()

        rows = try {
            val r = input.toInt()
            if (r <= 0) {
                println("Ошибка: количество строк должно быть положительным числом.")
                null
            } else r
        } catch (e: NumberFormatException) {
            println("Ошибка: введите корректное целое число.")
            null
        }
    }

    while (columns == null) {
        println("Введите количество столбцов массива:")
        val input = readln().trim()

        columns = try {
            val c = input.toInt()
            if (c <= 0) {
                println("Ошибка: количество столбцов должно быть положительным числом.")
                null
            } else c
        } catch (e: NumberFormatException) {
            println("Ошибка: введите корректное целое число.")
            null
        }
    }

    val array = Array(rows) { IntArray(columns) }

    println("Введите ${rows * columns} трёхзначных числа для заполнения массива:")
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            while (true) {
                println("Введите трёхзначное число для позиции [$i][$j]:")
                val input = readln().trim()

                if (isValidThreeDigitNumber(input)) {
                    array[i][j] = input.toInt()
                    break
                } else {
                    println("Ошибка: введите корректное трёхзначное число.")
                }
            }
        }
    }

    val digitSet = mutableSetOf<Char>()
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            digitSet.addAll(array[i][j].toString().toList())
        }
    }

    println("Ваш двумерный массив:")
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            print("${array[i][j]} \t")
        }
        println()
    }

    println("В массиве использовано ${digitSet.size} различных цифр.")
}