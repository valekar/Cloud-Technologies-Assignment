package com.cloud.model;


import java.io.Serializable;

/**
 * <p>Class representing the csv file columns</p>
 */
public class KickStarter implements Serializable {

    private Long ID;
    private String name;
    private String category;
    private String main_category;
    private String currency;
    private String deadline;
    private Long goal;
    private String launched;
    private Long pledged;
    private String state;
    private Integer backers;
    private String country;
    private Long usd_pledged;
    private Long usd_pledged_real;
    private Long usd_goal_real;


    public KickStarter(Long ID,String name, String category, String main_category, String currency,
                       String deadline, Long goal, String launched, Long pledged, String state,
                       Integer backers, String country, Long usd_pledged, Long usd_pledged_real, Long usd_goal_real){
        this.ID=ID;
        this.name=name;
        this.category=category;
        this.main_category=main_category;
        this.currency=currency;
        this.deadline=deadline;
        this.goal=goal;
        this.launched=launched;
        this.pledged=pledged;
        this.state=state;
        this.backers=backers;
        this.country=country;
        this.usd_pledged=usd_pledged;
        this.usd_pledged_real=usd_pledged_real;
        this.usd_goal_real=usd_goal_real;
    }

    public KickStarter(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMain_category() {
        return main_category;
    }

    public void setMain_category(String main_category) {
        this.main_category = main_category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Long getGoal() {
        return goal;
    }

    public void setGoal(Long goal) {
        this.goal = goal;
    }

    public String getLaunched() {
        return launched;
    }

    public void setLaunched(String launched) {
        this.launched = launched;
    }

    public Long getPledged() {
        return pledged;
    }

    public void setPledged(Long pledged) {
        this.pledged = pledged;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getBackers() {
        return backers;
    }

    public void setBackers(Integer backers) {
        this.backers = backers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getUsd_pledged() {
        return usd_pledged;
    }

    public void setUsd_pledged(Long usd_pledged) {
        this.usd_pledged = usd_pledged;
    }

    public Long getUsd_pledged_real() {
        return usd_pledged_real;
    }

    public void setUsd_pledged_real(Long usd_pledged_real) {
        this.usd_pledged_real = usd_pledged_real;
    }

    public Long getUsd_goal_real() {
        return usd_goal_real;
    }

    public void setUsd_goal_real(Long usd_goal_real) {
        this.usd_goal_real = usd_goal_real;
    }
}
