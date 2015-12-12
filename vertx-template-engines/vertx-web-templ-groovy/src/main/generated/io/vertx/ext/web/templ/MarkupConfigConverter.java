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

package io.vertx.ext.web.templ;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.ext.web.templ.MarkupConfig}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.web.templ.MarkupConfig} original class using Vert.x codegen.
 */
public class MarkupConfigConverter {

  public static void fromJson(JsonObject json, MarkupConfig obj) {
    if (json.getValue("autoEscape") instanceof Boolean) {
      obj.setAutoEscape((Boolean)json.getValue("autoEscape"));
    }
    if (json.getValue("autoIndent") instanceof Boolean) {
      obj.setAutoIndent((Boolean)json.getValue("autoIndent"));
    }
    if (json.getValue("autoIndentString") instanceof String) {
      obj.setAutoIndentString((String)json.getValue("autoIndentString"));
    }
    if (json.getValue("autoNewLine") instanceof Boolean) {
      obj.setAutoNewLine((Boolean)json.getValue("autoNewLine"));
    }
    if (json.getValue("cacheTemplates") instanceof Boolean) {
      obj.setCacheTemplates((Boolean)json.getValue("cacheTemplates"));
    }
    if (json.getValue("declarationEncoding") instanceof String) {
      obj.setDeclarationEncoding((String)json.getValue("declarationEncoding"));
    }
    if (json.getValue("expandEmptyElements") instanceof Boolean) {
      obj.setExpandEmptyElements((Boolean)json.getValue("expandEmptyElements"));
    }
    if (json.getValue("locale") instanceof String) {
      obj.setLocale((String)json.getValue("locale"));
    }
    if (json.getValue("newLineString") instanceof String) {
      obj.setNewLineString((String)json.getValue("newLineString"));
    }
    if (json.getValue("useDoubleQuotes") instanceof Boolean) {
      obj.setUseDoubleQuotes((Boolean)json.getValue("useDoubleQuotes"));
    }
  }

  public static void toJson(MarkupConfig obj, JsonObject json) {
    json.put("autoEscape", obj.isAutoEscape());
    json.put("autoIndent", obj.isAutoIndent());
    if (obj.getAutoIndentString() != null) {
      json.put("autoIndentString", obj.getAutoIndentString());
    }
    json.put("autoNewLine", obj.isAutoNewLine());
    json.put("cacheTemplates", obj.isCacheTemplates());
    if (obj.getDeclarationEncoding() != null) {
      json.put("declarationEncoding", obj.getDeclarationEncoding());
    }
    json.put("expandEmptyElements", obj.isExpandEmptyElements());
    if (obj.getLocale() != null) {
      json.put("locale", obj.getLocale());
    }
    if (obj.getNewLineString() != null) {
      json.put("newLineString", obj.getNewLineString());
    }
    json.put("useDoubleQuotes", obj.isUseDoubleQuotes());
  }
}