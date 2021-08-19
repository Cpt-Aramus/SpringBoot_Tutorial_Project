package Student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * This class is responsible for managing the students and is part of the service layer
 */
@Component // start of depencdency injection, this is an object that needs to instantiated
public class StudentService {


    public List<Student> getStudents() {
        return List.of(new Student(1L, "Mariam", "mariam.jamal@gmail.com", LocalDate.of(2000, Month.JANUARY, 5), 21));

    }

}
