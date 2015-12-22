package ucoach.google;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("google-fit")
public class GoogleFitConfig extends ResourceConfig {

  public GoogleFitConfig () {
    packages("ucoach.google");
  }
}