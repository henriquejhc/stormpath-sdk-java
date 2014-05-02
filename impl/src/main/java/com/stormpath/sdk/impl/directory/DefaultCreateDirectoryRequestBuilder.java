/*
 * Copyright 2014 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.impl.directory;

import com.stormpath.sdk.directory.CreateDirectoryRequest;
import com.stormpath.sdk.directory.CreateDirectoryRequestBuilder;
import com.stormpath.sdk.directory.Directory;
import com.stormpath.sdk.lang.Assert;
import com.stormpath.sdk.provider.CreateProviderRequestBuilder;
import com.stormpath.sdk.provider.Provider;

/**
 * @since 1.0.beta
 */
public class DefaultCreateDirectoryRequestBuilder implements CreateDirectoryRequestBuilder {

    private Directory directory;
    private Provider provider;

    public DefaultCreateDirectoryRequestBuilder(Directory directory) {
        Assert.notNull(directory, "directory cannot be null.");
        this.directory = directory;
    }

    @Override
    public <T extends CreateProviderRequestBuilder> CreateDirectoryRequestBuilder forProvider(T createProviderRequest) {
        this.provider = createProviderRequest.build().getProvider();
        return this;
    }

    @Override
    public CreateDirectoryRequest build() {
        return new DefaultCreateDirectoryRequest(this.directory, this.provider);
    }
}
