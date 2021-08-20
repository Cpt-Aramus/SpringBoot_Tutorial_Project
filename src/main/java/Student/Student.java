package Student;

import javax.persistence.*;
import java.time.LocalDate;

/** This class represents a Student with the following attributes:
 * ID (Long)
 * Name (String)
 * Email (String)
 * Date of Birth/ dob (LocalDate)
 * Age (Integer)
 */

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name = "student_seqence", sequenceName = "student_seqence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seqence")
private long id;
private String name;
private String eMail;
private LocalDate dob;
private Integer age;

    //Empty constructor
    public Student() {
    }

    // Fixed ID
    public Student(long id, String name, String eMail, LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.eMail = eMail;
        this.dob = dob;
        this.age = age;
    }

    // Generates random ID
    public Student(String name, String eMail, LocalDate dob, Integer age) {
        this.name = name;
        this.eMail = eMail;
        this.dob = dob;
        this.age = age;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
