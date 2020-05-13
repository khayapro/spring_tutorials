import com.aonsource.com.aonsource.service.SpeakerService;
import com.aonsource.com.aonsource.service.SpeakerServiceImpl;

public class Application {

    public static void main(String [] args) {
        final SpeakerService speakerService = new SpeakerServiceImpl();
        System.out.println(speakerService.findAll().get(0).getFirstName());

    }

}
