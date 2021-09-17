package CybertekApi;

public class Students {

    private int studentId;
    private String firstName;
    private String lastName;
    private int batch;

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", batch=" + batch +
                '}';
    }

    public Students() {
    }

    public Students(int studentId, String firstName, String lastName, int batch) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.batch = batch;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBatch() {
        return batch;
    }
}
