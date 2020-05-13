import com.aonsource.com.aonsource.service.SpeakerService;
import com.aonsource.com.aonsource.service.SpeakerServiceImpl;
import com.aonsource.repository.HibernateSpeakerRepositoryImpl;
import com.aonsource.repository.SpeakerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        return new SpeakerServiceImpl(getSpeakerRepository());
    }


}
