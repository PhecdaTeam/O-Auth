package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.oucik.auth.OAuth;
import java.util.Locale;

public class PlayerCommandListener implements Listener {

    private final OAuth p;
    public PlayerCommandListener(OAuth p){ this.p = p;}

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        if(!p.manager().getUser(e.getPlayer().getName()).islogged()){
            String cmd = e.getMessage().toLowerCase(Locale.ROOT);
            if (cmd.startsWith("/l") || cmd.startsWith("/login") || cmd.startsWith("/reg") || cmd.startsWith("/register") || cmd.startsWith("/changepass") || cmd.startsWith("/changepassword")){
                return;
            }
            e.setCancelled(true);
        }
    }

}
