package Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

/**
 * This class includes all the necassarry recourses for our API
 */

@RestController
@RequestMapping(path = "student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List getStudents () {

        return studentService.getStudents();

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) { // Request body gets mapped into a Student

        studentService.addNewStudent(student);

    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent (@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false)String eMail) {
        studentService.updateStudent(studentId, name, eMail);
    }

}
