package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import pl.oucik.auth.OAuth;

public class PlayerInventoryOpenListener implements Listener {

    private final OAuth p;
    public PlayerInventoryOpenListener(OAuth p){ this.p = p;}

    @EventHandler
    public void onOpen(InventoryOpenEvent e){
        if(!p.manager().getUser(e.getPlayer().getName()).islogged()){
            e.setCancelled(true);
        }
    }

}
