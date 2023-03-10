package pkg3iteration.studentorder.domain;

import java.util.ArrayList;
import java.util.List;

public class StudentOrder {
   private long studentOrderId;
   private Adult Husband;
   private Adult wife;
   private List<Child> children;

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
    
    public void addChild(Child child){
        if(children == null){
            children = new ArrayList<>(5);
        }
        children.add(child);
    }

    public List<Child> getChildren() {
        return children;
    }

   
}
