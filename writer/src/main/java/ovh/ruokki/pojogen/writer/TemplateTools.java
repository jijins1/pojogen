package ovh.ruokki.pojogen.writer;

import java.io.StringWriter;
import java.util.Map;
import java.util.function.Function;

import com.github.mustachejava.MustacheFactory;
import com.google.common.base.Strings;

public class TemplateTools {
    
    private MustacheFactory mustacheFactory;
    
    public TemplateTools(MustacheFactory mustacheFactory) {
        this.mustacheFactory = mustacheFactory;
        
    }
    
    public String generate(Map<String, Object> context, String template) {
        StringWriter stringWriter = new StringWriter();
        Function<String, String> capitalize = TemplateTools::capitalizeString;
        context.put("capitalize",capitalize);
        mustacheFactory.compile(template).execute(stringWriter, context);
        return stringWriter.toString();
    }
    public static String capitalizeString(String str) {
        String retStr = str;
        try { // We can face index out of bound exception if the string is null
            retStr = str.substring(0, 1).toUpperCase() + str.substring(1);
        }catch (Exception e){}
        return retStr;
    }
}