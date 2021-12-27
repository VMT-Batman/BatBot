package Commands.AdminCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Kick extends ListenerAdapter {
    public static EmbedBuilder embed = new EmbedBuilder();

    public static void kickUsage(GuildMessageReceivedEvent e){
            embed.setColor(0xff3923);
            embed.setTitle("Ping the person you would like to kick");
            embed.setDescription("Usage: `b!kick @literallyanyone`");
            e.getChannel().sendMessage(embed.build()).queue();
    }
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        TextChannel channel = e.getChannel();
        if (args[0].equals("b!kick")){
            List<Member> mentionedMembers = e.getMessage().getMentionedMembers();
            Member target = mentionedMembers.get(0);
            if (args.length < 2){ kickUsage(e); }
            else {
                try {
                    if (e.getMember().hasPermission(Permission.KICK_MEMBERS) && e.getMember().canInteract(target)) {
                        e.getGuild().kick(target).complete();
                        embed.setColor(0xfff447);
                        embed.setDescription(args[1] + ", has been yeeted.");
                    }
                    else {
                        embed.setColor(0xff3923);
                        embed.setTitle("🔴 You don't have permission to do that");
                        embed.setDescription("This command is limited to members who have the 'Kick Members' permission.\n`Note: Make sure the BatBot also has a role that has the Kick Members permission`");
                    }
                    channel.sendMessage(embed.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                }
                catch (HierarchyException f) {
                    embed.setColor(0xff3923);
                    embed.setTitle("🔴 You can't do that");
                    embed.setDescription("This command must be used on someone with lower permissions than you.");
                    channel.sendMessage(embed.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
                }
            }
        }
    }
}
