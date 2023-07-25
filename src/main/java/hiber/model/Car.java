package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @Column(name = "user_id")
    private long userId;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car(){}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
