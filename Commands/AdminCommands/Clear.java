package Commands.AdminCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Clear extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        TextChannel channel = event.getChannel();
        if (args[0].equalsIgnoreCase("b!clear")) {
            if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                if (args.length < 2) {
                    EmbedBuilder embed = new EmbedBuilder();
                    // Usage
                    embed.setColor(0xff3923);
                    embed.setTitle("Specify amount to delete");
                    embed.setDescription("Usage: `b!clear [# of messages]`");
                    channel.sendMessage(embed.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                }
                else {
                    // Success
                    try {
                        EmbedBuilder embed = new EmbedBuilder();
                        List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                        event.getChannel().deleteMessages(messages).queue();
                        embed.setColor(0x22ff2a);
                        embed.setTitle("✅ Successfully deleted " + args[1] + " messages.");
                        channel.sendMessage(embed.build()).queue( message -> message.delete().queueAfter(5, TimeUnit.SECONDS) );


                    }
                    // The person doesn't have a high enough role
                    catch (InsufficientPermissionException e){
                        EmbedBuilder embed = new EmbedBuilder();
                        embed.setColor(0xff3923);
                        embed.setTitle("🔴 Bot has insufficient permissions");
                        embed.setDescription("Check bot permissions to make sure it has either the Administrator permission or the Manage Messages permission.");
                        channel.sendMessage(embed.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                    }
                    // Too many messages
                    catch (IllegalArgumentException e) {
                        if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                            EmbedBuilder embed = new EmbedBuilder();
                            embed.setColor(0xff3923);
                            embed.setTitle("🔴 Too many messages selected");
                            embed.setDescription("Between 1-100 messages can be deleted at one time.");
                            channel.sendMessage(embed.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                        }
                        // Messages too old
                        else {
                            EmbedBuilder embed = new EmbedBuilder();
                            embed.setColor(0xff3923);
                            embed.setTitle("🔴 Selected messages are older than 2 weeks");
                            embed.setDescription("Messages older than 2 weeks cannot be deleted.");
                            channel.sendMessage(embed.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                        }
                    }
                }
            }
            // No perms
            else {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(0xff3923);
                embed.setTitle("🔴 You don't have permission to do that");
                embed.setDescription("This command is limited to members who have the 'Manage Messages' permission");
                channel.sendMessage(embed.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
            }
        }
    }
}
