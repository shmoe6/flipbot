package com.github.shmoe6.commands.command.auctions;

import com.github.shmoe6.commands.CommandContext;
import com.github.shmoe6.commands.ICommand;
import com.github.shmoe6.utils.Utils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class AHInfoCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) throws IOException {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        if (args.isEmpty()) {
            channel.sendMessage("Please specify an item. It should look like \"aspect of the dragons\" or \"strong dragon boots\"").queue();
            return;
        }

        StringBuilder builder = new StringBuilder();

        for(String s : args) {
            builder.append(s).append("_");
        }

        String itemID = builder.toString();
        JSONObject json = Utils.readJsonFromUrl("https://api.slothpixel.me/api/skyblock/auctions/" + Utils.formatItemID(itemID));

        try {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.MAGENTA);
            embed.setTitle("Auction Data for: ".concat(Utils.formatItemID(itemID)));
            embed.addField("Average Price: ", Utils.addCommas((int) json.get("average_price")).concat(" Coins"), false);
            embed.addField("Median Price: ", Utils.addCommas((int) json.get("median_price")).concat(" Coins"), false);
            embed.addField("Standard Deviation: ", Utils.addCommas((int) json.get("standard_deviation")).concat(" Coins"), false);
            embed.addField("Min. Price: ", Utils.addCommas((int) json.get("min_price")).concat(" Coins"), false);
            embed.addField("Max. Price: ", Utils.addCommas((int) json.get("max_price")).concat(" Coins"), false);
            embed.setFooter("Created by: Shmoe6#1746. Data obtained through the Slothpixel API https://docs.slothpixel.me/");
            channel.sendMessage(embed.build()).queue();
        } catch (Exception e) {
            channel.sendMessage("An error has occurred. Try again and make sure the item name looks like \"aspect of the dragons\" or \"strong dragon boots\". If the error persists, message Shmoe6#1746 with details on the issue").queue();
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

}
