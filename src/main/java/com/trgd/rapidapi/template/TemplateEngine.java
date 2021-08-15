package com.trgd.rapidapi.template;

import java.io.IOException;
import java.util.Map;

public interface TemplateEngine {
    String interpolate(String template, Map<String, String> variables) throws IOException;
}
