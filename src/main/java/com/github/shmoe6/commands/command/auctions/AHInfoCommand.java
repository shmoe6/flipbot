package com.github.shmoe6.commands.command.auctions;

import com.github.shmoe6.commands.CommandContext;
import com.github.shmoe6.commands.ICommand;

public class AHInfoCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        return;
    }


    @Override
    public String getName() {
        return "ahinfo";
    }

    @Override
    public String getHelp() {
        return "Returns auction info for the specified item.";
    }

}
