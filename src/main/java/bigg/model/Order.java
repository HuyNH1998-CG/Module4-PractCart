package bigg.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private Timestamp date;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
