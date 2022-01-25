package pl.oucik.auth.commands;

import com.google.common.hash.Hashing;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.oucik.auth.OAuth;
import pl.oucik.auth.helper.ChatHelper;
import pl.oucik.auth.objects.User;
import java.nio.charset.StandardCharsets;

public class LoginCommand implements CommandExecutor {

    private final OAuth p;
    public LoginCommand(OAuth p){
        this.p=p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        User user = p.manager().getUser(sender.getName());

        if(p.conf().captcha){

            if(!user.isRegistered()){
                sender.sendMessage(ChatHelper.color(p.conf().register));
                return true;
            }

            if(args.length<2){
                sender.sendMessage(ChatHelper.color(p.conf().login));
                return true;
            }

            if(!args[1].equals(p.getCaptchaManager().getCaptcha((Player) sender))){
                sender.sendMessage(ChatHelper.color(p.conf().invalid_captcha));
                return true;
            }

        }else {
            if(!user.isRegistered()){
                sender.sendMessage(ChatHelper.color(p.conf().register.replace("<captcha>", "")));
                return true;
            }

            if(args.length<1){
                sender.sendMessage(ChatHelper.color(p.conf().login.replace("<captcha>", "")));
                return true;
            }

        }
        if(!Hashing.md5().hashBytes(args[0].getBytes(StandardCharsets.UTF_8)).toString().equals(user.getPassword())){
            sender.sendMessage(ChatHelper.color(p.conf().invalid_password));
            return true;
        }
        user.setLogged(true);
        sender.sendMessage(ChatHelper.color(p.conf().logged));

        return true;
    }
}
