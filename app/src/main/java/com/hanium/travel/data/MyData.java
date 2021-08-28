package com.hanium.travel.data;

public class MyData {

    String[] movement;
    String[] dest;
    String[] goal;
    int max_money;
    int min_money;

    public MyData(String[] movement, String[] dest, String[] goal, int max_money, int min_money) {
        this.movement = movement;
        this.dest = dest;
        this.goal = goal;
        this.max_money = max_money;
        this.min_money = min_money;
    }

    public String[] getMovement() {
        return movement;
    }

    public String[] getDest() {
        return dest;
    }

    public String[] getGoal() {
        return goal;
    }

    public int getMax_money() {
        return max_money;
    }

    public int getMin_money() {
        return min_money;
    }

    public void setMovement(String[] movement) {
        this.movement = movement;
    }

    public void setDest(String[] dest) {
        this.dest = dest;
    }

    public void setGoal(String[] goal) {
        this.goal = goal;
    }

    public void setMax_money(int max_money) {
        this.max_money = max_money;
    }

    public void setMin_money(int min_money) {
        this.min_money = min_money;
    }
}
