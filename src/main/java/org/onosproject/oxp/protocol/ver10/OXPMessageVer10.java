package org.onosproject.oxp.protocol.ver10;

import org.jboss.netty.buffer.ChannelBuffer;
import org.onosproject.oxp.exceptions.OXPParseError;
import org.onosproject.oxp.protocol.OXPMessage;
import org.onosproject.oxp.protocol.OXPMessageReader;

/**
 * Created by cr on 16-4-9.
 */
public final class OXPMessageVer10 {
    // version: 1.0
    static final byte WIRE_VERSION = 1;
    static final int MINIMUM_LENGTH = 8;

    private OXPMessageVer10() {
    }

    public static final OXPMessageVer10.Reader READER = new Reader();

    static class Reader implements OXPMessageReader<OXPMessage> {
        @Override
        public OXPMessage readFrom(ChannelBuffer bb) throws OXPParseError {
            if (bb.readableBytes() < MINIMUM_LENGTH) {
                return null;
            }
            int start = bb.readerIndex();
            // fixed value property version == 1
            byte version = bb.readByte();
            if (version != (byte) 0x1) {
                throw new OXPParseError("Wrong version: Expected=OFVersion.OF_10(1), got=" + version);
            }
            byte type = bb.readByte();
            bb.readerIndex(start);
            switch (type) {
                case (byte) 0x0:
                    // discriminator value OFType.HELLO=0 for class OFHelloVer10
                    return OXPHelloVer10.READER.readFrom(bb);
                default:
                    throw new OXPParseError("Unknown value for discriminator type of class OXPMessageVer10: " + type);
            }
        }
    }
}
