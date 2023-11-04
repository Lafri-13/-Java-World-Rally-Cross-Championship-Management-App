package com.example.cwpart2.cw2programming;

public class driverClass { // creating private instance variables.
    private String name;
    private Integer position;
    private String team;
    private String car;
    private Integer points;

    public driverClass(String name, Integer position, String team, String car, Integer points) {
        // Constructor to initializing the variables
        this.name = name;
        this.position = position;
        this.team = team;
        this.car = car;
        this.points = points;
    }

    public String getName() { // To provide access to the variables

        return name;
    }

    public Integer getPosition() {

        return position;
    }

    public String getTeam() {

        return team;
    }

    public String getCar() {

        return car;
    }

    public Integer getPoints() {

        return points;
    }

}
