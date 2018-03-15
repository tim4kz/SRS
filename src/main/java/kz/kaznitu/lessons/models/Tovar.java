package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tovar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tovarName;
    private int cost;

    public Tovar() {
        this.tovarName = "" ;
        this.cost = 0 ;
    }

    public Tovar(String tovarName, int cost) {
        this.tovarName = tovarName;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTovarName() {
        return tovarName;
    }

    public void setTovarName(String tovarName) {
        this.tovarName = tovarName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
