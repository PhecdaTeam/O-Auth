package pl.oucik.auth.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.oucik.auth.OAuth;
import pl.oucik.auth.helper.ChatHelper;

public class PlayerJoinListener implements Listener {

    private final OAuth p;
    public PlayerJoinListener(OAuth p){ this.p=p; }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.getPlayer().teleport(p.conf().spawn);
        ChatHelper.title(event.getPlayer(), p.conf().prefix, p.conf().welcome_message, 10, 40, 10);
        event.setJoinMessage(ChatHelper.color(p.conf().welcome_format.replace("{PLAYER}", event.getPlayer().getName())));
        if(p.manager().getUser(event.getPlayer().getName()) == null){ p.manager().create(event.getPlayer()); }

        if(!p.manager().getUser(event.getPlayer().getName()).isRegistered()){
            if(p.conf().captcha){
                event.getPlayer().sendMessage(ChatHelper.color(p.conf().register));
            }else { event.getPlayer().sendMessage(ChatHelper.color(p.conf().register).replace("<captcha>", "")); }
        }else{
            if(p.conf().captcha) {
                event.getPlayer().sendMessage(ChatHelper.color(p.conf().login));
            }else {
                event.getPlayer().sendMessage(ChatHelper.color(p.conf().login.replace("<captcha>", "")));
            }
        }

    }

}
