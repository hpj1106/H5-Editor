package H5Editor;

import H5Editor.Model.AdminRepository;
import H5Editor.Model.Admin;
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
    public CommandLineRunner test(AdminRepository repository) {
        return (args) -> {
            Admin admin = repository.findByUsername("cjw");
            log.info(admin.toString());
        };
    }

}
