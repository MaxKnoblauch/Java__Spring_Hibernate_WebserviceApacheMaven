package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // Konfiguriert den JSP-ViewResolver
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
