package web.demo.ui.demoui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;


@SpringBootApplication(scanBasePackages = {"web.demo.ui.demoui"})
public class DemoUiApplication {
	
	@Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoUiApplication.class, args);
	}
}