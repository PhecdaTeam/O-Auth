package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import pl.oucik.auth.OAuth;

public class PlayerBreakBlockListener implements Listener {

    private final OAuth p;
    public PlayerBreakBlockListener(OAuth p){ this.p = p;}

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(!p.manager().getUser(e.getPlayer().getName()).islogged()){
            e.setCancelled(true);
        }
    }


}
