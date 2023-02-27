package tobyspring.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector { // BeanClassLoaderAware를 impl 받아서 해도 됨.
    private final ClassLoader classLoader;  // 생성자 주입 방법.

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);// 스프링 컨테이너가 빈을 로딩하는 클래스로더를 넣어줌.
        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
    }
}
