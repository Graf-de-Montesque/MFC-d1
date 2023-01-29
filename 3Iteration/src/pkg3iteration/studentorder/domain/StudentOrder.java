package pkg3iteration.studentorder.domain;

public class StudentOrder {
   private long studentOrderId;
   private Adult Husband;
   private Adult wife;
   private Child child;

    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusband() {
        return Husband;
    }

    public void setHusband(Adult Husband) {
        this.Husband = Husband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
   
}
