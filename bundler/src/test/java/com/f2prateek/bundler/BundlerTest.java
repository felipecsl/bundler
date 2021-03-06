/*
 * Copyright 2014 Prateek Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.f2prateek.bundler;

import android.os.Bundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class) //
@Config(manifest = Config.NONE)
public class BundlerTest {
  Bundle bundle;
  Bundler bundler;

  @Before public void setup() {
    bundle = new Bundle();
    bundler = Bundler.with(bundle);
  }

  static BundleAssert assertThat(Bundle bundle) {
    return new BundleAssert(bundle);
  }

  @Test
  public void testForwardsCorrectly() throws Exception {
    bundler.put("foo", "bar");
    assertThat(bundle).contains("foo", "bar");
  }

  @Test
  public void testPutAll() {
    Bundle otherBunde = new Bundle();
    otherBunde.putString("foo", "bar");
    bundler.putAll(otherBunde);
    assertThat(bundle).contains("foo", "bar");
  }
}
