package org.onosproject.oxp.protocol.ver10;

import org.onosproject.oxp.protocol.OXPFactory;
import org.onosproject.oxp.protocol.OXPHello;
import org.onosproject.oxp.protocol.OXPHelloElem;
import org.onosproject.oxp.protocol.OXPMessage;
import org.onosproject.oxp.protocol.OXPMessageReader;
import org.onosproject.oxp.protocol.OXPVersion;
import org.onosproject.oxp.protocol.XidGenerator;
import org.onosproject.oxp.protocol.XidGenerators;

import java.util.List;

/**
 * Created by cr on 16-4-9.
 */
public class OXPFactoryVer10 implements OXPFactory {

    public static final OXPFactoryVer10 INSTANCE = new OXPFactoryVer10();

    private final XidGenerator xidGenerator = XidGenerators.global();

    @Override
    public OXPHello.Builder buildHello() {
        return new OXPHelloVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPHello hello(List<OXPHelloElem> elements) {
        return new OXPHelloVer10(
                nextXid()
        );
    }

    @Override
    public OXPMessageReader<OXPMessage> getReader() {
        return OXPMessageVer10.READER;
    }

    @Override
    public OXPVersion getVersion() {
        return OXPVersion.OXP_10;
    }

    @Override
    public long nextXid() {
        return xidGenerator.nextXid();
    }


}
