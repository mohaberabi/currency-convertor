package source;

import api.CurrencyApi;
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
public final class RetrofitCurrencyRemoteDataSource_Factory implements Factory<RetrofitCurrencyRemoteDataSource> {
  private final Provider<CurrencyApi> apiProvider;

  public RetrofitCurrencyRemoteDataSource_Factory(Provider<CurrencyApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public RetrofitCurrencyRemoteDataSource get() {
    return newInstance(apiProvider.get());
  }

  public static RetrofitCurrencyRemoteDataSource_Factory create(Provider<CurrencyApi> apiProvider) {
    return new RetrofitCurrencyRemoteDataSource_Factory(apiProvider);
  }

  public static RetrofitCurrencyRemoteDataSource newInstance(CurrencyApi api) {
    return new RetrofitCurrencyRemoteDataSource(api);
  }
}
