package com.github.shmoe6.commands;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ICommand {
    void handle(CommandContext ctx) throws ExecutionException, InterruptedException, IOException;

    String getName();

    String getHelp();

    default List<String> getAliases() {
        return Arrays.asList();
    }
}