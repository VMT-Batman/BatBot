package Commands.AdminCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserInfo extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase("b!user")) {
                Member name;
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy"); //Time formatter
                try {
                    name = e.getMessage().getMentionedMembers().get(0);
                    EmbedBuilder eb = new EmbedBuilder();
                            eb.setColor(Color.YELLOW)
                            // .setThumbnail(target.getUser().getEffectiveAvatarUrl());
                            .setAuthor("Information on " + name.getUser().getName(), "http://www.google.com", name.getUser().getAvatarUrl())
                            .setDescription("```" + name.getUser().getName() + " was created "+ name.getTimeCreated().format(fmt) + " \n"  + name.getUser().getName() + " joined on " + name.getTimeJoined().format(fmt) + "```")
                            .addField("ID: ", name.getId(), true)
                            .addField("Mention: ", name.getAsMention(), false)
                            .addField("Tag: ", name.getUser().getAsTag(), false)
                            .addField("Roles:", getRolesAsString(name.getRoles()), true)
                            .addField("Game:", displayGameInfo(name), true)
                            .addField("Status:", name.getOnlineStatus().toString() , true)
                            .addField("Nickname: ", name.getNickname() == null ? "No Nickname" : name.getNickname(), true);
                    e.getChannel().sendMessage(eb.build()).queue();
                    e.getChannel().sendMessage(e.getAuthor().getAsMention() + " there you go").queue();
                }
                catch (IndexOutOfBoundsException ex) {
                    System.out.println("Exception Occured");
                    e.getChannel().sendMessage("You need to provide the name as a mention.").queue();
                }
        }
        if (args[0].equalsIgnoreCase("b!server")){
            EmbedBuilder embed = new EmbedBuilder();
            System.out.print(e.getGuild().getChannels().size());
                embed.setAuthor("Information on " + e.getGuild().getName() ,"https://google.com" , e.getGuild().getIconUrl());
                embed.setColor(Color.PINK);
                //embed.addField("Owner: ", e.getGuild().getOwner().getUser().getAsMention() , true);
                embed.addField("Boost Count: ", String.valueOf(e.getGuild().getBoostCount()) , true);
                embed.addField("Region: ", e.getGuild().getRegion().toString() , true);
                // embed.addField("Description: ", e.getGuild().getDescription() , true);
            e.getChannel().sendMessage(embed.build()).queue();
        }
        if (args[0].equalsIgnoreCase("b!avatar")){
            if (args.length == 2) {
                Member name;
                name = e.getMessage().getMentionedMembers().get(0);
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(0x02ffb5);
                embed.setTitle("Here is " + name.getUser().getName() + "'s profile picture!");
                embed.setImage(name.getUser().getAvatarUrl());
                e.getChannel().sendMessage(embed.build()).queue();
            }
            else {
                User author = e.getAuthor();
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(0x02ffb5);
                embed.setTitle("Here is " + e.getAuthor().getName() + "'s profile picture!");
                embed.setImage(author.getAvatarUrl());
                e.getChannel().sendMessage(embed.build()).queue();
            }
        }
    }
        //Display game status
        private String displayGameInfo (Member name){
            try {
                String game = name.getActivities().toString();
                String test = name.getOnlineStatus().toString();
                List<Activity> gametest = name.getActivities();
                System.out.print(gametest + test);
                return "Playing: " + game;
            } catch (NullPointerException exx) {
                return "No Game Being Played";
            }
        }
        //Get roles for the user
        private String getRolesAsString (List < Role > rolesList) {
            String roles;
            if (!rolesList.isEmpty()) {
                Role tempRole = (Role) rolesList.get(0);
                roles = tempRole.getName();
                for (int i = 1; i < rolesList.size(); i++) {
                    tempRole = (Role) rolesList.get(i);
                    roles = roles + ", " + tempRole.getName();
                }
            } else {
                roles = "No Roles";
            }
            return roles;
        }
    }
