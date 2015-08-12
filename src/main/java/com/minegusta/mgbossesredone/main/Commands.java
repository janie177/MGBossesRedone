package com.minegusta.mgbossesredone.main;

import com.minegusta.mgbossesredone.commands.BossCommand;
import org.bukkit.command.CommandExecutor;

public enum Commands {

    BOSSCOMMAND("boss", new BossCommand());

    private CommandExecutor commandExecutor;
    private String command;

    Commands(String command, CommandExecutor commandExecutor)
    {
        this.commandExecutor = commandExecutor;
        this.command = command;
    }

    public String getCommand()
    {
        return command;
    }

    public CommandExecutor getExecutor()
    {
        return commandExecutor;
    }
}
