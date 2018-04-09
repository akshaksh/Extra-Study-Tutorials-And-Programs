package springbootjsp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner{

	 @Autowired
	 private ApplicationContext appContext;
	
	public static void main(String[] args) {
		//SpringApplication.run(SpringBootConsoleApplication.class, args);
		
		//To off this banner we have to set the property as below:
		SpringApplication app=new SpringApplication(SpringBootConsoleApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {
			String[] beans = appContext.getBeanDefinitionNames();
	        Arrays.sort(beans);
	        for (String bean : beans) {
	            System.out.println(bean);
	        }
	}
}
