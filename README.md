[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SoundLine-green.svg?style=flat )]( https://android-arsenal.com/details/1/8033 )
# SoundLine

SoundLine is an Android custom view which similarly works as the `SoundCloud` track time line.
By using two different `HorizontalScrollViews`, the effect looks pretty similar and it's possible to customize the image resource used for the waves.

<p align="center">
    <img src="art/SoundLine.gif"/>
</p>

## Getting Started

Add the **soundline** module in your project.

## Usage

In your layout add **prieto.fernando.soundline.SoundLineView** and you can specify the drawable resources ```app:wave_first_src``` and ```app:wave_second_src``` (optional).

- By default, there are 3 different sound waves to use (with three different lengths):
*soundwave_first_default_0.png
soundwave_first_default_1.png
soundwave_first_default_2.png*

- Also 3 default sound waves for the non complete track:
*soundwave_second_default_0.png
soundwave_second_default_1.png
soundwave_second_default_2.png*

## Sample

There is a sample in the project where the sound waves are set *custom_first_default_0* and *custom_second_default_0*


#  License

Copyright 2019 Fernando Prieto Moyano

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


