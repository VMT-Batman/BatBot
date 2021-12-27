import Commands.AdminCommands.Clear;
import Commands.AdminCommands.Kick;
import Commands.AdminCommands.UserInfo;
import Commands.AdminCommands.Warn;
import Commands.CommandIndex;
import Commands.Invite;
import Commands.MiscCommands.Hermes;
import Commands.MiscCommands.Mute;
import Commands.MiscCommands.PersonalCommands;
import Commands.MiscCommands.Titties;
import Commands.VoiceCommands.PlayCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args){
        JDABuilder jdaBuilder = JDABuilder.createDefault("NzQwMzA5NDA4NzU1NzQ0ODI4.XynI3Q.SbhqHThEBxwvZnn3HsDQnaefRec");
        JDA jda = null;
        jdaBuilder.setActivity(Activity.streaming("b!help","https://www.youtube.com/watch?v=Lrj2Hq7xqQ8"));

        //jdaBuilder.setStatus(OnlineStatus.DO_NOT_DISTURB); jdaBuilder.setActivity(Activity.listening("In Maintenence Mode"));

        CommandIndex commandIndex = new CommandIndex();
        jdaBuilder.addEventListeners(commandIndex);

        PersonalCommands personalCommands = new PersonalCommands();
        jdaBuilder.addEventListeners(personalCommands);

        Invite invite = new Invite();
        jdaBuilder.addEventListeners(invite);

        Clear clear = new Clear();
        jdaBuilder.addEventListeners(clear);

        Warn warn = new Warn();
        jdaBuilder.addEventListeners(warn);

        Hermes hermes = new Hermes();
        jdaBuilder.addEventListeners(hermes);


        Kick kick = new Kick();
        jdaBuilder.addEventListeners(kick);

        PlayCommand playCommand = new PlayCommand();
        jdaBuilder.addEventListeners(playCommand);

        Mute mute = new Mute();
        jdaBuilder.addEventListeners(mute);

        Titties titties = new Titties();
        jdaBuilder.addEventListeners(titties);

        UserInfo userinfo = new UserInfo();
        jdaBuilder.addEventListeners(userinfo);

        try {
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        try {
            jda.awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
