package freeFlow.model;

import java.util.List;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:14
 */
public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
