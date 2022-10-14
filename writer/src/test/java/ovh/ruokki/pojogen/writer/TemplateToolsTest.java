package ovh.ruokki.pojogen.writer;

import java.util.HashMap;

import ovh.ruokki.pojogen.data.java.Clazz;
import ovh.ruokki.pojogen.data.java.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mustachejava.DefaultMustacheFactory;

class TemplateToolsTest {
    
    Logger log = LoggerFactory.getLogger(TemplateToolsTest.class);
    private TemplateTools templateTools;
    
    @BeforeEach
    void setUp() {
        templateTools = new TemplateTools(new DefaultMustacheFactory());
    }
    
    @Test
    public void itShouldGenerateEmptyClass() {
        Clazz emptyClass = emptyClass();
        generateClass(emptyClass);
    }
    
    @Test
    public void itShouldGenerateClassWithAnnotation() {
        Clazz emptyClass = classWithAnnotation();
        generateClass(emptyClass);
    }
    
    @Test
    public void itShouldGenerateClassWithField() {
        Clazz emptyClass = classWithFields();
        generateClass(emptyClass);
    }
    @Test
    public void itShouldGenerateClassWithFieldAnnoted() {
        Clazz emptyClass = classWithFieldsAnnoted();
        generateClass(emptyClass);
    }
    @Test
    public void itShouldGenerateClassWithFieldExtended() {
        Clazz emptyClass = extendClass();
        generateClass(emptyClass);
    }
    @Test
    public void itShouldGenerateClassWithFieldImplement() {
        Clazz emptyClass = implementClass();
        generateClass(emptyClass);
    }
    
    private void generateClass(final Clazz emptyClass) {
        HashMap<String, Object> context = new HashMap<>();
        context.put("new", emptyClass);
        
        String generate = templateTools.generate(context, "templates/class.mustache");
        log.info("\n"+generate);
    }
    
    private Clazz classWithAnnotation() {
        Clazz annotedClazz = Clazz.builder().name("AnnotedClazz").build();
        annotedClazz.setPackage("com.annotations");
        annotedClazz.addAnnotations(emptyClass());
        
        return annotedClazz;
    }
    
    private Clazz classWithFields() {
        Clazz fieldClass = Clazz.builder().name("FieldedClazz").build();
        fieldClass.setPackage("com.field");
        fieldClass.addField(Field.builder().type(emptyClass()).name("myField").build());
        
        return fieldClass;
    }
    
    private Clazz classWithFieldsAnnoted() {
        Clazz fieldClass =  Clazz.builder().name("FieldedAnnotedClazz").build();
        fieldClass.setPackage("com.field");
        Field myField = Field.builder().type(emptyClass()).name("myField").build();
        fieldClass.addField(myField);
        myField.getAnnotations().add(emptyClass());
        
        return fieldClass;
    }
    
    
    private static Clazz emptyClass() {
        Clazz emptyClass = Clazz.builder().name("EmptyClass").build();
        emptyClass.setPackage("com.empty");
        return emptyClass;
    }
    private static Clazz extendClass() {
        Clazz emptyClass = Clazz.builder().extend(emptyClass()).name("ExtendedEmpty").build();
        emptyClass.setPackage("com.empty");
        return emptyClass;
    }
    private static Clazz implementClass() {
        Clazz emptyClass = Clazz.builder().implement(emptyClass()).name("ImplementEmpty").build();
        emptyClass.setPackage("com.empty");
        return emptyClass;
    }
    
}