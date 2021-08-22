package org.example.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class HistoryButtonListener implements ActionListener {

    private Goable historyWindow;

    @Override
    public void actionPerformed(ActionEvent e) {
        historyWindow.go();
    }

    @Autowired
    public void setHistoryWindow(Goable historyWindow) {
        this.historyWindow = historyWindow;
    }
}
