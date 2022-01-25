package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.oucik.auth.OAuth;
import pl.oucik.auth.helper.ChatHelper;
import pl.oucik.auth.objects.User;

public class PlayerQuitListener implements Listener {

    private final OAuth p;
    public PlayerQuitListener(OAuth p){ this.p=p; }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        User u = p.manager().getUser(e.getPlayer().getName());
        if(u.islogged()){
            u.setLogged(false);
        }
        e.setQuitMessage(ChatHelper.color(p.conf().quit_format.replace("{PLAYER}", e.getPlayer().getName())));
    }

}
