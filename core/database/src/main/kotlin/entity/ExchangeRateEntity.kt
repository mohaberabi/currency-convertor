package entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import model.Currency


@Entity("currency")
data class CurrencyEntity(
    @PrimaryKey
    val code: String,
    val value: Double,
    val lastTime: String
)

fun Currency.toEntity(
    lastTime: String = ""
): CurrencyEntity = CurrencyEntity(
    code = code,
    value = value,
    lastTime = lastTime
)

fun CurrencyEntity.toDomain(
): Currency = Currency(
    code = code,
    value = value,
)