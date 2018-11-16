package com.hax.discordinfo;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Main {

    String token;

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your BotToken...");
        token = scanner.next();

        try {
            JDA jda = new JDABuilder().setToken(token).addEventListener(new ListenerAdapter() {
                @Override
                public void onReady(ReadyEvent event) {
                    System.out.println("Name: "+event.getJDA().getSelfUser().getName()+"#"+event.getJDA().getSelfUser().getDiscriminator()+
                            "\nGuilds: "+event.getJDA().getGuilds().size()+
                            "\nUsers: "+event.getJDA().getUsers().size()+
                            "\nTextChannels: "+event.getJDA().getTextChannels().size()+
                            "\nVoiceChannels: "+event.getJDA().getVoiceChannels().size()
                    );
                    event.getJDA().shutdownNow();
                }
            }).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
