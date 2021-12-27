package com.sedmelluq.discord.lavaplayer.demo.jda;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

/**
 * Holder for both the player and a track scheduler for one guild.
 */
public class GuildMusicManager {
    /**
     * Audio player for the guild.
     */
    public final AudioPlayer player;
    /**
     * Track scheduler for the player.
     */
    public final com.sedmelluq.discord.lavaplayer.demo.jda.TrackScheduler scheduler;

    /**
     * Creates a player and a track scheduler.
     * @param manager Audio player manager to use for creating the player.
     */
    public GuildMusicManager(AudioPlayerManager manager) {
        player = manager.createPlayer();
        scheduler = new com.sedmelluq.discord.lavaplayer.demo.jda.TrackScheduler(player);
        player.addListener(scheduler);
    }

    /**
     * @return Wrapper around AudioPlayer to use it as an AudioSendHandler.
     */
    public com.sedmelluq.discord.lavaplayer.demo.jda.AudioPlayerSendHandler getSendHandler() {
        return new com.sedmelluq.discord.lavaplayer.demo.jda.AudioPlayerSendHandler(player);
    }
}