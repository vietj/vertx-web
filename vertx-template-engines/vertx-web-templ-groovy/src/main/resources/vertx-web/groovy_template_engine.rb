require 'vertx-web/template_engine'
require 'vertx/util/utils.rb'
# Generated from io.vertx.ext.web.templ.GroovyTemplateEngine
module VertxWeb
  #  A simple wrapper for Groovy template engines to be used as
  #  Vert.x template engines
  class GroovyTemplateEngine < ::VertxWeb::TemplateEngine
    # @private
    # @param j_del [::VertxWeb::GroovyTemplateEngine] the java delegate
    def initialize(j_del)
      super(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxWeb::GroovyTemplateEngine] the underlying java delegate
    def j_del
      @j_del
    end
    #  Create a template engine using defaults
    # @param [Hash] config 
    # @return [::VertxWeb::GroovyTemplateEngine] the engine
    def self.create_markup_template(config=nil)
      if !block_given? && config == nil
        return ::Vertx::Util::Utils.safe_create(Java::IoVertxExtWebTempl::GroovyTemplateEngine.java_method(:createMarkupTemplate, []).call(),::VertxWeb::GroovyTemplateEngine)
      elsif config.class == Hash && !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::IoVertxExtWebTempl::GroovyTemplateEngine.java_method(:createMarkupTemplate, [Java::IoVertxExtWebTempl::MarkupConfig.java_class]).call(Java::IoVertxExtWebTempl::MarkupConfig.new(::Vertx::Util::Utils.to_json_object(config))),::VertxWeb::GroovyTemplateEngine)
      end
      raise ArgumentError, "Invalid arguments when calling create_markup_template(config)"
    end
    #  Set the extension for the engine
    # @param [String] extension the extension
    # @return [::VertxWeb::GroovyTemplateEngine] a reference to this for fluency
    def set_extension(extension=nil)
      if extension.class == String && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:setExtension, [Java::java.lang.String.java_class]).call(extension),::VertxWeb::GroovyTemplateEngine)
      end
      raise ArgumentError, "Invalid arguments when calling set_extension(extension)"
    end
    #  Set the max cache size for the engine
    # @param [Fixnum] maxCacheSize the maxCacheSize
    # @return [::VertxWeb::GroovyTemplateEngine] a reference to this for fluency
    def set_max_cache_size(maxCacheSize=nil)
      if maxCacheSize.class == Fixnum && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:setMaxCacheSize, [Java::int.java_class]).call(maxCacheSize),::VertxWeb::GroovyTemplateEngine)
      end
      raise ArgumentError, "Invalid arguments when calling set_max_cache_size(maxCacheSize)"
    end
  end
end
