package com.tou;

public class Player {
    private String name;
    private int lives;

    public Player(String name) {
        this.name = name;
        this.lives = 5;
    }

    public String getName() {
        return name;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", lives=" + lives +
                '}';
    }
}
