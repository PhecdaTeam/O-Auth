package pl.oucik.auth.managers;

import org.bukkit.entity.Player;
import java.util.UUID;
import java.util.WeakHashMap;

public class CaptchaManager {

    private final WeakHashMap<Player, String > hashMap = new WeakHashMap<>();

    public void genCaptcha(Player player){
        String captcha = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        hashMap.put(player, captcha);
    }

    public String getCaptcha(Player player){
        if(hashMap.get(player)==null) {
         genCaptcha(player);
        }
        return hashMap.get(player);
    }

    public void removeCaptcha(Player player){
        hashMap.remove(player);
    }

}
