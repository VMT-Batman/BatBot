package Commands.MiscCommands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Hermes extends ListenerAdapter {
    String[] hermesquotes = {
    "`She's more than a best friend arnarah I will always have your back just give me a chance I know you come back to me so much better now I want to apologize to to you for the way I've been acting you can trust me have learned from you hey you how are you going to read the first person to apologize apologizing for everything to you I hope you will let me be here I hope you get back to calling me again cuz I care about you more than anybody in this chatand I would rather have your friendship than any of any of the rest of them I hope you can forgive me I will always forgive you no matter how much you did to me and you've got a lot to me no more I'm not talking to them about you anymore last time I hope you call me you mean alot to me you will never burn my bridge cuz I owe a lot to you you should consider letting beat your friend for life cuz I want to be your friend for life and I want a game with you and have fun with you South Lawrence from like from you and I just want to be there for you I've been missing you since you left so much I didn't think I was going to miss you so much and I know you miss me and I can be quiet for you you're the one that taught me that talk talk too much crying with you I could talk to so many more people and I can have so much more fun what are the but the other all on Discord app we could teach each other so much you got me care so much for you you should let me go I just want to be with you and learn from you and hopefully I can help you get better and feel better`",
    "`She is the arnarahqueen legends that is a better name than the queen shuffle balls that week Batman Memphis that's if I don't name she should be called`",
    "`I don't care what you said it I have heart and love for arnarah and I just want to be there for her don't give her love`",
    "`You're actually put your balls deep in your butthole`",
    "`If you want more of it let me talk to my queen arnarah`",
    "`Arnarah I will suck your toes if you want me to`",
    "`I only listen to my queen arnarah I'm done talking to everybody else to talk to her`",
    "`I sacrificed everything for arnarah and now I don't even get to talk to her nobody cares bunch of people betrayed my trust I'm done in the server`",
    "`I also promise to stay with her during all this to stay with her forever no matter what happens I'm not working any of them in the bad in through the good and everything else in between arnarah this is the one I promised myself it just happened during all the problems and that two things is what kept me going`",
    "`I can never give up me  and arnarah i promised I would be there for no matter what she's the only one it can release I promise she has to talk to me in voice Discord app actual conversation`",
    "`I will only be a simp for her she talks to me invoice I got to tell her myself and she has to have a conversation with me on Discord arnarah`",
    "`She is the arnarahqueen legends that is a better name than the queen shuffle balls that week Batman Memphis that's if I don't name she should be called`",
    "`It was hard cuz I had nobody to help me the one person I trusted arnarah should never left me but hope she'll realize that she brought me into all this and abandon me I still want to get back with her`",
    "`You need to stop being so mean and such a stupid ass who likes to kill people you seem like you would be someone who would be a serial killer`",
    "`She's more than a best friend arnarah I will always have your back just give me a chance I know you come back to me so much better now I want to apologize to to you for the way I've been acting you can trust me have learned from you hey you how are you going to read the first person to apologize apologizing for everything to you I hope you will let me be here I hope you get back to calling me again cuz I care about you more than anybody in this chatand I would rather have your friendship than any of any of the rest of them I hope you can forgive me I will always forgive you no matter how much you did to me and you've got a lot to me no more I'm not talking to them about you anymore last time I hope you call me you mean alot to me you will never burn my bridge cuz I owe a lot to you you should consider letting beat your friend for life cuz I want to be your friend for life and I want a game with you and have fun with you South Lawrence from like from you and I just want to be there for you I've been missing you since you left so much I didn't think I was going to miss you so much and I know you miss me and I can be quiet for you you're the one that taught me that talk talk too much crying with you I could talk to so many more people and I can have so much more fun what are the but the other all on Discord app we could teach each other so much you got me care so much for you you should let me go I just want to be with you and learn from you and hopefully I can help you get better and feel better`",
    "`Yeah without her arnarah she's the reason  playing fallout 76 and she helped him make all my friends and that's why I don't want to lose you she's being there for me I would have never had all my friends and I don't want to lose you give me a chance to be with you`",
    "`I'm popular on Discord app lot of people like hanging out with me`",
    "`I can be exactly whatever she wants me to be but she doesn't care`",
    "`Message message message message message messages are good`",
    "`Your cries in the creeps of the highest order I felt for a long before I started listening to Spotify`",
    "`Jack off on this And that means you're out that you just died`"
    };
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getMessage().getContentRaw().equals("b!hermes")) {
            int min = 1;
            int max = 21;
            int quotenum = (int) (Math.random() * (max - min + 1) + min);
            e.getChannel().sendMessage(hermesquotes[quotenum]).queue();
        }
    }
}