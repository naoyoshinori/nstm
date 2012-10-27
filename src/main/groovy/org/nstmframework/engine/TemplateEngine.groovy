package org.nstmframework.engine

import groovy.text.GStringTemplateEngine
import org.apache.commons.io.FileUtils

import java.beans.PropertyDescriptor
import org.apache.commons.io.IOUtils

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

    /**
     * Default encoding UTF-8
     */
    String encoding = 'UTF-8'

    boolean debug

    def createFile(String src_relative_path, String dest_relative_path) {
        def src_file = new File(template_root, src_relative_path)
        def dest_file = new File(app_root, dest_relative_path)
        def reader = new InputStreamReader(new FileInputStream(src_file), encoding)

        println "  create  " + (debug ? dest_file.canonicalPath : dest_relative_path)

        def generated_from_template = new GStringTemplateEngine().createTemplate(reader).make(binding).toString()
        FileUtils.writeStringToFile(dest_file, generated_from_template, encoding)
    }

    def copyFile(String src_relative_path, String dest_relative_path) {
        def src_file = new File(template_root, src_relative_path)
        def dest_file = new File(app_root, dest_relative_path)

        println "  create  " + (debug ? dest_file.canonicalPath : dest_relative_path)

        FileUtils.copyFile(src_file, dest_file)
    }

    def createDirectory(String relative_path) {
        def path_file = new File(app_root, relative_path)

        println "  create  " + (debug ? path_file.canonicalPath : relative_path)

        FileUtils.forceMkdir(path_file)
    }

    def start() {
        if (!template_root) {
            // set $NSTM_HOME/templates
            def nstm_home = new File(TemplateEngine.class.protectionDomain.codeSource.location.path).parent
            template_root = new File(nstm_home, "templates").canonicalPath
        }

        if (!app_root) {
            // set current directory
            app_root = "."
        }

        def subclass_fields = this.class.declaredFields
        subclass_fields.each {
            if (it.isAnnotationPresent(TemplateParameter)) {
                binding["${it.name}"] = new PropertyDescriptor(it.name, this.class).readMethod?.invoke(this)
            }
        }

        def subclass_methods = this.class.methods
        subclass_methods.each {
            if (it.isAnnotationPresent(TemplateGenerator)) {
                it.invoke(this)
            }
        }
    }
}
