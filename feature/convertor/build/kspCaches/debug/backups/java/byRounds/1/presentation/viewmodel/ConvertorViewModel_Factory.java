package presentation.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import repository.CurrencyRepository;
import worker.SyncManager;

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
public final class ConvertorViewModel_Factory implements Factory<ConvertorViewModel> {
  private final Provider<CurrencyRepository> currencyRepositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<SyncManager> syncManagerProvider;

  public ConvertorViewModel_Factory(Provider<CurrencyRepository> currencyRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<SyncManager> syncManagerProvider) {
    this.currencyRepositoryProvider = currencyRepositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.syncManagerProvider = syncManagerProvider;
  }

  @Override
  public ConvertorViewModel get() {
    return newInstance(currencyRepositoryProvider.get(), savedStateHandleProvider.get(), syncManagerProvider.get());
  }

  public static ConvertorViewModel_Factory create(
      Provider<CurrencyRepository> currencyRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<SyncManager> syncManagerProvider) {
    return new ConvertorViewModel_Factory(currencyRepositoryProvider, savedStateHandleProvider, syncManagerProvider);
  }

  public static ConvertorViewModel newInstance(CurrencyRepository currencyRepository,
      SavedStateHandle savedStateHandle, SyncManager syncManager) {
    return new ConvertorViewModel(currencyRepository, savedStateHandle, syncManager);
  }
}
