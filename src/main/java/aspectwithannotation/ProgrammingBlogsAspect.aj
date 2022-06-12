package aspectwithannotation;


aspect ProgrammingBlogsAspect {

  /**
   * There are many ways to define pointcut. This is just one way.
   */
  pointcut apiKeyAnnotatedMethod(ApiKey key, ProgrammingBlogs blog) : target(blog)
                                                                      && @annotation(key);

  before(ApiKey key, ProgrammingBlogs blog) : apiKeyAnnotatedMethod(key, blog) {
    if (key.isRequired() && (!ApiKeyStorage.isApiKeyValid(blog.getApiKey()))) {
      throw new IllegalAccessError("Valid ApiKey is required to access the content.");
    }
  }
}