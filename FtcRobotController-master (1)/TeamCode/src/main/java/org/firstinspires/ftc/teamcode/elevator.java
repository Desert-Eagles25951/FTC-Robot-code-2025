package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

public class elevator extends SubsystemBase {

    private final MotorEx m1;
    private final  MotorEx m2;



    private PIDController controlELvator;
    private MotorGroup elevator;

    double Power_off = 0.0;
    

    public elevator (HardwareMap hardwareMap){

        m1 = new MotorEx(hardwareMap, "m1r");
        m2 = new MotorEx(hardwareMap, "m2l");


        controlELvator = new PController(.01,.0,.0);
        elevator = new MotorGroup(m1,m2);


        m1.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        m2.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        m1.setInverted(false);
        m2.setInverted(true);


        controlELvator.setTolerance(10);



    }

    public void ResetEncoder(){
        m1.stopAndResetEncoder();
        m2.stopAndResetEncoder();
    }

    public void climber(){
     controlELvator.setSetPoint(1100);

    }

    public void higBasquet(){
        controlELvator.setSetPoint(0);//FIXME
    }

    public void lowBasquet(){
        controlELvator.setSetPoint(0); //FIXME
    }

    public void higChamber(){
        controlELvator.setSetPoint(0); //FIXME
    }
    public void lowChamber(){
        controlELvator.setSetPoint(0); //FIXME
    }

    public void offsetPOs(){
        controlELvator.setSetPoint(0);
    }



    public void loop() {
        double move = controlELvator.calculate(m1.getCurrentPosition());
        if (move > 1) {
            move = 1;
        }
        if (move < -1) {
            move = -1;
        }

        double finalMove = move;
        if (Power_off != 0.0) {
            Power_off = finalMove;
        }

        elevator.set(finalMove);
    }

}
