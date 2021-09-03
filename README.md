# README #
<img src="art/meik.png" />

Miek
=========================

A fixed viewport image cropping library for Android with built-in support for [Picasso][picasso], [Glide][glide] or [Universal Image Loader][uil].
Forked from [Scissors][scissors].

Usage
-----

See `scissors-sample`.

<img src="art/demo.gif" width="320" align="right" hspace="20" />


- Include it on your layout:
```xml
<com.lyft.android.scissors.CropView
    android:id="@+id/crop_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:cropviewViewportRatio="1"
    />
```
-  Set a Bitmap to be cropped. In example by calling `cropView.setImageBitmap(someBitmap);`
-  Call `Bitmap croppedBitmap = cropView.crop();` to obtain a cropped Bitmap to match viewport dimensions

Extensions
----------
Scissors comes with handy extensions which help with common tasks like:

#### Loading a Bitmap
To load a Bitmap automatically with [Picasso][picasso], [Glide][glide] or [Universal Image Loader][uil] into `CropView` use as follows:

```java
cropView.extensions()
    .load(galleryUri);
```
#### Cropping into a File
To save a cropped Bitmap into a `File` use as follows:

```java
cropView.extensions()
    .crop()
    .quality(87)
    .format(PNG)
    .into(croppedFile))
```

Questions
----------
Ask Rod I guess? ヽ(•̀ω•́ )ゝ

Download
--------

```groovy
compile 'com.lyft:scissors:1.1.1'
```

License
-------

    Copyright (C) 2015 Lyft, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

Contributing
------------

Please see `CONTRIBUTING.md`.

Contributors
------------
- [See contributors on GitHub](https://github.com/lyft/scissors/graphs/contributors)

 [picasso]: https://github.com/square/picasso
 [glide]: https://github.com/bumptech/glide
 [uil]: https://github.com/nostra13/Android-Universal-Image-Loader
 [scissors]: https://github.com/lyft/scissors
