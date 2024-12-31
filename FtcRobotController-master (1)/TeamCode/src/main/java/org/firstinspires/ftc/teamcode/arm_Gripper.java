package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class arm_Gripper extends SubsystemBase  {
    private ServoEx gripper;

    private ServoEx arm1, arm2;

    private ServoController ARM1, ARM2;

    public  arm_Gripper(HardwareMap harmap){



        gripper = new SimpleServo(harmap, "gripper",-180 ,180, AngleUnit.DEGREES );

        arm1 = new SimpleServo(harmap, "arm1", 0,180);
        arm2 = new SimpleServo(harmap, "arm2", 0,180);

        ARM1 = harmap.get(Servo.class,"arm1" ).getController();
        ARM2 = harmap.get(Servo.class, "arm2").getController();


        arm2.setInverted(false);
        arm1.setInverted(true);

        gripper.setInverted(false);
    }

    public void armOfseTake(){
        ARM1.pwmEnable();
        ARM2.pwmEnable();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int pos = 112; pos > 0; pos -= 1){
            arm1.turnToAngle(pos);
            arm2.turnToAngle(pos);
        }
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ARM1.pwmDisable();
        ARM2.pwmDisable();
    }
    public void ArmOfsetBasket(){
        ARM1.pwmEnable();
        ARM2.pwmEnable();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(int pos = 35; pos > 0  ; pos -= 1){
            arm1.turnToAngle(pos);
            arm2.turnToAngle(pos);

        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ARM1.pwmDisable();
        ARM2.pwmDisable();
    }

    public void ArmOfsetChamber(){
        ARM1.pwmEnable();
        ARM2.pwmEnable();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(int pos = 40; pos > 0; pos -= 1){
            arm1.turnToAngle(pos);
            arm2.turnToAngle(pos);

        }
        ARM1.pwmDisable();
        ARM2.pwmDisable();
    }




    public void Gripperoffset(){
        gripper.turnToAngle(-43);
    }

    public void OpenGripper(){
        gripper.turnToAngle(23);
    }

    public void TakePiece(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ARM1.pwmEnable();
        ARM2.pwmEnable();
     for(int pos = 0; pos < 112; pos += 1){
         arm1.turnToAngle(pos);
         arm2.turnToAngle(pos);

     }


    }

    public void OutPieceBasket(){

        for(int pos = 0; pos < 40; pos += 1){
            arm1.turnToAngle(pos);
            arm2.turnToAngle(pos);

        }

    }

    public void OutPiece(){
        for(int pos = 0; pos < 35; pos += 1){
            arm1.turnToAngle(pos);
            arm2.turnToAngle(pos);

        }
    }
    public double getangleArm(){
        return gripper.getAngle(AngleUnit.DEGREES);
    }





}
