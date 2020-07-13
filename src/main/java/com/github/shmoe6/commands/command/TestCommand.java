package com.github.shmoe6.commands.command;

import com.github.shmoe6.commands.CommandContext;
import com.github.shmoe6.commands.ICommand;

public class TestCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage("Test Successful!").queue();
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getHelp() {
        return "Basic Test Command";
    }
}
