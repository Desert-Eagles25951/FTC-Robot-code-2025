package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = " tlaxcala")
public class robot extends CommandOpMode
{


    //private final  double wheel_diameter = 101.6;

      powertrain drivetrain;
    private final GamepadEx ps4 = new GamepadEx(gamepad1);
     drive drivecomand;


    @Override
    public void initialize() {
      drivetrain = new powertrain(hardwareMap, "left","right",101.6);

         drivecomand = new drive(drivetrain
                , ps4::getLeftY
                , ps4::getRightX
        );


      drivetrain.setDefaultCommand(drivecomand);
      register(drivetrain);


    }


}




