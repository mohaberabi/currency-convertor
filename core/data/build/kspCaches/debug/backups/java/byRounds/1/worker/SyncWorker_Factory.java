package worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import repository.CurrencyRepository;

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
public final class SyncWorker_Factory {
  private final Provider<CurrencyRepository> currencyRepositoryProvider;

  public SyncWorker_Factory(Provider<CurrencyRepository> currencyRepositoryProvider) {
    this.currencyRepositoryProvider = currencyRepositoryProvider;
  }

  public SyncWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, currencyRepositoryProvider.get());
  }

  public static SyncWorker_Factory create(Provider<CurrencyRepository> currencyRepositoryProvider) {
    return new SyncWorker_Factory(currencyRepositoryProvider);
  }

  public static SyncWorker newInstance(Context context, WorkerParameters params,
      CurrencyRepository currencyRepository) {
    return new SyncWorker(context, params, currencyRepository);
  }
}
