package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    static Hippodrome game;

    private List<Horse> horses = new ArrayList<Horse>();


    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List getHorses() {
        return this.horses;
    }

    public void run() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {

        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {

        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double maxDistance = 0.;
        int count = 0;
        int winner = 0;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                winner = count;
                maxDistance = horse.getDistance();
            }
            count++;
        }
        return horses.get(winner);
    }

    public void printWinner() {

        System.out.println("Winner is " + this.getWinner().getName() + "!");

    }

    public static void main(String[] args) throws InterruptedException {

        Hippodrome.game = new Hippodrome(new ArrayList<Horse>());

        Horse horse1 = new Horse("Horse1", 3, 0);
        Horse horse2 = new Horse("Horse2", 3, 0);
        Horse horse3 = new Horse("Horse3", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();

        game.printWinner();

    }
}
