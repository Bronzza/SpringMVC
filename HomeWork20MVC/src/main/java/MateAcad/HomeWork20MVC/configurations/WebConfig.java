package MateAcad.HomeWork20MVC.configurations;

import MateAcad.HomeWork20MVC.interceptors.ProgrammerInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor (onConstructor = @__(@Autowired))
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ProgrammerInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);

    }
}
