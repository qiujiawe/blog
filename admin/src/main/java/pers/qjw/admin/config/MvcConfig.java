package pers.qjw.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 莫名其妙的警告
        registry.addViewController("/login").setViewName("/page/login.html");
        registry.addViewController("/admin").setViewName("/page/admin.html");
        registry.addViewController("/editor").setViewName("/page/editor.html");
        registry.addViewController("/update/**").setViewName("/page/update.html");
        registry.addViewController("/article/**").setViewName("/page/article.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///" + System.getProperty("user.dir") + "/images/");
    }
}
