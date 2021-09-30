
package CybertekApi.PojoCyberStudents;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CyberStudents {

    @SerializedName("students")
    @Expose
    private List<Student> students = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CyberStudents() {
    }

    /**
     * 
     * @param students
     */
    public CyberStudents(List<Student> students) {
        super();
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
