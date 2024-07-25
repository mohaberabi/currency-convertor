package di;

import api.CurrencyApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class CoreNetworkModule_ProvideCurrencyApiFactory implements Factory<CurrencyApi> {
  private final Provider<OkHttpClient> clientProvider;

  public CoreNetworkModule_ProvideCurrencyApiFactory(Provider<OkHttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public CurrencyApi get() {
    return provideCurrencyApi(clientProvider.get());
  }

  public static CoreNetworkModule_ProvideCurrencyApiFactory create(
      Provider<OkHttpClient> clientProvider) {
    return new CoreNetworkModule_ProvideCurrencyApiFactory(clientProvider);
  }

  public static CurrencyApi provideCurrencyApi(OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(CoreNetworkModule.INSTANCE.provideCurrencyApi(client));
  }
}
