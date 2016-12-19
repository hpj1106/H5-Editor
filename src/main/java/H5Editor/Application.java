package H5Editor;

import H5Editor.Model.File.File;
import H5Editor.Model.File.FileRepo;
import H5Editor.Model.UserRepository;
import H5Editor.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
    public CommandLineRunner test(FileRepo repository) {
        return (args) -> {
            //User user = repository.findByUsername("aaa");
            List<File> file = repository.getAllFilesForAdmin();
            log.info(file.toString());
        };
    }

}
