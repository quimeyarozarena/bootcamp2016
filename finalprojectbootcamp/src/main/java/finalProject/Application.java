package finalProject;

import com.mangofactory.swagger.plugin.EnableSwagger;
import finalProject.DAOs.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableSwagger
@EnableJpaRepositories(basePackageClasses = UserDAO.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
