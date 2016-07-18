package org.onosproject.oxp.protocol.ver10;

import org.onosproject.oxp.protocol.OXPMessageReader;
import org.onosproject.oxp.protocol.OXPVersion;
import org.onosproject.oxp.protocol.XidGenerators;
import org.onosproject.oxp.protocol.errormsg.OXPDomainConfigFailedErrorMsg;
import org.onosproject.oxp.protocol.errormsg.OXPErrorMsgs;
import org.onosproject.oxp.protocol.OXPErrorMsg;
import org.onosproject.oxp.protocol.XidGenerator;
import org.onosproject.oxp.protocol.errormsg.OXPBadRequestErrorMsg;
import org.onosproject.oxp.protocol.errormsg.OXPExperimenterErrorMsg;
import org.onosproject.oxp.protocol.errormsg.OXPHelloFailedErrorMsg;

/**
 * Created by cr on 16-7-17.
 */
public class OXPErrorMsgsVer10 implements OXPErrorMsgs {
    public final static OXPErrorMsgsVer10 INSTANCE = new OXPErrorMsgsVer10();

    private final XidGenerator xidGenerator = XidGenerators.global();

    @Override
    public OXPHelloFailedErrorMsg.Builder buildHelloFailedErrorMsg() {
        return new OXPHelloFailedErrorMsgVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPBadRequestErrorMsg.Builder buildBadRequestErrorMsg() {
        return new OXPBadRequestErrorMsgVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPDomainConfigFailedErrorMsg.Builder buildDomainConfigFailedErrorMsg() {
        return new OXPDomainConfigFailedErrorMsgVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPExperimenterErrorMsg.Builder buildExperimenterErrorMsg() {
        return null;
    }

    @Override
    public OXPMessageReader<OXPErrorMsg> getReader() {
        return OXPErrorMsgVer10.READER;
    }

    @Override
    public OXPVersion getVersion() {
        return null;
    }

    @Override
    public long nextXid() {
        return xidGenerator.nextXid();
    }
}
