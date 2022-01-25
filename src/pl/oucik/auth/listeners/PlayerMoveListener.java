package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.oucik.auth.OAuth;

public class PlayerMoveListener implements Listener {

    private final OAuth p;
    public PlayerMoveListener(OAuth p){
        this.p=p;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
            if(!p.manager().getUser(e.getPlayer().getName()).islogged()){
                e.getPlayer().teleport(e.getFrom());
            }
        }
    }


}
