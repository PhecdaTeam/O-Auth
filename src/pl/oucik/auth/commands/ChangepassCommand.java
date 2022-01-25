package pl.oucik.auth.commands;

import com.google.common.hash.Hashing;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.oucik.auth.OAuth;
import pl.oucik.auth.helper.ChatHelper;
import pl.oucik.auth.objects.User;

import java.nio.charset.StandardCharsets;

public class ChangepassCommand implements CommandExecutor {

    private final OAuth p;
    public ChangepassCommand(OAuth p){
        this.p=p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        User user = p.manager().getUser(sender.getName());
        if (!user.islogged()){
            sender.sendMessage(ChatHelper.color(p.conf().not_logged));
            return true;
        }

        if(args.length<2){
            sender.sendMessage(ChatHelper.color(p.conf().changepass));
            return true;
        }

        if(!Hashing.md5().hashBytes(args[0].getBytes(StandardCharsets.UTF_8)).toString().equals(user.getPassword())){
            sender.sendMessage(ChatHelper.color(p.conf().invalid_password));
            return true;
        }

        user.setPassword(Hashing.md5().hashBytes(args[1].getBytes(StandardCharsets.UTF_8)).toString());
        sender.sendMessage(ChatHelper.color(p.conf().changed_pass));
        return true;
    }
}
