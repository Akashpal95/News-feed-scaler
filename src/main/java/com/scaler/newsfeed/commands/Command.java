package com.scaler.newsfeed.commands;

public interface Command {

    boolean canExecute(String input);

    void execute(String input);
}
