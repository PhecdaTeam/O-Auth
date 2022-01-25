package pl.oucik.auth.task;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import pl.oucik.auth.OAuth;
import pl.oucik.auth.helper.ChatHelper;

public class CaptchaTask extends BukkitRunnable {

    private final OAuth p;
    public CaptchaTask(OAuth p){
        this.p=p;
    }

    // why.
    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            ChatHelper.actionBar(player, p.conf().captcha_message.replace("{CAPTCHA}", p.getCaptchaManager().getCaptcha(player)));
        });
    }
}
