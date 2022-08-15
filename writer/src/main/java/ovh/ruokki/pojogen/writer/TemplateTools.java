package ovh.ruokki.pojogen.writer;

import java.io.StringWriter;
import java.util.Map;

import com.github.mustachejava.MustacheFactory;

public class TemplateTools {

    private MustacheFactory mustacheFactory;

    public TemplateTools(MustacheFactory mustacheFactory) {
        this.mustacheFactory = mustacheFactory;

    }

    public String generate(Map<String, Object> context, String template){
        StringWriter stringWriter = new StringWriter();
         mustacheFactory.compile(template).execute(stringWriter, context);
         return stringWriter.toString();
    }

}