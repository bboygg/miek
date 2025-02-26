/*
 * Copyright (C) 2015 Lyft, Inc.
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
package co.steezy.android.imagecropsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

import co.steezy.android.imagecropsample.databinding.ActivityCropResultBinding;

public class CropResultActivity extends AppCompatActivity {

    private static final String EXTRA_FILE_PATH = "EXTRA_FILE_PATH";
    private ActivityCropResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_crop_result);

        String filePath = getIntent().getStringExtra(EXTRA_FILE_PATH);
        File imageFile = new File(filePath);

        Picasso.with(this)
                .load(imageFile)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(binding.resultImage);

        // Or Glide
        //Glide.with(this)
        //        .load(imageFile)
        //        .diskCacheStrategy(DiskCacheStrategy.NONE)
        //        .skipMemoryCache(true)
        //        .into(binding.resultImage);

        // Or Android-Universal-Image-Loader
        //DisplayImageOptions options = new DisplayImageOptions.Builder()
        //        .cacheInMemory(false)
        //        .cacheOnDisk(false)
        //        .build();
        //ImageLoader.getInstance().displayImage("file://" + filePath, binding.resultImage, options);
    }

    static void startUsing(File croppedPath, Activity activity) {
        Intent intent = new Intent(activity, CropResultActivity.class);
        intent.putExtra(EXTRA_FILE_PATH, croppedPath.getPath());
        activity.startActivity(intent);
    }
}
