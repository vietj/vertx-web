package io.vertx.ext.web.templ;

import groovy.text.markup.TemplateConfiguration;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.core.json.JsonObject;

import java.util.Locale;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@DataObject(generateConverter = true)
public class MarkupConfig {

  private TemplateConfiguration config;

  public MarkupConfig() {
    config = new TemplateConfiguration();
  }

  public MarkupConfig(JsonObject json) {
  }

  public MarkupConfig(MarkupConfig that) {
    config = new TemplateConfiguration(that.config);
  }

  public String getDeclarationEncoding() {
    return config.getDeclarationEncoding();
  }

  public MarkupConfig setDeclarationEncoding(String encoding) {
    return this;
  }

  public boolean isExpandEmptyElements() {
    return config.isExpandEmptyElements();
  }

  public MarkupConfig setExpandEmptyElements(boolean expandEmptyElements) {
    config.setExpandEmptyElements(expandEmptyElements);
    return this;
  }

  public boolean isUseDoubleQuotes() {
    return config.isUseDoubleQuotes();
  }

  public MarkupConfig setUseDoubleQuotes(boolean useDoubleQuotes) {
    config.setUseDoubleQuotes(useDoubleQuotes);
    return this;
  }

  public String getNewLineString() {
    return config.getNewLineString();
  }

  public MarkupConfig setNewLineString(String newLineString) {
    config.setNewLineString(newLineString);
    return this;
  }

  public boolean isAutoEscape() {
    return config.isAutoEscape();
  }

  public MarkupConfig setAutoEscape(boolean autoEscape) {
    config.setAutoEscape(autoEscape);
    return this;
  }

  public boolean isAutoIndent() {
    return config.isAutoIndent();
  }

  public MarkupConfig setAutoIndent(boolean autoIndent) {
    config.setAutoEscape(autoIndent);
    return this;
  }

  public String getAutoIndentString() {
    return config.getAutoIndentString();
  }

  public MarkupConfig setAutoIndentString(String autoIndentString) {
    config.setAutoIndentString(autoIndentString);
    return this;
  }

  public boolean isAutoNewLine() {
    return config.isAutoNewLine();
  }

  public MarkupConfig setAutoNewLine(boolean autoNewLine) {
    config.setAutoNewLine(autoNewLine);
    return this;
  }

  public String getLocale() {
    return config.getLocale().toLanguageTag();
  }

  public MarkupConfig setLocale(String locale) {
    config.setLocale(Locale.forLanguageTag(locale));
    return this;
  }

  public boolean isCacheTemplates() {
    return config.isCacheTemplates();
  }

  public MarkupConfig setCacheTemplates(boolean cacheTemplates) {
    config.setCacheTemplates(cacheTemplates);
    return this;
  }

  @GenIgnore
  public TemplateConfiguration toConfiguration() {
    return new TemplateConfiguration(config);
  }
}
