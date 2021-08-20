package Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class is responsible for managing the students and is part of the service layer
 */
@Service // start of depencdency injection, this is a class that needs to instantiated
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEMail(student.geteMail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {

      boolean exists =  studentRepository.existsById(studentId);
      if (!exists) {
          throw new IllegalStateException("student with id " + studentId +" does not exist");
      }
      studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String eMail) {

        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        } else {
            Student student = studentRepository.getById(studentId);
            if (name != null && !Objects.equals(student.getName(), name)) {
                student.setName(name);
            }

            if (eMail != null && !Objects.equals(student.geteMail(), eMail)) {
                student.seteMail(eMail);
            }
        }

    }
}
