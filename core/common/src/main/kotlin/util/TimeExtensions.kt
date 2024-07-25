package util

import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object DateTimePatterns {
    const val DD_MMMM_YYYY = "dd MMMM yyyy"
}

fun LocalDateTime.toIso(): String = format(
    DateTimeFormatter.ISO_DATE_TIME
)


fun String.formatAsDateTime(
    patter: String = DateTimePatterns.DD_MMMM_YYYY,
): String {
    val zonedDateTime = ZonedDateTime.parse(this)
    val formatter = DateTimeFormatter.ofPattern(patter)
    val converted = zonedDateTime.format(formatter)
    return converted
}