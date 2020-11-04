package Questions.Concurrency;

import java.io.Serializable;

public class leotest {
    public int id;
    public int leotest;
    public int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeotest() {
        return leotest;
    }

    public void setLeotest(int leotest) {
        this.leotest = leotest;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public leotest(int id, int leotest, int salary) {
        this.id = id;
        this.leotest = leotest;
        this.salary = salary;
    }
}
