package pl.java.data.base.helloW.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table//(name = "departments")
public class Departments {
    @Id
    @Column(name = "dept_no", columnDefinition = "char(4)")
    private String id;
    @Column
    private String dept_name;

    public String getId() {
        return id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
