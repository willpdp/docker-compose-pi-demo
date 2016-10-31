package style_service;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class MainResource {

    private class Response {
	private final String style;
	private final String hostname;
	private final String runtime;
	public Response(String style, String hostname, String runtime) {
	    this.style = style;
	    this.hostname = hostname;
	    this.runtime = runtime;
	}
	public String getStyle() { return style; }
	public String getHostname() { return hostname; }
	public String getRuntime() { return runtime; }
    }
    
    public MainResource() {
    }

    @GET
    @Timed
    public Response getStylish() {
	try {
	    return new Response(CSS3Patterns.aRandomCSS3Pattern(), InetAddress.getLocalHost().getHostName(), "java-"+System.getProperty("java.runtime.version"));
	} catch(UnknownHostException e) {
	    return null;
	}
    }
}
