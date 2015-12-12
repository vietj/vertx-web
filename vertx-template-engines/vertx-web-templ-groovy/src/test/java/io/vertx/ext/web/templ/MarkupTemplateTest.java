package io.vertx.ext.web.templ;

import groovy.text.TemplateEngine;
import groovy.text.markup.MarkupTemplateEngine;
import io.vertx.ext.web.templ.GroovyTemplateTestBase;

/**
 * @author <a href="http://github.com/aesteve">Arnaud Esteve</a>
 */
public class MarkupTemplateTest extends GroovyTemplateTestBase {

  @Override
  protected GroovyTemplateEngine createEngine() {
    return GroovyTemplateEngine.createMarkupTemplate();
  }

  @Override
  protected String getFSTemplateName() {
    return "test-markup-template3.gtpl";
  }

  @Override
  protected String getCpTemplateName() {
    return "test-markup-template2.gtpl";
  }

  @Override
  protected String getExtension() {
    return "gtpl";
  }

  @Override
  protected String getFSExpectedResult() {
    return "<html><body>badger</body></html>";
  }

  @Override
  protected String getCpExpectedResult() {
    return "<html><body>fox</body></html>";
  }

  @Override
  protected String getAnotherExtensionExpectedResult() {
    return "<html><body>ztpl:fox</body></html>";
  }

  @Override
  public void testGetGroovyEngine() throws Exception {
    // Does not pass because no groovy engine
  }
}
