package org.onosproject.oxp.protocol;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.junit.Test;
import org.onosproject.oxp.exceptions.OXPParseError;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
/**
 * Created by cr on 16-7-16.
 */
public class OXPHelloMsgTest {

    @Test
    public void oxpHelloMsgTest() throws OXPParseError{
        // OXP Hello Message
        byte[] helloMsgBytes = new byte[]{(byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x08,
                                          (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01};
        byte[] testHelloMsgBytes;
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        buffer.writeBytes(helloMsgBytes);

        OXPMessageReader<OXPMessage> reader = OXPFactories.getGenericReader();
        OXPMessage oxpMessage;
        oxpMessage = reader.readFrom(buffer);
        //check message type
        assertThat(oxpMessage, instanceOf(OXPHello.class));

        ChannelBuffer buf = ChannelBuffers.dynamicBuffer();
        oxpMessage.writeTo(buf);

        int readLen = buf.writerIndex();
        testHelloMsgBytes = new byte[readLen];
        buf.readBytes(testHelloMsgBytes, 0 , readLen);

        assertThat(testHelloMsgBytes, is(helloMsgBytes));
    }
}
