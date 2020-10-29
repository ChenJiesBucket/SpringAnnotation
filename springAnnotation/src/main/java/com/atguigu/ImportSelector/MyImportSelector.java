package com.atguigu.ImportSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    
    /** exp9
     * @Author dcj
     * @Description selectImports
     * @Param [annotationMetadata]   当前标注@Import 注解的类的所包含的注解 的信息
     * @return java.lang.String[]    返回值不能为null 返回字符串包名 注意自动导入的包名格式！
    **/
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.atguigu.bean.Red","com.atguigu.bean.Blue"};
    }
}