package sixlab;
/*
            2211
            8)Возможность смены номера фигуры из уо

         */

import java.util.*;
import java.awt.*;
import java.awt.event.*;


class OurWindowAdapter extends WindowAdapter {

    public void windowClosing (WindowEvent wE) {
        System.exit (0);
    }
}

class Frames extends Frame {

    int count = 0; //количество фигур
    int numbers[];	//id

    java.util.List<Figure> figures = new ArrayList<Figure>(); //список фигур

    Frame childFrame ; // Дочерняя форма
    Canvas cnv;
    Label numberLab, objectLab, speedLab, objectLabForChange, speedLabForChange, colorLab,idLabForChange, idLabForChangeNew;
    TextField numberTB, speedTB, objectIdForChangeNew;
    Choice colorTB, figureTB;
    Button addBut, changeBut, changeButId;
    Choice objectChForAdd, objectChForChange, speedCh, objectIdForChange;
    Color color;


    Frames() {

        this.setTitle("PiPiPoPo");
        this.setSize (360, 400);

        numbers = new int [15];
        for (int i = 0; i < 10; i ++)
            numbers[i] = -1;

        numberLab = new Label("Номер: ");
        objectLab = new Label("Объект: ");
        speedLab = new Label("Скорость: ");
        objectLabForChange = new Label("Объект: ");
        speedLabForChange = new Label("Скорость: ");
        colorLab = new Label("Цвет: ");
        idLabForChange = new Label("ID");
        idLabForChangeNew = new Label("New ID");

        numberTB = new TextField();
        numberTB.setText("1");
        speedTB = new TextField();
        speedTB.setText("1");
        colorTB = new Choice();
        colorTB.addItem("Красный");
        colorTB.addItem("Оранжевый");
        colorTB.addItem("Синий");
        colorTB.addItem("Белый");
        colorTB.addItem("Черный");
        figureTB = new Choice();
        figureTB.addItem("круг");
        figureTB.addItem("квадрат");


        addBut = new Button("Добавить");
        changeBut = new Button("Изменить");
        changeButId = new Button("Изменить ID");


        objectChForChange = new Choice();

        speedCh = new Choice();
        speedCh.addItem("1");
        speedCh.addItem("2");
        speedCh.addItem("3");
        speedCh.addItem("4");
        speedCh.addItem("5");

        objectIdForChange = new Choice();
        objectIdForChangeNew = new TextField();

        cnv = new Canvas() {
            public void paint(Graphics g) {
                //
            }
        };


        //интерфейс УО
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout (new GridBagLayout());

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;
        this.add (numberLab, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 0;
        this.add (numberTB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 1;
        this.add (objectLab, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 1;
        this.add (figureTB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 2;
        this.add (colorLab, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 2;
        this.add (colorTB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 3;
        this.add (speedLab, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 3;
        this.add (speedTB, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;  gbc.gridy = 4;
        gbc.gridwidth = 3;
        this.add (addBut, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        this.add (new Label(""), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 6;
        this.add (objectLabForChange, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 6;
        this.add (objectChForChange, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 7;
        this.add (speedLabForChange, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 7;
        this.add (speedCh, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.gridwidth = 2;
        this.add (changeBut, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        this.add (new Label(""), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 10;
        this.add (idLabForChange, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 10;
        this.add (objectIdForChange, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 11;
        this.add (idLabForChangeNew, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1; gbc.gridy = 11;
        this.add (objectIdForChangeNew, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 12;
        gbc.gridwidth = 2;
        this.add (changeButId, gbc);


        addBut.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent aE) {
                AddButFunc();
            }
        });

        changeBut.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent aE) {
                ChangeButFunc();
            }
        });

        changeButId.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent aE) {
                ChangeIdFunc();
            }
        });

        this.addWindowListener (new OurWindowAdapter());

        //ДО
        childFrame= new Frame(); // Создать дочернюю форму
        childFrame.setSize (800, 600); // с размером
        childFrame.setLocation (450, 0);
        childFrame.add(cnv);
        childFrame.show(); // Перерисовать область клиента окна
        childFrame.addWindowListener (new OurWindowAdapter());
    }

    public void AddButFunc() {

        if (IsInteger(numberTB.getText())) {	//проверка номера
            int num = Integer.parseInt(numberTB.getText());
            if (CheckNumbers(num)) {
                if (IsInteger(speedTB.getText())) { //проверка скорости
                    int speed = Integer.parseInt(speedTB.getText());
                    if (CheckSpeed(speed)) {
                        if (CheckColor(colorTB.getSelectedItem())) { //проверка цвета

                            numbers[count] = num;
                            count ++;
                            objectChForChange.addItem(num + "");
                            objectIdForChange.addItem(num + "");




                            if (CheckFigure(figureTB.getSelectedItem())) {

                                figures.get(count-1).start();
                            }
                            else {

                                figures.get(count-1).start();
                            }
                        }
                    }
                }
            }
        }
    }

    public void ChangeButFunc() {

        if (IsInteger(objectChForChange.getSelectedItem())) { //проверка номера объекта
            int num = Integer.parseInt(objectChForChange.getSelectedItem());

            int foundNumber = -1;
            for (int i = 0; i < count; i ++) { //поиск объекта
                if (numbers[i] == num)
                    foundNumber = i;
            }

            figures.get(foundNumber).speed = Integer.parseInt(speedCh.getSelectedItem()); // изменение скорости
        }
    }

    public void ChangeIdFunc() {

        if (IsInteger(objectIdForChange.getSelectedItem())) { //проверка номера объекта
            int num = Integer.parseInt(objectIdForChange.getSelectedItem());

            int foundNumber = -1;
            for (int i = 0; i < count; i ++) { //поиск объекта
                if (numbers[i] == num)
                    foundNumber = i;
            }
            objectChForChange.remove(objectIdForChange.getSelectedItem());
            objectIdForChange.remove(objectIdForChange.getSelectedItem());
            numbers[foundNumber] = Integer.parseInt(objectIdForChangeNew.getText());
            figures.get(foundNumber).id = Integer.parseInt(objectIdForChangeNew.getText());
            objectChForChange.addItem(objectIdForChangeNew.getText() + "");
            objectIdForChange.addItem(objectIdForChangeNew.getText() + "");
        }
    }

    public boolean IsInteger(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean CheckNumbers(int num) {
        for (int i = 0; i < count; i ++) {
            if (numbers[i] == num)
                return false;
        }
        return true;
    }

    public boolean CheckSpeed (int speed) {
        if ((speed == 1) || (speed == 2) || (speed == 3) || (speed == 4) || (speed == 5))
            return true;
        else
            return false;
    }

    public boolean CheckFigure(String fgr) {
        if (fgr.equalsIgnoreCase("круг")) {
            figures.add(new Circle(this.cnv, color, Integer.parseInt(speedTB.getText()), Integer.parseInt(numberTB.getText())));
        }
        else if (fgr.equalsIgnoreCase("квадрат")) {
            figures.add(new Quadrangle(this.cnv, color, Integer.parseInt(speedTB.getText()), Integer.parseInt(numberTB.getText())));
        }
        else
            return false;

        return true;
    }

    public boolean CheckColor(String clr) {
        if (clr.equalsIgnoreCase("красный")) {
            this.color = Color.red;
        }
        else if (clr.equalsIgnoreCase("оранжевый")) {
            this.color = Color.orange;
        }
        else if (clr.equalsIgnoreCase("синий")) {
            this.color = Color.blue;
        }
        else if (clr.equalsIgnoreCase("желтый")) {
            this.color = Color.yellow;
        }
        else if (clr.equalsIgnoreCase("зеленый")) {
            this.color = Color.green;
        }
        else if (clr.equalsIgnoreCase("белый")) {
            this.color = Color.white;
        }
        else if (clr.equalsIgnoreCase("черный")) {
            this.color = Color.black;
        }
        else
            return false;

        return true;
    }

    public static void main (String[] args) {
        Frames Fr = new Frames();
        Fr.show();
    }
}



abstract class Figure extends Thread{

    Point point = new Point(50, 50);
    Canvas cnv;
    Graphics g;
    Color color;
    public int speed;
    double angle;
    int id;
    int step = 4;
    final  Random random = new Random();

    void moveTo() {
        this.show(false);
        this.point.x += this.speed*Math.cos(this.angle)*step;
        this.point.y += this.speed*Math.sin(this.angle)*step;
        checkBorder();
        this.show(true);
    }

    void show(boolean sh) {
        //
    }

    void checkBorder() {
        //
    }

    public void run() {
        while(true) {
            moveTo();
            try {
                sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Circle extends Figure{

    int radius = 70;

    void show(boolean sh) {
        if (sh)
            g.setColor(color);
        else
            g.setColor(Color.white);

        g.fillOval(point.x, point.y, radius, radius);
        g.drawString(this.id + "", point.x, point.y);
    }

    void checkBorder() {
        boolean border = false;

        if ((cnv.getWidth()-point.x <= this.radius) && (Math.cos(this.angle) > 0)) {
            this.angle = Math.PI - this.angle;
            border = true;
        }
        else if ((point.x <= 0) && (Math.cos(this.angle) < 0)) {
            this.angle = Math.PI - this.angle;
            border = true;
        }

        if ((cnv.getHeight()-point.y <= this.radius) && (Math.sin(this.angle) > 0)) {
            this.angle *= (-1);
            border = true;
        }
        else if ((point.y <= 0) && (Math.sin(this.angle) < 0)) {
            this.angle *= (-1);
            border = true;
        }

        if (border) {
            this.point.x += this.speed*Math.cos(this.angle);
            this.point.y += this.speed*Math.sin(this.angle);
        }
    }

    Circle(Canvas cnv, Color color, int speed, int id) {
        this.cnv = cnv;
        this.color = color;
        this.speed = speed;
        this.angle = Math.random()*2*Math.PI;
        this.g = cnv.getGraphics();
        this.id = id;
    }
}
class Quadrangle extends Figure{

    int height = 70;

    void show(boolean sh) {
        if (sh)
            g.setColor(color);
        else
            g.setColor(Color.white);

        g.fillRect(point.x-height/2, point.y-height/2, height, height);
        g.drawString(this.id + "", point.x-height/2-2, point.y-height/2-2);
    }

    void checkBorder() {
        boolean border = false;

        if ((cnv.getWidth()-point.x <= this.height/2) && (Math.cos(this.angle) > 0)) {
            this.angle = Math.PI - this.angle;
            border = true;
        }
        else if ((point.x <= this.height/2) && (Math.cos(this.angle) < 0)) {
            this.angle = Math.PI - this.angle;
            border = true;
        }

        if ((cnv.getHeight()-point.y <= this.height/2) && (Math.sin(this.angle) > 0)) {
            this.angle *= (-1);
            border = true;
        }
        else if ((point.y <= this.height/2) && (Math.sin(this.angle) < 0)) {
            this.angle *= (-1);
            border = true;
        }

        if (border) {
            this.point.x += this.speed*Math.cos(this.angle);
            this.point.y += this.speed*Math.sin(this.angle);
        }
    }

    Quadrangle(Canvas cnv, Color color, int speed, int id) {
        this.cnv = cnv;
        this.color = color;
        this.speed = speed;
        this.angle = Math.random()*2*Math.PI;
        this.g = cnv.getGraphics();
        this.id = id;
    }
}
