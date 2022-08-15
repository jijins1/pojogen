package ovh.ruokki.pojogen.writer.config;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

public class MustacheConfig {
    public MustacheFactory buildFactory() {
        DefaultMustacheFactory factory = new DefaultMustacheFactory();
        return factory;       
    }
}
