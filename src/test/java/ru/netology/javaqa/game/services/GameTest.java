package ru.netology.javaqa.game.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class gameTest {

    List<Player> players = new ArrayList<>();
    Player player1 = new Player(2, "Predator", 78);
    Player player2 = new Player(15, "Alien", 93);
    Player player3 = new Player(7, "Sub-Zero", 78);
    Player player4 = new Player(17, "Godzilla", 201);

    @Test
    public void firstPlayerNotRegistered() {
        Game game = new Game();
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Predator", "Alien"));
    }

    @Test
    public void secondPlayerNotRegistered() {
        Game game = new Game();
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Predator", "Alien"));
    }

    @Test
    public void allPlayersNotRegistered() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Predator", "Alien"));
    }

    @Test
    public void firstPlayerWin() {
        Game game = new Game();
        game.register(player4);
        game.register(player3);
        int expected = 1;
        int actual = game.round("Godzilla", "Sub-Zero");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Game game = new Game();
        game.register(player2);
        game.register(player4);
        int expected = 2;
        int actual = game.round("Alien", "Godzilla");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersParity() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        int expected = 0;
        int actual = game.round("Predator", "Sub-Zero");
        Assertions.assertEquals(expected, actual);
    }


}






