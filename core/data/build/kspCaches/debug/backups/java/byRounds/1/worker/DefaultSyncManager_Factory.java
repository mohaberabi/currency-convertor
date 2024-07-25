package worker;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DefaultSyncManager_Factory implements Factory<DefaultSyncManager> {
  private final Provider<Context> contextProvider;

  public DefaultSyncManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DefaultSyncManager get() {
    return newInstance(contextProvider.get());
  }

  public static DefaultSyncManager_Factory create(Provider<Context> contextProvider) {
    return new DefaultSyncManager_Factory(contextProvider);
  }

  public static DefaultSyncManager newInstance(Context context) {
    return new DefaultSyncManager(context);
  }
}
