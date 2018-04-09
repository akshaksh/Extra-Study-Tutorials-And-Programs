package springbootprofile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("raining")
public class RainingDayService implements WeatherService {

	@Override
    public String forecast() {
        return "Today is raining day!";
    }

}
