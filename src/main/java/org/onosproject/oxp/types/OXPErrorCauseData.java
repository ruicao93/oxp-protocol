package org.onosproject.oxp.types;

import com.google.common.hash.PrimitiveSink;
import org.jboss.netty.buffer.ChannelBuffer;
import org.onosproject.oxp.protocol.OXPVersion;
import org.onosproject.oxp.protocol.Writeable;
import org.onosproject.oxp.util.ChannelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by cr on 16-7-17.
 */
public class OXPErrorCauseData implements Writeable, PrimitiveSinkable{
    private final static  Logger logger = LoggerFactory.getLogger(OXPErrorCauseData.class);

    public final static OXPErrorCauseData NONE = new OXPErrorCauseData(new byte[0], OXPVersion.OXP_10);

    private final byte[] data;
    private final OXPVersion version;

    private OXPErrorCauseData(byte[] data, OXPVersion version) {
        this.data = data;
        this.version = version;
    }

    public static OXPErrorCauseData of(byte[] data, OXPVersion version) {
        return new OXPErrorCauseData(data, version);
    }

    public static OXPErrorCauseData read(ChannelBuffer bb, int length, OXPVersion version) {
        byte[] bytes = ChannelUtils.readBytes(bb, length);
        return of(bytes, version);
    }

    @Override
    public void putTo(PrimitiveSink sink) {
        sink.putBytes(data);
    }

    @Override
    public void writeTo(ChannelBuffer bb) {
        bb.writeBytes(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OXPErrorCauseData other = (OXPErrorCauseData) obj;
        if (!Arrays.equals(data, other.data))
            return false;
        if (version != other.version)
            return false;
        return true;
    }
}
