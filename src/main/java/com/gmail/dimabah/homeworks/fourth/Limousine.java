package com.gmail.dimabah.homeworks.fourth;

public class Limousine extends Car {
    private String comfort;
    private boolean extendedBase = true;

    public Limousine(String name, String color, double price, Engine engine,
                     Wheel[] wheels, int seats, String comfort, boolean extendedBase) {
        super(name, color, price, engine, wheels, seats);
        this.comfort = comfort;
        this.extendedBase = extendedBase;
    }

    public Limousine(String name, String color, double price, Engine engine,
                     Wheel wheel, int numberOfWheels, int seats, String comfort, boolean extendedBase) {
        super(name, color, price, engine, wheel, numberOfWheels, seats);
        this.comfort = comfort;
        this.extendedBase = extendedBase;
    }

    public Limousine() {
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public boolean isExtendedBase() {
        return extendedBase;
    }

    public void setExtendedBase(boolean extendedBase) {
        this.extendedBase = extendedBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        if (super.getName() == null || !super.getName().equals(car.getName())) return false;
        if (super.getColor() == null || !super.getColor().equals(car.getColor())) return false;
        if (super.getPrice() != car.getPrice()) return false;

        if (super.getEngine() == null || car.getEngine() == null) return false;
        if (super.getEngine().getPower() != car.getEngine().getPower()) return false;
        if (super.getEngine().getFuelConsumption() != car.getEngine().getFuelConsumption()) return false;

        if (super.getWheels() == null || car.getWheels() == null) return false;
        for (int i = 0; i < super.getWheels().length; i++) {
            if (super.getWheels()[i].getWidth() != car.getWheels()[i].getWidth()) return false;
            if (super.getWheels()[i].getDiameter() != car.getWheels()[i].getDiameter()) return false;
            if (super.getWheels()[i].getProducer() == null ||
                    !super.getWheels()[i].getProducer().equals(car.getWheels()[i].getProducer())) return false;
        }
        if (super.getSeats() != car.getSeats()) return false;

        Limousine limousine = (Limousine) o;
        if (comfort == null || !comfort.equals(limousine.getComfort())) return false;
        return extendedBase == limousine.isExtendedBase();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + hashCodeFromSting(super.getName());

        result += 31 * result + hashCodeFromSting(super.getColor());

        long temp = Double.doubleToLongBits(super.getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        if (super.getEngine() != null) {
            result = 31 * result + super.getEngine().getPower();
            temp = Double.doubleToLongBits(super.getEngine().getFuelConsumption());
            result = 31 * result + (int) (temp ^ (temp >>> 32));
        }

        if (super.getWheels() != null) {
            for (var i : super.getWheels()) {
                if (i != null) {
                    result = 31 * result + i.getDiameter();
                    result = 31 * result + i.getWidth();
                    result = 31 * result + hashCodeFromSting(i.getProducer());
                }
            }
        }

        result = 31 * result + super.getSeats();

        result = 31 * result + hashCodeFromSting(comfort);

        result = 31 * result + (extendedBase ? 1103 : 1109);

        return result;
    }

    private int hashCodeFromSting(String text) {
        int result = 1;
        if (text == null) {
            return 0;
        } else {
            for (int i = 0; i < text.length(); i++) {
                result = 31 * result + text.charAt(i);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Limousine ");
        sb.append(super.getName());
        sb.append(" - ");
        sb.append(super.getPrice());
        sb.append("$ (color=");
        sb.append(super.getColor());
        sb.append(", seat=");
        sb.append(super.getSeats());
        sb.append(", engine [power=");
        sb.append(super.getEngine().getPower());
        sb.append(" hp, fuel consumption=");
        sb.append(super.getEngine().getFuelConsumption());
        sb.append(" L/100 km], wheels [");
        for (var wheel : super.getWheels()) {
            sb.append("(");
            sb.append(wheel.getProducer());
            sb.append(") diameter=");
            sb.append(wheel.getDiameter());
            sb.append(", width=");
            sb.append(wheel.getWidth());
        }
        sb.append("] , comfort=");
        sb.append(comfort);
        if (isExtendedBase()) {
            sb.append(", exended base");
        }
        sb.append(")");

        return sb.toString();
    }

    @Override
    String moveCar() {
        return "Make it comfortable!";
    }
}
