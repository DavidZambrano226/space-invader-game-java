package com.javeriana.commands;


import java.util.ArrayList;
import java.util.List;

public class InvokerCommand {
    private final List<ICommand> commands = new ArrayList<>();

    public void executeCommand(ICommand command) {
        commands.add(command);
        command.execute();
    }
}
