
package CybertekApi.PojoCyberStudents;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Student {

    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("batch")
    @Expose
    private Integer batch;
    @SerializedName("joinDate")
    @Expose
    private String joinDate;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("admissionNo")
    @Expose
    private String admissionNo;
    @SerializedName("major")
    @Expose
    private String major;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("company")
    @Expose
    private Company company;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Student() {
    }

    /**
     * 
     * @param lastName
     * @param gender
     * @param subject
     * @param batch
     * @param section
     * @param birthDate
     * @param studentId
     * @param firstName
     * @param password
     * @param joinDate
     * @param major
     * @param admissionNo
     * @param contact
     * @param company
     */
    public Student(Integer studentId, String firstName, String lastName, Integer batch, String joinDate, String birthDate, String password, String subject, String gender, String admissionNo, String major, String section, Contact contact, Company company) {
        super();
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.batch = batch;
        this.joinDate = joinDate;
        this.birthDate = birthDate;
        this.password = password;
        this.subject = subject;
        this.gender = gender;
        this.admissionNo = admissionNo;
        this.major = major;
        this.section = section;
        this.contact = contact;
        this.company = company;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
