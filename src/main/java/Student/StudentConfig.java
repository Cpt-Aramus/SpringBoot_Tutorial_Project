package Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

/**
 * Configuration that adds Students to the database by following the complete apllication build up process
 * API => Service Layer => Data Access Layer => Database
 */

@Configuration
public class StudentConfig {

    CommandLineRunner commandLineRunner (StudentRepository  repository) {
        return args -> {
           Student mariam = new Student(1L, "Mariam", "mariam.jamal@gmail.com", LocalDate.of(2000, JANUARY, 5), 21);

            Student alex = new Student( "Alex", "alex@gmail.com", LocalDate.of(2004, JANUARY, 5), 21);

            repository.saveAll(List.of(mariam, alex));
        };
    }

}
