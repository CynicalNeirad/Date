package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
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

    private String wZodiac;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> dateUser;


    public void addUser(AppUser user) {
        this.dateUser.add(user);
    }

    public AppDate() {
        this.dateUser = new HashSet<>();
    }

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

    public void setmName(Integer date) {
        switch (date) {
            case 1:
                this.mName = ("Kwesi");
                break;
            case 2:
                this.mName = ("Kojo");
                break;
            case 3:
                this.mName = ("Kwabena");
                break;
            case 4:
                this.mName = ("Kweku");
                break;
            case 5:
                this.mName = ("Yaw");
                break;
            case 6:
                this.mName = ("Kofi");
                break;
            case 7:
                this.mName = ("Kwame");
                break;
        }
    }

    public String getfName() {
        return fName;
    }

    public void setfName(Integer date) {
        switch (date) {
            case 1:
                this.fName = ("Akosua");
                break;
            case 2:
                this.fName = ("Adjoa");
                break;
            case 3:
                this.fName = ("Abena");
                break;
            case 4:
                this.fName = ("Akua");
                break;
            case 5:
                this.fName = ("Yaa");
                break;
            case 6:
                this.fName = ("Afua");
                break;
            case 7:
                this.fName = ("Ama");
                break;
        }
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

    public void setZodiac(int year) {
        switch (year) {
            case 0:
                this.zodiac = ("Monkey");
                break;
            case 1:
                this.zodiac = ("Rooster");
                break;
            case 2:
                this.zodiac = ("Dog");
                break;
            case 3:
                this.zodiac = ("Pig");
                break;
            case 4:
                this.zodiac = ("Rat");
                break;
            case 5:
                this.zodiac = ("Ox");
                break;
            case 6:
                this.zodiac = ("Tiger");
                break;
            case 7:
                this.zodiac = ("Rabbit");
                break;
            case 8:
                this.zodiac = ("Dragon");
                break;
            case 9:
                this.zodiac = ("Snake");
                break;
            case 10:
                this.zodiac = ("Horse");
                break;
            case 11:
                this.zodiac = ("Sheep");
                break;
        }
    }

    public String getwZodiac() {
        return wZodiac;
    }

    public void setwZodiac(int month, int day) {
        switch (month) {
            case 0:
                if (day <= 20) {
                    this.wZodiac = "Capricorn";
                } else {
                    this.wZodiac = "Aquarius";
                }
                break;
            case 1:
                if (day <= 19) {
                    this.wZodiac = "Aquarius";
                } else {
                    this.wZodiac = "Pisces";
                }
                break;
            case 2:
                if (day <= 20) {
                    this.wZodiac = "Pisces";
                } else {
                    this.wZodiac = "Aries";
                }
                break;
            case 3:
                if (day <= 20) {
                    this.wZodiac = "Aries";
                } else {
                    this.wZodiac = "Taurus";
                }
                break;
            case 4:
                if (day <= 21) {
                    this.wZodiac = "Taurus";
                } else {
                    this.wZodiac = "Gemini";
                }
                break;
            case 5:
                if (day <= 21) {
                    this.wZodiac = "Gemini";
                } else {
                    this.wZodiac = "Cancer";
                }
                break;
            case 6:
                if (day <= 22) {
                    this.wZodiac = "Cancer";
                } else {
                    this.wZodiac = "Leo";
                }
                break;
            case 7:
                if (day <= 22) {
                    this.wZodiac = "Leo";
                } else {
                    this.wZodiac = "Virgo";
                }
                break;
            case 8:
                if (day <= 23) {
                    this.wZodiac = "Virgo";
                } else {
                    this.wZodiac = "Libra";
                }
                break;
            case 9:
                if (day <= 23) {
                    this.wZodiac = "Libra";
                } else {
                    this.wZodiac = "Scorpio";
                }
                break;
            case 10:
                if (day <= 22) {
                    this.wZodiac = "Scorpio";
                } else {
                    this.wZodiac = "Sagittarius";
                }
                break;
            case 11:
                if (day <= 21) {
                    this.wZodiac = "Sagittarius";
                } else {
                    this.wZodiac = "Capricorn";
                }
                break;
        }
    }
}
