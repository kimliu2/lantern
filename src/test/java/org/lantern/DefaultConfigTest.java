package org.lantern;

import static org.junit.Assert.assertTrue;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class DefaultConfigTest {

    @Test public void testWhitelist() throws Exception {
        final Config conf = new DefaultConfig();
        final String wl = conf.whitelist();
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode read = mapper.readTree(wl);
        final JsonNode avaaz = read.get("avaaz.org");
        assertTrue(avaaz != null);
        final JsonNode rules = avaaz.get("httpsRules");
        assertTrue(rules != null);
    }
    
    @Test public void testHttpsEverywhere() throws Exception {
        final Config conf = new DefaultConfig();
        final String json = conf.httpsEverywhere();
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode read = mapper.readTree(json);
        final JsonNode avaaz = read.get("avaaz.org");
        assertTrue(avaaz != null);
        final JsonNode rules = avaaz.get("rules");
        assertTrue(rules != null);
    }
}
