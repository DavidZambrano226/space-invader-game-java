package com.javeriana.commands.impl;

import com.javeriana.commands.ICommand;
import com.javeriana.commands.Receiver;

public class CloseGameCommand implements ICommand {
    private Receiver receiver;

    public CloseGameCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.closeGame();
    }
}
