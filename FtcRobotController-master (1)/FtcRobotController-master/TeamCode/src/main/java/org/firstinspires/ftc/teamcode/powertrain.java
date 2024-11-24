package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.motors.RevRobotics20HdHexMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class powertrain extends SubsystemBase {

    private final Motor left = new Motor(hardwareMap, "left");
    private final Motor right = new Motor(hardwareMap, "right");

    private final DifferentialDrive drive = new DifferentialDrive(left,right);

    //double PosRight;
    //double PosLeft;


    public powertrain() {

       left.setRunMode(Motor.RunMode.VelocityControl);
       right.setRunMode(Motor.RunMode.VelocityControl);

       left.setInverted(true);
       right.setInverted(false);

       left.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
       right.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

       left.resetEncoder();
       right.resetEncoder();

       //PosLeft = left.getPositionCoefficient();
       //PosRight = right.getPositionCoefficient();

    }



    public void arcade(double speed, double turn){

        drive.arcadeDrive(speed,turn);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}