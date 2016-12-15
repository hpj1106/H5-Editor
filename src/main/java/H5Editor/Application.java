package H5Editor;

import H5Editor.Model.UserRepository;
import H5Editor.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by MrCJ on 2016/12/5.
 */

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner test(UserRepository repository) {
        return (args) -> {
            User user = repository.findByUsername("aaa");
            log.info(user.toString());
        };
    }

}
