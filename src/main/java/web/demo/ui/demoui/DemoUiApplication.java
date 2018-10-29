package web.demo.ui.demoui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"web.demo.ui.demoui"})
public class DemoUiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoUiApplication.class, args);
	}
}