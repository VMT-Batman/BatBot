package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Invite extends ListenerAdapter{

    String batBotAvatar = new CommandIndex().batBotAvatar;
    String batmanAvatarImage = new CommandIndex().batmanAvatarImage;
    String url = "https://discord.com/oauth2/authorize?client_id=740309408755744828&scope=bot"; //Invite
    String url4 = "https://cdn.discordapp.com/attachments/743543576847450165/786978369522761728/ze_bobby_pin.mp4";
    String url5 = "https://gyazo.com/8c2750bf6ac15ee3d581d302cb0ca941";
    String url8 = "https://cdn.discordapp.com/attachments/743543576847450165/743545417815293953/PitLast.png"; //PitLast
    String url9 = "https://cdn.discordapp.com/attachments/743543576847450165/743545448903475310/raiderpit.png"; //RaiderPit
    String url10 = "https://cdn.discordapp.com/attachments/743543576847450165/743545467157086259/RileyTOes.jpg"; //RileyTOes
    String url11 = "https://cdn.discordapp.com/attachments/743543576847450165/776524768026427412/giphy.gif";
    String url12 = "https://cdn.discordapp.com/attachments/743543576847450165/780288358693077022/doom_update_medium_bitrate.mp4";
    String url13 = "https://cdn.discordapp.com/attachments/743543576847450165/780311422256021514/image0.jpeg";
    String url14 = "https://superkumi.atshop.io/";
    String url15 = "https://cdn.discordapp.com/attachments/743543576847450165/786438580682883072/goblin_gets_pwned.mp4";
    String url16 = "https://open.spotify.com/playlist/2n00CqkjXVyb5GBSGJMWvh?si=45cQ2pDMQ7GjEEHQ9oicIw";
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        String message = e.getMessage().getContentRaw();
        MessageChannel channel = e.getChannel();
        String queue = e.getJDA().getSelfUser().getId();
        if (message.equals("b!invite")){
            EmbedBuilder info = new EmbedBuilder();
            info.setThumbnail(batBotAvatar);
            info.setTitle("✨ BatBot Invitation Link ✨");
            info.addField("Boom, use the link below to invite BatBot to your server:",url, false);
            info.setColor(0x000000);
            info.setFooter("Created By Batman#0002", batmanAvatarImage);
            channel.sendMessage(info.build()).queue();
        }
        //if (message.equals("b!pit")) {
        //    channel.sendMessage(String.format(url5, queue)).queue();
        //    channel.sendMessage(String.format(url9, queue)).queue();
        //    channel.sendMessage(String.format(url8, queue)).queue();
        //}
        if (message.equals("b!riley")) {
            channel.sendMessage(String.format(url10, queue)).queue();
        }
        if (message.equals("b!starbucks")) {
            channel.sendMessage(String.format(url14, queue)).queue();
        }
        if (message.equals("b!finch")){
            channel.sendMessage(String.format(url11, queue)).queue();
        }
        if (message.equals("b!doom")){
            channel.sendMessage(String.format(url12, queue)).queue();
        }
        if (message.equals("b!atmos")){
            channel.sendMessage(String.format(url13, queue)).queue();
        }
        if (message.equals("b!goblin")){
            channel.sendMessage(String.format(url15, queue)).queue();
        }
        if (message.equals("b!bobbypin")){
            channel.sendMessage(String.format(url4, queue)).queue();
        }
        if (message.equals("b!throwback")){
            channel.sendMessage(String.format(url16, queue)).queue();
        }
    }
}
