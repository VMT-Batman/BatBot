package Commands.MiscCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class Mute extends ListenerAdapter {

    public static void muteUsage(MessageReceivedEvent e) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(0xff3923);
        embed.setTitle("Ping the person you would like to mute/unmute");
        embed.setDescription("Usage: `b!mute @LiterallyAnyone` or `b!unmute @WhoeversMuted` \n Make sure you have a role called Muted for the bot to give.");
        e.getChannel().sendMessage(embed.build()).queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase("b!mute")) {
            if (args.length > 2) {
                muteUsage(e);
            } else {
                if (e.getMember().hasPermission(Permission.MANAGE_ROLES)) {
                    EmbedBuilder embed = new EmbedBuilder();
                    Member target = e.getMessage().getMentionedMembers().get(0);
                    Role role = e.getGuild().getRolesByName("Muted", true).get(0);
                    e.getGuild().addRoleToMember(target, role).queue();
                    embed.setColor(0xFF0000);
                    embed.setDescription(args[1] + ", has been muted.");
                    e.getChannel().sendMessage(embed.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
                    System.out.print(target);
                } else {
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setColor(0xff3923);
                    embed.setTitle("🔴 You don't have permission to do that");
                    embed.setDescription("This command is limited to members who have the 'Manage Roles' permission.\n`Note: Make sure the BatBot also has a role that has the Manage Roles permission`");
                    e.getChannel().sendMessage(embed.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
                }
            }
        }
            if (args[0].equalsIgnoreCase("b!unmute")) {
                if (args.length > 2) { muteUsage(e); }
                else {
                    if (e.getMember().hasPermission(Permission.MANAGE_ROLES)) {
                        EmbedBuilder embed = new EmbedBuilder();
                        Member target = e.getMessage().getMentionedMembers().get(0);
                        Role role = e.getGuild().getRolesByName("Muted", true).get(0);
                        e.getGuild().removeRoleFromMember(target, role).queue();
                        embed.setColor(0x1BFF00);
                        embed.setDescription(args[1] + ", has been unmuted.");
                        e.getChannel().sendMessage(embed.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
                    }
                    else {
                        EmbedBuilder embed = new EmbedBuilder();
                        embed.setColor(0xff3923);
                        embed.setTitle("🔴 You don't have permission to do that");
                        embed.setDescription("This command is limited to members who have the 'Manage Roles' permission.\n`Note: Make sure the BatBot also has a role that has the Manage Roles permission`");
                        e.getChannel().sendMessage(embed.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
                    }
                }
            }
    }
}