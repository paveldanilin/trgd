package com.trgd.rapidapi.template;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class MustacheTemplate implements TemplateEngine {
    private final MustacheFactory mustacheFactory;

    public MustacheTemplate() {
        this.mustacheFactory = new DefaultMustacheFactory();
    }

    @Override
    public String interpolate(String template, Map<String, String> variables) throws IOException {
        Mustache m = this.mustacheFactory.compile(template);

        StringWriter sw = new StringWriter();

        m.execute(sw, variables).flush();

        return sw.toString();
    }
}
