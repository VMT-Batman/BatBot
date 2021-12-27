package Commands.AdminCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Warn extends ListenerAdapter {

    public static void warnUsage(MessageReceivedEvent e){
        EmbedBuilder usage = new EmbedBuilder();
        usage.setColor(0xff3923);
        usage.setTitle("Ping the person you would like to warn");
        usage.setDescription("Usage: `b!warn @literallyanyone <reason in a word>`");
        e.getChannel().sendMessage(usage.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        MessageChannel channel = e.getChannel();
        if (args[0].equalsIgnoreCase("b!warn")) {

            if (e.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                if (args.length < 2) { warnUsage(e); }
                else {
                    try {
                        EmbedBuilder usage = new EmbedBuilder();
                        usage.setColor(Color.orange);
                        usage.setDescription(args[1] + ", you have been warned for '" + args[2] + "'");
                        channel.sendMessage(usage.build()).queue();
                    }
                    catch (IllegalArgumentException | ArrayIndexOutOfBoundsException illegal){ warnUsage(e); }
                }
            }
            else {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(0xff3923);
                usage.setTitle("🔴 You don't have permission to do that");
                usage.setDescription("This command is limited to members who have the 'Administrator' permission");
                channel.sendMessage(usage.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
            }
        }
        if (args[0].equalsIgnoreCase("b!verify") && e.getMember().hasPermission(Permission.MANAGE_ROLES)) {
            e.getMessage().delete().queue();
            Member target = e.getMessage().getMentionedMembers().get(0);
            Role role = e.getGuild().getRolesByName("unverified", true).get(0);
            e.getGuild().removeRoleFromMember(target, role).queue();
        }
    }
}
