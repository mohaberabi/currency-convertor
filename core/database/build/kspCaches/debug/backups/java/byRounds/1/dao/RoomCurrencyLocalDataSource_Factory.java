package dao;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class RoomCurrencyLocalDataSource_Factory implements Factory<RoomCurrencyLocalDataSource> {
  private final Provider<CurrencyDao> daoProvider;

  public RoomCurrencyLocalDataSource_Factory(Provider<CurrencyDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public RoomCurrencyLocalDataSource get() {
    return newInstance(daoProvider.get());
  }

  public static RoomCurrencyLocalDataSource_Factory create(Provider<CurrencyDao> daoProvider) {
    return new RoomCurrencyLocalDataSource_Factory(daoProvider);
  }

  public static RoomCurrencyLocalDataSource newInstance(CurrencyDao dao) {
    return new RoomCurrencyLocalDataSource(dao);
  }
}
