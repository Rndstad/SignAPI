package me.rndstad.signapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SignUpdateEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private String[] signText;
    private Player player;

    public SignUpdateEvent(Player player, String[] signText) {
        this.player = player;
        this.signText = signText;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String[] getSignText() {
        return this.signText;
    }
}

