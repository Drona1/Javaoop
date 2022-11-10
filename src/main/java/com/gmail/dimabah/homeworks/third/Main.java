package com.gmail.dimabah.homeworks.third;

import com.gmail.dimabah.homeworks.third.products.Clothes;
import com.gmail.dimabah.homeworks.third.products.Food;
import com.gmail.dimabah.homeworks.third.products.Furniture;
import com.gmail.dimabah.homeworks.third.products.Souvenir;

public class Main {
    public static void main(String[] args) {
        Clothes clothesOne = new Clothes("Coat", 10, 1000.0,
                Categories.CLOTHES, 48, "brown", "wool");
        Clothes clothesTwo = new Clothes("Dress", 5, 500.0,
                Categories.CLOTHES, 42, "red", "silk");

        Food foodOne = new Food("Nuts", 200, 5.9,
                Categories.FOOD, "01.12.2023", 200);
        Food foodTwo = new Food("Sausages", 50, 30,
                Categories.FOOD, "01.03.2023", 1000);

        Furniture furnitureOne = new Furniture("Chair", 3, 1200.0,
                Categories.FURNITURE, 98, 50, 50, "oak", "brown");
        Furniture furnitureTwo = new Furniture("Table", 5, 1300.0,
                Categories.FURNITURE, 70, 100, 200, "steel", "black");

        Souvenir souvenirOne = new Souvenir("Magnet", 500, 5.2,
                Categories.SOUVENIR, 50);
        Souvenir souvenirTwo = new Souvenir("Lighter", 300, 48.5,
                Categories.SOUVENIR, 135);

        Product[] products = {clothesOne, clothesTwo, foodOne, foodTwo, furnitureOne, furnitureTwo, souvenirOne};
        Customer customer = new Customer(3000);
        Store store = new Store(products);
        PaymentSystem paymentSystem = new PaymentSystem("BuyEverything");
        Manager manager = new Manager("Dmytro");

        manager.addProduct(store,souvenirTwo);
        manager.changeAmount(store, foodOne,50);

        UserInterface userInterface =new UserInterface(store,customer,paymentSystem);
        userInterface.showInterface();

    }
}
