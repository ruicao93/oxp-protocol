package org.onosproject.oxp.types;

import com.google.common.hash.PrimitiveSink;
import org.jboss.netty.buffer.ChannelBuffer;
import org.onosproject.oxp.protocol.OXPVersion;
import org.onosproject.oxp.protocol.Writeable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cr on 16-7-21.
 */
public class OXPInternalLink implements Writeable, PrimitiveSinkable{
    private final static Logger logger = LoggerFactory.getLogger(OXPInternalLink.class);

    private final OXPVport srcVport;
    private final OXPVport dstVport;
    private final long capability;
    private final OXPVersion version;

    OXPInternalLink(OXPVport srcVport, OXPVport dstVport, long capability, OXPVersion version) {
        this.srcVport = srcVport;
        this.dstVport = dstVport;
        this.capability = capability;
        this.version = version;
    }

    public OXPVport getSrcVport() {
        return srcVport;
    }

    public OXPVport getDstVport() {
        return dstVport;
    }

    public long getCapability() {
        return capability;
    }

    public static OXPInternalLink of(OXPVport srcVport, OXPVport dstVport, long capability,OXPVersion version) {
        return new OXPInternalLink(srcVport, dstVport, capability, version);
    }


    @Override
    public void putTo(PrimitiveSink sink) {
        srcVport.putTo(sink);
        dstVport.putTo(sink);
        sink.putLong(capability);
    }

    @Override
    public void writeTo(ChannelBuffer bb) {
        srcVport.writeTo(bb);
        dstVport.writeTo(bb);
        bb.writeLong(capability);
    }
}
