package aspectwithannotation;

import java.util.Arrays;
import java.util.List;

public class ApiKeyStorage {
  private static final List<Long> KEYS =Arrays.asList(1000L, 2000L, 3000L);

  public static boolean isApiKeyValid(final Long apiKey) {
    return KEYS.contains(apiKey);
  }
}
