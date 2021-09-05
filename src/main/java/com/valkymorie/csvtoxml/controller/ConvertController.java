package com.valkymorie.csvtoxml.controller;

import com.valkymorie.csvtoxml.model.User;
import freemarker.cache.ConditionalTemplateConfigurationFactory;
import freemarker.cache.FileExtensionMatcher;
import freemarker.core.TemplateConfiguration;
import freemarker.core.XMLOutputFormat;
import freemarker.template.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertController {

    public void converToXml(List<User> userList) throws IOException, ParserConfigurationException, SAXException, TemplateException {

        Configuration config = new Configuration(Configuration.VERSION_2_3_31);
        config.setDirectoryForTemplateLoading(new File("C:\\Users\\emir\\Desktop\\PROJELER\\Spring\\Csvtoxml"));
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        config.setLogTemplateExceptions(false);
        config.setWrapUncheckedExceptions(true);
        config.setFallbackOnNullLoopVariable(false);

        //config.setObjectWrapper(Configuration.getDefaultObjectWrapper(Configuration.VERSION_2_3_31));
        //config.setObjectWrapper(new MyUserObjectWrapper(config.getIncompatibleImprovements()));

        DefaultObjectWrapperBuilder defaultObjectWrapperBuilder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_31);
        defaultObjectWrapperBuilder.setIterableSupport(true);
        config.setObjectWrapper(defaultObjectWrapperBuilder.build());

        TemplateConfiguration tcUTF8XML = new TemplateConfiguration();
        tcUTF8XML.setEncoding("utf-8");
        tcUTF8XML.setOutputFormat(XMLOutputFormat.INSTANCE);

        config.setTemplateConfigurations(new ConditionalTemplateConfigurationFactory(new FileExtensionMatcher("xml"), tcUTF8XML));

        Map<String, List<User>> root = new HashMap();
        //root.put("doc", freemarker.ext.dom.NodeModel.parse(new File("template.ftlx")));

        Template temp = config.getTemplate("template.ftl");

        File file = new File("output.xml");
        if (!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Writer out = new OutputStreamWriter(System.out);

        root.put("userList", userList);
        temp.process(root,out);
        temp.process(root,bufferedWriter);

        out.close();
        bufferedWriter.close();
    }
}
