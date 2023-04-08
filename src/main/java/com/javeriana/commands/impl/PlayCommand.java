package com.javeriana.commands.impl;

import com.javeriana.commands.ICommand;
import com.javeriana.commands.Receiver;

public class PlayCommand implements ICommand {

    private Receiver receiver;

    public PlayCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.play();
    }
}
