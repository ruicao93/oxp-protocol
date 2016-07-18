package org.onosproject.oxp.protocol.ver10;

import org.onosproject.oxp.protocol.OXPFactories;
import org.onosproject.oxp.protocol.OXPFactory;
import org.onosproject.oxp.protocol.OXPMessage;
import org.onosproject.oxp.protocol.OXPMessageReader;
import org.onosproject.oxp.protocol.OXPVersion;

/**
 * Created by cr on 16-7-18.
 */
public class TestBaseVer10 {
    final static OXPFactory oxpMsgFactory = OXPFactories.getFactory(OXPVersion.OXP_10);
    final static OXPMessageReader<OXPMessage> oxpMsgReader = OXPFactories.getGenericReader();

    public static OXPFactory getMsgFactory() {
        return oxpMsgFactory;
    }

    public static OXPMessageReader<OXPMessage> getMsgReader() {
        return oxpMsgReader;
    }
}
