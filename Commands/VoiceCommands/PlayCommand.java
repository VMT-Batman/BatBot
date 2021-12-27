package Commands.VoiceCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class PlayCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        String input = String.join(" ", args);
        PlayerManager manager = PlayerManager.getInstance();
        String userinput = e.getMessage().getContentRaw().toLowerCase();
        // Creates a variable equal to the channel that the user is in
        if (args[0].equals("b!play")) {
            TextChannel channel = e.getChannel();
            VoiceChannel connectedChannel = e.getMember().getVoiceState().getChannel();
            if (e.getGuild().getSelfMember().getVoiceState().getChannel() != connectedChannel) {
                if (!e.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
                    // The bot does not have permission to join any voice channel. Don't forget the .queue()!
                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(0xfff447);
                    success.setDescription("I do not have permission to connect to Voice Channel.");
                    e.getChannel().sendMessage(success.build()).queue();
                    return;
                }
                // Checks if they are in a channel -- not being in a channel means that the variable = null.
                if (connectedChannel == null) {
                    // Don't forget to .queue()!
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(0xff3923);
                    error.setDescription("You are not in a Voice Channel.");
                    e.getChannel().sendMessage(error.build()).queue();
                    return;
                }
                // Gets the audio manager.
                AudioManager audioManager = e.getGuild().getAudioManager();
                // When somebody really needs to chill.
                if (audioManager.isAttemptingToConnect()) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(0xff3923);
                    error.setDescription("The bot is trying to connect ...");
                    e.getChannel().sendMessage(error.build()).queue();
                    return;
                }
                // Connects to the channel.
                audioManager.openAudioConnection(connectedChannel);
                // Obviously people do not notice someone/something connecting.
                EmbedBuilder csuccess = new EmbedBuilder();
                csuccess.setColor(0xfff447);
                csuccess.setDescription("I have connected to `" + connectedChannel + "`");
                e.getChannel().sendMessage(csuccess.build()).queue();
                manager.loadAndPlay(e.getChannel(), args[1]);
                manager.getGuildMusicManager(e.getGuild()).player.setVolume(10);
            }
        }
        if (userinput.equals("b!leave")) {
            VoiceChannel connectedChannel = e.getMember().getVoiceState().getChannel();
            // Checks if the bot is connected to a voice channel.
            if (e.getGuild().getSelfMember().getVoiceState().getChannel()  == null) {
                // Get slightly fed up at the user.
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(0xff3923);
                error.setDescription("I am not in a Voice Channel to disconnect from.");
                e.getChannel().sendMessage(error.build()).queue();
                return;
            }
            // Disconnect from the channel.
            e.getGuild().getAudioManager().closeAudioConnection();
            // Notify the user.
            EmbedBuilder dcsuccess = new EmbedBuilder();
            dcsuccess.setColor(0xfff447);
            dcsuccess.setDescription("I have disconnected from `" + connectedChannel + "`");
            e.getChannel().sendMessage(dcsuccess.build()).queue();
        }
        if (e.getMessage().getContentRaw().equals("b!pause")) {
            manager.getGuildMusicManager(e.getGuild()).player.setPaused(true);
            e.getChannel().sendMessage("Music Paused").queue();
        }
        if (e.getMessage().getContentRaw().equals("b!stop")) {
            manager.getGuildMusicManager(e.getGuild()).player.stopTrack();
            e.getChannel().sendMessage("Music Stopped").queue();
        }
    }
}