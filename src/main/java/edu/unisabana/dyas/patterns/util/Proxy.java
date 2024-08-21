package edu.unisabana.dyas.patterns.util;

import java.util.regex.Pattern;

public class Proxy implements MessageSender{
    private MessagingClient client;
    private static final Pattern DANGEROUS_PATTERN = Pattern.compile("##\\{\\.\\/exec\\(.*\\)\\}");

    public Proxy(MessagingClient client) {
        this.client = client;
    }

    @Override
    public void sendMessage(String message) {
        if (DANGEROUS_PATTERN.matcher(message).find()) {
            System.out.println("Mensaje bloqueado debido a contenido peligroso");
        } else {
            client.sendMessage(message);
        }
    }
}
