package springbootprofile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component	
@Profile({"sunny", "default"})
public class SunnyDayService implements WeatherService {

	@Override
	public String forecast() {
		return "Today is sunny day!";
	}

}
