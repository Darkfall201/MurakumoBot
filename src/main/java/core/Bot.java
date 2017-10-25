package core;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Secrets;

import javax.security.auth.login.LoginException;

public class Bot {


    //Non error, no action exit codes.
    public static final int NEWLY_CREATED_CONFIG = 12;

    public static void main(String[] arguments) throws Exception
    {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(Secrets.TOKEN);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.of("I'm still under dev"));

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e){
            e.printStackTrace();

        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (RateLimitedException e){
            e.printStackTrace();
        }

    }
}
