/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.groovy.ext.web.templ;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.templ.MarkupConfig
/**
 * A simple wrapper for Groovy template engines to be used as
 * Vert.x template engines
*/
@CompileStatic
public class GroovyTemplateEngine extends TemplateEngine {
  private final def io.vertx.ext.web.templ.GroovyTemplateEngine delegate;
  public GroovyTemplateEngine(Object delegate) {
    super((io.vertx.ext.web.templ.GroovyTemplateEngine) delegate);
    this.delegate = (io.vertx.ext.web.templ.GroovyTemplateEngine) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  /**
   * Create a template engine using defaults
   * @return the engine
   */
  public static GroovyTemplateEngine createMarkupTemplate() {
    def ret= InternalHelper.safeCreate(io.vertx.ext.web.templ.GroovyTemplateEngine.createMarkupTemplate(), io.vertx.groovy.ext.web.templ.GroovyTemplateEngine.class);
    return ret;
  }
  /**
   * Create a template engine using defaults
   * @param config  (see <a href="../../../../../../../../cheatsheet/MarkupConfig.html">MarkupConfig</a>)
   * @return the engine
   */
  public static GroovyTemplateEngine createMarkupTemplate(Map<String, Object> config) {
    def ret= InternalHelper.safeCreate(io.vertx.ext.web.templ.GroovyTemplateEngine.createMarkupTemplate(config != null ? new io.vertx.ext.web.templ.MarkupConfig(new io.vertx.core.json.JsonObject(config)) : null), io.vertx.groovy.ext.web.templ.GroovyTemplateEngine.class);
    return ret;
  }
  /**
   * Set the extension for the engine
   * @param extension the extension
   * @return a reference to this for fluency
   */
  public GroovyTemplateEngine setExtension(String extension) {
    def ret= InternalHelper.safeCreate(this.delegate.setExtension(extension), io.vertx.groovy.ext.web.templ.GroovyTemplateEngine.class);
    return ret;
  }
  /**
   * Set the max cache size for the engine
   * @param maxCacheSize the maxCacheSize
   * @return a reference to this for fluency
   */
  public GroovyTemplateEngine setMaxCacheSize(int maxCacheSize) {
    def ret= InternalHelper.safeCreate(this.delegate.setMaxCacheSize(maxCacheSize), io.vertx.groovy.ext.web.templ.GroovyTemplateEngine.class);
    return ret;
  }
}
