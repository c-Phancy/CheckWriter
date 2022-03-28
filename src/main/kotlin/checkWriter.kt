
/************************************************************
 *  Name:         Christina Phan
 *  Date:         2022/01/23
 *  Assignment:   CheckWriter
 *  Class Number: CIS 283
 *  Description:  Create a program that has an extended Double class that returns a string representation of a given Double
 ************************************************************/

fun Double.toCheckString(): String {
    val words = hashMapOf(
        1 to "One",
        2 to "Two",
        3 to "Three",
        4 to "Four",
        5 to "Five",
        6 to "Six",
        7 to "Seven",
        8 to "Eight",
        9 to "Nine",
        10 to "Ten",
        11 to "Eleven",
        12 to "Twelve",
        13 to "Thirteen",
        14 to "Fourteen",
        15 to "Fifteen",
        16 to "Sixteen",
        17 to "Seventeen",
        18 to "Eighteen",
        19 to "Nineteen",
        20 to "Twenty",
        30 to "Thirty",
        40 to "Forty",
        50 to "Fifty",
        60 to "Sixty",
        70 to "Seventy",
        80 to "Eighty",
        90 to "Ninety"
    )
    val placeValue = hashMapOf(
        0 to "",
        1 to "Thousand",
        2 to "Million",
        3 to "Billion",
        4 to "Trillion"
    )
    // starts getting wonky in the quadrillions+ -> supports up to the hundred trillions due to nature of Long
    val dollars = this.toLong()
    val cents = (java.text.DecimalFormat(".00").format(this - dollars)).toString().substringAfter(".").toLong()
    fun convertNumber(number: Long): String {
        var retStr = ""
        val chunks = if (number > 99) {
            number.toString().reversed().chunked(3).map { it.reversed().toInt() }
        } else listOf(number.toInt())
        chunks.forEachIndexed { index, it ->
            var stringChunk = ""
            if (it != 0) {
                val underHundred = it % 100
                val hundreds = it - underHundred
                if (hundreds != 0) {
                    stringChunk += " ${words[hundreds / 100]} Hundred"
                }
                if (underHundred != 0) {
                    stringChunk += if (words.containsKey(underHundred)) {
                        " ${words[underHundred]}"
                    } else {
                        val ones = underHundred % 10
                        " ${words[underHundred - ones]} ${words[ones]}"
                    }
                }
                if (index > 0) {
                    stringChunk += " ${placeValue[index]}"
                    if (chunks.filterIndexed { i, _ -> i < index }.any { it != 0 }) stringChunk += ","
                }
            }
            retStr = stringChunk.plus(retStr)
        }
        return retStr
    }
    fun plural(number: Long): String {
        return if (number == 1L) "" else "s"
    }
    val dollarString = if (dollars != 0L) {
        convertNumber(dollars).trim()
    } else "Zero"
    val centString = if (cents != 0L) {
        convertNumber(cents).trim()
    } else "Zero"
    return "$dollarString dollar${plural(dollars)} and $centString cent${plural(cents)}"
}

//fun main() {
//    println(101002347089123.5.toCheckString())
//    println((10000010000000.0).toCheckString()) // checks for correct commas
//}