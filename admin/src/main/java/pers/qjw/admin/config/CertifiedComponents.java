package pers.qjw.admin.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.qjw.admin.interceptor.AccessRecordInterceptor;
import pers.qjw.admin.interceptor.TokenInterceptor;
import pers.qjw.admin.mapper.BlogMapper;
import pers.qjw.admin.resolver.CurrentUserResolver;

import java.util.List;

@Configuration
@AllArgsConstructor
public class CertifiedComponents implements WebMvcConfigurer {

    private final BlogMapper blogMapper;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 刨除掉 swagger2 相关的url，不然 swagger2 无法正常生成帮助文档
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        registry.addInterceptor(new AccessRecordInterceptor(blogMapper)).addPathPatterns("/api/articles/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CurrentUserResolver());
    }

}
