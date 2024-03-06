package org.example;

import org.apache.james.mime4j.dom.address.Mailbox;
import org.apache.james.mime4j.message.DefaultMessageBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KoreanCharsTest {
    @Test
    public void base64Encoded() throws IOException {
        var is = Main.class.getClassLoader().getResourceAsStream("base64-encoded.eml");
        var parsed = new DefaultMessageBuilder().parseMessage(is);
        var to = ((Mailbox) parsed.getTo().get(0)).getName();
        assertEquals("시험", to);
    }

    @Test
    public void notBase64Encoded() throws IOException {
        var is = Main.class.getClassLoader().getResourceAsStream("not-base64-encoded.eml");
        var parsed = new DefaultMessageBuilder().parseMessage(is);
        var to = ((Mailbox) parsed.getTo().get(0)).getName();
        assertEquals("시험", to);
    }
}
