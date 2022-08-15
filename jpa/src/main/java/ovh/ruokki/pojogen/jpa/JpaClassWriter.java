package ovh.ruokki.pojogen.jpa;

import ovh.ruokki.pojogen.data.Context;
import ovh.ruokki.pojogen.model.writer.ClassWriter;
import ovh.ruokki.pojogen.writer.TemplateTools;

public class JpaClassWriter implements ClassWriter {


    private final TemplateTools templateTools;

    public JpaClassWriter(TemplateTools templateTools) {
        this.templateTools = templateTools;
    }

    @Override
    public void writeClass(Context context) {

    }

}
