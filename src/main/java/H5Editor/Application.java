package H5Editor;

import H5Editor.Model.File.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by MrCJ on 2016/12/5.
 */

@SpringBootApplication
@EnableSwagger2 // 启动Swagger注解
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner test(FileRepository repository) {
        return (args) -> {
        };
    }

}
