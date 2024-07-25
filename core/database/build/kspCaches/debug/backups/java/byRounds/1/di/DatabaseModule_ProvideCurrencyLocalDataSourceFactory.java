package di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import dao.CurrencyLocalDataSource;
import db.CurrencyDatabase;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvideCurrencyLocalDataSourceFactory implements Factory<CurrencyLocalDataSource> {
  private final Provider<CurrencyDatabase> dbProvider;

  public DatabaseModule_ProvideCurrencyLocalDataSourceFactory(
      Provider<CurrencyDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CurrencyLocalDataSource get() {
    return provideCurrencyLocalDataSource(dbProvider.get());
  }

  public static DatabaseModule_ProvideCurrencyLocalDataSourceFactory create(
      Provider<CurrencyDatabase> dbProvider) {
    return new DatabaseModule_ProvideCurrencyLocalDataSourceFactory(dbProvider);
  }

  public static CurrencyLocalDataSource provideCurrencyLocalDataSource(CurrencyDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCurrencyLocalDataSource(db));
  }
}
