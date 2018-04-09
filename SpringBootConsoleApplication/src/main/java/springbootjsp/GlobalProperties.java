package springbootjsp;

import javax.validation.constraints.Min;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("classpath:global.properties")
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class GlobalProperties {

  //  @Value("${thread-pool}")
	 //@Min(10) JSR validation will also support by @ConfigurationProperties
	 private int threadPool;
	 private String email;

    //@Value("${email}")

	public int getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(int threadPool) {
		this.threadPool = threadPool;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GlobalProperties [threadPool=" + threadPool + ", email="
				+ email + "]";
	}
    
    

}

/*OR
@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class GlobalProperties {

    private int threadPool;
    private String email;

    //getters and setters

}*/