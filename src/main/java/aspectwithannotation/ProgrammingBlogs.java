package aspectwithannotation;

public class ProgrammingBlogs {
  private static final String PREMIUM_CONTENT = "This is premium content";
  private static final String FREE_CONTENT = "This is free content";
  private final Long apiKey;

  public ProgrammingBlogs(final Long apiKey) {
    this.apiKey = apiKey;
  }

  public static ProgrammingBlogs build(Long apiKey) {
    return new ProgrammingBlogs(apiKey);
  }

  public Long getApiKey() {
    return apiKey;
  }

  @ApiKey(isRequired = true)
  public String getPremiumContent() {
    return PREMIUM_CONTENT;
  }

  @ApiKey(isRequired = false)
  public String getFreeContent() {
    return FREE_CONTENT;
  }
}
