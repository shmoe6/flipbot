package com.github.shmoe6.commands.command.players;

import com.github.shmoe6.Config;
import com.github.shmoe6.commands.CommandContext;
import com.github.shmoe6.commands.ICommand;
import com.github.shmoe6.utils.PlayerUtils;
import com.google.gson.JsonObject;
import net.dv8tion.jda.api.entities.TextChannel;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.util.ILeveling;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import zone.nora.slothpixel.player.Player;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PlayerLevelCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) throws ExecutionException, InterruptedException, IOException {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        String uuid = PlayerUtils.getUUID(args.get(0));

        if (args.isEmpty()) {
            channel.sendMessage("Please specify a username.").queue();
            return;
        }

        channel.sendMessage(uuid).queue();
        /*
        HypixelAPI api = new HypixelAPI(UUID.fromString(Config.get("API_KEY")));
        JsonObject player = api.getPlayerByUuid(uuid).get().getPlayer();
        double networkExp = player.get("networkExp").getAsDouble();
        System.out.println("Player Level: " + ILeveling.getLevel(networkExp));
        api.shutdown();
         */
    }

    @Override
    public String getName() {
        return "playerlevel";
    }

    @Override
    public String getHelp() {
        return "Returns the specified player's Hypixel Level";
    }

}
