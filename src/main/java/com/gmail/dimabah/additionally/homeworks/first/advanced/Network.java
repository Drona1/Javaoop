package com.gmail.dimabah.additionally.homeworks.first.advanced;

import java.util.*;

public class Network {
    private Map<String, Phone> map = new HashMap<>();

    public Network(Map<String, Phone> map) {
        this.map = map;
    }

    public Network() {
    }

    public Map<String, Phone> getMap() {
        return map;
    }

    public void setMap(Map<String, Phone> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Network{" +
                "map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return Objects.equals(map, network.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

    public boolean regInNetwork(String number, Phone phone) {
        if (number == null) {
            return false;
        }
        map.put(number, phone);
        return true;
    }

    public Phone checkForNumber(String number) {
        return map.get(number);
    }


}
