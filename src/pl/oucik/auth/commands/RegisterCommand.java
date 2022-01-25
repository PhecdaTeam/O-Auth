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

public class RegisterCommand implements CommandExecutor {

    private final OAuth p;
    public RegisterCommand(OAuth p){
        this.p=p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        User user = p.manager().getUser(sender.getName());
        if(user.isRegistered()){
            sender.sendMessage(ChatHelper.color(p.conf().already_registered));
            sender.sendMessage(ChatHelper.color(p.conf().login));
            return true;
        }

        if(p.conf().captcha){
            if(args.length<3){
                sender.sendMessage(ChatHelper.color(p.conf().register));
                return true;
            }

            if(!args[0].equals(args[1])){
                sender.sendMessage(ChatHelper.color(p.conf().not_same_password));
                return true;
            }

            if(!args[2].equals(p.getCaptchaManager().getCaptcha((Player) sender))){
                sender.sendMessage(ChatHelper.color(p.conf().invalid_captcha));
                return true;
            }

        }else {
            if(args.length<2){
                sender.sendMessage(ChatHelper.color(p.conf().register.replace("<captcha>", "")));
                return true;
            }

            if(!args[0].equals(args[1])){
                sender.sendMessage(ChatHelper.color(p.conf().not_same_password));
                return true;
            }


        }
        user.setRegistered(true);
        user.setPassword(Hashing.md5().hashBytes(args[0].getBytes(StandardCharsets.UTF_8)).toString());
        user.setLogged(true);
        sender.sendMessage(ChatHelper.color(p.conf().registered));


        return true;
    }
}
