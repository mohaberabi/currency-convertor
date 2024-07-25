package repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import dao.CurrencyLocalDataSource;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import source.CurrencyRemoteDataSource;

@ScopeMetadata
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
public final class OfflineFirstCurrencyRepository_Factory implements Factory<OfflineFirstCurrencyRepository> {
  private final Provider<CurrencyRemoteDataSource> currencyRemoteDataSourceProvider;

  private final Provider<CurrencyLocalDataSource> currencyLocalDatasourceProvider;

  public OfflineFirstCurrencyRepository_Factory(
      Provider<CurrencyRemoteDataSource> currencyRemoteDataSourceProvider,
      Provider<CurrencyLocalDataSource> currencyLocalDatasourceProvider) {
    this.currencyRemoteDataSourceProvider = currencyRemoteDataSourceProvider;
    this.currencyLocalDatasourceProvider = currencyLocalDatasourceProvider;
  }

  @Override
  public OfflineFirstCurrencyRepository get() {
    return newInstance(currencyRemoteDataSourceProvider.get(), currencyLocalDatasourceProvider.get());
  }

  public static OfflineFirstCurrencyRepository_Factory create(
      Provider<CurrencyRemoteDataSource> currencyRemoteDataSourceProvider,
      Provider<CurrencyLocalDataSource> currencyLocalDatasourceProvider) {
    return new OfflineFirstCurrencyRepository_Factory(currencyRemoteDataSourceProvider, currencyLocalDatasourceProvider);
  }

  public static OfflineFirstCurrencyRepository newInstance(
      CurrencyRemoteDataSource currencyRemoteDataSource,
      CurrencyLocalDataSource currencyLocalDatasource) {
    return new OfflineFirstCurrencyRepository(currencyRemoteDataSource, currencyLocalDatasource);
  }
}
