package org.nstmframework.engine

import groovy.text.GStringTemplateEngine
import groovy.util.logging.Slf4j
import org.apache.commons.io.FileUtils

import java.beans.PropertyDescriptor

/**
 * User: Naoyuki Yoshinori
 */
@Slf4j
abstract class TemplateEngine {

    def binding = [:]

    /**
     * The root path of the templates.
     */
    String template_root

    /**
     * The root path of the application.
     */
    String app_root

    /**
     * The default encoding is UTF-8
     */
    String encoding = 'UTF-8'


    def createFile(String src_relative_path, String dest_relative_path) {
        def src_file = new File(template_root, src_relative_path)
        def dest_file = new File(app_root, dest_relative_path)
        def reader = new InputStreamReader(new FileInputStream(src_file), encoding)

        println "  create  " + dest_relative_path
        log.debug "path: {}", dest_file.canonicalPath

        def generated_from_template = new GStringTemplateEngine().createTemplate(reader).make(binding).toString()
        FileUtils.writeStringToFile(dest_file, generated_from_template, encoding)
    }

    def copyFile(String src_relative_path, String dest_relative_path) {
        def src_file = new File(template_root, src_relative_path)
        def dest_file = new File(app_root, dest_relative_path)

        println "  create  " + dest_relative_path
        log.debug "path: {}", dest_file.canonicalPath

        FileUtils.copyFile(src_file, dest_file)
    }

    def createDirectory(String relative_path) {
        def path_file = new File(app_root, relative_path)

        println "  create  " + relative_path
        log.debug "path: {}", path_file.canonicalPath

        FileUtils.forceMkdir(path_file)
    }

    def start() {
        if (!template_root) {
            // Set the template directory. The default is $NSTM_HOME/templates.
            def nstm_home = new File(TemplateEngine.class.protectionDomain.codeSource.location.path).parent
            template_root = new File(nstm_home, "templates").canonicalPath
        }

        if (!app_root) {
            // Set the current directory.
            app_root = "."
        }

        // Get the fields of a subclass.
        def subclass_fields = this.class.declaredFields
        subclass_fields.each { field ->
            if (field.isAnnotationPresent(TemplateParameter)) {
                binding["${field.name}"] = new PropertyDescriptor(field.name, this.class).readMethod?.invoke(this)
            }
        }

        // Get the methods of a subclass.
        def subclass_methods = this.class.methods
        subclass_methods.each { method ->
            // Execute the method of TemplateGenerator.
            if (method.isAnnotationPresent(TemplateGenerator)) {
                method.invoke(this)
            }
        }
    }
}
