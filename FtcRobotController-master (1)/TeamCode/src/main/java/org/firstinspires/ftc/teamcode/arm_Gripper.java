package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class arm_Gripper extends SubsystemBase  {
    private ServoEx arm1,arm2,gripper;

    public  arm_Gripper(HardwareMap harmap){

        arm1 = new SimpleServo(harmap, "rightarm", 0,120, AngleUnit.DEGREES);
        arm2 = new SimpleServo(harmap, "leftarm", 0, 120, AngleUnit.DEGREES);

        gripper = new SimpleServo(harmap, "gripper",0 ,180, AngleUnit.DEGREES );



    }

    public void armOffset(){
        arm1.turnToAngle(0);
        arm2.turnToAngle(0);
    }

    public void Gripperoffset(){
        gripper.turnToAngle(0);
    }

    public void OpenGripper(){
        gripper.turnToAngle(120);
    }

    public void TakePiece(){
        arm1.turnToAngle(120);
        arm2.turnToAngle(-120);
    }

    public void OutPiece(){
        arm1.turnToAngle(50);
        arm2.turnToAngle(-50);
    }



}
