package com.javarush.task.task23.task2312;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue); //Задаем цвет элементов зеленый
        g.fillRect(Room.game.getWidth() * 10, 0, 10, (Room.game.getWidth() * 10) + 10);  //Рисуем прямоугольник показывающий край поля справа
        g.fillRect(0, Room.game.getHeight() * 10, (Room.game.getHeight() * 10) + 10, 10); //Рисуем прямоугольник показывающий край поля снизу

        g.setColor(Color.BLACK);
        g.fillRect(Room.game.getMouse().getX()*10, Room.game.getMouse().getY()*10, 10, 10); //Рисуем прямоугольник показывающий мышь
        g.setColor(java.awt.Color.GREEN);

        ArrayList<SnakeSection> getsection = Room.game.getSnake().getSections(); //Получаем секции змейки
        for (int i = 0; i < getsection.size(); i++) {
            if(i==0){
                g.setColor(Color.ORANGE);
            } else {
                g.setColor(Color.GRAY);
            }
            g.fillRect(getsection.get(i).getX()*10, getsection.get(i).getY()*10, 10, 10); //Рисуем по очереди секции змейки
        }
    }

}