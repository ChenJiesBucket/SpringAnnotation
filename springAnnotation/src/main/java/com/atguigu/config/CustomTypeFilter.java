package com.atguigu.config;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class CustomTypeFilter implements TypeFilter {
    /**
     * @Author dcj
     * @Description metadataReader  可以获取正在扫描的类
     * @Description metadataReaderFactory  可以获取所有扫描的类
     * @return boolean
    **/
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata =  metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();
        if(className.contains("er")){
            return true;
        }else{
            return false;
        }

    }
}