package Com.sangram.DSA.Com.java8concept.Stream;

public class Employee {
    int id;
    String Name;
    String Dept;
    int salary;

    public Employee(int id, String name, String dept,int salary) {
        this.id = id;
        Name = name;
        Dept = dept;
        this.salary=salary;
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Dept='" + Dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
