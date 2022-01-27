package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.oucik.auth.OAuth;

public class PlayerChatMessageLisener implements Listener {

    private final OAuth p;
    public PlayerChatMessageLisener(OAuth p){ this.p = p;}

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent e){
        if(!p.manager().getUser(e.getPlayer().getName()).islogged()){
            e.setCancelled(true);
        }
    }

}
