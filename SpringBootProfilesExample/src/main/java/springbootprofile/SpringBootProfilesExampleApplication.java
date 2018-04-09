package springbootprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProfilesExampleApplication implements CommandLineRunner{

	@Autowired
    private WeatherService weatherService;

	@Autowired
    private ServerProperties serverProperties;
	
    @Override
    public void run(String... args) throws Exception {
        System.out.println(weatherService.forecast());
        System.out.println(serverProperties);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesExampleApplication.class, args);
	}
}
