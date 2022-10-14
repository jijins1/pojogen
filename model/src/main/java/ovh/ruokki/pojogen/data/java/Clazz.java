package ovh.ruokki.pojogen.data.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Clazz {
    
    private String thePackage = "";
    private final Set<Clazz> imports;
    private final Set<Clazz> annotations;
    private final Set<Clazz> implementList;
    private final Clazz extend;
    private final List<Field> fields;
    private final String name;
    public static final Clazz STRING = Clazz.builder().name("String").thePackage("java.lang").build();
    
    public String getPackage() {
        return thePackage;
    }
    
    public void setPackage(final String s) {
        this.thePackage = s;
    }
    
    public void addAnnotations(Clazz clazz) {
        this.imports.add(clazz);
        this.annotations.add(clazz);
    }
    
    public void addField(Field field) {
        this.imports.add(field.getType());
        this.imports.addAll(field.getAnnotations());
        this.fields.add(field);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Clazz clazz = (Clazz) o;
        return thePackage.equals(clazz.thePackage) && name.equals(clazz.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(thePackage, name);
    }
    
    public static class ClazzBuilder {
        private List<Field> fields = new ArrayList<>();
        private Set<Clazz> annotations = new HashSet<>();
        private Set<Clazz> implementList = new HashSet<>();
        private Set<Clazz> imports = new HashSet<>();
        private Clazz extend;
        
        public ClazzBuilder fields(List<Field> fields) {
            fields.forEach(this::field);
            return this;
        }
        
        public ClazzBuilder field(Field field) {
            this.fields.add(field);
            this.imports.add(field.getType());
            this.imports.addAll(field.getAnnotations());
            
            return this;
        }
        
        public ClazzBuilder annotations(Clazz annotation) {
            this.annotations.add(annotation);
            this.imports.add(annotation);
            return this;
        }
        
        public ClazzBuilder implement(Clazz interfaceImplements) {
            this.implementList.add(interfaceImplements);
            this.imports.add(interfaceImplements);
            return this;
        }
        
        public ClazzBuilder extend(Clazz clazz) {
            this.extend = clazz;
            this.imports.add(clazz);
            return this;
        }
        
    }
}
