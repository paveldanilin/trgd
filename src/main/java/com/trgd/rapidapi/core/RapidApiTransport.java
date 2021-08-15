package com.trgd.rapidapi.core;

import java.io.IOException;

public interface RapidApiTransport {
    RapidApiResponse call(RapidApiRequest rapidApiRequest) throws IOException;
}
