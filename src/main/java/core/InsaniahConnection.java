package core;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by LEO on 6/26/15.
 * This interface is implemented by Insaniah class which use Apache HttpClient to connect to internet
 * and InsaniahUrlConnection class which use URLConnection to connect to internet
 * Insaniah class is suitable for desktop application and
 * InsaniahUrlConnection class is suitable for android application
 *
 *
 */

public interface InsaniahConnection {

    public Document getDoc(String url) throws IOException;

    public boolean login() throws IOException;
}
