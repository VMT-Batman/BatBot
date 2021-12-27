package Commands.MiscCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PersonalCommands extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        MessageChannel channel = e.getChannel();
        String message = e.getMessage().getContentRaw();

        if (message.equals("b!bio")) {
            channel.sendMessage("`Papa Bio is a god.`").queue();
        }
        if (message.contains(":Beebz:")) {
            channel.sendMessage("Its Complicated").queue();
        }
        if (message.contains("beebz")) {
            channel.sendMessage("Atmosphere's Kitten").queue();
            
        }
        if (message.equals("b!riley")) {
            channel.sendMessage("`I'm still coming for your dick tomorrow. Ignore me all you like, I have a key.`").queue();
        }
        if (message.equals("b!juda")) {
            channel.sendMessage("`hack to kill pacifist playeur pls pacific playeur top foodbuild please give hack kill`").queue();
        }
        if (message.equals("b!sookan")) {
            channel.sendMessage("`SOOKAN THESE NUTS NIGGA`").queue();
        }
        if (message.equals("b!rogue")) {
            channel.sendMessage("```diff\n" +
                    "-Rogue is bae\n" +
                    "```").queue();
        }
        /*if (message.contains("fork")||message.contains("Fork")) {
            channel.sendMessage("ALL HAIL FORK").queue();
        }*/
        /* if (message.equals("b!hermes")){
            String batmanAvatarImage = "https://cdn.discordapp.com/avatars/234339845680398336/a_53be66ea2e72d354a6b1a03d021f19ca.webp?size=4096";
            String batBotAvatar = "https://cdn.discordapp.com/avatars/740309408755744828/965296483eca89420ff6688dffa41100.png?size=4096";
            e.getChannel().sendTyping().queue();
            EmbedBuilder info = new EmbedBuilder();
            info.setThumbnail(batBotAvatar);
            info.setTitle("Hermes Command");
            info.setDescription("The Hermes Command has been removed as Hermes appears to be a changed man. If theres evidence that these changes have been reverted, the command will return.");
            info.addField("Code for Hermes Command:","https://github.com/VMT-Batman/BatBot/blob/master/Hermes.java", false);
            info.setColor(0x000000);
            info.setFooter("Created By Batman#0002", batmanAvatarImage);

            channel.sendMessage(info.build()).queue();
            info.clear();
        } */

        if (e.getMessage().getContentRaw().contains("b!confirm")) {
            int min = 1;
            int max = 2;
            int truefalse = (int) (Math.random() * (max - min + 1) + min);
            if (truefalse == 1) {
                e.getChannel().sendMessage("`mmmm yes, what has been said is true`").queue();
            }
            if (truefalse == 2) {
                e.getChannel().sendMessage("`nahhh thats not true in the slightest`").queue();
            }
        }
        if (args[0].equalsIgnoreCase("b!batman")) {
            int min = 1;
            int max = 110;
            int num = (int) (Math.random() * (max - min + 1) + min);
            EmbedBuilder embed = new EmbedBuilder();
            String target = e.getMessage().getMentionedMembers().get(0).getEffectiveName();
            embed.setColor(0x0038FA);
            embed.setTitle(target + " has a Mexican Rating of " + num + "%");
            if (num < 50){
                embed.setDescription("*You might wanna eat some tacos or something ese, you ain't a real Mexican*");
            }
            else if (num < 75){
                embed.setDescription("*You've got some mexican in you, but its not enough to be a true Mexican God*");
            }
            else {
                embed.setDescription("*Oi chico, your veins must be filled with taco juice, you are a real Mexican*");
            }
            e.getChannel().sendMessage(embed.build()).queue();
        }

    }
}
