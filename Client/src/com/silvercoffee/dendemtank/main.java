package com.silvercoffee.dendemtank;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;

public class main {
    public static void main(String[] args) {


        try {
            AppGameContainer app = new AppGameContainer(new ScalableGame(new StateManager(), 800, 600));
            app.setDisplayMode(800, 600, false);
            app.setTitle("dendemtank");
            //app.setIcon("res/icons/32x32.tga");
            app.setAlwaysRender(true);
//            if (app instanceof AppGameContainer) {
//                app.setIcons(new String[]{"res/icons/32x32.tga", "res/icons/24x24.tga", "res/icons/16x16.tga"});
//            }
            app.setTargetFrameRate(60);
            app.setVSync(true);
            app.setVerbose(false);
            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }


    }
}
