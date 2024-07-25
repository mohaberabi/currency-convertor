package db

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.room.RoomOpenHelper
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import dao.CurrencyDao
import dao.CurrencyDao_Impl
import java.lang.Class
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import javax.`annotation`.processing.Generated
import kotlin.Any
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.Set

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class CurrencyDatabase_Impl : CurrencyDatabase() {
  private val _currencyDao: Lazy<CurrencyDao> = lazy {
    CurrencyDao_Impl(this)
  }


  protected override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
    val _openCallback: SupportSQLiteOpenHelper.Callback = RoomOpenHelper(config, object :
        RoomOpenHelper.Delegate(1) {
      public override fun createAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `currency` (`code` TEXT NOT NULL, `value` REAL NOT NULL, `lastTime` TEXT NOT NULL, PRIMARY KEY(`code`))")
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c9ee3e6cfef7679d5af5a4e1eae7569d')")
      }

      public override fun dropAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("DROP TABLE IF EXISTS `currency`")
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onDestructiveMigration(db)
          }
        }
      }

      public override fun onCreate(db: SupportSQLiteDatabase) {
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onCreate(db)
          }
        }
      }

      public override fun onOpen(db: SupportSQLiteDatabase) {
        mDatabase = db
        internalInitInvalidationTracker(db)
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onOpen(db)
          }
        }
      }

      public override fun onPreMigrate(db: SupportSQLiteDatabase) {
        dropFtsSyncTriggers(db)
      }

      public override fun onPostMigrate(db: SupportSQLiteDatabase) {
      }

      public override fun onValidateSchema(db: SupportSQLiteDatabase):
          RoomOpenHelper.ValidationResult {
        val _columnsCurrency: HashMap<String, TableInfo.Column> =
            HashMap<String, TableInfo.Column>(3)
        _columnsCurrency.put("code", TableInfo.Column("code", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCurrency.put("value", TableInfo.Column("value", "REAL", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsCurrency.put("lastTime", TableInfo.Column("lastTime", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysCurrency: HashSet<TableInfo.ForeignKey> = HashSet<TableInfo.ForeignKey>(0)
        val _indicesCurrency: HashSet<TableInfo.Index> = HashSet<TableInfo.Index>(0)
        val _infoCurrency: TableInfo = TableInfo("currency", _columnsCurrency, _foreignKeysCurrency,
            _indicesCurrency)
        val _existingCurrency: TableInfo = read(db, "currency")
        if (!_infoCurrency.equals(_existingCurrency)) {
          return RoomOpenHelper.ValidationResult(false, """
              |currency(entity.CurrencyEntity).
              | Expected:
              |""".trimMargin() + _infoCurrency + """
              |
              | Found:
              |""".trimMargin() + _existingCurrency)
        }
        return RoomOpenHelper.ValidationResult(true, null)
      }
    }, "c9ee3e6cfef7679d5af5a4e1eae7569d", "8fee4a14953f1558fd0b0c484d057fd5")
    val _sqliteConfig: SupportSQLiteOpenHelper.Configuration =
        SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build()
    val _helper: SupportSQLiteOpenHelper = config.sqliteOpenHelperFactory.create(_sqliteConfig)
    return _helper
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: HashMap<String, String> = HashMap<String, String>(0)
    val _viewTables: HashMap<String, Set<String>> = HashMap<String, Set<String>>(0)
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "currency")
  }

  public override fun clearAllTables() {
    super.assertNotMainThread()
    val _db: SupportSQLiteDatabase = super.openHelper.writableDatabase
    try {
      super.beginTransaction()
      _db.execSQL("DELETE FROM `currency`")
      super.setTransactionSuccessful()
    } finally {
      super.endTransaction()
      _db.query("PRAGMA wal_checkpoint(FULL)").close()
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM")
      }
    }
  }

  protected override fun getRequiredTypeConverters(): Map<Class<out Any>, List<Class<out Any>>> {
    val _typeConvertersMap: HashMap<Class<out Any>, List<Class<out Any>>> =
        HashMap<Class<out Any>, List<Class<out Any>>>()
    _typeConvertersMap.put(CurrencyDao::class.java, CurrencyDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecs(): Set<Class<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: HashSet<Class<out AutoMigrationSpec>> =
        HashSet<Class<out AutoMigrationSpec>>()
    return _autoMigrationSpecsSet
  }

  public override
      fun getAutoMigrations(autoMigrationSpecs: Map<Class<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = ArrayList<Migration>()
    return _autoMigrations
  }

  public override fun currencyDao(): CurrencyDao = _currencyDao.value
}
