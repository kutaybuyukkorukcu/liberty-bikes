package org.libertybikes.player.service;

public class PlayerStats {

    public int totalGames;

    public int numWins;

    public int rating = 1000;

    public double winLossRatio() {
        return totalGames == 0 ? 0 : numWins / totalGames;
    }

}
