package Commands.MiscCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class Titties extends ListenerAdapter {
    String[] tittiestreamers = {
            "https://www.twitch.tv/inannastorm",
            "https://www.twitch.tv/anastasia_lexmur",
            "https://www.twitch.tv/ivysky",
            "https://www.twitch.tv/stellarztv",
            "https://www.twitch.tv/arilove",
            "https://www.twitch.tv/nanerboots",
            "https://www.twitch.tv/alinaarose",
            "https://www.twitch.tv/indiefoxx",
            "https://www.twitch.tv/lunalanie",
            "https://www.twitch.tv/annacomix",
            "https://www.twitch.tv/rainnie_bunny",
            "https://www.twitch.tv/varvaria",
            "https://www.twitch.tv/amouranth",
            "https://www.twitch.tv/chickensoup4the",
            "https://www.twitch.tv/xoaeriel",
            "https://www.twitch.tv/thenicolet",
            "https://www.twitch.tv/rolloutrena"
    };
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getMessage().getContentRaw().equals("b!tits")) {
            int min = 1;
            int max = 16;
            int quotenum = (int) (Math.random() * (max - min + 1) + min);
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("🌟   E-Thot Time!   🌟");
            embed.setDescription(tittiestreamers[quotenum]);
            embed.setColor(0x005dfc);
            e.getChannel().sendMessage(embed.build()).queue();
        }
        if (e.getMessage().getContentRaw().startsWith("b!submit")) {
            String[] args = e.getMessage().getContentRaw().split("\\s+");
            String Author = e.getAuthor().getAsTag();
            Guild Guild = e.getGuild();
            EmbedBuilder embed2 = new EmbedBuilder();
            /*
            embed2.setTitle("E-Thot Request");
            embed2.setDescription("User: " + Author + " in " + Channel + Guild + "has requested" + Link + "be added to the twitch e thots list");
            */
            embed2.setTitle("🌟   Request Submitted   🌟");
            embed2.setDescription("Your request to add " + args[1] + " has been processed and may be added soon");
            embed2.setColor(0x005dfc);
            e.getChannel().sendMessage(embed2.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));

            System.out.println("User: " + Author + " in " + Guild + " has requested " + args[1] + " be added to the twitch e thots list");
        }
    }

}