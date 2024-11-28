# Team 10669 - UG 2020-2021

## This is the Team10669 clutch teleOP and autonomous code for UG 2020-2021.

**More Info:** https://sites.google.com/view/team10669/ultimate-goal-program?authuser=2

If you need any help understanding this code, feel free to email us at shauryasclutch21@gmail.com, or fill out the form on our site.
You can also ask under the "issues" tab. 


EasyOpenCV, PID, and servo control is done through <a href="https://docs.ftclib.org/ftclib/">FTClib</a>

Odometry, field relative, and the semi-auto code is done through the <a href="https://learnroadrunner.com">roadrunner</a> library 

Testing is done through <a href="https://acmerobotics.github.io/ftc-dashboard/">FTC Dashboard</a>, which lets us test code without the need for a driver station 

EasyOpenCv testing is done through <a href="https://github.com/serivesmejia/EOCV-Sim/tree/master">EOCV sim</a>

## Installation

### Note: This project is still in a testing stage

**Option 1: .apk Install**

1. Set up <a href="https://github.com/OpenFTC/EasyOpenCV">EasyOpenCV</a> on your phone 

2. Grab the latest .apk from <a href="https://github.com/Clutch-Squad-10669/UltimateGoal/releases/tag/v1.2.0-beta.1">releases</a>

3. Put it on your phone, double tap to install

**Option 2: Build From Source**

For more detailed instructions on getting Road Runner setup in your own project, see the [Road Runner README](https://github.com/acmerobotics/road-runner#core).

1. Download or clone this repo

1. Open the project in Android Studio and build `TeamCode` like any other `ftc_app` project.

1. If you have trouble with multidex, enable proguard by changing `useProguard` to `true` in `build.common.gradle`.
