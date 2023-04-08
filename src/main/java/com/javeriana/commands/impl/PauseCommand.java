package com.javeriana.commands.impl;

import com.javeriana.InterfazSpaceInvaders;
import com.javeriana.commands.ICommand;
import com.javeriana.commands.Receiver;

public class PauseCommand implements ICommand {

    private Receiver receiver;

    public PauseCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
       this.receiver.pause();
    }
}
