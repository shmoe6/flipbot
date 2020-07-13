package com.github.shmoe6;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import zone.nora.slothpixel.Slothpixel;
import zone.nora.slothpixel.skyblock.auctions.SkyblockAuction;
import zone.nora.slothpixel.skyblock.auctions.bids.SkyblockAuctionBid;

import javax.security.auth.login.LoginException;

public class Bot {

    private Bot() throws LoginException {

        new JDABuilder()
                .setToken(Config.get("token"))
                .addEventListeners(new Listener())
                .setActivity(Activity.watching("The Hypixel Skyblock Auction House"))
                .build();

    }

    public static void main(String[] args) throws LoginException {
        new Bot();
    }

}