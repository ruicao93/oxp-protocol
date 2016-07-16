package org.onosproject.oxp.protocol;


import java.util.List;

/**
 * Created by cr on 16-4-9.
 */
public interface OXPFactory extends XidGenerator {


    OXPHello.Builder buildHello();
    OXPHello hello(List<OXPHelloElem> elements);

    OXPMessageReader<OXPMessage> getReader();
    OXPVersion getVersion();
}
