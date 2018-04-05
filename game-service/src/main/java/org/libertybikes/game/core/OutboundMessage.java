/**
 *
 */
package org.libertybikes.game.core;

import java.util.Set;

import javax.json.bind.annotation.JsonbProperty;

public class OutboundMessage {

    public static class PlayerList {
        @JsonbProperty("playerlist")
        public final Player[] playerlist;

        public PlayerList(Set<Player> players) {
            if (players.size() > 0) {
                // Send players in proper order, padding out empty slots with "Bot Player"
                playerlist = new Player[Player.MAX_PLAYERS];
                for (Player p : players)
                    playerlist[p.playerNum] = p;
                for (int i = 0; i < Player.MAX_PLAYERS; i++)
                    if (playerlist[i] == null)
                        playerlist[i] = new Player("", "Bot Player", (short) i);
            } else {
                // If no players are in the game yet, do not show all bot players
                playerlist = new Player[0];
            }
        }
    }

    public static class RequeueGame {
        @JsonbProperty("requeue")
        public final String roundId;

        public RequeueGame(String nextRoundId) {
            this.roundId = nextRoundId;
        }
    }

    public static class StartingCountdown {
        @JsonbProperty("countdown")
        public final int seconds;

        public StartingCountdown(int startingSeconds) {
            this.seconds = startingSeconds;
        }
    }

    public static class Heartbeat {
        @JsonbProperty("keepAlive")
        public final boolean keepAlive = true;

        public Heartbeat() {}
    }

}