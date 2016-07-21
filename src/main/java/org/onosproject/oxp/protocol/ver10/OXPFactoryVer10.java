package org.onosproject.oxp.protocol.ver10;

import org.onosproject.oxp.protocol.OXPEchoReply;
import org.onosproject.oxp.protocol.OXPEchoRequest;
import org.onosproject.oxp.protocol.OXPFactory;
import org.onosproject.oxp.protocol.OXPFeaturesReply;
import org.onosproject.oxp.protocol.OXPFeaturesRequest;
import org.onosproject.oxp.protocol.OXPGetConfigReply;
import org.onosproject.oxp.protocol.OXPGetConfigRequest;
import org.onosproject.oxp.protocol.OXPHello;
import org.onosproject.oxp.protocol.OXPMessageReader;
import org.onosproject.oxp.protocol.OXPSetConfig;
import org.onosproject.oxp.protocol.OXPVersion;
import org.onosproject.oxp.protocol.XidGenerator;
import org.onosproject.oxp.protocol.XidGenerators;
import org.onosproject.oxp.protocol.errormsg.OXPErrorMsgs;
import org.onosproject.oxp.protocol.OXPHelloElem;
import org.onosproject.oxp.protocol.OXPMessage;

import java.util.List;

/**
 * Created by cr on 16-4-9.
 */
public class OXPFactoryVer10 implements OXPFactory {

    public static final OXPFactoryVer10 INSTANCE = new OXPFactoryVer10();

    private final XidGenerator xidGenerator = XidGenerators.global();

    @Override
    public OXPErrorMsgs errorMsgs() {
        return OXPErrorMsgsVer10.INSTANCE;
    }

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
    public OXPEchoRequest.Builder buildEchoRequest() {
        return new OXPEchoRequestVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPEchoReply.Builder buildEchoReply() {
        return new OXPEchoReplyVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPFeaturesRequest.Builder buildFeaturesRequst() {
        return new OXPFeaturesRequestVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPFeaturesReply.Builder buildFeaturesReply() {
        return new OXPFeaturesReplyVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPGetConfigRequest.Builder buildGetConfigRequest() {
        return new OXPGetConfigRequestVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPGetConfigReply.Builder buildGetConfigReply() {
        return new OXPGetConfigReplyVer10.Builder().setXid(nextXid());
    }

    @Override
    public OXPSetConfig.Builder buildSetConfig() {
        return new OXPSetConfigVer10.Builder().setXid(nextXid());
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
