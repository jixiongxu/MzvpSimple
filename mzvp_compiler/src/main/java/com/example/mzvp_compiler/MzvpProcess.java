package com.example.mzvp_compiler;

import com.example.mzvp_java.manager.MzvpEntity;
import com.example.mzvp_java.manager.MzvpViewManagerImp;
import com.example.mzvp_java.support.MzvpBind;
import com.google.auto.service.AutoService;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;


/**
 * 作者: xujixiong@meizu.com
 * 创建时间: 21-1-22 下午2:45
 * 需求/缺陷:
 * 描述: 处理注解生成代码
 */
@AutoService(Processor.class)
public class MzvpProcess extends AbstractProcessor {

    private static final String TAG = "MzvpProcess";

    private static Map<String, String> map = new HashMap<>();

    private Filer filer;

    private boolean hasProcess = false;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        System.out.println(TAG + ":process");
        if (hasProcess) {
            return false;
        }
        for (Element element : roundEnvironment.getElementsAnnotatedWith(MzvpBind.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                String className = element.asType().toString();
                MzvpBind mzvpBind = element.getAnnotation(MzvpBind.class);
                if (mzvpBind == null) {
                    continue;
                }
                String value = mzvpBind.value();
                map.put(value, className);
            }
        }
        generation();
        hasProcess = true;
        return true;
    }

    private void generation() {

        String packageName = MzvpViewManagerImp.PACKAGE_NAME;
        String className = MzvpViewManagerImp.MZVP_CONSTANCE_MAP_CLASS_NAME;

        ClassName MZVP_CONSTANCE_CLASS_NAME = ClassName.get(packageName, className);

        MethodSpec.Builder methodSpecBuilder = MethodSpec.methodBuilder(MzvpViewManagerImp.MZVP_CONSTANCE_METHOD_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.STATIC)
                .returns(MzvpEntity[].class)
                .addStatement(String.format("MzvpEntity[] mzvps = new MzvpEntity[%1s]", map.size()));

        int index = 0;
        for (String key : map.keySet()) {
            methodSpecBuilder.addStatement(String.format("MzvpEntity mzvp%1s = new MzvpEntity()", index));
            methodSpecBuilder.addStatement(String.format("mzvp%1s.setMzvpId(\"%2s\")", index, key));
            methodSpecBuilder.addStatement(String.format("mzvp%1s.setMzvpClass(%2s.class)", index, map.get(key)));
            methodSpecBuilder.addStatement("mzvps[" + index + "] = mzvp" + index);
            index++;
        }

        MethodSpec methodSpec = methodSpecBuilder
                .addCode("return mzvps ;")
                .build();

        TypeSpec mzvpConstanceTypeSpec = TypeSpec.classBuilder(MZVP_CONSTANCE_CLASS_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(methodSpec)
                .build();
        JavaFile javaFile = JavaFile.builder(packageName, mzvpConstanceTypeSpec).build();
        try {
            javaFile.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected synchronized boolean isInitialized() {
        System.out.println(TAG + ":isInitialized");
        return super.isInitialized();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        System.out.println(TAG + ":init");
        filer = processingEnv.getFiler();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        System.out.println(TAG + ":getSupportedAnnotationTypes");
        Set<String> set = new HashSet<>();
        set.add(MzvpBind.class.getName());
        return set;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        System.out.println(TAG + ":getSupportedSourceVersion");
        return SourceVersion.RELEASE_8;
    }

}


