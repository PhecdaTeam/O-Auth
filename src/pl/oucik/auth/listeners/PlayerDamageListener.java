package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.oucik.auth.OAuth;

public class PlayerDamageListener implements Listener {

    private final OAuth p;
    public PlayerDamageListener(OAuth p){ this.p = p;}

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(!p.manager().getUser(e.getDamager().getName()).islogged()){
            e.setCancelled(true);
        }
    }

}
