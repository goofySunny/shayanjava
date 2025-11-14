package ir.najaftech.configuration;

import java.io.File;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {

    @Value("${upload.path:./uploads}")
    private String uploadPath;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return registry -> {
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // With this referencing /images/{whatever} resolves to the resource location that
        // was defined beneath it with add resource location method
        String absolutePath = new File(uploadPath).getAbsolutePath() + "/";

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + absolutePath);

        registry.addResourceHandler("/simages/**")
                .addResourceLocations("classpath:/static/images");

    }

}
