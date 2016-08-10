package com.example.yusuf.myapplication.backend;

import com.google.api.server.spi.config.Api;


;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "cloudJokeProviderApi",
        version = "v1",
        resource = "com.example.yusuf.myapplication.backend.cloudJokeProvider",
        namespace = @ApiNamespace(
                ownerDomain = "",
                ownerName = "",
                packagePath = ""
        )
)
public class cloudJokeProviderEndpoint {

    private static final Logger logger = Logger.getLogger(cloudJokeProviderEndpoint.class.getName());

    /**
     * This method gets the <code>com.example.yusuf.myapplication.backend.cloudJokeProvider</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>com.example.yusuf.myapplication.backend.cloudJokeProvider</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getcloudJokeProvider")
    public cloudJokeProvider getcloudJokeProvider(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getcloudJokeProvider method");
        return null;
    }

    /**
     * This inserts a new <code>com.example.yusuf.myapplication.backend.cloudJokeProvider</code> object.
     *
     * @param cloudJokeProvider The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertcloudJokeProvider")
    public cloudJokeProvider insertcloudJokeProvider(cloudJokeProvider cloudJokeProvider) {
        // TODO: Implement this function
        logger.info("Calling insertcloudJokeProvider method");
        return cloudJokeProvider;
    }
}