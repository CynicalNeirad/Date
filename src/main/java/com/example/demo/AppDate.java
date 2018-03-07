package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inputDate;

    private String mName;

    private String fName;

    private String zodiac;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> dateUser;


    public void addUser(AppUser user){
        this.dateUser.add(user);
    }

    public AppDate() {this.dateUser = new HashSet<>();}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Set<AppUser> getDateUser() {
        return dateUser;
    }

    public void setDateUser(Set<AppUser> dateUser) {
        this.dateUser = dateUser;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }
}
