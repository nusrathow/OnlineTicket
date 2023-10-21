package net.javaguides.springboot.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "busId")
    private Bus busId;


    @Column(name = "userName")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name = "mobileNo")
    private String mobileNo;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Bus getBusId() {
        return busId;
    }

    public void setBusId(Bus busId) {
        this.busId = busId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

}
