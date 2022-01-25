package pl.oucik.auth.managers;

import org.bukkit.entity.Player;
import pl.oucik.auth.OAuth;
import pl.oucik.auth.objects.User;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

     private final OAuth plugin;
     public UserManager(OAuth plugin){
         this.plugin=plugin;
     }

     private final ConcurrentHashMap<String, User> user = new ConcurrentHashMap();

     public User getUser(String user){
         return (User)this.user.get(user);
     }

     public void create(Player player){
         User user = new User(plugin, player);
         this.user.put(player.getName(), user);
     }

     public void load(){
      plugin.getSql().query("SELECT * FROM OAuth", rs -> {
          while (rs.next()){
              User user = new User(plugin, rs);
              this.user.put(user.getName(), user);
          }
          System.out.println("Successfully loaded " + user.size() + " users! [5/5]");
      });

     }
}
