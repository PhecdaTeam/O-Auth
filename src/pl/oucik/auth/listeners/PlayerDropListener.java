package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import pl.oucik.auth.OAuth;

public class PlayerDropListener implements Listener {

    private final OAuth p;
    public PlayerDropListener(OAuth p){ this.p = p;}

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(!p.manager().getUser(e.getPlayer().getName()).islogged()){
            e.setCancelled(true);
        }
    }


}
