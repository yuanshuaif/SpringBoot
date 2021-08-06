package com.lsj.springboot.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String[] imports = new String[1];
        imports[0] = "com.lsj.springboot.entity.Student";
        return imports;
    }
}
