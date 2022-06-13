package ui;

import input.MouseInput;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {

    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private Boolean mouseIn;
    private Rectangle boundingBox;

    private Action action;
    private String text;

    public Button(
        BufferedImage mouseOutImg,
        BufferedImage mouseInImg,
        Integer x, Integer y,
        String text,
        Action action
        ) {
        this.mouseInImg = mouseInImg;
        this.mouseOutImg = mouseOutImg;
        this.text = text;
        boundingBox = new Rectangle(x,y,mouseInImg.getWidth(),mouseInImg.getHeight());
        this.action = action;
    }

    public void  update(){
        if (boundingBox.contains(MouseInput.X,MouseInput.Y)){
            mouseIn = true;
        } else {
            mouseIn = false;
        }

        if (mouseIn && MouseInput.MLB){
            action.doAction();
        }
    }
    public void draw(Graphics g){
        if (mouseIn){
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
        } else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
        }
        //g.setColor(Color.black);
        g.setFont(new Font( "Arial",Font.BOLD,19));
        g.drawString(text, boundingBox.x+65,boundingBox.y+30);
    }
}
