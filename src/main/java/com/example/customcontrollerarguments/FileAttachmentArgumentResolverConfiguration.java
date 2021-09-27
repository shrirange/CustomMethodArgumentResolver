package com.example.customcontrollerarguments;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
class FileAttachmentArgumentResolverConfiguration implements WebMvcConfigurer {


  @Override
  public void addArgumentResolvers(
      List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(new FileAttachmentArgumentResolver());
  }

}