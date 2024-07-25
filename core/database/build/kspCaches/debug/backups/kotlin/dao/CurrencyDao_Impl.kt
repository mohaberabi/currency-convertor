package dao

import android.database.Cursor
import androidx.room.CoroutinesRoom
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.EntityInsertionAdapter
import androidx.room.EntityUpsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.query
import androidx.sqlite.db.SupportSQLiteStatement
import entity.CurrencyEntity
import java.lang.Class
import java.util.ArrayList
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class CurrencyDao_Impl(
  __db: RoomDatabase,
) : CurrencyDao {
  private val __db: RoomDatabase

  private val __upsertionAdapterOfCurrencyEntity: EntityUpsertionAdapter<CurrencyEntity>
  init {
    this.__db = __db
    this.__upsertionAdapterOfCurrencyEntity = EntityUpsertionAdapter<CurrencyEntity>(object :
        EntityInsertionAdapter<CurrencyEntity>(__db) {
      protected override fun createQuery(): String =
          "INSERT INTO `currency` (`code`,`value`,`lastTime`) VALUES (?,?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: CurrencyEntity) {
        statement.bindString(1, entity.code)
        statement.bindDouble(2, entity.value)
        statement.bindString(3, entity.lastTime)
      }
    }, object : EntityDeletionOrUpdateAdapter<CurrencyEntity>(__db) {
      protected override fun createQuery(): String =
          "UPDATE `currency` SET `code` = ?,`value` = ?,`lastTime` = ? WHERE `code` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: CurrencyEntity) {
        statement.bindString(1, entity.code)
        statement.bindDouble(2, entity.value)
        statement.bindString(3, entity.lastTime)
        statement.bindString(4, entity.code)
      }
    })
  }

  public override suspend fun upsertAll(currencies: List<CurrencyEntity>): Unit =
      CoroutinesRoom.execute(__db, true, object : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __upsertionAdapterOfCurrencyEntity.upsert(currencies)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override fun getAllCurrencies(): Flow<List<CurrencyEntity>> {
    val _sql: String = "SELECT * FROM currency"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    return CoroutinesRoom.createFlow(__db, false, arrayOf("currency"), object :
        Callable<List<CurrencyEntity>> {
      public override fun call(): List<CurrencyEntity> {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfCode: Int = getColumnIndexOrThrow(_cursor, "code")
          val _cursorIndexOfValue: Int = getColumnIndexOrThrow(_cursor, "value")
          val _cursorIndexOfLastTime: Int = getColumnIndexOrThrow(_cursor, "lastTime")
          val _result: MutableList<CurrencyEntity> = ArrayList<CurrencyEntity>(_cursor.getCount())
          while (_cursor.moveToNext()) {
            val _item: CurrencyEntity
            val _tmpCode: String
            _tmpCode = _cursor.getString(_cursorIndexOfCode)
            val _tmpValue: Double
            _tmpValue = _cursor.getDouble(_cursorIndexOfValue)
            val _tmpLastTime: String
            _tmpLastTime = _cursor.getString(_cursorIndexOfLastTime)
            _item = CurrencyEntity(_tmpCode,_tmpValue,_tmpLastTime)
            _result.add(_item)
          }
          return _result
        } finally {
          _cursor.close()
        }
      }

      protected fun finalize() {
        _statement.release()
      }
    })
  }

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
