package model.sendplay;

import model.exceptions.TooManyPlayersException;

import java.util.List;

public interface Player {

    Boolean addPlayers(List<Player> players) throws TooManyPlayersException;

    String getNamePlayer();

}
