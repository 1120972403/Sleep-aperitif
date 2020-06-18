package cn.jingyiban.pojo;

import java.util.Date;

public class Emr {
    private Integer id;

    private Integer emrLevelId;

    private Integer userId;

    private String userImg;

    private String userContent;

    private Date userTime;

    private Integer doctorId;

    private String doctorContent;

    private Date doctorTime;

    private String doctorImg;

    private Member member;

    private Doctor doctor;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmrLevelId() {
        return emrLevelId;
    }

    public void setEmrLevelId(Integer emrLevelId) {
        this.emrLevelId = emrLevelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserContent() {
        return userContent;
    }

    public void setUserContent(String userContent) {
        this.userContent = userContent;
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorContent() {
        return doctorContent;
    }

    public void setDoctorContent(String doctorContent) {
        this.doctorContent = doctorContent;
    }

    public Date getDoctorTime() {
        return doctorTime;
    }

    public void setDoctorTime(Date doctorTime) {
        this.doctorTime = doctorTime;
    }

    public String getDoctorImg() {
        return doctorImg;
    }

    public void setDoctorImg(String doctorImg) {
        this.doctorImg = doctorImg;
    }
}