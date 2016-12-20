package H5Editor;

import H5Editor.Model.File.File;
import H5Editor.Model.File.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
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
    public CommandLineRunner test(FileRepository repository) {
        return (args) -> {
            //User user = repository.findByUsername("aaa");

            /*
            List<File> file = (List<File>) repository.findAll();
            //log.info(file.get(0).toString());
            List f = Arrays.asList(file);
            f.forEach(n -> System.out.println(n));

            List<Long> ids = new ArrayList<>();
            ids.add(1L);
            List<File> file1 = (List<File>) repository.findAll(ids);
            List f1 = Arrays.asList(file1);
            f1.forEach(n -> System.out.println(n));
            //log.info(file1.get(0).toString());
            * */
        };
    }

}
