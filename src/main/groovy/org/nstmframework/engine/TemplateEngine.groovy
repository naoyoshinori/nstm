package org.nstmframework.engine

import groovy.text.GStringTemplateEngine
import org.apache.commons.io.FileUtils

import java.beans.PropertyDescriptor

/**
 * User: Naoyuki Yoshinori
 */
abstract class TemplateEngine {

    def binding = [:]

    /**
     * Template root path.
     */
    String template_root

    /**
     * Application root path.
     */
    String app_root

    boolean debug

    def createFile(String src, String dest) {
        def src_file = new File(template_root, src)
        def dest_file = new File(app_root, dest)

        println "  create  " + debug ? dest_file.canonicalPath : dest

        def engine = new GStringTemplateEngine()
        def template = engine.createTemplate(src_file).make(binding)
        FileUtils.writeStringToFile(dest_file, template.toString())
    }

    def copyFile(String src, String dest) {
        def src_file = new File(template_root, src)
        def dest_file = new File(app_root, dest)

        println "  create  " + debug ? dest_file.canonicalPath : dest

        FileUtils.copyFile(src_file, dest_file)
    }

    def createDirectory(String path) {
        def path_file = new File(app_root, path)

        println "  create  " + debug ? path_file.canonicalPath : path

        FileUtils.forceMkdir(path_file)
    }

    def start() {
        def subclass = this.class

        if (!template_root) {
            def nstm_home = new File(subclass.protectionDomain.codeSource.location.path).parent
            template_root = new File(nstm_home, "templates").canonicalPath
        }

        if (!app_root) {
            app_root = "."
        }

        def subclass_fields = subclass.declaredFields
        subclass_fields.each {
            if (it.isAnnotationPresent(TemplateParameter)) {
                def pd = new PropertyDescriptor(it.name, subclass)
                def val = pd.readMethod.invoke(this)
                binding["${it.name}"] = val
            }
        }

        def subclass_methods = subclass.methods
        subclass_methods.each {
            if (it.isAnnotationPresent(TemplateGenerator)) {
                it.invoke(this)
            }
        }
    }
}
