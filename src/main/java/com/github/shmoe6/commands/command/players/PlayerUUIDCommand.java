package com.github.shmoe6.commands.command.players;

import com.github.shmoe6.commands.CommandContext;
import com.github.shmoe6.commands.ICommand;
import com.github.shmoe6.utils.Utils;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.IOException;
import java.util.List;

public class PlayerUUIDCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) throws IOException {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        if (args.isEmpty()) {
            channel.sendMessage("Please specify a player.");
        }

        String player = ctx.getArgs().get(0);
        String UUID = Utils.getTrimmedUUID(player);
        channel.sendMessage(UUID).queue();
    }

    @Override
    public String getName() {
        return "playeruuid";
    }

    @Override
    public String getHelp() {
        return "Displays the trimmed (no \"-\") UUID for the specified player";
    }
}
