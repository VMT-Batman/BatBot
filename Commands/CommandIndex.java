package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandIndex extends ListenerAdapter {
    String batmanAvatarImage = "https://cdn.discordapp.com/avatars/234339845680398336/a_53be66ea2e72d354a6b1a03d021f19ca.webp?size=4096";
    String batBotAvatar = "https://cdn.discordapp.com/avatars/740309408755744828/965296483eca89420ff6688dffa41100.png?size=4096";
    public void onMessageReceived(MessageReceivedEvent e){



        if (e.getMessage().getContentRaw().equals("b!help")){
            e.getChannel().sendTyping().queue();
            EmbedBuilder info = new EmbedBuilder();
            info.setThumbnail(batBotAvatar);
            info.setTitle("--| BatBot Commands (WIP) |--");
            info.setDescription("These are a list of the current commands BatBot has.");
            info.addField("`b!help`","Lists all of BatBots Commands\n",true);
            info.addField("`b!invite`", "Sends a link that allows people to add BatBot to their server", true);
            info.addField("Misc Commands","For any other commands, please visit my wiki https://github.com/VMT-Batman/BatBot/wiki", false);
            info.setColor(0x000000);
            info.setFooter("Created By Batman#0002", batmanAvatarImage);

            e.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }
    }
}
