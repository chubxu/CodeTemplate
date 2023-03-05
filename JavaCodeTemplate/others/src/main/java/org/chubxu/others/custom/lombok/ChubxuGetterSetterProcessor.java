package org.chubxu.others.custom.lombok;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @ClassName ChubxuGetterSetterProcessor
 * @Description 自定义的 getter setter 注解 处理器
 * @Since 1.0.0
 * @Date 2023/3/5 23:09
 * @Author chubxu
 */
@SupportedAnnotationTypes("org.chubxu.others.custom.lombok.ChubxuGetterSetter")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ChubxuGetterSetterProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(ChubxuGetterSetter.class);
        elementsAnnotatedWith.forEach(element -> {

        });
        return false;
    }
}
