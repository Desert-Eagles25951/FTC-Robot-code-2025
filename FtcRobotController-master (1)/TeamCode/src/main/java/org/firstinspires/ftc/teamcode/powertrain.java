package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;



import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.function.DoubleSupplier;

public class powertrain extends SubsystemBase {


   private Motor right = null;
   private Motor left = null;

   DifferentialDrive drive = null;

   double speed;
   double turn;

   public powertrain(HardwareMap hardwareMap){

       right = new Motor(hardwareMap, "mright");
       left = new Motor(hardwareMap, "mleft");

       right.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
       left.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);

        drive = new DifferentialDrive(right, left);



   }


   public void inputcontrol(GamepadEx ps4){
     speed =  ps4.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) -ps4.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) ;
     turn = -ps4.getLeftX();
   }


   public void arcade(){
       drive.arcadeDrive(speed , turn);
   }

   



    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}