package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "controller")
public class SpringContextConfiguration {
    public SpringContextConfiguration() {
        System.out.println("SpringContextConfiguration 初始化");
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/META-INF/views");
        Properties properties = new Properties();
        properties.setProperty("defaultEncoding", "utf-8");
        properties.setProperty("locale", "zh_CN");
        freeMarkerConfigurer.setFreemarkerSettings(properties);
        Map<String, Object> map = new HashMap();
        map.put("dev", true);
        map.put("reqsuffix", ".jsps");
        freeMarkerConfigurer.setFreemarkerVariables(map);
        return freeMarkerConfigurer;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setPrefix("/META-INF/views/");
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        return freeMarkerViewResolver;
    }



    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/META-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

}
