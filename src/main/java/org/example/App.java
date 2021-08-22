package org.example;

import org.example.configuration.RootConfiguration;
import org.example.gui.MainWindow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args ) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfiguration.class);
        MainWindow mainWindow = (MainWindow) applicationContext.getBean("mainWindow");
        mainWindow.go();
    }
}
