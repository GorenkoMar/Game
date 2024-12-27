package ru.netology.javaqa.game.services;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Player " + playerName + " is not registered");
    }
}
