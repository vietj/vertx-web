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

package io.vertx.rxjava.ext.web.templ;

import java.util.Map;
import io.vertx.lang.rxjava.InternalHelper;
import rx.Observable;
import io.vertx.ext.web.templ.MarkupConfig;

/**
 * A simple wrapper for Groovy template engines to be used as
 * Vert.x template engines
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.web.templ.GroovyTemplateEngine original} non RX-ified interface using Vert.x codegen.
 */

public class GroovyTemplateEngine extends TemplateEngine {

  final io.vertx.ext.web.templ.GroovyTemplateEngine delegate;

  public GroovyTemplateEngine(io.vertx.ext.web.templ.GroovyTemplateEngine delegate) {
    super(delegate);
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  /**
   * Create a template engine using defaults
   * @return the engine
   */
  public static GroovyTemplateEngine createMarkupTemplate() { 
    GroovyTemplateEngine ret= GroovyTemplateEngine.newInstance(io.vertx.ext.web.templ.GroovyTemplateEngine.createMarkupTemplate());
    return ret;
  }

  /**
   * Create a template engine using defaults
   * @param config 
   * @return the engine
   */
  public static GroovyTemplateEngine createMarkupTemplate(MarkupConfig config) { 
    GroovyTemplateEngine ret= GroovyTemplateEngine.newInstance(io.vertx.ext.web.templ.GroovyTemplateEngine.createMarkupTemplate(config));
    return ret;
  }

  /**
   * Set the extension for the engine
   * @param extension the extension
   * @return a reference to this for fluency
   */
  public GroovyTemplateEngine setExtension(String extension) { 
    GroovyTemplateEngine ret= GroovyTemplateEngine.newInstance(this.delegate.setExtension(extension));
    return ret;
  }

  /**
   * Set the max cache size for the engine
   * @param maxCacheSize the maxCacheSize
   * @return a reference to this for fluency
   */
  public GroovyTemplateEngine setMaxCacheSize(int maxCacheSize) { 
    GroovyTemplateEngine ret= GroovyTemplateEngine.newInstance(this.delegate.setMaxCacheSize(maxCacheSize));
    return ret;
  }


  public static GroovyTemplateEngine newInstance(io.vertx.ext.web.templ.GroovyTemplateEngine arg) {
    return arg != null ? new GroovyTemplateEngine(arg) : null;
  }
}
