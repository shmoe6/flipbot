package com.github.shmoe6.commands.command.auctions;

import com.github.shmoe6.commands.CommandContext;
import com.github.shmoe6.commands.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;
import net.hypixel.example.ExampleUtil;
import net.hypixel.api.HypixelAPI;

import java.util.List;

public class AHInfoCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        if (args.isEmpty()) {
            channel.sendMessage("Please specify an ITEM_ID to get information on. ITEM_IDs can be found on the skyblock wiki and look like: RAIDER_AXE").queue();
        }


    }

    @Override
    public String getName() {
        return "ahinfo";
    }

    @Override
    public String getHelp() {
        return "Returns auction info for the specified item.";
    }

    private void getAuctions() {
        ExampleUtil.API.getSkyBlockAuctions(0).whenComplete((page0, throwable) -> {
            if (throwable != null) {
                throwable.printStackTrace();
                System.exit(0);
                return;
            }

            System.out.println(page0);
            if (page0.hasNextPage()) {
                ExampleUtil.API.getSkyBlockAuctions(page0.getPage() + 1).whenComplete(ExampleUtil.getTestConsumer());
            } else {
                System.exit(0);
            }
        });
        ExampleUtil.await();
    }
}
