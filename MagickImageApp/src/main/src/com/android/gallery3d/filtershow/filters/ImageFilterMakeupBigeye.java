/*
* Copyright (C) 2014,2015 Thundersoft Corporation
* All rights Reserved
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.android.gallery3d.filtershow.filters;

import android.graphics.Bitmap;

import co.jachi.magickimage.R;

import com.thundersoft.hz.selfportrait.detect.FaceInfo;
import com.thundersoft.hz.selfportrait.makeup.engine.MakeupEngine;

public class ImageFilterMakeupBigeye extends SimpleMakeupImageFilter {
    private static final String SERIALIZATION_NAME = "BIGEYE";

    public ImageFilterMakeupBigeye() {
        mName = "Bigeye";
    }

    public FilterRepresentation getDefaultRepresentation() {
        FilterBasicRepresentation representation =
                (FilterBasicRepresentation) super.getDefaultRepresentation();
        representation.setName("Bigeye");
        representation.setSerializationName(SERIALIZATION_NAME);
        representation.setFilterClass(ImageFilterMakeupBigeye.class);
        representation.setTextId(R.string.text_makeup_bigeye);
        representation.setOverlayOnly(true);
        representation.setOverlayId(R.drawable.ic_ts_makeup_bigeye);
        representation.setMinimum(0);
        representation.setMaximum(100);
        representation.setSupportsPartialRendering(true);
        return representation;
    }

    protected void doMakeupEffect(Bitmap bitmap, FaceInfo faceInfo, int width, int height,
            int value) {
        MakeupEngine.doWarpFace(bitmap, bitmap, width, height, faceInfo.eye1, faceInfo.eye2,
                faceInfo.mouth, value, 0);
    }
}
