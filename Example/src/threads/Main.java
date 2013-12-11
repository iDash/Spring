package threads;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    static int SIZE = 2;
    static ArrayBlockingQueue<Place> places = new ArrayBlockingQueue<Place>(SIZE);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            places.offer(new Place("PLACE" + i));
        }

        LinkedList<Object> list = new LinkedList<Object>();
        new LinkedList().poll();
        while (true) {
            Thread.currentThread().sleep(10);
            for (int i = 0; i < 13; i++) {
                Thread car = new Thread(new Car("CAR " + i, (int) Math.random() * 1000 + i * 10));
                car.start();
            }
        }
    }
}

class Car implements Runnable {
    String id;
    int timeToWait;
    int timeToParking;
    Place place;

    Car(String id, int timeToWait) {
        this.id = id;
        this.timeToWait = timeToWait;
        timeToParking = timeToWait;
    }

    @Override
    public void run() {
        try {
            System.out.println(id + " waiting");

            place = Main.places.poll(timeToWait, TimeUnit.MILLISECONDS);
            if (place == null) {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + id + " AWAY!");
                return;
            }

            System.out.println("\t\t\t\t" + id + " parked on " + place);
            Thread.sleep(timeToParking);

            System.out.println("\t\t\t\t\t\t\t\t\t\t" + id + " exit");
            Main.places.offer(place);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Place {
    public String name;

    Place(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
