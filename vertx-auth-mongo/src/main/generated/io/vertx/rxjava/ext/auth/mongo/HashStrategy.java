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

package io.vertx.rxjava.ext.auth.mongo;

import java.util.Map;
import rx.Observable;
import io.vertx.ext.auth.mongo.HashSaltStyle;
import io.vertx.rxjava.ext.auth.User;

/**
 * Determines how the hashing is computed in the implementation You can implement this to provide a different hashing
 * strategy to the default.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.auth.mongo.HashStrategy original} non RX-ified interface using Vert.x codegen.
 */

public class HashStrategy {

  final io.vertx.ext.auth.mongo.HashStrategy delegate;

  public HashStrategy(io.vertx.ext.auth.mongo.HashStrategy delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  /**
   * Compute the hashed password given the unhashed password and the user
   * @param password the unhashed password
   * @param user the user to get the salt for. This paramter is needed, if the  is declared to be used
   * @return the hashed password
   */
  public String computeHash(String password, User user) { 
    String ret = delegate.computeHash(password, (io.vertx.ext.auth.User)user.getDelegate());
    return ret;
  }

  /**
   * Retrieve the password from the user, or as clear text or as hashed version, depending on the definition
   * @param user the user to get the stored password for
   * @return the password, either as hashed version or as cleartext, depending on the preferences
   */
  public String getStoredPwd(User user) { 
    String ret = delegate.getStoredPwd((io.vertx.ext.auth.User)user.getDelegate());
    return ret;
  }

  /**
   * Retrieve the salt. The source of the salt can be the external salt or the propriate column of the given user,
   * depending on the defined {@link io.vertx.rxjava.ext.auth.mongo.HashSaltStyle}
   * @param user the user to get the salt for. This paramter is needed, if the  is declared to be used
   * @return null in case of  the salt of the user or a defined external salt
   */
  public String getSalt(User user) { 
    String ret = delegate.getSalt((io.vertx.ext.auth.User)user.getDelegate());
    return ret;
  }

  /**
   * Set an external salt. This method should be used in case of 
   * @param salt the salt, which shall be used
   */
  public void setExternalSalt(String salt) { 
    delegate.setExternalSalt(salt);
  }

  /**
   * Set the saltstyle as defined by {@link io.vertx.rxjava.ext.auth.mongo.HashSaltStyle}.
   * @param saltStyle the {@link io.vertx.rxjava.ext.auth.mongo.HashSaltStyle} to be used
   */
  public void setSaltStyle(HashSaltStyle saltStyle) { 
    delegate.setSaltStyle(saltStyle);
  }

  /**
   * Get the defined {@link io.vertx.rxjava.ext.auth.mongo.HashSaltStyle} of the current instance
   * @return the saltStyle
   */
  public HashSaltStyle getSaltStyle() { 
    HashSaltStyle ret = delegate.getSaltStyle();
    return ret;
  }


  public static HashStrategy newInstance(io.vertx.ext.auth.mongo.HashStrategy arg) {
    return arg != null ? new HashStrategy(arg) : null;
  }
}
