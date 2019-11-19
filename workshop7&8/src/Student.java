

public class Student {

   private String firstName;
   private String lastName;
   private double grade;
   private String department;


    public Student(String firstName, String lastName, double grade, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getName(){

    return getFirstName() +"\t\t"+ getLastName() ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (Double.compare(student.grade, grade) != 0) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        return department.equals(student.department);
    }



    @Override
    public String toString() {
        return  getFirstName() + "\t" + getLastName() + "\t\t" + getGrade()+ "\t"+getDepartment();
    }
}