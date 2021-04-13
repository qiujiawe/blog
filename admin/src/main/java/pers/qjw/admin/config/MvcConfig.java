package pers.qjw.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/page/login.html");
        registry.addViewController("/admin").setViewName("/page/admin.html");
        registry.addViewController("/editor").setViewName("/page/editor.html");
        registry.addViewController("/update/**").setViewName("/page/update.html");
        registry.addViewController("/article/**").setViewName("/page/article.html");
    }
}
