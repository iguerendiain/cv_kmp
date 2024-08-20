package nacholab.iguerendiain.cv.tools

import io.ktor.util.date.GMTDate

fun Long.toMonth(months: Array<String>): String{
    val date = GMTDate(this*1000)
    return months.getOrNull(date.month.ordinal)?:date.month.name.lowercase()
}

fun Long.toYear(): String{
    val date = GMTDate(this*1000)
    return date.year.toString()
}